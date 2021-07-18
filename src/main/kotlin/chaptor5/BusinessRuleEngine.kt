package chaptor5

class BusinessRuleEngine(
    val facts: Facts
) {
    val actions = mutableListOf<Action>()

    fun addAction(action: Action) {
        actions.add(action)
    }

    fun count() : Int = actions.size

    fun run() {
        actions.forEach { it.execute(facts) }
    }

}