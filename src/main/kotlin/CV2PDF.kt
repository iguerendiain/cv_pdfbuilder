package nacholab.cv.pdf

import com.lowagie.text.Document
import com.lowagie.text.Element
import com.lowagie.text.pdf.PdfName
import com.lowagie.text.pdf.PdfPageEventHelper
import com.lowagie.text.pdf.PdfString
import com.lowagie.text.pdf.PdfWriter
import nacholab.cv.pdf.components.*
import nacholab.cv.pdf.model.MainCV
import nacholab.cv.pdf.theme.Theme
import java.io.FileOutputStream

fun CV2PDF(
    outputFile: String,
    theme: Theme,
    cvData: MainCV,
    language: String
){

    val document = Document(
        theme.PAGE_SIZE,
        theme.MARGIN_HORIZONTAL,
        theme.MARGIN_HORIZONTAL,
        theme.MARGIN_VERTICAL,
        theme.MARGIN_VERTICAL
    )

    val pdfWriter = PdfWriter.getInstance(document, FileOutputStream(outputFile))

    pdfWriter.pageEvent = object: PdfPageEventHelper() {
        override fun onStartPage(writer: PdfWriter?, document: Document?) {
            buildHeaderFooter(
                writer = writer,
                navBarData = cvData.navbar,
                contactData = cvData.contact,
                language = language,
                theme = theme,
                y = (writer?.pageSize?.height?:0f) - theme.HEADER_MARGIN_VERTICAL
            )
        }

        override fun onEndPage(writer: PdfWriter?, document: Document?) {
            buildHeaderFooter(
                writer = writer,
                navBarData = cvData.navbar,
                contactData = cvData.contact,
                language = language,
                theme = theme,
                y = theme.HEADER_MARGIN_VERTICAL + 35f
            )
        }
    }

    document.open()

    pdfWriter.info.put(PdfName.CREATOR, PdfString(Document.getVersion()))

    WorkExperience(document, cvData.cv.work, language, theme)
    document.newPage()
    TechnicalSkills(document, cvData.cv.tech, language, theme)
    Spacer(document, 15f)
    Languages(document, cvData.cv.languages, language, theme)
    Spacer(document, 15f)
    Portfolio(document, cvData.portfolio, language, theme)

    document.close()
}