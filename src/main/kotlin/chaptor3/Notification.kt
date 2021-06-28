package chaptor3

class Notification {
    val errors = arrayListOf<String>()

    fun addError(message: String){
        errors.add(message)
    }

    fun hasError(): Boolean {
        return errors.isNotEmpty()
    }

    fun errorMessage(): String {
        return errors.toString()
    }
}