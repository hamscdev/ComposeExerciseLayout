package com.hamscdev.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hamscdev.myapplication.ui.theme.ComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    MyBox("Android")
                }
            }
        }
    }
}

@Composable
fun myComplexLayout(){
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color.Cyan)){}


        Row (modifier = Modifier.fillMaxWidth().weight(1f)){
            Box(modifier = Modifier.fillMaxHeight()
                .weight(1f)
                .background(Color.Red)){}
            Box(modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
                .background(Color.Green)){}
        }

        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color.Cyan)){}
        
    }
    
}

@Composable
fun MyColumn(){
    // un Column es como un linearlayout en Vertical
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        Text("Ejemplo1",modifier = Modifier.background(Color.Cyan))
        Text("Ejemplo2",modifier = Modifier.background(Color.Red))
        Text("Ejemplo3",modifier = Modifier.background(Color.Blue))
        Text("Ejemplo4",modifier = Modifier.background(Color.Black))
    }
}


@Composable
fun MyRows(){
    //un Row es como un linearlayout en Horizontal

    Row(modifier = Modifier
        .fillMaxSize()
        .horizontalScroll(rememberScrollState())) {
        Text("Ejemplo1",modifier = Modifier
            .background(Color.Cyan)
            .weight(1f))
        Text("Ejemplo2",modifier = Modifier
            .background(Color.Red)
            .weight(1f))
        Text("Ejemplo3",modifier = Modifier
            .background(Color.Blue)
            .weight(1f))
    }

}


@Composable
fun MyBox(name: String){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.CenterEnd){
        Box(modifier = Modifier
            .width(30.dp)
            .height(30.dp)
            .background(Color.Cyan)
            .verticalScroll(
                rememberScrollState()
            )){
            Text("Esto es un EJEMPLO")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeTheme {
        //MyBox("Android")
        //MyColumn()
        //MyRows()
        myComplexLayout()
    }
}