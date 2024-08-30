package i18n

import nacholab.cv.i18n.Strings

class EnglishStrings : Strings {
    override val code = "en"

    override val strings = hashMapOf(
        "since" to "Since"
    )

    override val months = arrayOf(
        "January",
        "February",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December"
    )
}