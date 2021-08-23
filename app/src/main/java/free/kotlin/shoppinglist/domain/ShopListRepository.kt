package free.kotlin.shoppinglist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    fun getShopList(): LiveData<List<ShopItem>>
    fun addShopItem(shopItem: ShopItem)
    fun deleteShopItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopItemById(shopItemId: Int): ShopItem
}