package com.lastminutedevice.mediumroast.test.dsl

open class BaseBot {

    // Overriding 'invoke' allows us to call code in this class without explicitly naming a function.
    operator fun invoke(block: BaseBot.() -> Unit) {
        BaseBot().block()
    }
}
