package me.pavelsakhanko.shared.models

import kotlinx.serialization.*

/**
 *
 * @param href
 * @param title
 * @param ingredients
 * @param thumbnail
 */
@Serializable
data class Recipe (
    @SerialName(value = "href") @Required val href: String,
    @SerialName(value = "title") val title: String? = null,
    @SerialName(value = "ingredients") val ingredients: String? = null,
    @SerialName(value = "thumbnail") val thumbnail: String? = null
)

