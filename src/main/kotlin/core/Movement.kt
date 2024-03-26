package core

import arrow.core.None
import arrow.core.Option
import arrow.core.Some

sealed class Movement(amount: Int) {
    abstract fun value(): Int


    data class Credit(val amount: Int) : Movement(1) {
        override fun value(): Int {
            return amount
        }
    }

    data class Debit(val amount: Int) : Movement(1) {
        override fun value(): Int {
            return  -amount
        }
    }

    companion object {
        fun debit(value: Int): Option<Debit> {
            if (value <= 0) {
                return None
            }
            return Some(Debit(value))
        }
    }

}
