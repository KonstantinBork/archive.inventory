package inventory

import com.inventory.app.Role
import com.inventory.app.User
import com.inventory.app.UserRole

class BootStrap {

    def init = { servletContext ->
        def adminRole = new Role(authority: 'ROLE_ADMIN').save()
        def userRole = new Role(authority: 'ROLE_USER').save()

        def testUser = new User(username: 'admin', password: 'password', emailAddress: 'a@b.com').save()
        def testUser2 = new User(username: 'user', password: 'password', emailAddress: 'b@b.com').save()

        UserRole.create testUser, adminRole
        UserRole.create testUser2, userRole

        UserRole.withSession {
            it.flush()
            it.clear()
        }

        assert User.count() == 2
        assert Role.count() == 2
        assert UserRole.count() == 2
    }

    def destroy = {

    }

}