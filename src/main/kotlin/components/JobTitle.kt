package nacholab.cv.pdf.components

import com.lowagie.text.Chunk
import com.lowagie.text.Document
import com.lowagie.text.Phrase
import nacholab.cv.i18n.i18n
import nacholab.cv.pdf.theme.Theme
import nacholab.cv.pdf.tools.toMonth

fun JobTitle(
    document: Document,
    theme: Theme,
    language: String,
    name: String?,
    url: String?,
    from: List<Int>,
    to: List<Int>?
) {
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
                            from[0].toMonth(language),
                            from[1],
                            to[0].toMonth(language),
                            to[1]
                        )
                    }else{
                        "%s %s %s".format(
                            "since".i18n(language),
                            from[0].toMonth(language),
                            from[1]
                        )
                    }
                ).apply { font = theme.buildDefaultFont() },
            ).forEach { add(it) }
        }
        .let { document.add(it) }
}