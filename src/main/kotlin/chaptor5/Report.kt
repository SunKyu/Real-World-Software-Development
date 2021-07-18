package chaptor5

class Report(
    val conditionalAction: ConditionalAction? = null,
    val facts: Facts? = null,
    val isPositive: Boolean = false

) {
    override fun toString(): String {
        return "Diagnosis{" +
                "conditionalAction=" + conditionalAction +
                ", facts=" + facts +
                ", result=" + isPositive +
                '}'
    }
}