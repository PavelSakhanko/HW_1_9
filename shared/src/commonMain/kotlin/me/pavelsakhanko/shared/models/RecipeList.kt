package me.pavelsakhanko.shared.models

import kotlinx.serialization.*

/**
 *
 * @param title
 * @param results
 */
@Serializable
data class RecipeList (
    @SerialName(value = "title") val title: String? = null,
    @SerialName(value = "results") val results: List<Recipe>? = null
)