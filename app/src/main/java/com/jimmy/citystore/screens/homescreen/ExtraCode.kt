package com.jimmy.citystore.screens.homescreen

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

//
//class HomeViewModel : ViewModel() {
//    private var _homeUiState = MutableStateFlow(HomeUiState())
//    var homeUiState= _homeUiState.asStateFlow()
//
//    private var _cartItems = MutableStateFlow<List<Item>>(emptyList())
//    val cartItems = _cartItems.asStateFlow() // State to track cart items
//
//    private var _filteredItems = MutableStateFlow<List<Item>>(emptyList())
//    val filteredItems = _filteredItems.asStateFlow() // State to track filtered items
//
//
//    init {
//        updateHomeItems()
//    }
//
//    fun updateHomeItems() {
//        val db = Firebase.firestore
//        db.collection("items").get()
//            .addOnSuccessListener { result ->
//                val itemList = result.mapNotNull { document ->
//                    document.toObject(Item::class.java)
//                }
//                _homeUiState.value = _homeUiState.value.copy(items = itemList)
//                _filteredItems.value = itemList // Initialize filteredItems with all items
//            }
//    }
//    // Filter items based on the category (section)
//    fun filterItemsByCategory(category: String?) {
//        _filteredItems.value = if (category.isNullOrEmpty()) {
//            _homeUiState.value.items // If no category selected, show all items
//        } else {
//            _homeUiState.value.items.filter { it.category == category }
//        }
//    }
//
//    fun addOrder(name: String, price: String) {
//        val db = Firebase.firestore
//        val order = hashMapOf(
//            "name" to name,
//            "price" to price,
//            "timestamp" to FieldValue.serverTimestamp() // To track when the order was placed
//        )
//
//        db.collection("orders")
//            .add(order)
//            .addOnSuccessListener {
//                // Handle success (e.g., show a success message)
//            }
//            .addOnFailureListener { e ->
//                // Handle failure (e.g., show an error message)
//            }
//    }
//    fun addItemToCart(item: Item) {
//        _cartItems.value = _cartItems.value + item // Add new item to the cart list
//    }
//
//}
//
//data class HomeUiState(
//    val items: List<Item> = emptyList(),
//    val sections: List<Section> = emptyList(),
//    val selectedSection: Section? = null,
//    val subSections: List<SubSection> = emptyList(),
//    val selectedSubSection: SubSection? = null
//)
//
//data class Item(
//    val selectedOption:String = "",
//    val name: String = "",
//    val markeetPrice: String = "",
//    val ourPrice:String = "",
//    val youSave:String = "",
//    val image: String = "",
//    val itemQuantity:String = "",
//    val category: String = ""
//)
//
//class HomeViewModel : ViewModel() {
//
//    private val _homeUiState = MutableStateFlow(HomeUiState())
//    val homeUiState = _homeUiState.asStateFlow()
//
//    private val _filteredItems = MutableStateFlow<List<Item>>(emptyList())
//    val filteredItems = _filteredItems.asStateFlow()
//    private var _cartItems = MutableStateFlow<List<Item>>(emptyList())
//    val cartItems = _cartItems.asStateFlow() // State to track cart items
//
//    init {
//        loadHomeItems()
//    }
//
//    fun loadHomeItems() {
//        // Load items from Firestore
//        val db = Firebase.firestore
//        db.collection("items").get()
//            .addOnSuccessListener { result ->
//                val items = result.mapNotNull { it.toObject(Item::class.java) }
//                _homeUiState.value = HomeUiState(allItems = items, sections = allSections)
//                _filteredItems.value = items
//            }
//    }
//
//    fun showAllItems() {
//        _filteredItems.value = _homeUiState.value.allItems
//    }
//
//    fun filterItemsBySection(section: Section) {
//        _homeUiState.value = _homeUiState.value.copy(selectedSection = section, isSectionSelected = true)
//        _filteredItems.value = _homeUiState.value.allItems.filter { it.category == section.name }
//    }
//
//    fun filterItemsBySubSection(subSection: SubSection) {
//        _filteredItems.value = _homeUiState.value.allItems.filter { it.subCategory == subSection.name }
//    }
//
//    fun addItemToCart(item: Item) {
//        // Add item to cart (implementation not shown)
//    }
//}
//
//data class HomeUiState(
//    val allItems: List<Item> = emptyList(),
//    val sections: List<Section> = emptyList(),
//    val selectedSection: Section? = null,
//    val subSections: List<SubSection> = emptyList(),
//    val selectedSubSection: SubSection? = null,
//    val isSectionSelected:Boolean? = false,
//    val sectionItems:List<Item> = emptyList(),
//    val sectionAndSubsectionItems:List<Item> = emptyList()
//)
//
//data class Item(
//    val subCategory:String = "",
//    val name: String = "",
//    val markeetPrice: String = "",
//    val ourPrice:String = "",
//    val youSave:String = "",
//    val image: String = "",
//    val itemQuantity:String = "",
//    val category: String = ""
//)
