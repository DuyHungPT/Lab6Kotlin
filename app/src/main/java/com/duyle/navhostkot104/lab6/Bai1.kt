//package com.duyle.navhostkot104
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.lazy.rememberLazyListState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import coil.compose.AsyncImage
//
//data class Movie(
//    val title: String,
//    val year: String,
//    val posterUrl: String
//) {
//    companion object {
//        fun getSampleMovies() = listOf(
//            Movie("Movie 1", "2023", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQT78twdRqOflfGqu0PV8lIgNViVpThhmIGhQ&s"),
//            Movie("Movie 2", "2022", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT64BRWov6lv8ET0qq7ducYOOTcese6U4W_OA&s"),
//            Movie("Movie 3", "2021", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQNs7f4edDw2UjVXwiCsKu304xicfJWzuWtLA&s"),
//            Movie("Movie 4", "2020", "https://example.com/poster4.jpg"),
//            Movie("Movie 5", "2019", "https://example.com/poster5.jpg")
//        )
//    }
//}
//
//@Composable
//fun MovieItem(movie: Movie) {
//    Card(
//        colors = CardDefaults.cardColors(containerColor = Color.White),
//        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
//        modifier = Modifier
//            .width(175.dp)
//            .height(330.dp)
//    ) {
//        Column {
//            AsyncImage(
//                model = movie.posterUrl,
//                contentScale = ContentScale.Crop,
//                contentDescription = null,
//                modifier = Modifier
//                    .height(255.dp)
//                    .fillMaxWidth()
//                    .clip(RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp))
//            )
//            Column(modifier = Modifier.padding(8.dp)) {
//                Text(
//                    text = movie.title,
//                    style = MaterialTheme.typography.titleSmall,
//                    maxLines = 2
//                )
//                Text(
//                    text = "Year: ${movie.year}",
//                    style = MaterialTheme.typography.bodySmall
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun MovieScreen(movies: List<Movie>) {
//    LazyRow(
//        state = rememberLazyListState(),
//        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
//        horizontalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        items(movies) { movie ->
//            MovieItem(movie = movie)
//        }
//    }
//}
//
//class Bai1 : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MovieScreen(Movie.getSampleMovies())
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MovieScreen(Movie.getSampleMovies())
//}
