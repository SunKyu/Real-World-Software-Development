package chaptor5

class Facts {
    val facts = HashMap<String, String>()

    fun getFact(name: String): String{
        return facts.get(name) ?: ""
    }

    fun addFact(name: String, value: String){
        facts[name] = value
    }

}
