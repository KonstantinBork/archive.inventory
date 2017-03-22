package com.bork.user

import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_ADMIN")
class AdminController {

    AdminService adminService

    void index() {
        render(view: "admin")
    }

    void showAllUser() {
        List<User> allUsers = adminService.getAllUsers()
        if (allUsers && allUsers.size() > 0) {
            // TODO render success page
            "A"
        } else {
            // TODO render error page
            ""
        }
    }

    void findUser() {
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

    void deleteUser() {
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