package com.bork.inventory

import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_ADMIN")
class InventoryController {

    ImportService importService
    UpdateService updateService
    DeleteService deleteService

    static defaultAction = "importMedia"

    def importMedia() {
        log.debug("Import Media")
        boolean successfulImport
        switch (params.media) {
            case "book":
                successfulImport = importService.importBook(params.author, params.name, params.publisher, params.barcode)
                break
            case "movie":
                MoviePlatform platform = getMoviePlatform(params.platform)
                successfulImport = importService.importMovie(params.name, params.director, platform, params.barcode)
                break
            case "music":
                successfulImport = importService.importMusic(params.interpreter, params.name, params.barcode)
                break
            case "videogame":
                VideogamePlatform platform = getVideogamePlatform(params.platform)
                successfulImport = importService.importVideoGame(params.name, params.developer, platform, params.barcode)
                break
            default:
                successfulImport = false
        }
        if (successfulImport) {
            // TODO render success page
            ""
        } else {
            // TODO render error page
            "A"
        }
    }

    def updateMedia() {
        log.debug("Update Media")
        boolean successfulUpdate
        switch (params.media) {
            case "book":
                successfulUpdate = updateService.updateBook(params.author, params.name, params.publisher, params.barcode)
                break
            case "movie":
                MoviePlatform platform = getMoviePlatform(params.platform)
                successfulUpdate = updateService.updateMovie(params.name, params.director, platform, params.barcode)
                break
            case "music":
                successfulUpdate = updateService.updateMusic(params.interpreter, params.name, params.barcode)
                break
            case "videogame":
                VideogamePlatform platform = getVideogamePlatform(params.platform)
                successfulUpdate = updateService.updateVideoGame(params.name, params.developer, platform, params.barcode)
                break
            default:
                successfulUpdate = false
        }
        if (successfulUpdate) {
            // TODO render success page
            ""
        } else {
            // TODO render error page
            "A"
        }
    }

    def deleteMedia() {
        log.debug("Delete Media")
        boolean successfulDelete
        switch (params.media) {
            case "book":
                successfulDelete = deleteService.deleteBook(params.author, params.name, params.publisher, params.barcode)
                break
            case "movie":
                MoviePlatform platform = getMoviePlatform(params.platform)
                successfulDelete = deleteService.deleteMovie(params.name, params.director, platform, params.barcode)
                break
            case "music":
                successfulDelete = deleteService.deleteMusic(params.interpreter, params.name, params.barcode)
                break
            case "videogame":
                VideogamePlatform platform = getVideogamePlatform(params.platform)
                successfulDelete = deleteService.deleteVideoGame(params.name, params.developer, platform, params.barcode)
                break
            default:
                successfulDelete = false
        }
        if (successfulDelete) {
            // TODO render success page
            ""
        } else {
            // TODO render error page
            "A"
        }
    }

    private VideogamePlatform getVideogamePlatform(String platform) {
        switch (platform) {
            case "n3ds":
                return VideogamePlatform.NINTENDO3DS
            case "n64":
                return VideogamePlatform.NINTENDO64
            case "nds":
                return VideogamePlatform.NINTENDODS
            case "pc":
                return VideogamePlatform.PC
            case "ps3":
                return VideogamePlatform.PLAYSTATION3
            case "ps4":
                return VideogamePlatform.PLAYSTATION4
            case "snes":
                return VideogamePlatform.SUPERNINTENDO
            case "wii":
                return VideogamePlatform.WII
            case "wiiu":
                return VideogamePlatform.WIIU
            default:
                return null
        }
    }

    private MoviePlatform getMoviePlatform(String platform) {
        switch (platform) {
            case "bluray":
                return MoviePlatform.BLURAY
            case "dvd":
                return MoviePlatform.DVD
            case "vod":
                return MoviePlatform.VOD
            default:
                return null
        }
    }

}