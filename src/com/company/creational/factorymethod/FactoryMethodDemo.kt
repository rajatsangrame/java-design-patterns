package com.company.creational.factorymethod

abstract class Account {

    abstract fun getBalance(): Float

    fun processDocuments() {
    }

    fun doKyc() {
    }
}

class Sbi : Account() {
    override fun getBalance(): Float {
        return 5000f
    }
}

class Hdfc : Account() {
    override fun getBalance(): Float {
        return 6000f
    }
}

abstract class AccountCreator {

    abstract fun createAccount(): Account

    fun getAccount(): Account{
        val account = createAccount()
        account.processDocuments()
        account.doKyc()
        return account
    }
}

class SbiAccountCreator : AccountCreator(){
    override fun createAccount(): Account {
        return Sbi()
    }
}

class HdfcAccountCreator : AccountCreator(){
    override fun createAccount(): Account {
        return Hdfc()
    }
}

fun main(args: Array<String>) {

    // Client
    val accountCreator = SbiAccountCreator()
    val account = accountCreator.getAccount()
    val balance = account.getBalance()
    println(balance)

}