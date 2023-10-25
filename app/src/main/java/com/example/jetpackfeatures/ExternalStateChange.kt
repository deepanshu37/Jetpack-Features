package com.example.jetpackfeatures

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackfeatures.ui.theme.JetpackFeaturesTheme
import kotlin.random.Random

class ExternalStateChange : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                Text(text = "Color of the Second box is changed when first box is clicked")
                Column(Modifier.fillMaxSize()) {
                    val color = remember {
                        mutableStateOf(Color.Yellow)
                    }
                    ColorBox(
                        Modifier
                            .fillMaxSize()
                            .weight(1f)
                    ) {
                        color.value = it
                    }
                    Box(
                        modifier = Modifier
                            .background(color.value)
                            .weight(1f)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}
@Composable
fun ColorBox(modifier: Modifier = Modifier,
             updateColor: (Color) -> Unit){
/*    val color = remember{   //prevents to change the value when the box is recomposed
        mutableStateOf(Color.Yellow) //The changing state will be declared here. Initially the color would be 'yellow'
    }*/
    Box(modifier = modifier
        .background(Color.Red)    //'color.value' refers to the 'color' declared above
        .clickable {    //changes the BG color to random color
            updateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f)
            )
        }
    )
}
