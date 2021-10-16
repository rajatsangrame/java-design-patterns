package com.company.creational.abstractfactory.printer

import com.company.creational.abstractfactory.data.Data

class Epson : Printer {
    override fun initialise() {
        println("Epson initialised")
    }

    override fun connect(ip: String) {
        println("Epson connected to $ip")
    }

    override fun print(data: Data) {
        println("Epson printing $data")
    }

    override fun disconnect() {
        println("Epson disconnected")
    }
}