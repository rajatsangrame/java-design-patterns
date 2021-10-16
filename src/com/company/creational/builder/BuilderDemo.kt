package com.company.creational.builder

import java.time.LocalDate
import java.time.Period

fun main(args: Array<String>) {

    // Client
    val builder = User.Builder()
            .setFirstName("Mark")
            .setLastName("Henry")
            .setAddress(Address("Mumbai"))
            .setBirthDay(LocalDate.of(1995, 9, 18))
    val user = builder.build()
    println(user.toString())
}

// Product Class
class User {

    private lateinit var firstName: String
    private lateinit var lastName: String
    private lateinit var birthDay: LocalDate
    private lateinit var address: Address

    fun getAge(): String {
        val age = Period.between(birthDay,LocalDate.now())
        return age.years.toString()
    }

    fun getName() = "$firstName $lastName"

    override fun toString(): String {
        return "${getName()} ${getAge()}"
    }

    // Builder
    class Builder {
        private val user: User = User()

        fun setFirstName(firstName: String): Builder {
            user.firstName = firstName
            return this
        }

        fun setLastName(lastName: String): Builder {
            user.lastName = lastName
            return this
        }

        fun setBirthDay(birthDay: LocalDate): Builder {
            user.birthDay = birthDay
            return this
        }

        fun setAddress(address: Address): Builder {
            user.address = address
            return this
        }

        fun build() = user
    }
}

data class Address(private val city: String)