package free.kotlin.shoppinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import free.kotlin.shoppinglist.data.ShopListRepositoryImpl
import free.kotlin.shoppinglist.domain.DeleteShopItemUseCase
import free.kotlin.shoppinglist.domain.EditShopItemUseCase
import free.kotlin.shoppinglist.domain.GetShopListUseCase
import free.kotlin.shoppinglist.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }
    fun changeActiveState(shopItem: ShopItem){
        val newShopItem = shopItem.copy(isActive = !shopItem.isActive)
        editShopItemUseCase.editShopItem(newShopItem)
    }
}