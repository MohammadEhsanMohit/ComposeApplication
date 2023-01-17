import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.composeapplication.data.BottomNavigationItem

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomNavigationItem.Profile,
        BottomNavigationItem.ProfileList,
    )

    BottomAppBar(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        screens.forEach { item ->
            this.NavigationBarItem(selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                alwaysShowLabel = true,
                icon = {
                    Column(
                        modifier = Modifier
                            .wrapContentWidth()
                            .padding(8.dp)
                    ) {
                        Icon(
                            modifier = Modifier
                                .width(32.dp)
                                .padding(8.dp)
                                .align(alignment = Alignment.CenterHorizontally),
                            tint = MaterialTheme.colorScheme.onBackground,
                            imageVector = item.icon,
                            contentDescription = item.title
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(text = item.title, style = TextStyle(fontSize = 12.sp))
                    }
                }
            )
        }

    }

}
