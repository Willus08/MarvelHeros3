package com.helpmeproductions.willus08.marvelheros.data.remote;


import android.util.Log;

import com.helpmeproductions.willus08.marvelheros.model.MarvelInformation;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIProvider {
    // example url   https://gateway.marvel.com:443/v1/public/characters?name=Iron%20Man&apikey=
    private static final String BASE_URL ="http://gateway.marvel.com/";
    private static final String API_KEY = "180e0f588589d3582823a295978d6008";
    private static final String PPRIVATE_KEY ="b0c261e9e790d1c50b74736108887e44ed59a750";
    private static final String HASH = "07becf51c683440afdfff94fab889585";
    private static final String TS = "1" ;
//    private static String createHash(String encTarget){
//        MessageDigest mdEnc = null;
//        try {
//            mdEnc = MessageDigest.getInstance("MD5");
//        } catch (NoSuchAlgorithmException e) {
//            System.out.println("Exception while encrypting to md5");
//            e.printStackTrace();
//        } // Encryption algorithm
//        mdEnc.update(encTarget.getBytes(), 0, encTarget.length());
//        String md5 = new BigInteger(1, mdEnc.digest()).toString(16);
//        while ( md5.length() < 32 ) {
//            md5 = "0"+md5;
//        }
//        Log.d("test", "createHash: " + md5);
//        return md5;
//    }

    private static Retrofit create(){

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Call<MarvelInformation> getCharWithFullName(String name){
      String trimedName = name.trim().replaceAll("\\s+","%20");
        Log.d(name, "getCharWithFullName: " + trimedName);
        Retrofit retrofit = create();
        APIService services = retrofit.create(APIService.class);
        return services.fullNameCall(TS,HASH,API_KEY,trimedName);
    }

    public static Call<MarvelInformation> getCharWithPartialName(String name){
        String trimedName = name.replaceAll("\\s+","%20");
        Retrofit retrofit = create();
        APIService services = retrofit.create(APIService.class);
        return services.partialNameCall(TS,HASH,API_KEY,trimedName.trim());
    }
}
