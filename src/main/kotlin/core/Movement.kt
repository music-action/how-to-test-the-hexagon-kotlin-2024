package core

import arrow.core.None
import arrow.core.Option
import arrow.core.Some

sealed class Movement() {
    abstract fun value(): Int
    abstract operator fun plus(movement: Movement): Movement



    data class Credit(val amount: Int) : Movement() {
        override fun value(): Int {
            return amount
        }

        override fun plus(movement: Movement): Movement {
            return Movement.Credit(movement.value() + amount)
        }

    }

    data class Debit(val amount: Int) : Movement() {
        override fun value(): Int {
            return -amount
        }

        override fun plus(movement: Movement): Movement {
            return Movement.Debit(-movement.value() + amount)
        }
    }

    companion object {
        fun debit(value: Int): Option<Debit> {
            if (value <= 0) {
                return None
            }
            return Some(Debit(value))
        }

        fun credit(value: Int): Option<Credit> {
            if (value <= 0) {
                return None
            }
            return Some(Credit(value))
        }
    }

}
