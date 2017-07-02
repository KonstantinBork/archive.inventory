package com.bork.inventory

class Movie extends Media {

    String director
    MoviePlatform platform

    static constraints = {

    }

    @Override
    void setHashCode() {
        hashCode = (name.hashCode() + barcode.hashCode() + director.hashCode() + platform.hashCode()) as String
    }

}