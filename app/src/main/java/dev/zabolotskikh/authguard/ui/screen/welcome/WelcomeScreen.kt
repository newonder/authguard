package dev.zabolotskikh.authguard.ui.screen.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.zabolotskikh.authguard.R

@Composable
fun WelcomeScreen() {
    val viewModel = hiltViewModel<WelcomeViewModel>()
    WelcomeScreenView(onStartLocal = viewModel::startLocal)
}

@Composable
private fun WelcomeScreenView(
    onStartLocal: () -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.app_logo),
            contentDescription = stringResource(id = R.string.app_logo_content_description),
            modifier = Modifier.clip(RoundedCornerShape(40.dp))
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(horizontal = 16.dp))
        ) {
            Text(
                text = String.format(stringResource(id = R.string.welcome), stringResource(id = R.string.app_name)),
                modifier = Modifier.fillMaxWidth(),
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(22.dp)
            )
            Text(
                text = stringResource(id = R.string.welcome_description),
                modifier = Modifier.fillMaxWidth(),
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.secondary
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(horizontal = 16.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = onStartLocal,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                Text(text = stringResource(id = R.string.start))
            }
//            TextButton(onClick = onStartLocal) {
//                Text(text = stringResource(id = R.string.local_mode))
//            }
        }

    }
}

@Preview(device = Devices.PIXEL_4, showSystemUi = true)
@Composable
private fun WelcomeScreenPreview() {
    WelcomeScreenView()
}