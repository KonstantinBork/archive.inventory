package com.bork.user

import com.bork.inventory.Book
import com.bork.inventory.Game
import com.bork.inventory.Movie

class User {

    String name
    String emailAddress
    String passwordHash

    static hasMany = [
            books : Book,
            movies: Movie,
            games : Game
    ]

    static constraints = {
        name(nullable: false)
    }

}