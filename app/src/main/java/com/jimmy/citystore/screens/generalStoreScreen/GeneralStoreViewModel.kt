package com.jimmy.citystore.screens.generalStoreScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class GeneralStoreViewModel : ViewModel() {

    private val _generalStoreUiState = MutableStateFlow(GeneralStoreUiState())
    val homeUiState = _generalStoreUiState.asStateFlow()

    private var allItems: List<Item> = emptyList() // Store all items fetched from Firestore
    private var allProducts: List<Product> = emptyList()
    private fun initializeFirebaseProjects() {
        // Default FirebaseApp for the first project (items)
        FirebaseApp.initializeApp(FirebaseApp.getInstance().applicationContext)

        // Initialize the second FirebaseApp with the second JSON file (products)
        val options = FirebaseOptions.Builder()
            .setProjectId("restaurant-4d63b")
            .setApplicationId("1:923934671778:android:bfcefbc9aa9b66cb0528fb")
            .setApiKey("AIzaSyBMpva03BoB_k0EByqa58HzPYHJokjFtfk")
//            .setDatabaseUrl("https://your-second-database-url.firebaseio.com")
            .build()
        FirebaseApp.initializeApp(FirebaseApp.getInstance().applicationContext, options, "secondFirebaseApp")
    }
    init {
        initializeFirebaseProjects()
        fetchItemsFromFireStore()
        fetchProductsFromSecondFireStore()
    }
    private fun fetchItemsFromFireStore() {
        val db = FirebaseFirestore.getInstance()

        db.collection("items")
            .get()
            .addOnSuccessListener { result ->
                val itemList = result.mapNotNull { document ->
                   document.toObject(Item::class.java)
                }
                allItems = itemList
                _generalStoreUiState.value = _generalStoreUiState.value.copy(homeItems = allItems)
                Log.d("image", "imagefromfirestore:${allItems[0].image} ")
            }
            .addOnFailureListener { exception ->
                // Handle the error
            }
    }
    private fun fetchProductsFromSecondFireStore() {
        val secondApp = FirebaseApp.getInstance("secondFirebaseApp") // Get the second Firebase instance
        val secondDb = FirebaseFirestore.getInstance(secondApp)

        secondDb.collection("products")
            .get()
            .addOnSuccessListener { result ->
                val productList = result.mapNotNull { document ->
                    document.toObject(Product::class.java)
                }
                allProducts = productList
                _generalStoreUiState.value = _generalStoreUiState.value.copy(products = allProducts)
                Log.d("Firestore", "Fetched products: $allProducts")
            }
            .addOnFailureListener { exception ->
                Log.e("Firestore", "Error fetching products", exception)
            }
    }
    fun onCategorySelected(category: Category) {
        _generalStoreUiState.value = _generalStoreUiState.value.copy(
            isCategorySelected = true,
            subCategories = category.subCategories,
            selectedCategory = category,
            homeItems = allItems.filter { it.category==category.name },



        )
    }



    fun onSubCategorySelected(subCategory: SubCategory) {
        // Filter items by both the selected category and subcategory
        val filteredItems = allItems.filter {
            it.category == _generalStoreUiState.value.selectedCategory?.name &&
                    it.subCategory == subCategory.name
        }

        _generalStoreUiState.value = _generalStoreUiState.value.copy(
            isSubCategorySelected = true,
            selectedSubCategory = subCategory,
            homeItems = filteredItems // Show filtered items by subcategory
        )
    }
    fun onAllClick() {
        _generalStoreUiState.value = _generalStoreUiState.value.copy(
            homeItems = allItems,  // Show all items
            isCategorySelected = false,  // Reset category selection if needed
            isSubCategorySelected = false,  // Reset subcategory selection if needed
            selectedCategory = null,  // Clear selected category
            selectedSubCategory = null // Clear selected subcategory
        )
    }
    fun resetHomeScreen() = onAllClick()
    fun updateItem(item: Item){
        _generalStoreUiState.value= _generalStoreUiState.value.copy(item=item)
    }



}
data class GeneralStoreUiState(
    val products: List<Product> = emptyList(),
    val product: Product = Product(),
    val item: Item= Item(),
    val homeItems: List<Item> = emptyList(), // All items from Firestore
    val filteredItems: List<Item> = emptyList(), // Items filtered by category and subcategory
    val isCategorySelected: Boolean = false,
    val isSubCategorySelected: Boolean = false,
    val subCategories: List<SubCategory> = emptyList(),
    val selectedCategory: Category? = null,
    val selectedSubCategory: SubCategory? = null,
    val isLoading: Boolean = false
)




data class Item(
    var name: String = "",
    var marketPrice: String = "",
    var ourPrice: String = "",
    var image: String = "",
    var category:String = "",
    var subCategory:String="",
    var description:String="",
    var photos:Map<String,String> = emptyMap(),
    var totalCartItems:Int = 0,
    var itemQuantity: Int = 1, // Default quantity is 1

    )
data class Product(
    var name:String = "",
    var price:String= "",
)