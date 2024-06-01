package com.duyle.navhostkot104

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoScaffoldScreen() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = "Drawer Item 1")
                Text(text = "Drawer Item 2")
                Text(text = "Drawer Item 3")
            }
        },
        content = {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("TopTop") },
                        navigationIcon = {
                            IconButton(onClick = {
                                scope.launch {
                                    if (drawerState.isClosed) drawerState.open() else drawerState.close()
                                }
                            }) {
                                Icon(Icons.Default.Menu, contentDescription = null)
                            }
                        },
                        actions = {
                            IconButton(onClick = { /* Handle search icon click */ }) {
                                Icon(Icons.Default.Search, contentDescription = null)
                            }
                            IconButton(onClick = { /* Handle shopping cart icon click */ }) {
                                Icon(Icons.Default.ShoppingCart, contentDescription = null)
                            }
                            IconButton(onClick = { /* Handle call icon click */ }) {
                                Icon(Icons.Default.Call, contentDescription = null)
                            }
                        }
                    )
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = { /* Handle FAB click */ }) {
                        Icon(Icons.Default.Add, tint = Color.White, contentDescription = null)
                    }
                },
                floatingActionButtonPosition = FabPosition.Center,
                bottomBar = {
                    Box {
                        NavigationBar(
                            modifier = Modifier
                                .align(Alignment.BottomCenter)
                                .padding(bottom = 32.dp)
                        ) {
                            NavigationBarItem(
                                selected = true,
                                onClick = { /* Handle item click */ },
                                icon = { Icon(Icons.Default.Home, contentDescription = null) },
                                label = { Text("Home") }
                            )
                            NavigationBarItem(
                                selected = false,
                                onClick = { /* Handle item click */ },
                                icon = { Icon(Icons.Default.ShoppingCart, contentDescription = null) },
                                label = { Text("Cart") }
                            )
                            NavigationBarItem(
                                selected = false,
                                onClick = { /* Handle item click */ },
                                icon = { Icon(Icons.Default.Search, contentDescription = null) },
                                label = { Text("Search") }
                            )
                            NavigationBarItem(
                                selected = false,
                                onClick = { /* Handle item click */ },
                                icon = { Icon(Icons.Default.Face, contentDescription = null) },
                                label = { Text("Profile") }
                            )
                        }
                    }
                }
            ) { paddingValues ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Body")
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun CheckoutScreenPreview() {
    DemoScaffoldScreen()
}
