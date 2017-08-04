package com.inventory.app

import com.inventory.cms.Book
import com.inventory.cms.Media
import com.inventory.cms.VideoGame
import com.inventory.cms.MediaPlatform
import com.inventory.cms.Movie
import com.inventory.cms.Music
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

    Map<String, Media> getUserMedia(User user) {
        return [books: user.books, movies: user.movies, music: user.music, videogames: user.videogames] as Map<String, Media>
    }

    boolean addMedia(User user, MediaPlatform type, String id) {
        switch (type) {
            case MediaPlatform.BOOK:
                Book book = Book.findByBarcode(id)
                if (book) {
                    user.addToBooks(book)
                    return true
                }
                return false
            case MediaPlatform.MOVIE:
                Movie movie = Movie.findByBarcode(id)
                if (movie) {
                    user.addToMovies(movie)
                    return true
                }
                return false
            case MediaPlatform.MUSIC:
                Music music = Music.findByBarcode(id)
                if (music) {
                    user.addToMusic(music)
                    return true
                }
                return false
            case MediaPlatform.VIDEOGAME:
                VideoGame game = VideoGame.findByBarcode(id)
                if (game) {
                    user.addToVideogames(game)
                    return true
                }
                return false
            default:
                return false
        }
    }

    boolean removeMedia(User user, MediaPlatform type, String id) {
        switch (type) {
            case MediaPlatform.BOOK:
                user.removeFromBooks(Book.findByBarcode(id))
                return true
            case MediaPlatform.MOVIE:
                user.removeFromMovies(Movie.findByBarcode(id))
                return true
            case MediaPlatform.MUSIC:
                user.removeFromMusic(Music.findByBarcode(id))
                return true
            case MediaPlatform.VIDEOGAME:
                user.removeFromVideogames(VideoGame.findByBarcode(id))
                return true
            default:
                return false
        }
    }

}