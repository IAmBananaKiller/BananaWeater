package com.example.bananaweater.logic

import android.service.media.MediaBrowserService
import androidx.lifecycle.liveData
import com.example.bananaweater.logic.model.Place
import com.example.bananaweater.logic.network.PlaceService
import com.example.bananaweater.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers
import retrofit2.http.Query

object Repository {

    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok"){
                val places = placeResponse.places
                Result.success(places)
            }else{
                Result.failure(RuntimeException("response status is${placeResponse.status}"))
            }
        }catch (e: Exception){
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}