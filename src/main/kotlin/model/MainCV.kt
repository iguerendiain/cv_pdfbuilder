package nacholab.cv.pdf.model

import kotlinx.serialization.Serializable

@Serializable
data class MainCV(
    val languages: List<Language>,
    val defaultLanguage: String,
    val navbar: NavBarData,
    val portfolio: PortfolioData,
    val cv: ResumeData,
    val contact: ContactData
){
    companion object{
        const val KEY_TITLE = "title"
    }
}