import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import childrenbookstore.composeapp.generated.resources.*
import childrenbookstore.composeapp.generated.resources.Res
import childrenbookstore.composeapp.generated.resources.historialComprasb
import childrenbookstore.composeapp.generated.resources.libroPrincipitp
import childrenbookstore.composeapp.generated.resources.libroRatondeCiudad
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


data class ArticuloComprado(
    val titulo: String,
    val image: Painter,
    val precio: String,
    val fecha: String,
    val cometario: String? = null

)


@OptIn(ExperimentalResourceApi::class)
@Composable
fun HistoriaCompras() {
    val listaCompras = listOf(
        ArticuloComprado("El Principito", painterResource(Res.drawable.libroPrincipitp), "10.99", "13 - Enero 2024"),
        ArticuloComprado("Ratón de campo y ratón de ciudad ", painterResource(Res.drawable.libroRatondeCiudad), "10.99", "13 - Enero 2024","Me gustó mucho cuando el ratón de campo visitó la ciudad. ¡Fue muy divertido!" ),
        ArticuloComprado("Las tres Mellizas ", painterResource(Res.drawable.libroLastresmelli), "9.99", "17 - Septiembre 2024","Me gustó mucho" ),
        ArticuloComprado("¡Buenas noches, Gorila! ", painterResource(Res.drawable.libroBuenasnochesgo), "8.99", "28 - Febrero 2024"),
        ArticuloComprado("Charlie y la fábrica de chocolate", painterResource(Res.drawable.libroCharlieylafabr), "7.99", "31 - Abril 2024" ),
        )

    Column (modifier = Modifier.fillMaxWidth()){
        Image(painterResource(Res.drawable.historialComprasb), null)
        Spacer(modifier = Modifier.height(25.dp))
        listaCompras.forEach {
            CardCompra(it, modifier = Modifier.padding(vertical = 15.dp, horizontal = 35.dp).fillMaxWidth())
        }
    }
}

@Composable
fun CardCompra(articuloComprado: ArticuloComprado, modifier: Modifier) {
    Card(modifier) {
        Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
            Image(articuloComprado.image, null, modifier = Modifier.size(75.dp))
            Text(articuloComprado.titulo, modifier = Modifier.width(350.dp))
            Text(articuloComprado.precio, modifier = Modifier.width(80.dp))
            if(articuloComprado.cometario != null){
                Card( modifier = Modifier.width(250.dp),backgroundColor = Color(0xFFaed6f1 )) {
                    Column (Modifier.padding(8.dp)){
                        Text("Tu comentario", color = Color(0xFF1b4f72 ), fontWeight = FontWeight.Bold)
                        Text(articuloComprado.cometario, color = Color(0xFF1b4f72 ))
                    }
                }
            }else{
                Row (modifier = Modifier.width(250.dp), horizontalArrangement = Arrangement.Center){
                    Button(onClick ={},modifier=  Modifier.width(180.dp),  colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF02CBA7))){
                        Text("Anadir comentario", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                }
            }
            Row (modifier = Modifier.width(250.dp), horizontalArrangement = Arrangement.Center){
                Button(onClick ={}, modifier = Modifier.width(180.dp), colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF02CBA7))){
                    Text("Obtener factura",color = Color.White, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}