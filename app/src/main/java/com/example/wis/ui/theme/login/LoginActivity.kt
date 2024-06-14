package com.example.wis.ui.theme.login

import android.app.LauncherActivity.IconResizer
import android.graphics.drawable.AdaptiveIconDrawable
import android.text.style.BackgroundColorSpan
import android.widget.CheckBox
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wis.R
import com.example.wis.ui.theme.BLUE
import com.example.wis.ui.theme.Black
import com.example.wis.ui.theme.WISTheme
import com.example.wis.ui.theme.White
import com.example.wis.ui.theme.components.HeaderText
import com.example.wis.ui.theme.components.LoginTextField

val defaultPadding = 16.dp
val itemSpacing = 8.dp

@Composable
fun LoginActivity() {
    val (userName,setUsername) = rememberSaveable {
        mutableStateOf("")
    }

    val (password,setPassword) = rememberSaveable {
        mutableStateOf("")
    }
    val (checked,onCheckedChange) = rememberSaveable {
        mutableStateOf(false)
    }

    val context = LocalContext.current


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Black) // Set background color to black
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(defaultPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp)) // Top padding

            // Add your logo or image here
            Image(
                painter = painterResource(id = R.drawable.wis), // Replace with your actual image resource
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(100.dp) // Adjust the size as needed
                    .padding(bottom = 24.dp) // Space between the image and the header text
            )

            HeaderText(
                text = "Log In",
                modifier = Modifier.padding(vertical = 15.dp) // Adjust padding as needed
            )

            // Add more UI elements here, like TextFields for username and password, buttons, etc.

            LoginTextField(
                value = userName,
                onValueChange = setUsername,
                labelText = "Username",
                leadingIcon = Icons.Default.Person,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.height(20.dp))

            LoginTextField(
                value = password,
                onValueChange = setPassword,
                labelText = "Password",
                leadingIcon = Icons.Default.Lock,
                modifier = Modifier.fillMaxWidth(),
                keyboardType = KeyboardType.Password,
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(Modifier.height(itemSpacing))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Checkbox(checked = checked, onCheckedChange = onCheckedChange,
                            colors = CheckboxDefaults.colors(
                            checkedColor = if (checked) BLUE else Color.Gray,
                            uncheckedColor = Color.Gray))
                    Text("Remember Me", color = Color.Gray)
                }
                TextButton(onClick = {}) {
                    Text("Forgot Password?", color = BLUE)
                }
            }
            Spacer(Modifier.height(itemSpacing))
            Spacer(Modifier.height(itemSpacing))
            ElevatedButton(onClick = {}, modifier = Modifier.width(166.dp), colors = ButtonDefaults.buttonColors(
                containerColor = BLUE) ){
                Text("LOG IN", fontSize = 20.sp, color = White)

            }

            Spacer(Modifier.height(20.dp))
//            Spacer(Modifier.height(20.dp))

            Text("-OR-", color = Color.Gray)


            AlternativeLoginOptions(
                onIconClick = {index ->
                              when(index){
                                  0 -> {
                                      Toast.makeText(context, "Sign Up with Google", Toast.LENGTH_SHORT).show()
                                  }
                              }
                },
                onSignUpClick = {},
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(align = Alignment.BottomCenter)
            )
            // Spacer to push remaining elements to the bottom
//            Spacer(modifier = Modifier.weight(1f))

        }
    }
}



@Composable
fun AlternativeLoginOptions(
    onIconClick:(index:Int) -> Unit,
    onSignUpClick:() -> Unit,
    modifier: Modifier = Modifier
){
    val iconList = listOf(
        R.drawable.google_android_dark
    )

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement =  Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Row (horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.padding(0.dp)){

            Image(
                    painter = painterResource(id = iconList[0]),
                    contentDescription = "alternative Login",
                    modifier = Modifier
                        .paddingFromBaseline(bottom = 0.dp)
//                        .size(170.dp)

                        .clickable {
                            onIconClick(iconList.indexOf(R.drawable.google_android_dark))
                        }

                )
//                Spacer(Modifier.height(defaultPadding))

        }
        Spacer(Modifier.height(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text("Don't have an Account?", color = White)
            Spacer(Modifier.height(itemSpacing))
            TextButton(onClick = onSignUpClick) {
                Text("Sign Up", color = BLUE)

            }

        }
    }
}





@Preview(showSystemUi = true)
@Composable
fun PrevLoginScreen(){
    WISTheme {
        LoginActivity()
    }
}