package com.bork.inventory

abstract class Media {

    String name
    String barcode
    String hashCode = null

    static constraints = {

    }

    def beforeInsert() {
        if(!hashCode) {
            setHashCode()
        }
    }

    abstract void setHashCode()

}