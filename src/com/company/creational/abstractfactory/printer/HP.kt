package com.company.creational.abstractfactory.printer

import com.company.creational.abstractfactory.data.Data

class HP : Printer {
    override fun initialise() {
        println("HP initialised")
    }

    override fun connect(ip: String) {
        println("HP connected to $ip")
    }

    override fun print(data: Data) {
        println("HP printing $data")
    }

    override fun disconnect() {
        println("HP disconnected")
    }
}