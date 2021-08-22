package free.kotlin.shoppinglist.domain

data class ShopItem(
    val id: Int,
    val name: String,
    val count: Float,
    val isActive: Boolean
)
