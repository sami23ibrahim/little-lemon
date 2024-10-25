package com.example.littlelemon.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littlelemon.R

@Composable
fun HomeScreen(navController: NavHostController? = null) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Row for Header (with logo on the left and profile icon on the right)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Logo (or app name)
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo",
                modifier = Modifier.size(300.dp)
            )

            // Profile Icon (Clickable)
            Image(
                painter = painterResource(id = R.drawable.profile), // Replace with your profile icon
                contentDescription = "Profile",
                modifier = Modifier
                    .size(80.dp)
                    .clickable {
                        // Navigate to Profile Screen
                        navController?.navigate(Profile.route)
                    }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Welcome message or home content
        Text(text = "Welcome to the Home Screen")

        Spacer(modifier = Modifier.height(16.dp))

//        // Button to go to Profile Screen
//        Button(onClick = {
//            navController?.navigate(Profile.route)
//        }) {
//            Text(text = "Go to Profile")
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
