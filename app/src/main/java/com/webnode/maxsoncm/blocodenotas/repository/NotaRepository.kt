package com.webnode.maxsoncm.blocodenotas.repository

import com.webnode.maxsoncm.blocodenotas.api.getNotaAPI
import com.webnode.maxsoncm.blocodenotas.model.Nota
import retrofit2.Call
import retrofit2.Callback // cuidado no import do Callback - usar o do Retrofit
import retrofit2.Response

class NotaRepository {
    fun buscarTodos(
        onComplete:(List<Nota>) -> Unit,
        onError: (Throwable?) -> Unit
    ) {
        getNotaAPI()
            .getNotas()
            .enqueue(object : Callback<List<Nota>> {
                override fun onFailure(call: Call<List<Nota>>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(call: Call<List<Nota>>, response: Response<List<Nota>>) {
                    if (response.isSuccessful){
                        onComplete(response.body()!!)
                    }else{
                        onError(Throwable("Erro ao buscar os dados"))
                    }
                }
            } )
    }
}