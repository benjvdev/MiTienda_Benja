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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.navigation.compose.composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.mitienda_benja.model.Mensaje
import com.example.mitienda_benja.navigation.NavigationEvent
import com.example.mitienda_benja.ui.theme.MiTienda_BenjaTheme
import com.example.mitienda_benja.viewmodel.MainViewModel
import kotlinx.coroutines.flow.collectLatest
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import com.example.mitienda_benja.navigation.AppRoute

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MiTienda_BenjaTheme{
                Surface (modifier = Modifier.fillMaxSize()){
                    TarjetaConMensaje(Mensaje("Cangri","Inviten bolivianos rikos sipo"))
                }
                val viewModel: MainViewModel = viewModel()
                val navController = rememberNavController()

                LaunchedEffect(Unit) {
                    viewModel.navEvents.collectLatest {
                        event ->
                        when(event){
                            is NavigationEvent.NavigateTo ->{
                                navController.navigate(event.appRoute.route)
                                {
                                    event.popUpRoute?.let {
                                        popUpTo(it.route){
                                            inclusive=event.inclusive
                                        }
                                        launchSingleTop=event.singleTop
                                        restoreState=true
                                    }
                                }
                            }
                            is NavigationEvent.NavigateUp ->navController.navigateUp()
                            is NavigationEvent.PopBackStack -> navController.popBackStack()
                        }
                    }
                }//Final del bloque launceeffect para manejar la navegacion
                Scaffold(modifier = Modifier.fillMaxSize())
                {
                    innerPadding ->
                    NavHost(
                        NavController=navController,
                        startDestination = AppRoute.Home.route,
                        modifier = Modifier.padding(innerPadding)
                    ){
                        composable(AppRoute.Home.route){
                            //HomeScreen(navController,viewModel)
                        }
                        composable(AppRoute.Home.route){
                            //ProfileScreen(navController,viewModel)
                        }
                        composable(AppRoute.Home.route){
                            //SettingsScreen(navController,viewModel)
                        }
                    }
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
            TarjetaConMensaje(Mensaje("Cangri","Inviten bolivianos rikos sipo"))
        }
    }
}