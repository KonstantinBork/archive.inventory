package com.bork.user

import grails.plugin.springsecurity.annotation.Secured

class UserController {

    UserService userService
    SpringSecurityService springSecurityService

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

    @Secured("ROLE_USER")
    void addMedia() {
        User user = springSecurityService.isLoggedIn() ? springSecurityService.getCurrentUser() : null
        if (user) {
            ""
        }
    }

    @Secured("ROLE_USER")
    void deleteMedia() {
        User user = springSecurityService.isLoggedIn() ? springSecurityService.getCurrentUser() : null
        if (user) {
            ""
        }
    }

    @Secured("ROLE_USER")
    void showMedia() {
        User user = springSecurityService.isLoggedIn() ? springSecurityService.getCurrentUser() : null
        if (user) {
            Map<String, ?> media = userService.getUserMedia(user)
            // TODO render result
        }
    }

}