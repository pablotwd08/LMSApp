package br.com.pablokalil.lmsapp

import android.app.Application

class LMSApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: LMSApplication? = null
        fun getInstance(): LMSApplication {
            if (appInstance == null) {
                throw IllegalAccessException("configure application no Manifest")
            }
            return appInstance!!
        }
    }
}
