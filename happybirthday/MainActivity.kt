package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithImage(
                        getString(R.string.Happy_Birthday_Message),
                        "-from: Taofiq Akintunde"
                    )
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithText(message: String, from: String) {
    val offset = Offset(5.0f, 10.0f)
    Column {
        Text(
            text = message,
            modifier = Modifier
                .wrapContentWidth(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(start = 26.dp, top = 16.dp, bottom = 16.dp, end = 16.dp),
            style = TextStyle(
                fontSize = 46.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                shadow = Shadow(
                    color = Color.Black,
                    offset = offset,
                    blurRadius = 3f
                )
                //TextAlignment = Alignment.CenterHorizontally,

            )
        )

        Text(
            text = from,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .wrapContentWidth(Alignment.CenterHorizontally)
                .background(color = Color.Magenta)
                .fillMaxWidth()
                .padding(start = 26.dp, top = 16.dp, bottom = 16.dp, end = 16.dp),
        )
    }
}

@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {
    val image = painterResource(R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentScale = ContentScale.Crop,

            )
        BirthdayGreetingWithText(message = message, from = from)
    }

}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        BirthdayGreetingWithImage(
            stringResource(R.string.Happy_Birthday_Message),
            "-From: Taofiq Akintunde"
        )
    }
}