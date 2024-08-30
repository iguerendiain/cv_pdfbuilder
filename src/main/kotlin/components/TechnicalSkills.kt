package nacholab.cv.pdf.components

import com.lowagie.text.Chunk
import com.lowagie.text.Document
import com.lowagie.text.Paragraph
import com.lowagie.text.Phrase
import nacholab.cv.pdf.model.TechData
import nacholab.cv.pdf.theme.Theme

fun TechnicalSkills(document: Document, techSkillData: TechData, language: String, theme: Theme){
    techSkillData.title[language]?.let { Title (document, theme, it) }

    Spacer(document, 15f)

    techSkillData.content.forEach{ skill ->
        Phrase()
            .apply{
                add(Chunk("%s: ".format(skill.title[language])).apply { font = theme.buildSubtitleFont() })

                skill
                    .content
                    .mapIndexed { index, item ->
                        Chunk(
                            if (index < skill.content.size -1){
                                "%s, ".format(item)
                            }else item
                        ).apply { font = theme.buildDefaultFont() }
                    }
                    .forEach { add(it) }

                Paragraph(this).apply {
                }.let { document.add(it) }
            }

        Spacer(document, 10f)
    }
}