package com.example.counterapp

import androidx.compose.runtime.Composable
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent{
            CounterApp();
        }
    }
}


@Composable

fun CounterApp(){
    var count by remember { mutableIntStateOf(0) }
    val maxLimit = 10
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Count: $count",
            fontSize = 30.sp
        )

        Button(onClick = {

            if(count < maxLimit){
                count++;
            }

            else{
                Toast.makeText(context, "Maxx Limit Reached", Toast.LENGTH_SHORT).show();
            }

        }) {
            Text("Increase Count"
            )
        }

        Button(onClick = {count = 0}){
            Text("Reset")
        }

    }


}