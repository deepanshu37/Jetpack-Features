package com.example.jetpackfeatures

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

class TextFieldsSnackBars : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextFieldsSnackBarContent()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
@Composable
fun TextFieldsSnackBarContent() {
    var name by remember { mutableStateOf("") }
    var snackbarVisible by remember { mutableStateOf(false) }
    val keyboardController = LocalSoftwareKeyboardController.current
    val density = LocalDensity.current.density

    Scaffold(
        topBar = {
            MaterialTheme {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    BasicTextField(
                        value = name,
                        onValueChange = { name = it },
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                snackbarVisible = true
                            }
                        ),
                        /*textStyle = MaterialTheme.typography.body1.copy(fontSize = 18.sp)*/
                    )
                    Button(
                        onClick = {
                            snackbarVisible = true
                            keyboardController?.hide()
                        },
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        MaterialTheme {
                            Text("Greet")
                        }
                    }
                }
            }
        }
    ) {
        if (snackbarVisible) {
            LaunchedEffect(Unit) {
                // Delay the Snackbar to let the keyboard hide first
                delay(300)
                snackbarVisible = false
            }
            Column(
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ) {
                MaterialTheme {
                    Text("Hello, $name!")
                }
            }
        }
    }
}
