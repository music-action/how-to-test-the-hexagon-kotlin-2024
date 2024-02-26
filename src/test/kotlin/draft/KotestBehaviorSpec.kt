package draft


import io.kotest.core.spec.style.BehaviorSpec

class SampleBehaviorSpec : BehaviorSpec({
    given("I have sufficient balance") {
        `when`("I make a card payment") {
            then("The card payment should be successful") {
                // test code
            }
        }
    }
})