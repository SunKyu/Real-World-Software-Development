package chaptor5

interface ConditionalAction {
    fun evaluate(facts: Facts): Boolean
    fun execute(facts: Facts)
}