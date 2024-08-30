package nacholab.cv.pdf.theme

import com.lowagie.text.Font
import com.lowagie.text.Rectangle

interface Theme{
    val COLORS: Colors

    // General
    val PAGE_SIZE: Rectangle
    val MARGIN_HORIZONTAL: Float
    val MARGIN_VERTICAL: Float
    val DEFAULT_FONT_FAMILY: Int
    val DEFAULT_FONT_STYLE: Int
    val DEFAULT_FONT_SIZE: Float

    // Header / Footer
    val HEADER_FOOTER_FONT_SIZE: Float
    val HEADER_MARGIN_VERTICAL: Float

    // Title
    val TITLE_FONT_FAMILY: Int
    val TITLE_FONT_STYLE: Int
    val TITLE_FONT_SIZE: Float

    // Subtitle
    val SUBTITLE_FONT_FAMILY: Int
    val SUBTITLE_FONT_STYLE: Int
    val SUBTITLE_FONT_SIZE: Float

    fun buildDefaultHeaderFont(): Font{
        return Font(DEFAULT_FONT_FAMILY, HEADER_FOOTER_FONT_SIZE, DEFAULT_FONT_STYLE, COLORS.DEFAULT_TEXT)
    }

    fun buildLinkHeaderFont(): Font{
        return Font(DEFAULT_FONT_FAMILY, HEADER_FOOTER_FONT_SIZE, DEFAULT_FONT_STYLE, COLORS.LINK_TEXT)
    }

    fun buildTitleFont(): Font{
        return Font(TITLE_FONT_FAMILY, TITLE_FONT_SIZE, TITLE_FONT_STYLE, COLORS.DEFAULT_TEXT)
    }

    fun buildDefaultFont(): Font{
        return Font(DEFAULT_FONT_FAMILY, DEFAULT_FONT_SIZE, DEFAULT_FONT_STYLE, COLORS.DEFAULT_TEXT)
    }

    fun buildLinkFont(): Font{
        return Font(DEFAULT_FONT_FAMILY, DEFAULT_FONT_SIZE, DEFAULT_FONT_STYLE, COLORS.LINK_TEXT)
    }

    fun buildSubtitleFont(): Font{
        return Font(SUBTITLE_FONT_FAMILY, SUBTITLE_FONT_SIZE, SUBTITLE_FONT_STYLE, COLORS.DEFAULT_TEXT)
    }

    fun buildSubtitleLinkFont(): Font{
        return Font(SUBTITLE_FONT_FAMILY, SUBTITLE_FONT_SIZE, SUBTITLE_FONT_STYLE, COLORS.LINK_TEXT)
    }
}

