package free.kotlin.shoppinglist.domain

data class ShopItem(
    val name: String,
    val count: Float,
    val isActive: Boolean,
    var id: Int = UNDEFINED_ID
){
    companion object{
        const val UNDEFINED_ID = -1
    }
}
