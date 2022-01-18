package com.akshayashokcode.ktorpushnotification.data.remote

interface ApiService {
    suspend fun sendNotification(title:String, description:String)

    companion object{
         const val SEND_NOTIFICATION="http://192.168.203.40:8080/sendNotification"
    }
}