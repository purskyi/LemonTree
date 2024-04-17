package com.example.lemontree

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemontree.ui.theme.LemonTreeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonTreeTheme {
              LemonTreeApp()
            }
        }
    }
}
@Composable
fun LemonTree(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)){

}


@Composable
fun LemonTreeApp() {
    LemonTree()
}

@Preview(showBackground = true)
@Composable
fun LemonTreeAppPreview() {
    LemonTreeTheme {
        LemonTreeApp()
    }
}