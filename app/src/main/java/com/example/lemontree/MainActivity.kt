package com.example.lemontree

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

data class ImageData(val imageResource: Int, val text: Int , val CD:Int)

@Composable
fun LemonTree(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)){


    var result by remember {
        mutableStateOf(1)
    }

    var  imageResourse:ImageData = when(result) {
        1 -> ImageData(R.drawable.lemon_tree,R.string.TapTree,R.string.CDLemontree)
        in 2..5-> ImageData(R.drawable.lemon_squeeze,R.string.squeezIt,R.string.CDLemon)
        6 -> ImageData(R.drawable.lemon_drink,R.string.drinkIt,R.string.CDGlassoflemonade)
        else -> ImageData(R.drawable.lemon_restart,R.string.startAgain,R.string.CDEmptyglass)
    }



    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){


        Image(
            painter = painterResource(imageResourse.imageResource),
            contentDescription = stringResource(imageResourse.CD),

            modifier = Modifier
                .height(200.dp)
                .clickable {if(result >= 7) result = 1 else result += 1}

        )
        Spacer(
            modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(imageResourse.text),
            style =  TextStyle(fontSize = 16.sp),
            modifier = Modifier
            )
    }
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