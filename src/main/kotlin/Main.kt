package nacholab.cv.pdf

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json
import nacholab.cv.pdf.model.MainCV
import nacholab.cv.pdf.theme.MainTheme

suspend fun main() {

    val client = HttpClient(CIO)
    val response: HttpResponse = client.get("https://ignacio.guerendiain.com.ar/assets/db.json")
    val dbRaw = response.bodyAsText()
    val jsonHandler = Json { ignoreUnknownKeys = true }
    val cvData = jsonHandler.decodeFromString<MainCV>(dbRaw)

    CV2PDF(
        outputFile = "/home/iguerendiain/Cosas/output.pdf",
        theme = MainTheme,
        cvData = cvData,
        language = "en"
    )

}