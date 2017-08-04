package com.inventory.cms

import com.inventory.app.User
import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_ADMIN")
class AdminController {

    AdminService adminService

    def index() {
        render(view: "/cms/admin")
    }

    def showAllUser() {
        List<User> allUsers = adminService.getAllUsers()
        render(view: "", params: [allUsers: allUsers])
    }

    def findUser(String username) {
        User user = adminService.getUser(username)
        render(view: "", params: [user: user])
    }

    def deleteUser(String username) {
        boolean deleted = adminService.deleteUser(username)
        render(view: "", params: [userDeleted: deleted])
    }

}