package com.bork.user

import grails.plugin.springsecurity.annotation.Secured

class AdminController {

    static defaultAction = "admin"

    @Secured("ROLE_ADMIN")
    void admin() {

    }

}