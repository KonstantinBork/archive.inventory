package com.bork.user

import grails.plugin.springsecurity.SpringSecurityUtils

class SignupController {

    def springSecurityService
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

    def login() {
        def conf = SpringSecurityUtils.securityConfig
        if (springSecurityService.isLoggedIn()) {
            redirect uri: conf.successHandler.defaultTargetUrl
            return
        }

        String postUrl = request.contextPath + conf.apf.filterProcessesUrl
        render view: "/user/login", model: [postUrl            : postUrl,
                                            rememberMeParameter: conf.rememberMe.parameter,
                                            usernameParameter  : conf.apf.usernameParameter,
                                            passwordParameter  : conf.apf.passwordParameter,
                                            gspLayout          : conf.gsp.layoutAuth]
    }

}