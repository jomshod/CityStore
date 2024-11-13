package com.jimmy.citystore.screens.detailScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.jimmy.citystore.CutPrice
import com.jimmy.citystore.navigation.AppScreens
import com.jimmy.citystore.screens.cartScreen.CartScreenViewModel
import com.jimmy.citystore.screens.generalStoreScreen.GeneralStoreViewModel
import com.jimmy.citystore.screens.generalStoreScreen.Item

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DetailScreen(
    item: Item,
    vm: GeneralStoreViewModel,
    navController: NavController,
    cvm: CartScreenViewModel,
) {
    val generalStoreUiState by vm.generalStoreUiState.collectAsState()
    val pagerState = rememberPagerState(pageCount = { item.photos.size })
    val photoKeys = item.photos.keys.toList()

    Scaffold(topBar = {
        DetailScreenTopAppBar(
            onCartClick = { /*TODO*/ },
            title = "Details",
            vm = vm
        )
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
        ) {
            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                Text(text = item.name)
            }
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) { page ->

                Box(
                    modifier = Modifier
                        .fillMaxWidth() // Take full width for centering horizontally
                        .height(200.dp), // You can adjust height to your requirement
                    contentAlignment = Alignment.Center // Center content inside the box
                ) {
                    AsyncImage(
                        model = item.photos[photoKeys[page]],
                        contentDescription = "",
                        modifier = Modifier
                            .size(200.dp)
                            .padding(10.dp), contentScale = ContentScale.Crop
                    )
                }
            }
            Row(
                Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(pagerState.pageCount) { iteration ->
                    val color =
                        if (pagerState.currentPage == iteration) Color.Gray else Color.LightGray
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(12.dp)
                    )
                }
            }
            Row {
                Column {
                    Text(text = "Market Price")
                    CutPrice(text = item.marketPrice, modifier = Modifier.size(30.dp, 0.dp))
                }
                Spacer(modifier = Modifier.width(60.dp))
                Column {
                    Text(text = "Our Price")
                    Text(text = item.ourPrice)
                }


            }
            Text(
                text = item.description,
                modifier = Modifier.padding(16.dp),
                style = TextStyle(lineBreak = LineBreak.Paragraph)
            )
            Button(
                onClick = {
                    generalStoreUiState.item.totalCartItems++
                    cvm.AddInCart(item)
                    vm.resetHomeScreen()
                    navController.navigate(AppScreens.Home.route)
                },
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Add To Cart")
            }
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreenTopAppBar(
    modifier: Modifier = Modifier,
    onCartClick: () -> Unit,
    title: String,
    vm: GeneralStoreViewModel
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onPrimary,
            )
        },
        actions = {
            CartIcon(onCartClick, vm)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Composable
fun CartIcon(onCartClick: () -> Unit, vm: GeneralStoreViewModel) {
    val homeUiState by vm.generalStoreUiState.collectAsState()
    Row(modifier = Modifier.clickable(onClick = onCartClick)) {
        Icon(
            imageVector = Icons.Default.ShoppingCart,
            contentDescription = "Cart",
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.size(30.dp)
        )
        Surface(
            shape = RoundedCornerShape(15.dp),
            color = Color.Red.copy(alpha = 0.7f),
        ) {
            Text(
                text = homeUiState.item.totalCartItems.toString(),
                modifier = Modifier.padding(2.dp),
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                ),
            )
        }
    }
}

