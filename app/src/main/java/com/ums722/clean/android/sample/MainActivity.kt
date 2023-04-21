package com.ums722.clean.android.sample

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.ums722.clean.android.sample.ui.theme.CleanAndroidSampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanAndroidSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {
    var id by remember { mutableStateOf(TextFieldValue()) }
    var pw by remember { mutableStateOf(TextFieldValue()) }

    Column(Modifier.fillMaxSize()) {

        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = "id : "
            )

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = id,
                onValueChange = { text -> id = text })
        }

        Row(horizontalArrangement = Arrangement.Center) {
            Text(
                textAlign = TextAlign.Center, text = "pw : "
            )

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = pw, onValueChange = { text -> pw = text })
        }
        Button(onClick = { /*TODO*/ }) {

        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CleanAndroidSampleTheme {
        LoginScreen()
    }
}