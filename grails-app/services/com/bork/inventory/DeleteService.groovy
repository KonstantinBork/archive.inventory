package com.bork.inventory

import grails.transaction.Transactional

@Transactional
class DeleteService {

    boolean deleteBook(String barcode) {
        Book deleteBook = Book.findByBarcode(barcode)
        if (!deleteBook) {
            return false
        }
        deleteBook.delete()
        return true
    }

    boolean deleteMovie(String barcode) {
        Movie deleteMovie = Movie.findByBarcode(barcode)
        if (!deleteMovie) {
            return false
        }
        deleteMovie.delete()
        return true
    }

    boolean deleteMusic(String barcode) {
        Music deleteMusic = Music.findByBarcode(barcode)
        if (!deleteMusic) {
            return false
        }
        deleteMusic.delete()
        return true
    }

    boolean deleteVideoGame(String barcode) {
        VideoGame deleteGame = VideoGame.findByBarcode(barcode)
        if (!deleteGame) {
            return false
        }
        deleteGame.delete()
        return true
    }

}