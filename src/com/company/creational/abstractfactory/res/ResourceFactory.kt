package com.company.creational.abstractfactory.res

import com.company.creational.abstractfactory.printer.Printer
import com.company.creational.abstractfactory.data.Data

interface ResourceFactory {

    fun createPrinter(): Printer

    fun createData(data: String): Data
}