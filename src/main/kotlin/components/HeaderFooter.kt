package nacholab.cv.pdf.components

import com.lowagie.text.*
import com.lowagie.text.pdf.PdfPCell
import com.lowagie.text.pdf.PdfPTable
import com.lowagie.text.pdf.PdfWriter
import nacholab.cv.pdf.model.ContactData
import nacholab.cv.pdf.model.NavBarData
import nacholab.cv.pdf.theme.Theme

fun buildHeaderFooter(
    writer: PdfWriter?,
    navBarData: NavBarData,
    contactData: ContactData,
    language: String,
    theme: Theme,
    y: Float
){
    val table = PdfPTable(1)
    table.totalWidth = writer?.pageSize?.width?:0f

    Phrase()
        .apply {
            arrayOf(
                Chunk("${navBarData.title[language]} // ").apply { font = theme.buildDefaultHeaderFont() },
                Chunk("+54 11 3130 1701").apply {
                    font = theme.buildLinkHeaderFont()
                    setAnchor("cel:+541131301701")
                },
                Chunk(" // ").apply { font = theme.buildDefaultHeaderFont() },
                Chunk(contactData.email).apply {
                    font = theme.buildLinkHeaderFont()
                    setAnchor("mailto:${contactData.email})")
                },
            ).forEach { add(it) }
            table.addCell(
                PdfPCell(this).apply {
                    horizontalAlignment = Element.ALIGN_CENTER
                    border = Rectangle.NO_BORDER
                }
            )
        }

    Phrase()
        .apply {
            val portoflioURL = "https://ignacio.guerendiain.com.ar"
            val linkedInURL = "https://www.linkedin.com/in/iguerendiain"
            arrayOf(
                Chunk(portoflioURL).apply {
                    font = theme.buildLinkHeaderFont()
                    setAnchor(portoflioURL)
                },
                Chunk(" // ").apply { font = theme.buildDefaultHeaderFont() },
                Chunk(linkedInURL).apply {
                    font = theme.buildLinkHeaderFont()
                    setAnchor(linkedInURL)
                },
            ).forEach { add(it) }
            table.addCell(
                PdfPCell(this).apply {
                    horizontalAlignment = Element.ALIGN_CENTER
                    border = Rectangle.NO_BORDER
                }
            )
        }

    table.writeSelectedRows(0, -1, 0f, y, writer?.directContent)
}