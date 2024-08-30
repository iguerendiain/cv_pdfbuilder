package nacholab.cv.pdf.theme

import com.lowagie.text.Font
import com.lowagie.text.PageSize

object MainTheme: Theme {
    override val COLORS = object: Colors{
        override val DEFAULT_TEXT = MainColors.DARK_GRAY
        override val LINK_TEXT = MainColors.DARK_CYAN
    }

    // General
    override val PAGE_SIZE = PageSize.A4
    override val MARGIN_HORIZONTAL = 36f
    override val MARGIN_VERTICAL = 50f
    override val DEFAULT_FONT_FAMILY = Font.HELVETICA
    override val DEFAULT_FONT_STYLE = Font.NORMAL
    override val DEFAULT_FONT_SIZE = 9f

    // Header / Footer
    override val HEADER_FOOTER_FONT_SIZE = 10f
    override val HEADER_MARGIN_VERTICAL = 15f

    // Title
    override val TITLE_FONT_FAMILY = Font.HELVETICA
    override val TITLE_FONT_STYLE = Font.BOLD
    override val TITLE_FONT_SIZE = 12f

    // Subtitle
    override val SUBTITLE_FONT_FAMILY = Font.HELVETICA
    override val SUBTITLE_FONT_STYLE = Font.BOLD
    override val SUBTITLE_FONT_SIZE = 9f
}