package nacholab.cv.pdf.model

import kotlinx.serialization.Serializable

@Serializable
data class PortfolioData(
    val title: HashMap<String, String?>,
    val projects: List<ProjectData>
)