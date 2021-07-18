package chaptor5

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class BusinessRuleEngineTest : FunSpec({

    /*
    test("should havew no rules initially"){
        val businessRuleEngine = BusinessRuleEngine()

        businessRuleEngine.count() shouldBe 0
    }

    test("should add two actions"){
        val businessRuleEngine = BusinessRuleEngine()

        businessRuleEngine.addAction( { -> })
        businessRuleEngine.addAction( { -> })

        businessRuleEngine.count() shouldBe 2
    }

    test("should execute one action"){
        // given
        val businessRuleEngine = BusinessRuleEngine()
        val mockAction = mockk<Action>()
        every { mockAction.execute() } answers {}

        // when
        businessRuleEngine.addAction(mockAction)
        businessRuleEngine.run()

        // then
        verify {mockAction.execute()}
    }

     */

    test("should perform action with facts"){
        val mockAction = mockk<Action>()
        val mockFacts: Facts = mockk()
        val businessRuleEngine = BusinessRuleEngine(mockFacts)
        every { mockAction.execute(mockFacts) } answers {}

        businessRuleEngine.addAction(mockAction)
        businessRuleEngine.run()

        verify { mockAction.execute(mockFacts) }

    }

})
