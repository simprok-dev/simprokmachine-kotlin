//
//  Direction.kt
//  simprokmachine
//
//  Created by Andrey Prokhorenko on 12.03.2022.
//  Copyright (c) 2022 simprok. All rights reserved.

package com.simprok.simprokmachine.api

/**
 * A type that represents a behavior of `Machine.redirect()` operator.
 */
sealed interface Direction<Input> {

    /**
     * Returning this value from `Machine.redirect()`
     * method ensures that `[Input]` will be sent back to the child.
     */
    class Back<Input>(val values: List<Input>) : Direction<Input> {

        constructor(vararg values: Input) : this(values.toList())

        companion object {

            fun <Input> createArray(values: Array<Input>): Back<Input> = Back(values.toList())
        }
    }

    /**
     * Returning this value from `Machine.redirect()` method
     * ensures that the output will be pushed further to the root.
     */
    class Prop<Input> : Direction<Input>
}