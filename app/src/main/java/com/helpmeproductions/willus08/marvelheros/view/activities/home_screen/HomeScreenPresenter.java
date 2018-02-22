package com.helpmeproductions.willus08.marvelheros.view.activities.home_screen;


import android.support.annotation.NonNull;
import android.util.Log;

import com.helpmeproductions.willus08.marvelheros.data.remote.APIProvider;
import com.helpmeproductions.willus08.marvelheros.model.MarvelInformation;

import retrofit2.Call;
import retrofit2.Response;

public class HomeScreenPresenter implements HomeScreenContract.Presenter{
    private HomeScreenContract.View view;
    MarvelInformation marvelInformation;

    @Override
    public void addView(HomeScreenContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void getInformationFullName(String name) {
        final retrofit2.Call<MarvelInformation> heroInformationCall = APIProvider.getCharWithFullName(name);
        heroInformationCall.enqueue(new retrofit2.Callback<MarvelInformation>() {

            @Override
            public void onResponse(@NonNull Call<MarvelInformation> call, @NonNull Response<MarvelInformation> response) {
                view.showInformation(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<MarvelInformation> call, @NonNull Throwable t) {
                view.showError(t.getLocalizedMessage());
            }
        });
       // view.showInformation(marvelInformation);
    }

    @Override
    public void getInformationPartialName(String name) {
        final retrofit2.Call<MarvelInformation> heroInformationCall = APIProvider.getCharWithPartialName(name);
        heroInformationCall.enqueue(new retrofit2.Callback<MarvelInformation>() {
            @Override
            public void onResponse(@NonNull Call<MarvelInformation> call, @NonNull Response<MarvelInformation> response) {
                view.showInformation(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<MarvelInformation> call, @NonNull Throwable t) {
                view.showError(t.getLocalizedMessage());
            }
        });
    }
}
