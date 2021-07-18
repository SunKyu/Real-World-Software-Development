package chaptor5

class Chaptor5Main(
    val args: Array<String>
) {
    fun main(){
        var env = Facts()
        env.addFact("name", "bob")
        env.addFact("jobTitle", "CEO")

        val businessRuleEngine = BusinessRuleEngine(env)
        /*
        businessRuleEngine.addAction( {facts ->
            val jobtitle = facts.getFact("jobTitle")
            if (jobtitle == "CEO"){
                //do something
            }
        })

         */
        businessRuleEngine.run()
    }
}