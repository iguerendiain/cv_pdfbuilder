package nacholab.cv.pdf.components

import com.lowagie.text.Document
import com.lowagie.text.Paragraph
import nacholab.cv.pdf.model.WorkExperienceData
import nacholab.cv.pdf.theme.Theme

fun WorkExperience(
    document: Document,
    workData: WorkExperienceData,
    language: String,
    theme: Theme
){
    workData.title[language]?.let { Title(document, theme, it) }

    Spacer(document, 20f)

    workData.content.forEach { job ->
        job.title[language]?.let {
            JobTitle(
                document = document,
                theme = theme,
                language = language,
                name = it,
                url = job.url,
                from = job.from,
                to = job.to
            )
        }

        Paragraph(job.description[language], theme.buildDefaultFont())
            .apply {
                alignment = Paragraph.ALIGN_JUSTIFIED
                indentationLeft = 20f
            }
            .let { document.add(it) }

        Spacer(document, 15f)
    }
}