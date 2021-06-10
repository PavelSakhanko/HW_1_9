package me.pavelsakhanko.shared

import io.ktor.client.HttpClient
import io.ktor.client.call.ReceivePipelineException
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.request
import io.ktor.http.HttpMethod
import io.ktor.http.takeFrom
import kotlinx.serialization.json.Json

class RecipeAPI(
    basePath: String = "http://www.recipepuppy.com",
    httpClient: HttpClient,
    json: Json
) {
    private val _basePath = basePath
    private val _httpClient = httpClient
    private val _json = json

    @Suppress("UNCHECKED_CAST")
    suspend fun getRecipe(i: String, q: String?, p: Int?) : RecipeList {
        val builder = HttpRequestBuilder()

        builder.method = HttpMethod.Get
        builder.url {
            takeFrom(_basePath)
            encodedPath = encodedPath.let { startingPath ->
                path("api/")
                return@let startingPath + encodedPath.substring(1)
            }
            @Suppress("UNNECESSARY_SAFE_CALL")
            with(parameters) {
                i?.let { append("i", it.toString()) }
                q?.let { append("q", it.toString()) }
                p?.let { append("p", it.toString()) }
            }
        }

        with(builder.headers) {
            append("Accept", "application/json")
        }

        try {
            val result: String = _httpClient.request(builder)
            return _json.decodeFromString(RecipeList.serializer(), result)
        } catch (pipeline: ReceivePipelineException) {
            throw pipeline.cause
        }
    }
}