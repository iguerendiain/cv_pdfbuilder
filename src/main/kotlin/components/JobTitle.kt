package nacholab.cv.pdf.components

import com.lowagie.text.Chunk
import com.lowagie.text.Document
import com.lowagie.text.Phrase
import nacholab.cv.i18n.i18n
import nacholab.cv.pdf.theme.Theme
import nacholab.cv.pdf.tools.toMonth
import nacholab.cv.pdf.tools.toYear

fun JobTitle(document: Document, theme: Theme, language: String, name: String?, url: String?, from: Long, to: Long?) {
    Phrase()
        .apply {
            arrayOf(
                Chunk(name).apply {
                    if (url?.isNotBlank() == true){
                        font = theme.buildLinkFont()
                        setAnchor(url)
                    }else{
                        font = theme.buildDefaultFont()
                    }
                },
                Chunk(" // ").apply { font = theme.buildDefaultFont() },
                Chunk(
                    if (to != null){
                        "%s %s ~ %s %s".format(
                            from.toMonth(language),
                            from.toYear(),
                            to.toMonth(language),
                            to.toYear()
                        )
                    }else{
                        "%s %s %s".format(
                            "since".i18n(language),
                            from.toMonth(language),
                            from.toYear()
                        )
                    }
                ).apply { font = theme.buildDefaultFont() },
            ).forEach { add(it) }
        }
        .let { document.add(it) }
}