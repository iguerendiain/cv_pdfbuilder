package nacholab.cv.pdf

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json
import nacholab.cv.pdf.model.MainCV
import nacholab.cv.pdf.theme.MainTheme

suspend fun main(args: Array<String>) {

    if (args.isEmpty()) {
        println("Usage: cv2pdf dbURL [output] (will default to output.pdf)")
    } else {
        val dbURL = args[0]
        val output = args.getOrNull(1) ?: "./output.pdf"

        val client = HttpClient(CIO)
        val response: HttpResponse = client.get(dbURL)
        val dbRaw = response.bodyAsText()
        val jsonHandler = Json { ignoreUnknownKeys = true }
        val cvData = jsonHandler.decodeFromString<MainCV>(dbRaw)

        CV2PDF(outputFile = output, theme = MainTheme, cvData = cvData)
    }
}

