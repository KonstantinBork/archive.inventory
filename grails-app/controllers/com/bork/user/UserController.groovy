package com.bork.user

import com.bork.inventory.MediaPlatform
import grails.plugin.springsecurity.annotation.Secured

class UserController {

    UserService userService
    def springSecurityService

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
            boolean added = userService.addMedia(user, getMediaPlatform(params.mediaType as String), params.mediaId as String)
            if (added) {
                // TODO render success page
                ""
            } else {
                // TODO render error page
                "A"
            }
        }
    }

    @Secured("ROLE_USER")
    void deleteMedia() {
        User user = springSecurityService.isLoggedIn() ? springSecurityService.getCurrentUser() : null
        if (user) {
            boolean deleted = userService.deleteMedia(user, getMediaPlatform(params.mediaType as String), params.mediaId as String)
            if (deleted) {
                // TODO render success page
                "A"
            } else {
                // TODO render error page
                ""
            }
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

    private MediaPlatform getMediaPlatform(String mediaType) {
        switch (mediaType) {
            case "book":
                return MediaPlatform.BOOK
            case "game":
                return MediaPlatform.GAME
            case "movie":
                return MediaPlatform.MOVIE
            case "music":
                return MediaPlatform.MUSIC
            default:
                return null
        }
    }

}