package com.helpmeproductions.willus08.marvelheros.data.remote;


import com.helpmeproductions.willus08.marvelheros.model.MarvelInformation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET("GET v1/public/characters")
    Call<MarvelInformation> fullNameCall(@Query("ts") String ts,
                                               @Query("hash") String hash ,
                                               @Query("apikey") String key,
                                               @Query("name") String name);

    @GET("GET v1/public/characters")
    Call<MarvelInformation> partialNameCall(@Query("ts") String ts,
                                            @Query("hash") String hash ,
                                            @Query("apikey") String key,
                                            @Query("nameStartsWith") String name);
}
