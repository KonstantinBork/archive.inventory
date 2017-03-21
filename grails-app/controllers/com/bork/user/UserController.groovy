package com.bork.user

class UserController {

    UserService userService

    @Secured("ROLE_USER")
    void signup() {
        String username = params.username
        String emailAddress = params.emailAddress
        String password = params.password
        User user = userService.signUp(username, emailAddress, password)
        if (user) {
            UserRole.create(user, Role.findByAuthority('ROLE_USER'))
            // TODO render success
            ""
        } else {
            // TODO render error user already exists
            "A"
        }
    }

}