package com.company.creational.simplefactory

class Rectangle : Shape {
    override fun draw() {
        println("Drawing Rectangle")
    }
}

class Circle : Shape {
    override fun draw() {
        println("Drawing Circle")
    }
}

class Square : Shape {
    override fun draw() {
        println("Drawing Square")
    }
}

interface Shape {
    fun draw()
}

class ShapeFactory {

    companion object {
        fun getShape(type: String): Shape {
            return when (type) {
                "Circle" -> Circle()
                "Square" -> Square()
                "Rectangle" -> Rectangle()
                else -> throw IllegalArgumentException("Invalid Shape")
            }
        }
    }
}

fun main(args: Array<String>) {

    ShapeFactory.getShape("Circle").draw()
}