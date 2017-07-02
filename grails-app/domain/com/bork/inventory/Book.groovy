package com.bork.inventory

class Book extends Media {

    String author
    String publisher

    static constraints = {

    }

    @Override
    void setHashCode() {
        hashCode = (name.hashCode() + barcode.hashCode() + author.hashCode() + publisher.hashCode()) as String
    }

}