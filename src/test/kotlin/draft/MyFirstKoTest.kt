package draft

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldBeInstanceOf
import io.kotest.matchers.types.shouldBeTypeOf

class MyFirstKoTest : FunSpec({

    beforeTest {
    }

    afterTest { (testCase, result) ->
    }

    test("My first test") {
        // test code
        var myFirstClass = MyFirstClass(1);

        myFirstClass.shouldBeTypeOf<MyFirstClass>()
        myFirstClass.shouldBeInstanceOf<MyFirstClass>()
        myFirstClass.shouldNotBeNull()
        //infix
        myFirstClass shouldBe MyFirstClass(0)
        myFirstClass shouldNotBe MyFirstClass(2)
    }

})
