import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import childrenbookstore.composeapp.generated.resources.Res
import childrenbookstore.composeapp.generated.resources.master
import childrenbookstore.composeapp.generated.resources.visa
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.skia.Font

data class MetodosPago(val numero: String, val tipo: String, val painter: Painter)
data class Direcciones(val direccion: String, val estado: String, val pais: String, val codPostal: String)

@OptIn(ExperimentalResourceApi::class)
@Composable
fun UsuarioApp() {
    val listaMetodos = listOf(
        MetodosPago("4152", "Débito", painterResource(Res.drawable.visa)),
        MetodosPago("8264", "Crédito", painterResource(Res.drawable.master)),
    )
    val direcciones = listOf(
        Direcciones("Zavaleta con privada a Benito juárez #558", "Puebla", "Mexico", "72468"),
        Direcciones("Avenida del maestro #852", "Tlaxcala", "Mexico", "85362")
    )
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(325.dp))
                Column(Modifier.height(300.dp), verticalArrangement = Arrangement.SpaceAround) {
                    Text("Tu información", fontWeight = FontWeight.Bold, fontSize = 30.sp)
                    Text("Juanito Peréz", fontSize = 25.sp)
                    Text("22222645878", fontSize = 25.sp)
                    Text("juan_perez@gmail.com", fontSize = 25.sp)
                }
            }
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Card(
                    backgroundColor = Color(0xFFf8c471),
                    modifier = Modifier
                        .width(300.dp)
                        .padding(8.dp),
                    shape = RoundedCornerShape(15.dp)
                )  {
                    Column {
                        Text("Direcciones", fontSize = 30.sp, color = Color(0xFFFF5733), modifier = Modifier.padding(10.dp))
                        direcciones.forEach {
                            Card(backgroundColor = Color(0XFFDAF7A6), modifier = Modifier.padding(10.dp).fillMaxWidth()) {
                                Text("${it.direccion} ${it.estado} ${it.pais} ${it.codPostal}", modifier = Modifier.padding(10.dp))
                            }
                        }
                        Button(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFFC300)),
                            modifier = Modifier.fillMaxWidth().padding(10.dp)
                        ) {
                            Text("Añadir dirección", color = Color(0xFFFF5733))
                        }
                        Button(

                            onClick = {},
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFFC300)),
                            modifier = Modifier.fillMaxWidth().padding(10.dp)
                        ) {
                            Text("Editar direcciones", color = Color(0xFFFF5733))
                        }
                    }
                }
                Card(
                    backgroundColor = Color(0xFFf8c471),
                    modifier = Modifier
                        .width(300.dp)
                        .padding(8.dp),
                    shape = RoundedCornerShape(15.dp)
                )  {
                    Column {
                        Text("Métodos de Pago", fontSize = 30.sp, color = Color(0xFFFF5733), modifier = Modifier.padding(10.dp))
                        listaMetodos.forEach {
                            Card(backgroundColor = Color(0XFFDAF7A6), modifier = Modifier.padding(10.dp).fillMaxWidth()) {
                                Row(
                                    modifier = Modifier.fillMaxWidth().padding(10.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text("** ${it.numero}")
                                    Text(it.tipo)
                                    Image(it.painter, null, modifier = Modifier.size(30.dp))
                                }
                            }
                        }
                        Button(

                            onClick = {},
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFFC300)),
                            modifier = Modifier.fillMaxWidth().padding(10.dp)
                        ) {
                            Text("Añadir Método de pago", color = Color(0xFFFF5733))
                        }
                        Button(

                            onClick = {},
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFFC300)),
                            modifier = Modifier.fillMaxWidth().padding(10.dp)
                        ) {
                            Text("Editar Métodos de pago", color = Color(0xFFFF5733))
                        }
                    }
                }
            }
        }
        Column(verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxSize().padding(end = 15.dp, bottom = 15.dp),) {
            FloatingActionButton(onClick = {}){
                Icon(Icons.Default.Info, null, tint = Color.White)
            }
        }
    }
}