package chaptor5

class Inspector(
    conditionalActions: Array<ConditionalAction>
){
    val conditionalActionList = conditionalActions.toList()

    fun inspect(facts: Facts): List<Report>{
        val reportList = ArrayList<Report>()

        for (conditionalAction in conditionalActionList){
            val conditionResult = conditionalAction.evaluate(facts)
            reportList.add(Report(conditionalAction, facts, conditionResult))
        }
        return reportList
    }
}