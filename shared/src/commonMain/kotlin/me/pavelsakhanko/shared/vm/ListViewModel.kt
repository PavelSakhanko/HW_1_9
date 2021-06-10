package me.pavelsakhanko.shared

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

class ListViewModel {

    private val httpClient = HttpClient {
        install(JsonFeature) {
            val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }

    private val api = RecipeAPI(
        httpClient = httpClient,
        json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
    )

    suspend fun list(ingredients: String, query: String, page: Int): RecipeList {
        return api.getRecipe(i = ingredients, q = query, p = page)
    }
}
