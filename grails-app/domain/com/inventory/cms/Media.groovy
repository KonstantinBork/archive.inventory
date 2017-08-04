package com.inventory.cms

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

    def beforeUpdate() {
        setHashCode()
    }

    abstract void setHashCode()

}