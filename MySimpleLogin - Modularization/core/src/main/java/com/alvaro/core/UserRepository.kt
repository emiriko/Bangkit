package com.alvaro.core

class UserRepository(private val sesi: com.alvaro.core.SessionManager) {

    companion object {
        @Volatile
        private var instance: UserRepository? = null

        fun getInstance(sesi: com.alvaro.core.SessionManager): UserRepository =
            instance ?: synchronized(this) {
                instance ?: UserRepository(sesi)
            }
    }

    fun loginUser(username: String) {
        sesi.createLoginSession()
        sesi.saveToPreference(com.alvaro.core.SessionManager.KEY_USERNAME, username)
    }

    fun getUser() = sesi.getFromPreference(com.alvaro.core.SessionManager.KEY_USERNAME)

    fun isUserLogin() = sesi.isLogin

    fun logoutUser() = sesi.logout()
}