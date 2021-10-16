package com.company.creational.abstractfactory.res

import com.company.creational.abstractfactory.printer.Epson
import com.company.creational.abstractfactory.printer.Printer
import com.company.creational.abstractfactory.data.Data
import com.company.creational.abstractfactory.data.EpsonData

class EpsonResFactory : ResourceFactory {

    override fun createPrinter(): Printer {
        return Epson()
    }

    override fun createData(data: String): Data {
        return EpsonData()
    }
}