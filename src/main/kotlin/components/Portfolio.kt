package nacholab.cv.pdf.components

import com.lowagie.text.Chunk
import com.lowagie.text.Document
import com.lowagie.text.Paragraph
import com.lowagie.text.Phrase
import nacholab.cv.pdf.model.MainCV
import nacholab.cv.pdf.model.PortfolioData
import nacholab.cv.pdf.theme.Theme

fun Portfolio(document: Document, portfolio: PortfolioData, language: String, theme: Theme){
    portfolio.title[language]?.let { Title(document, theme, it) }

    portfolio
        .projects
        .subList(0, portfolio.projects.size-2)
        .forEach { project ->
        Phrase()
            .apply {
                mutableListOf<Chunk>()
                    .apply {
                        project.title[language]
                            ?.let { Chunk(it) }
                            ?.apply {
                                val url = project.urls?.firstOrNull()?.url

                                if (url?.isNotBlank() == true){
                                    font = theme.buildSubtitleLinkFont()
                                    setAnchor(url)
                                }else{
                                    font = theme.buildSubtitleFont()
                                }
                            }
                            ?.let { add(it) }

                        project
                            .urls
                            ?.subList(1, project.urls.size)
                            ?.forEachIndexed { index, url ->
                                if (index == 0)
                                    Chunk(" - ")
                                        .apply { font = theme.buildSubtitleFont() }
                                        .let { add(it) }

                                Chunk(url.title[language])
                                    .apply {
                                        font = theme.buildSubtitleLinkFont()
                                        setAnchor(url.url)
                                    }
                                    .let { add(it) }
                                if (index < project.urls.size - 2) {
                                    Chunk(", ")
                                        .apply { font = theme.buildSubtitleLinkFont() }
                                        .let { add(it) }
                                }
                            }
                    }
                    .forEach { add(it) }
            }
            .let { document.add(Paragraph(it)) }

        Phrase()
            .apply{
                project.items.mapIndexed { index, item ->
                    Chunk(
                        if (index < project.items.size -1){
                            "%s // ".format(item[MainCV.KEY_TITLE]?.get(language))
                        }else item[MainCV.KEY_TITLE]?.get(language)
                    ).apply { font = theme.buildDefaultFont() }
                }
                .forEach { add(it) }

                Paragraph(this)
                    .apply { alignment = Paragraph.ALIGN_JUSTIFIED}
                    .let { document.add(it) }
            }

        Spacer(document, 15f)
    }
}