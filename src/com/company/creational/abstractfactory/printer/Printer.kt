package com.company.creational.abstractfactory.printer

import com.company.creational.abstractfactory.data.Data

interface Printer {

    fun initialise()

    fun connect(ip: String)

    fun print(data: Data)

    fun disconnect()
}