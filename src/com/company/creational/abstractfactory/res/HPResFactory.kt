package com.company.creational.abstractfactory.res

import com.company.creational.abstractfactory.printer.HP
import com.company.creational.abstractfactory.printer.Printer
import com.company.creational.abstractfactory.data.Data
import com.company.creational.abstractfactory.data.HPData

class HPResFactory : ResourceFactory {

    override fun createPrinter(): Printer {
        return HP()
    }

    override fun createData(data: String): Data {
        return HPData()
    }
}