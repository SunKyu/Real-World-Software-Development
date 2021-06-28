package chaptor3

interface Exporter {
    fun export(summaryStatistics: SummaryStatistics): String
}