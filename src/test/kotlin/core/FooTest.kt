package core

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe


class FooTest  : FunSpec({
    /* TODO: property test, round trip Command Valid => Json Valid  */
    /* Json Invalid => Nothing */

    test("command valid transaction") {

        val input = "New register transaction"
        val jsonInput = "{    }"
        val c = CommandRegisterTransaction()
        val sut =

        false shouldBe true
    }

})
