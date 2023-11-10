import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.layoutId
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.composeapplication.data.BottomNavigationItem
import org.koin.core.component.getScopeId

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomNavigationItem.Profile,
        BottomNavigationItem.Note,
        BottomNavigationItem.RecipeList
    )

    BottomAppBar(
        modifier = Modifier
            .testTag("bottom:Bar")
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
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title ,
                    modifier = Modifier
                        .testTag("icon:${item.title}")
                        .width(IntrinsicSize.Min)
                        .height(IntrinsicSize.Min)) })
        }

    }

}
