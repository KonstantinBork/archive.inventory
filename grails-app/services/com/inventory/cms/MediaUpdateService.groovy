package com.inventory.cms

import grails.transaction.Transactional

@Transactional
class MediaUpdateService {

    boolean updateBook(String author, String name, String publisher, String barcode) {
        Book updateBook = Book.findByBarcode(barcode)
        if (!updateBook) {
            return false
        }
        updateBook.author = (updateBook.author != author) ? author : updateBook.author
        updateBook.publisher = (updateBook.publisher != author) ? publisher : updateBook.publisher
        updateBook.save()
        return true
    }

    boolean updateMovie(String name, String director, MoviePlatform platform, String barcode) {
        Movie updateMovie = Movie.findByBarcode(barcode)
        if (!updateMovie) {
            return false
        }
        updateMovie.name = (updateMovie.name != name) ? name : updateMovie.name
        updateMovie.director = (updateMovie.director != director) ? director : updateMovie.director
        updateMovie.platform = (updateMovie.platform != platform) ? platform : updateMovie.platform
        updateMovie.save()
        return true
    }

    boolean updateMusic(String interpreter, String albumOrSingleName, String barcode) {
        Music updateMusic = Music.findByBarcode(barcode)
        if (!updateMusic) {
            return false
        }
        updateMusic.name = (updateMusic.name != albumOrSingleName) ? albumOrSingleName : updateMusic.name
        updateMusic.name = (updateMusic.name != interpreter) ? interpreter : updateMusic.name
        updateMusic.save()
        return true
    }

    boolean updateVideoGame(String name, String developer, VideogamePlatform platform, String barcode) {
        VideoGame updateGame = VideoGame.findByBarcode(barcode)
        if (!updateGame) {
            return false
        }
        updateGame.name = (updateGame.name != name) ? name : updateGame.name
        updateGame.developer = (updateGame.developer != developer) ? developer : updateGame.developer
        updateGame.platform = (updateGame.platform != platform) ? name : updateGame.platform
        updateGame.save()
        return true
    }

}