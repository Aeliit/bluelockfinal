package com.example.bluelockfinal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun CharactersPage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp, bottom = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column {
                Text(
                    text = "Explore",
                    fontSize = 28.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Characters",
                    fontSize = 28.sp,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
            Text(
                text = "",
            )
            Text(
                text = "",
            )

            Icon(
                painter = painterResource(id = R.drawable.baseline_person_search_24),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
        }

        Spacer(modifier = Modifier.weight(2f))
        val hexColor = Color(0xFF000068)
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(hexColor, shape = RoundedCornerShape(16.dp))
                .padding(20.dp)
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(listOf(
                    Character("Jahzeel Berba Amul", " ano eme lang ", R.drawable.jahzeel),
                    Character("Wilson Malate Jr.", " ano comeback ", R.drawable.wilson),
                    Character("James Matthew Velasco", " bebetime ", R.drawable.matthew),
                    Character("Charles Leo Absalon", " pulis ", R.drawable.charles),
                    Character("John Leo Cordova", "service ace", R.drawable.leo),
                    Character("Shane Steven Batica", "di binalik yung longsleeve ko", R.drawable.shane)
                )) { character ->
                    CharacterEntry(
                        imageResId = character.imageResId,
                        name = character.name,
                        description = character.description
                    )
                }
            }
        }
    }
}

@Composable
fun CharacterEntry(imageResId: Int, name: String, description: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp))
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = "Character Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
        ) {
            Text(
                text = name,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = description,
                fontSize = 16.sp,
                color = Color.White
            )
        }
    }
}

data class Character(val name: String, val description: String, val imageResId: Int)
