package free.kotlin.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import free.kotlin.shoppinglist.domain.ShopItem
import free.kotlin.shoppinglist.domain.ShopListRepository

object ShopListRepositoryImpl: ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0
    private val shopListLD = MutableLiveData<List<ShopItem>>()

    init {
        for (i in 0..10){
            addShopItem(ShopItem("Name $i", i.toFloat(), true))
        }
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID){
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldShopItem = getShopItemById(shopItem.id)
        deleteShopItem(oldShopItem)
        addShopItem(shopItem)
    }

    override fun getShopItemById(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Element with id $shopItemId = null")
    }

    fun updateList(){
        shopListLD.value = shopList.toList()
    }
}