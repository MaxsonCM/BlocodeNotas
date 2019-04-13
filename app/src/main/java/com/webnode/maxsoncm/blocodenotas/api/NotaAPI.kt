package com.webnode.maxsoncm.blocodenotas.api

import com.webnode.maxsoncm.blocodenotas.model.Nota
import retrofit2.Call
import retrofit2.http.GET

interface  NotaAPI {

    @GET("/nota")
    fun getNotas() : Call<List<Nota>>

    /*@GET( value: "/nota/{id}")
    fun getNotas(@Path(value:"id") id:String)*/
}