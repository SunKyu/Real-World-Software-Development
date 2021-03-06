package chaptor3

class HtmlExporter: Exporter {
    override fun export(summaryStatistics: SummaryStatistics): String {
        var result = "<!doctype html>"
        result += "<html lang='en'>"
        result += "<head><title>Bank Transaction Report</title></head>"
        result += "<body>"
        result += "<ul>"
        result += "<li><strong>The sum is</strong>: " + summaryStatistics.sum + "</li>"
        result += "<li><strong>The average is</strong>: " + summaryStatistics.average + "</li>"
        result += "<li><strong>The max is</strong>: " + summaryStatistics.max + "</li>"
        result += "<li><strong>The min is</strong>: " + summaryStatistics.min + "</li>"
        result += "</ul>"
        result += "</body>"
        result += "</html>"
        return result
    }
}