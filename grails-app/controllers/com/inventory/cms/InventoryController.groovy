package com.inventory.cms

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@Secured("ROLE_ADMIN")
class InventoryController {

    MediaImportService mediaImportService
    MediaUpdateService mediaUpdateService
    MediaDeleteService mediaDeleteService

    static defaultAction = "importMedia"

    @RequestMapping(method = RequestMethod.POST)
    def importMedia(String media, String name, String barcode) {
        log.debug("Import Media")
        boolean successfulImport
        switch (media) {
            case "book":
                successfulImport = mediaImportService.importBook(params.author, name, params.publisher, barcode)
                break
            case "movie":
                MoviePlatform platform = getMoviePlatform(params.platform)
                successfulImport = mediaImportService.importMovie(name, params.director, platform, barcode)
                break
            case "music":
                successfulImport = mediaImportService.importMusic(params.interpreter, name, barcode)
                break
            case "videogame":
                VideogamePlatform platform = getVideogamePlatform(params.platform)
                successfulImport = mediaImportService.importVideoGame(name, params.developer, platform, barcode)
                break
            default:
                successfulImport = false
        }
        render(view: "", params: [importSuccessful: successfulImport])
    }

    @RequestMapping(method = RequestMethod.POST)
    def updateMedia(String media, String name, String barcode) {
        log.debug("Update Media")
        boolean successfulUpdate
        switch (media) {
            case "book":
                successfulUpdate = mediaUpdateService.updateBook(params.author, name, params.publisher, barcode)
                break
            case "movie":
                MoviePlatform platform = getMoviePlatform(params.platform)
                successfulUpdate = mediaUpdateService.updateMovie(name, params.director, platform, barcode)
                break
            case "music":
                successfulUpdate = mediaUpdateService.updateMusic(params.interpreter, name, barcode)
                break
            case "videogame":
                VideogamePlatform platform = getVideogamePlatform(params.platform)
                successfulUpdate = mediaUpdateService.updateVideoGame(name, params.developer, platform, barcode)
                break
            default:
                successfulUpdate = false
        }
        render(view: "", params: [updateSuccessful: successfulUpdate])
    }

    @RequestMapping(method = RequestMethod.POST)
    def deleteMedia(String media, String barcode) {
        log.debug("Delete Media")
        boolean successfulDelete
        switch (media) {
            case "book":
                successfulDelete = mediaDeleteService.deleteBook(barcode)
                break
            case "movie":
                successfulDelete = mediaDeleteService.deleteMovie(barcode)
                break
            case "music":
                successfulDelete = mediaDeleteService.deleteMusic(barcode)
                break
            case "videogame":
                successfulDelete = mediaDeleteService.deleteVideoGame(barcode)
                break
            default:
                successfulDelete = false
        }
        render(view: "", params: [deleteSuccessful: successfulDelete])
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