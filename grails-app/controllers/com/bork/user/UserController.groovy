package com.bork.user

class UserController {

    UserService userService

    def index() {

    }

    def signup(String name, String emailAddress, String passwordHash) {
        if (userService.signUp(name, emailAddress, passwordHash)) {
            // TODO render success
            ""
        } else {
            // TODO render error user already exists
            "A"
        }
    }

    def login(String emailAddress, String passwordHash) {
        int loginCode = userService.logIn(emailAddress, passwordHash)
        if (loginCode == 0) {
            // TODO render success
            ""
        } else if (loginCode == 1) {
            // TODO render error wrong email
            "A"
        } else {
            // TODO render error wrong password
            ""
        }
    }

}