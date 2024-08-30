package nacholab.cv.pdf.components

import com.lowagie.text.Document
import com.lowagie.text.Paragraph
import nacholab.cv.pdf.theme.Theme

fun Title(document: Document, theme: Theme, text: String){
    Paragraph(text, theme.buildTitleFont()).
        apply { alignment = Paragraph.ALIGN_CENTER }
        .let { document.add(it) }
}