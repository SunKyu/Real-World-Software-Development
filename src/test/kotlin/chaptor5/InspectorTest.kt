package chaptor5

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.lang.UnsupportedOperationException

class InspectorTest: FunSpec(){

    init {
        test("inspect one conditional evalutes true"){
            val facts = Facts()
            facts.addFact("jobTitle", "CEO")
            val conditionalAction = JobTitleCondition()
            val inspector = Inspector(arrayOf(conditionalAction))

            val reportList = inspector.inspect(facts)

            reportList.size shouldBe 1
            reportList[0].isPositive shouldBe true

        }
    }
    companion object {
        class JobTitleCondition: ConditionalAction {
            override fun evaluate(facts: Facts): Boolean {
                return "CEO" == facts.getFact("jobTitle")
            }

            override fun execute(facts: Facts) {
                throw(UnsupportedOperationException())
            }

        }

    }
}