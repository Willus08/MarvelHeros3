package com.helpmeproductions.willus08.marvelheros.view.activities.home_screen;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.helpmeproductions.willus08.marvelheros.model.MarvelInformation;
import com.helpmeproductions.willus08.marvelheros.view.activities.favorites_screen.FavoritesScreen;
import com.helpmeproductions.willus08.marvelheros.view.activities.hero_screen.HeroScreen;


public class HomeScreenRouter implements HomeScreenContract.Router{

    private Context context;

    public HomeScreenRouter(Context context) {
        this.context = context;
    }

    @Override
    public void goToHeroScreen(MarvelInformation information) {
        Intent intent = new Intent(context, HeroScreen.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("info", information);
        context.startActivity(intent);
    }

    @Override
    public void goToFavoritesScreen() {
        Intent intent = new Intent(context, FavoritesScreen.class);
        context.startActivity(intent);
    }

}
