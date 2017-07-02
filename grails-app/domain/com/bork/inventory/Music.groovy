package com.bork.inventory

class Music extends Media {

    String interpreter

    static constraints = {

    }

    @Override
    void setHashCode() {
        hashCode = (name.hashCode() + barcode.hashCode() + interpreter.hashCode()) as String
    }

}