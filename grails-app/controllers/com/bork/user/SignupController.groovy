package com.bork.user

class SignupController {

    UserService userService

    def index() {
        String username = params.username
        String emailAddress = params.emailAddress
        String password = params.password
        User user = userService.signUp(username, emailAddress, password)
        if (user) {
            UserRole.create(user, Role.findByAuthority('ROLE_USER'))
            render(view: "/user/signup", params: [signup: true])
        } else {
            render(view: "/user/signup", params: [signup: false])
        }
    }

}