package com.example.littlelemon.composables

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.littlelemon.R

@Composable
fun ProfileScreen(navController: NavHostController? = null) {
    // Retrieve user data from SharedPreferences
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
    val firstName = remember { sharedPreferences.getString("first_name", "") ?: "" }
    val lastName = remember { sharedPreferences.getString("last_name", "") ?: "" }
    val email = remember { sharedPreferences.getString("email", "") ?: "" }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Logo at the top
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(100.dp)
                .padding(top = 16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Header for Profile Information
        Text(text = "Personal Information", fontSize = 20.sp, modifier = Modifier.padding(bottom = 16.dp))

        // Display user information
        Text(text = "First name: $firstName", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Last name: $lastName", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Email: $email", fontSize = 18.sp)

        Spacer(modifier = Modifier.height(24.dp))

        // Logout Button with updated color
        Button(
            onClick = {
                // Clear SharedPreferences and navigate back to Onboarding screen
                sharedPreferences.edit().clear().apply()
                navController?.navigate(Onboarding.route) {
                    popUpTo(Onboarding.route) { inclusive = true } // Clear backstack
                }
            },
            colors = ButtonDefaults.buttonColors(Color(0xFFF4CE14)), // Yellow color for the button
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(text = "Logout", color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}
