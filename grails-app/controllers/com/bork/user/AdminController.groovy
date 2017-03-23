package com.bork.user

import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_ADMIN")
class AdminController {

    AdminService adminService

    def index() {
        render(view: "/user/admin")
    }

    def showAllUser() {
        List<User> allUsers = adminService.getAllUsers()
        if (allUsers && allUsers.size() > 0) {
            // TODO render success page
            "A"
        } else {
            // TODO render error page
            ""
        }
    }

    def findUser() {
        String username = params.username
        User user = adminService.getUser(username)
        if (user) {
            // TODO render success page
            "A"
        } else {
            // TODO render error page
            ""
        }
    }

    def deleteUser() {
        String username = params.username
        boolean deleted = adminService.deleteUser(username)
        if (deleted) {
            // TODO render success page
            "A"
        } else {
            // TODO render error page
            ""
        }
    }

}