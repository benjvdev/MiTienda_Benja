package com.example.mitienda_benja

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mitienda_benja.model.Mensaje
import com.example.mitienda_benja.ui.theme.MiTienda_BenjaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MiTienda_BenjaTheme{
                Surface (modifier = Modifier.fillMaxSize()){
                    TarjetaConMensaje(Mensaje("Benja","Hola gay, el cangri es muy gay"))
                }
            }

        }
    }
}
@Composable
fun  TarjetaConMensaje(mensaje: Mensaje){

    Row (modifier = Modifier.padding(all = 10.dp)){
        Image(
            painter = painterResource(R.drawable.cangri_jpg),
            contentDescription = "El Cangri",
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary,CircleShape)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Text(mensaje.autor,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleSmall)
            Spacer(modifier = Modifier.height(6.dp))
            Surface (shape = MaterialTheme.shapes.medium, shadowElevation = 4.dp){
                Text(
                    mensaje.cuerpo,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
            }
        }
    }
}
@Preview
@Composable
fun PreviewTarjetaConMensaje(){
    MiTienda_BenjaTheme{
        Surface(modifier = Modifier.fillMaxSize()) {
            TarjetaConMensaje(Mensaje("Benja","Hola gay, el cangri es muy gay"))
        }
    }
}