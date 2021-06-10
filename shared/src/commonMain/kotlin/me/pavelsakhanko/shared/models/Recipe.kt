package me.pavelsakhanko.shared

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Recipe (
    @SerialName("href")
    val href: String,
    @SerialName("title")
    val title: String? = null,
    @SerialName("ingredients")
    val ingredients: String? = null,
    @SerialName("thumbnail")
    val thumbnail: String? = null
) {}

