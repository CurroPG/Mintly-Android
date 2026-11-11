package com.example.mintly_kotlin.features.register

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class RegisterScreenState (
    val name: String = "",
    val mail: String = "",
    val password: String = "",
    val confirmedPassword: String = "",
    val isValidTheCreation: Boolean = false
)

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {
    private val _state = MutableStateFlow(RegisterScreenState())
    val state: StateFlow<RegisterScreenState>
        get() = _state.asStateFlow()

    fun changeName(newName: String) {
        val oldState = state.value
        _state.value = oldState.copy(
            name = newName,
            isValidTheCreation = isCreatedEnabled(newName, oldState.mail, oldState.password, oldState.confirmedPassword)
        )
    }

    fun changeMail(newMail: String) {
        val oldState = state.value
        _state.value = oldState.copy(
            mail = newMail,
            isValidTheCreation = isCreatedEnabled(oldState.name, newMail, oldState.password, oldState.confirmedPassword)
        )
    }

    fun changePassword(newPassword: String) {
        val oldState = state.value
        _state.value = oldState.copy(
            password = newPassword,
            isValidTheCreation = isCreatedEnabled(oldState.name, oldState.mail, newPassword, oldState.confirmedPassword)
        )
    }

    fun changeConfirmedPassword(newConfirmedPassword: String) {
        val oldState = state.value
        _state.value = oldState.copy(
            confirmedPassword = newConfirmedPassword,
            isValidTheCreation = isCreatedEnabled(oldState.name, oldState.mail, oldState.password, newConfirmedPassword)
        )
    }

    fun isCreatedEnabled(name: String, mail: String, password: String, confirmedPassword: String): Boolean {
        val validName = name.isNotBlank()
        val validMail = mail.contains("@") && mail.contains(".")
        val validPassword = password.length >= 8
        val samePasswords = password == confirmedPassword

        return validName && validMail && validPassword && samePasswords
    }
}