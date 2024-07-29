package com.alvaro.mysimplecleanarchitecture.presentation.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SimpleCleanArchitectureApp() {
    val viewModel = viewModel<MainViewModel>(
        factory = MainViewModelFactory()
    )
    
    val text by viewModel.message.collectAsState()
    
    Text(
        text = text.welcomeMessage,
        modifier = Modifier
    )
}