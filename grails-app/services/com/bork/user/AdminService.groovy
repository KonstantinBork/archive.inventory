package com.bork.user

import grails.transaction.Transactional

@Transactional
class AdminService {

    boolean deleteUser(String username) {
        User user = User.findByUsername(username)
        if (user) {
            user.delete()
            return true
        }
        return false
    }

    User getUser(String username) {
        return User.findByUsername(username)
    }

    List<User> getAllUsers() {
        return User.all
    }

}