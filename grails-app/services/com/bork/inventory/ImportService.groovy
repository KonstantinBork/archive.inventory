package com.bork.inventory

import grails.transaction.Transactional

@Transactional
class ImportService {

    boolean importBook(String author, String name, String publisher, String barcode) {
        Book importBook = Book.findByBarcode(barcode)
        if (!importBook) {
            importBook = new Book(author: author, name: name, publisher: publisher, barcode: barcode)
            importBook.save()
            return true
        }
        return false
    }

    boolean importGame(String name, String developer, VideogamePlatform platform, String barcode) {
        VideoGame importGame = VideoGame.findByBarcode(barcode)
        if (!importGame) {
            importGame = new VideoGame(name: name, developer: developer, platform: platform, barcode: barcode)
            importGame.save()
            return true
        }
        return false
    }

    boolean importMovie(String name, String director, MoviePlatform platform, String barcode) {
        Movie importMovie = Movie.findByBarcode(barcode)
        if (!importMovie) {
            importMovie = new Movie(name: name, director: director, platform: platform, barcode: barcode)
            importMovie.save()
            return true
        }
        return false
    }

    boolean importMusic(String interpreter, String albumOrSingleName, String barcode) {
        Music importMusic = Music.findByBarcode(barcode)
        if (!importMusic) {
            importMusic = new Music(interpreter: interpreter, albumOrSingleName: albumOrSingleName, barcode: barcode)
            importMusic.save()
            return true
        }
        return false
    }

}