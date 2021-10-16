package com.company.creational.abstractfactory

import com.company.creational.abstractfactory.printer.Printer
import com.company.creational.abstractfactory.res.HPResFactory
import com.company.creational.abstractfactory.res.ResourceFactory

fun main(args: Array<String>) {

    val client = Client()
    val factory = HPResFactory()
    val data = factory.createData("Print Data")

    val printer = client.createPrinter(factory)
    printer.connect("192.68.1.103")
    printer.print(data)
    printer.disconnect()
}

class Client {

    fun createPrinter(factory: ResourceFactory): Printer {
        val printer = factory.createPrinter()
        printer.initialise()
        return printer
    }
}