import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import childrenbookstore.composeapp.generated.resources.*
import childrenbookstore.composeapp.generated.resources.Res
import childrenbookstore.composeapp.generated.resources.amistad
import childrenbookstore.composeapp.generated.resources.animales
import childrenbookstore.composeapp.generated.resources.home
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


data class Categoria(
    val nome: String,
    val image: Painter,
)

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ItemsCategories() {
    var categoriaSeleted by remember { mutableStateOf("Todo") }

    @OptIn(ExperimentalResourceApi::class)
    val categorias: List<Categoria> = listOf(
        Categoria("Todo", painterResource(Res.drawable.libro)),
        Categoria("Amistad", painterResource(Res.drawable.amistad)),
        Categoria("Animales", painterResource(Res.drawable.animales)),
        Categoria("Ciencia", painterResource(Res.drawable.ciencia)),
        Categoria("Familia", painterResource(Res.drawable.familia)),
        Categoria("Fantasia", painterResource(Res.drawable.fantasia)),
        Categoria("Humor", painterResource(Res.drawable.humor)),
        Categoria("Naturaleza", painterResource(Res.drawable.naturaleza)),
        Categoria("Aprendizaje", painterResource(Res.drawable.aprendizaje)),
        Categoria("Dibujo", painterResource(Res.drawable.dibujo)),
    )
    Column() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(horizontal = 5.dp, )
                .background(Color(0xFF7CD8D5), shape = RoundedCornerShape(20.dp)),
            Arrangement.SpaceBetween
        ) {
            categorias.forEach { categoria ->
                ButtomCategoria(categoria) { categoriaSeleted = categoria.nome }
            }
        }
        ItemsBooks(categoriaSeleted)
    }
}

@Composable
fun ButtomCategoria(item: Categoria, onClick: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(onClick = onClick, modifier = Modifier.size(92.dp).padding(vertical = 2.dp)) {
            Image(painter = item.image, contentDescription = item.nome, modifier = Modifier.size(92.dp))
        }
        Text(item.nome, fontFamily = FontFamily.Cursive, color = Color(0xFF1b4f72 ), fontSize = 18.sp,   fontWeight = FontWeight.Bold)
    }

}



