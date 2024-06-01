package com.duyle.navhostkot104

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.lazy.staggeredgrid.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

data class Movie(
    val title: String,
    val year: String,
    val posterUrl: String,
    val duration: String,
    val releaseDate: String,
    val genre: String,
    val shotDescription: String
) {
    companion object {
        fun getSampleMovies() = listOf(
            Movie("Movie 1", "2023", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQT78twdRqOflfGqu0PV8lIgNViVpThhmIGhQ&s", "120 mins", "Jan 1, 2023", "Action", "An action-packed thriller."),
            Movie("Movie 2", "2022", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQT78twdRqOflfGqu0PV8lIgNViVpThhmIGhQ&s", "130 mins", "Feb 15, 2022", "Comedy", "A hilarious comedy."),
            Movie("Movie 3", "2021", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQT78twdRqOflfGqu0PV8lIgNViVpThhmIGhQ&s", "140 mins", "Mar 20, 2021", "Drama", "A touching drama."),
            Movie("Movie 4", "2020", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQT78twdRqOflfGqu0PV8lIgNViVpThhmIGhQ&s", "150 mins", "Apr 25, 2020", "Sci-Fi", "A sci-fi adventure."),
            Movie("Movie 5", "2019", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQT78twdRqOflfGqu0PV8lIgNViVpThhmIGhQ&s", "160 mins", "May 30, 2019", "Horror", "A spine-chilling horror.")
        )
    }
}

enum class ListType {
    ROW, COLUMN, GRID
}

@Composable
fun MovieItem(movie: Movie, listType: ListType) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier.then(getItemSizeModifier(listType))
    ) {
        Column {
            AsyncImage(
                model = movie.posterUrl,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.wrapContentHeight().fillMaxWidth()
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                BoldValueText(label = "Thời lượng: ", value = movie.duration)
                BoldValueText(label = "Khởi chiếu: ", value = movie.releaseDate)
            }
        }
    }
}

@Composable
fun BoldValueText(label: String, value: String) {
    Text(buildAnnotatedString {
        append(label)
        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
            append(value)
        }
    }, style = MaterialTheme.typography.bodySmall)
}

@Composable
fun getItemSizeModifier(listType: ListType): Modifier {
    return when (listType) {
        ListType.ROW -> Modifier.width(175.dp)
        ListType.COLUMN -> Modifier.fillMaxWidth()
        ListType.GRID -> Modifier.fillMaxWidth()
    }
}

@Composable
fun MovieColumnItem(movie: Movie) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row {
            AsyncImage(
                model = movie.posterUrl,
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .height(130.dp)
                    .width(100.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
            Column(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                BoldValueText(label = "Thời lượng: ", value = movie.duration)
                BoldValueText(label = "Khởi chiếu: ", value = movie.releaseDate)
                BoldValueText(label = "Thể loại: ", value = movie.genre)
                Text(
                    text = "Tóm tắt nội dung",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 4.dp, bottom = 2.dp)
                )
                Text(
                    text = movie.shotDescription,
                    style = MaterialTheme.typography.bodySmall,
                    maxLines = 5,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(end = 2.dp)
                )
            }
        }
    }
}

@Composable
fun MovieRow(movies: List<Movie>) {
    LazyRow(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movies.size) { index ->
            MovieItem(movie = movies[index], listType = ListType.ROW)
        }
    }
}

@Composable
fun MovieColumn(movies: List<Movie>) {
    LazyColumn(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movies.size) { index ->
            MovieColumnItem(movie = movies[index])
        }
    }
}

@Composable
fun MovieGrid(movies: List<Movie>) {
    val gridState = rememberLazyStaggeredGridState()
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        state = gridState,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalItemSpacing = 8.dp,
        contentPadding = PaddingValues(8.dp)
    ) {
        items(movies.size) { index ->
            MovieItem(movie = movies[index], listType = ListType.GRID)
        }
    }
}

class Bai2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieScreen(Movie.getSampleMovies())
        }
    }
}

@Composable
fun MovieScreen(movies: List<Movie>) {
    var listType by remember { mutableStateOf(ListType.ROW) }
    Column {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = { listType = ListType.ROW }) {
                Text("Row")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { listType = ListType.COLUMN }) {
                Text("Column")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { listType = ListType.GRID }) {
                Text("Grid")
            }
        }
        when (listType) {
            ListType.ROW -> MovieRow(movies)
            ListType.COLUMN -> MovieColumn(movies)
            ListType.GRID -> MovieGrid(movies)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieScreen(Movie.getSampleMovies())
}
