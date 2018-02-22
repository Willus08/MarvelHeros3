package com.helpmeproductions.willus08.marvelheros.view.injection.home_screen;

import com.helpmeproductions.willus08.marvelheros.view.activities.home_screen.HomeScreenPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeScreenModule {
    @Provides
    public HomeScreenPresenter homeScreenPresenterProvider(){
        return new HomeScreenPresenter();
    }
}
