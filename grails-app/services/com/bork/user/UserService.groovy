package com.bork.user

import grails.transaction.Transactional

@Transactional
class UserService {

    User signUp(String username, String emailAddress, String password) {
        User user = User.findByUsername(username)
        if (!user) {
            user = new User(username: username, emailAddress: emailAddress, password: password)
            user.save()
            return user
        } else {
            return null
        }
    }

}