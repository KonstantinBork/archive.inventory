package com.bork.inventory

class VideoGame extends Media {

    String developer
    VideogamePlatform platform

    static constraints = {

    }

    @Override
    void setHashCode() {
        hashCode = (name.hashCode() + barcode.hashCode() + developer.hashCode() + platform.hashCode()) as String
    }

}