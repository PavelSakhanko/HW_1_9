package me.pavelsakhanko.shared

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RecipeList (
    @SerialName("title")
    val title: String? = null,
    @SerialName("results")
    val results: List<Recipe>? = null
) {}