package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun StudentTitle(
    @StringRes name: Int,
    @StringRes code: Int,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = name),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.teal_200),
            fontSize = 32.sp,
        )
        Text(
            text = stringResource(id = code),
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.teal_200),
            fontSize = 25.sp,
        )
    }
}

@Composable
fun ArtSpaceScreen(modifier: Modifier = Modifier) {


    var result by remember { mutableStateOf( 1) }

    val image = when(result){
        1 -> R.drawable.asahi
        2 -> R.drawable.equipo
        3 -> R.drawable.equipo2
        4 -> R.drawable.equipo3
        5 -> R.drawable.haikyuu
        6 -> R.drawable.hinata
        7 -> R.drawable.hinata2
        8 -> R.drawable.kei
        9 -> R.drawable.kei2
        10 -> R.drawable.korai
        11 -> R.drawable.nishinoya
        12 -> R.drawable.rivales
        else -> R.drawable.tobio
    }


    val title = when(result){
        1 -> R.string.asahi
        2 -> R.string.equipo
        3 -> R.string.equipo2
        4 -> R.string.equipo3
        5 -> R.string.haikyu
        6 -> R.string.hinata
        7 -> R.string.hinata2
        8 -> R.string.kei
        9 -> R.string.kei2
        10 -> R.string.korai
        11 -> R.string.nishinoya
        12 -> R.string.rivales
        else -> R.string.Kageyama
    }



    val year = when(result){
        1 -> R.string.asahi_year
        2 -> R.string.equipo_year
        3 -> R.string.equipo2_year
        4 -> R.string.equipo3_year
        5 -> R.string.haikyu_year
        6 -> R.string.hinata_year
        7 -> R.string.hinata2_year
        8 -> R.string.kei_year
        9 -> R.string.kei2_year
        10 -> R.string.korai_year
        11 -> R.string.nishinoya_year
        12 -> R.string.rivales_year
        else -> R.string.Kageyama_year
    }


    val description = when(result){
        1 -> R.string.asahi_description
        2 -> R.string.equipo_description
        3 -> R.string.equipo2_description
        4 -> R.string.equipo3_description
        5 -> R.string.haikyu_description
        6 -> R.string.hinata_description
        7 -> R.string.hinata2_description
        8 -> R.string.kei_description
        9 -> R.string.kei2_description
        10 -> R.string.korai_description
        11 -> R.string.nishinoya_description
        12 -> R.string.rivales_description
        else -> R.string.Kageyama_description
    }

    var name by remember { mutableStateOf(R.string.name) }
    var code by remember { mutableStateOf(R.string.code) }


    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        StudentTitle(
            name = name,
            code = code,
        )
        Spacer(
            modifier = modifier.size(5.dp)
        )
        ArtworkImage(
            image = image
        )
        Spacer(
            modifier = modifier.size(5.dp)
        )
        ArtworkTitle(
            title = title,
            year = year,
            description = description,
        )
        Spacer(
            modifier = modifier.size(25.dp)
        )
        Row(
            modifier = modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {
                    if (result > 1){
                        result -= 1
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.teal_200),
                    contentColor = colorResource(id = R.color.gray_900)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp,
                )
            ) {
                Text(
                    text = stringResource(id = R.string.previus),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }
            Button(
                onClick = {
                            result = 1
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.teal_200),
                    contentColor = colorResource(id = R.color.teal_200)
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp,
                )
            ) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp) // Tamaño del icono
                )
            }
            Button(
                onClick = {
                    if (result <= 12){
                        result += 1
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.teal_200),
                    contentColor = colorResource(id = R.color.black),
                ),
                elevation = ButtonDefaults.elevatedButtonElevation(
                    defaultElevation = 1.dp,
                    pressedElevation = 0.dp,
                    focusedElevation = 0.dp
                ),
            ) {
                Text(
                    text = stringResource(id = R.string.next),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = colorResource(id = R.color.white)
                )
            }
        }
    }
}

@Composable
fun ArtworkImage(
    modifier: Modifier = Modifier,
    @DrawableRes image: Int
) {
    Surface(
        modifier = modifier.fillMaxWidth().padding(10.dp).shadow(30.dp),
        color = colorResource(id = R.color.gray_900),
        shape = MaterialTheme.shapes.medium, // Opcional: ajusta la forma del Surface
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = modifier
                .padding(10.dp)
                .aspectRatio(1f)
                .shadow(20.dp),
            contentScale = ContentScale.FillHeight
        )
    }
}
@Composable
fun ArtworkTitle(
    @StringRes title: Int,
    @StringRes year: Int,
    @StringRes description: Int,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = title),
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.teal_200),
            fontSize = 32.sp,
        )
        Text(
            text = stringResource(id = year),
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.gray_300),
            fontSize = 16.sp,
        )
        Text(
            text = stringResource(id = description),
            fontWeight = FontWeight.Medium,
            color = colorResource(id = R.color.gray_300),
            fontSize = 16.sp,
            textAlign = TextAlign.Center

        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}

