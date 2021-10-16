package com.company.creational.abstractfactory.data

import com.company.creational.abstractfactory.data.Data

class EpsonData : Data {
    override fun getData(): String {
        return "EpsonData"
    }
}