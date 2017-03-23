package com.bork.inventory

import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_ADMIN")
class InventoryController {

    ImportService importService

    static defaultAction = "importMedia"

    def importMedia() {
        log.debug("Import Media")
        boolean successfulImport
        switch (params.media) {
            case "book":
                successfulImport = importService.importBook(params.author, params.name, params.publisher, params.barcode)
                break
            case "game":
                VideogamePlatform platform = getVideogamePlatform(params.platform)
                successfulImport = importService.importGame(params.name, params.developer, platform, params.barcode)
                break
            case "movie":
                MoviePlatform platform = getMoviePlatform(params.platform)
                successfulImport = importService.importMovie(params.name, params.director, platform, params.barcode)
                break
            case "music":
                successfulImport = importService.importMusic(params.interpreter, params.name, params.barcode)
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