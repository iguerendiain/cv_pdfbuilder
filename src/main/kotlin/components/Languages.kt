package nacholab.cv.pdf.components

import com.lowagie.text.Chunk
import com.lowagie.text.Document
import com.lowagie.text.Paragraph
import com.lowagie.text.Phrase
import nacholab.cv.pdf.model.LanguagesData
import nacholab.cv.pdf.theme.Theme

fun Languages(document: Document, languageData: LanguagesData, language: String, theme: Theme){
    languageData.title[language]?.let { Title(document, theme, it) }

    languageData.content.forEach{ lang ->
        Phrase()
            .apply{
                add(Chunk("%s: ".format(lang.title[language])).apply { font = theme.buildSubtitleFont() })
                add(Chunk(lang.description[language]).apply { font = theme.buildDefaultFont() })
                document.add(Paragraph(this))
                Spacer(document, 15f)
            }
    }
}