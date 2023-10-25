package com.example.jetpackfeatures

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackfeatures.ui.theme.JetpackFeaturesTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Call your composable function here
            DisplayImageFromDrawable()
        }
    }
}

@Composable
fun DisplayImageFromDrawable() {
    // Replace R.drawable.your_image with the actual resource ID of your image in the drawable folder
    val imageResource = R.drawable.ic_launcher_foreground

    // Use the Image composable to display the image
    Image(
        painter = painterResource(id = imageResource),
        contentDescription = null, // You can provide a description here
        modifier = Modifier.fillMaxSize()
    )
}

@Preview(showBackground = true)
@Composable
fun DisplayImagePreview() {
    JetpackFeaturesTheme {
        DisplayImageFromDrawable()
    }
}
