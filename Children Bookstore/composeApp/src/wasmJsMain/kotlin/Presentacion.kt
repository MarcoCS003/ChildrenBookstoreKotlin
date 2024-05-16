import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import childrenbookstore.composeapp.generated.resources.*
import childrenbookstore.composeapp.generated.resources.Res
import childrenbookstore.composeapp.generated.resources.contacto
import childrenbookstore.composeapp.generated.resources.libreriaPara
import childrenbookstore.composeapp.generated.resources.nosotros
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


class BarraEmpresa(
    val imagen: Painter,
    val texto: String
)

@OptIn(ExperimentalResourceApi::class)
@Composable
fun LibreriaPreScreen() {
    Column(
        modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painterResource(Res.drawable.libreriaPara), null, modifier = Modifier.fillMaxWidth())
        Image(painterResource(Res.drawable.libreriaParaTitulo), null)
        BarraSobreNosotros()
        Text(
            "Sobre Nosotros",
            fontSize = 35.sp,
            modifier = Modifier.padding(top = 50.dp),
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0c5c6d)
        )
        Text(
            "Bienvenidos a Librería para niños, tu librería en línea dedicada exclusivamente a los niños. En nuestra página, encontrarás una amplia selección de libros diseñados para fomentar la imaginación, la creatividad y el amor por la lectura en los más pequeños. Nuestro objetivo es proporcionar un espacio seguro, accesible y divertido donde los niños puedan descubrir el maravilloso mundo de los libros.",
            fontSize = 20.sp,
            modifier = Modifier.fillMaxWidth().padding(top = 35.dp, start = 180.dp, end = 180.dp),
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0c5c6d)
        )
        Spacer(Modifier.fillMaxWidth().height(750.dp))
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun BarraSobreNosotros() {
    val listaBarra = listOf(
        BarraEmpresa(painterResource(Res.drawable.nosotros), "Nosotros"),
        BarraEmpresa(painterResource(Res.drawable.contacto), "Contacto"),
        BarraEmpresa(painterResource(Res.drawable.ubicacion), "Ubicación"),
        BarraEmpresa(painterResource(Res.drawable.mision), "Misión"),
        BarraEmpresa(painterResource(Res.drawable.vision), "Visión"),
        BarraEmpresa(painterResource(Res.drawable.valores), "Valores"),
    )

    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 120.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        listaBarra.forEach { barraEmpresa ->
            Column(
                modifier = Modifier.width(120.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(barraEmpresa.imagen, null, modifier = Modifier.size(100.dp).padding(bottom = 8.dp), tint = Color(0xFF14a8a3))
                Text(barraEmpresa.texto, fontSize = 20.sp,)
            }
        }
    }
}