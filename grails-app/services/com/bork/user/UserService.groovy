package com.bork.user

import grails.transaction.Transactional

@Transactional
class UserService {

    boolean signUp(String name, String emailAddress, String passwordHash) {
        User user = User.findByEmailAddress(emailAddress)
        if (!user) {
            user = new User(name: name, emailAddress: emailAddress, passwordHash: passwordHash)
            user.save()
            return true
        } else {
            return false
        }
    }

    int logIn(String emailAddress, String passwordHash) {
        User user = User.findByEmailAddress(emailAddress)
        if (!user) {
            return 1
        } else if (user.passwordHash != passwordHash) {
            return 2
        } else {
            return 0
        }
    }

}