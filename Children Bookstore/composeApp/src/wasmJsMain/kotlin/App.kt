import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import childrenbookstore.composeapp.generated.resources.*
import childrenbookstore.composeapp.generated.resources.Res
import childrenbookstore.composeapp.generated.resources.carrito
import childrenbookstore.composeapp.generated.resources.categorias
import childrenbookstore.composeapp.generated.resources.home
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


data class NavigationItemContent(
    val icon: Painter,
    val text: String,
    val ruta: String
)


@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    val listMenu = listOf(
        NavigationItemContent(
            icon = painterResource(Res.drawable.home),
            text =  "Menu Principal",
            ruta = "Presentacion"
        ),
        NavigationItemContent(
            icon = painterResource(Res.drawable.categorias),
            text = "Tienda",
            ruta = "Catogories"
        ),
        NavigationItemContent(
            icon = painterResource(Res.drawable.carrito),
            text = "Carrito",
            ruta = "CarritoCompras"
        ),
        NavigationItemContent(icon = painterResource(Res.drawable.historial), text = "Historial", ruta = "Historial"),
    )
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    var actualScreen by remember { mutableStateOf("Carrito") }

    Box {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier
                    .background(color = Color(0xFF14a8a3), shape = RoundedCornerShape(35.dp))
                    .fillMaxHeight()
                    .width(
                        if (isHovered) {
                            160.dp
                        } else 75.dp
                    )
                    .padding(horizontal = 15.dp)
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioLowBouncy,
                            stiffness = Spring.StiffnessVeryLow
                        )
                    ),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    listMenu.forEach { item ->
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            IconButton(
                                onClick = { actualScreen = item.text },
                                modifier = Modifier.size(40.dp),
                                interactionSource = interactionSource
                            ) {
                                Icon(
                                    painter = item.icon,
                                    contentDescription = item.text,
                                    modifier = Modifier.size(40.dp),
                                    tint = Color.White
                                )

                            }
                            if (isHovered) {
                                Text(item.text, modifier = Modifier.padding(start = 5.dp), color = Color.White, fontSize = 18.sp)
                            }
                        }
                    }


                }

                Column{
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(start = 5.dp, bottom = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        IconButton(
                            onClick = { actualScreen = "Nav Compra" },
                            modifier = Modifier.size(40.dp),
                            interactionSource = interactionSource
                        ) {

                        }
                        if (isHovered) {
                            Text("Metodo pago",modifier = Modifier.padding(start = 5.dp), color = Color.White, fontSize = 18.sp)
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(start = 5.dp, bottom = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        IconButton(
                            onClick = { actualScreen = "Articulo" },
                            modifier = Modifier.size(40.dp),
                            interactionSource = interactionSource
                        ) {

                        }
                        if (isHovered) {
                            Text(
                                "Articulo",
                                modifier = Modifier.padding(start = 5.dp),
                                color = Color.White,
                                fontSize = 18.sp
                            )
                        }
                    }
                        Row(
                            modifier = Modifier.fillMaxWidth().padding(start = 5.dp, bottom = 5.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {
                            IconButton(
                                onClick = { actualScreen = "Address" },
                                modifier = Modifier.size(40.dp),
                                interactionSource = interactionSource
                            ) {

                            }
                            if (isHovered) {
                                Text("Address",modifier = Modifier.padding(start = 5.dp), color = Color.White, fontSize = 18.sp)
                            }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(start = 5.dp, bottom = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        IconButton(
                            onClick = { actualScreen = "Usuario" },
                            modifier = Modifier.size(40.dp),
                            interactionSource = interactionSource
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Usuario",
                                modifier = Modifier.size(40.dp),
                                tint = Color.White
                            )

                        }
                        if (isHovered) {
                            Text(
                                "Usuario",
                                modifier = Modifier.padding(start = 5.dp),
                                color = Color.White,
                                fontSize = 18.sp
                            )
                        }
                    }
                }
            }
            when (actualScreen) {
                "Tienda" -> ItemsCategories()
                "Menu Principal" -> LibreriaPreScreen()
                "Carrito" -> CarroComprasApp()
                "Historial" -> HistoriaCompras()
                "Usuario" -> UsuarioApp()
                "Address" -> AgregarDireccion()
                "Nav Compra" ->AgregarMetodoPagoApp()
                "Articulo" -> LibroApp()
                else -> ItemsCategories()
            }
        }
    }
}




