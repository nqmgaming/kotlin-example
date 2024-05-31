package com.nqmgaming.kotlin.lab6.cinema.presentation.screens.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: MutableLiveData<String> = _email

    private val _password = MutableLiveData<String>()
    val password: MutableLiveData<String> = _password

    private val _rememberMe = MutableLiveData<Boolean>()
    val rememberMe: MutableLiveData<Boolean> = _rememberMe

    private val _isLoginSuccess = MutableLiveData<Boolean>()
    val isLoginSuccess: MutableLiveData<Boolean> = _isLoginSuccess

    fun onEmailChanged(email: String) {
        _email.value = email
    }

    fun onPasswordChanged(password: String) {
        _password.value = password
    }

    fun onRememberMeChanged(rememberMe: Boolean) {
        _rememberMe.value = rememberMe
    }

    fun onLoginClicked() {
        _isLoginSuccess.value =
            _email.value == "nguyenquangminh570@gmail.com" && _password.value == "123456"

        if (_isLoginSuccess.value == true) {
            _isLoginSuccess.value = true
        } else {
            _isLoginSuccess.value = false
        }

    }

    fun resetAuthenticationState() {
        _isLoginSuccess.value = null
    }

}