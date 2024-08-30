package nacholab.cv.pdf.components

import com.lowagie.text.Document
import com.lowagie.text.Font
import com.lowagie.text.Paragraph

fun Spacer(document: Document, size: Float){
    Paragraph(" ", Font(Font.HELVETICA, 1f))
        .apply { leading = size-1.5f }
        .let { document.add(it) }
}