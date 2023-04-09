package com.tutorial.tvapp.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tutorial.tvapp.model.CastResponse
import com.tutorial.tvapp.model.DetailResponse
import com.tutorial.tvapp.utils.Constants.API_KEY

class TmdbRepo(val service: ApiService) {

    val detailData = MutableLiveData<Response<DetailResponse>>()
    val castData = MutableLiveData<Response<CastResponse>>()

    val movieDetail: LiveData<Response<DetailResponse>>
        get() = detailData

    val castDetail: LiveData<Response<CastResponse>>
        get() = castData

    suspend fun getMovieDetails(id: Int) {

        try {
            val result = service.getMovieDetails(id, API_KEY)

            if (result.body() != null) {
                detailData.postValue(Response.Success(result.body()))
            } else {
                detailData.postValue(Response.Error(result.errorBody().toString()))
            }
        } catch (e: Exception) {
            detailData.postValue(Response.Error(e.message.toString()))
        }
    }

    suspend fun getMovieCast(id: Int) {

        try {
            val result = service.getMovieCast(id, API_KEY)

            if (result.body() != null) {
                castData.postValue(Response.Success(result.body()))
            } else {
                castData.postValue(Response.Error(result.errorBody().toString()))
            }
        } catch (e: Exception) {
            castData.postValue(Response.Error(e.message.toString()))
        }
    }


}