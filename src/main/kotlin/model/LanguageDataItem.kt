package nacholab.cv.pdf.model

import kotlinx.serialization.Serializable

@Serializable
data class LanguageDataItem(
    val title: HashMap<String, String?>,
    val description: HashMap<String, String?>
)