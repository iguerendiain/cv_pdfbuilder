package nacholab.cv.pdf.tools

import nacholab.cv.i18n.i18nMonth
import java.util.*

fun Long.toMonth(languageCode: String): String{
    val calendar = Calendar.getInstance()
    calendar.time = Date(this*1000+100000000)
    return calendar.get(Calendar.MONTH).i18nMonth(languageCode)
}

fun Long.toYear(): String{
    val calendar = Calendar.getInstance()
    calendar.time = Date(this*1000+100000000)
    return calendar.get(Calendar.YEAR).toString()
}