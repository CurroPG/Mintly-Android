package com.example.mintly_kotlin.features.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.mintly_kotlin.R
import com.example.mintly_kotlin.core.ui.components.LabeledTextField
import com.example.mintly_kotlin.core.ui.components.MintlyTopBar

@Composable
fun RegisterScreen(
    toHome: () -> Unit,
    viewModel: RegisterViewModel = hiltViewModel()
){
    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            MintlyTopBar(
                title = stringResource(R.string.create_account),
                onBack = toHome
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                LabeledTextField(
                    label = stringResource(R.string.full_name),
                    value = state.name,
                    onValueChange = viewModel::changeName ,
                    placeholder = stringResource(R.string.full_name_hint)
                )
            }
            item {
                LabeledTextField (
                    label = stringResource(R.string.email),
                    value = state.mail,
                    onValueChange = viewModel::changeMail,
                    placeholder = stringResource(R.string.email_hint)
                )
            }
            item {
                LabeledTextField (
                    label = stringResource(R.string.password),
                    value = state.password,
                    onValueChange = viewModel::changePassword,
                    placeholder = stringResource(R.string.password_hint),
                    visualTransformation = PasswordVisualTransformation()
                )
            }
            item {
                LabeledTextField (
                    label = stringResource(R.string.confirm_password),
                    value = state.confirmedPassword,
                    onValueChange = viewModel::changeConfirmedPassword,
                    placeholder = stringResource(R.string.confirm_password_hint),
                    visualTransformation = PasswordVisualTransformation()
                )
            }
            item {
                Button(
                    onClick = {},
                    enabled = state.isValidTheCreation,
                    modifier = Modifier.fillMaxWidth().height(56.dp),
                    shape = MaterialTheme.shapes.medium,
                ) {
                    Text(stringResource(R.string.create_account))
                }
            }
            item {
                Text(
                    text = stringResource(R.string.or_continue_with),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            item {
                OutlinedButton(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth().height(56.dp),
                    shape = MaterialTheme.shapes.medium,
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
                        contentColor = MaterialTheme.colorScheme.onSurface
                    )
                ) {
                    Text(stringResource(R.string.continue_with_google))
                }
            }
            item {
                Text(
                    text = stringResource(R.string.already_have_account),
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}