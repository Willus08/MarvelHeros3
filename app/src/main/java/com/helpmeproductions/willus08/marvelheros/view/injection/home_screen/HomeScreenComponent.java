package com.helpmeproductions.willus08.marvelheros.view.injection.home_screen;



import com.helpmeproductions.willus08.marvelheros.view.activities.home_screen.HomeScreen;

import dagger.Component;

@Component(modules = HomeScreenModule.class)
public interface HomeScreenComponent {
    void inject(HomeScreen homeScreen);
}
