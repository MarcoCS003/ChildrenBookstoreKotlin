import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import childrenbookstore.composeapp.generated.resources.Res
import childrenbookstore.composeapp.generated.resources.comprar
import childrenbookstore.composeapp.generated.resources.estrella
import childrenbookstore.composeapp.generated.resources.libroRatondeCiudad
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


data class Comentario(
    val comentario: String,
    val usuario: String,
    val estrellas: Int,
    val fecha: String,
)


@OptIn(ExperimentalResourceApi::class)
@Composable
fun LibroApp() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(Modifier.fillMaxWidth()) {
            Image(painter = painterResource(Res.drawable.comprar), null, modifier = Modifier.padding(start = 20.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth().height(550.dp)
            ) {
                Image(
                    painterResource(Res.drawable.libroRatondeCiudad),
                    contentDescription = null,
                    modifier = Modifier.size(400.dp)
                )
                Column(
                    modifier = Modifier.fillMaxHeight().width(300.dp),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Column {
                        Text("Ratón de campo y ratón de ciudad", fontSize = 36.sp)
                        Text("Autor : Esopo", fontSize = 20.sp)

                    }
                    Text("$8.99", fontSize = 32.sp)
                    Column {
                        Text("Disponibles: 20 ", fontSize = 20.sp)
                        Button(

                            onClick = {},
                            colors = ButtonDefaults.buttonColors(backgroundColor =Color(0xFFFFC300 )),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Comprar Ahora", color = Color(0xFFFF5733))
                        }
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFFC300 )),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Anadir a carrito", color =  Color(0xFFFF5733))
                        }
                    }
                }
                Comentarios(modifier = Modifier.padding(15.dp).fillMaxHeight().width(500.dp))
            }
        }
    }
}

@Composable
fun Comentarios(modifier: Modifier) {
    val comentariosRatonCiudadCampo: List<Comentario> = listOf(
        Comentario(
            comentario = "Me gustó mucho cuando el ratón de campo visitó la ciudad. ¡Fue muy divertido!",
            usuario = "Juanito123",
            estrellas = 5,
            fecha = "2023-05-01"
        ),
        Comentario(
            comentario = "La historia es muy bonita y me encantaron las ilustraciones.",
            usuario = "LolaMariposa",
            estrellas = 4,
            fecha = "2023-05-02"
        ),
        Comentario(
            comentario = "¡Qué aventura tan genial! Ahora quiero visitar el campo.",
            usuario = "PequeñoExplorador",
            estrellas = 5,
            fecha = "2023-05-03"
        ),
        Comentario(
            comentario = "Es un buen libro, pero me hubiera gustado más acción.",
            usuario = "SuperLeo",
            estrellas = 3,
            fecha = "2023-05-04"
        ),
        Comentario(
            comentario = "Me gustaron los personajes y cómo se ayudan mutuamente.",
            usuario = "AnaJugando",
            estrellas = 4,
            fecha = "2023-05-05"
        )
    )
    Card(modifier = modifier, backgroundColor = Color(0xFFFFC300 )) {
        Column {
            Text("Comentarios", fontSize = 22.sp, color = Color(0xFFFF5733), modifier = Modifier.padding(vertical = 10.dp, horizontal = 15.dp))
            LazyColumn(modifier = Modifier.padding(5.dp)) {
                items(comentariosRatonCiudadCampo) { comentario ->
                    Coment(comentario)
                }
            }
        }
    }
}


@Composable
fun Coment(comentario: Comentario) {
    Card(backgroundColor = Color(0XFFDAF7A6 ), modifier = Modifier.padding(10.dp).fillMaxWidth()) {
        Column(modifier = Modifier.padding(horizontal = 5.dp, vertical = 7.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Row (verticalAlignment = Alignment.CenterVertically){
                    Image(
                        imageVector = Icons.Default.Person,
                        null,
                        modifier = Modifier.size(25.dp).padding(horizontal = 5.dp)
                    )
                    Text(comentario.usuario, fontSize = 18.sp)
                }
                Row {
                    for (i in 1..comentario.estrellas) {
                        Image(imageVector = Icons.Default.Star, null, modifier = Modifier.size(20.dp).padding(end = 2.dp))
                    }
                }
            }
            Text(comentario.comentario, fontSize = 16.sp)

        }
    }
}

