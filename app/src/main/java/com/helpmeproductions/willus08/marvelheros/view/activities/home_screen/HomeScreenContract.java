package com.helpmeproductions.willus08.marvelheros.view.activities.home_screen;


import com.helpmeproductions.willus08.marvelheros.model.MarvelInformation;
import com.helpmeproductions.willus08.marvelheros.view.BasePresenter;
import com.helpmeproductions.willus08.marvelheros.view.BaseView;

public interface HomeScreenContract {
    interface View extends BaseView{
        void showInformation(MarvelInformation info);
    }

    interface Presenter extends BasePresenter<View>{
        void getInformationFullName(String name);
        void getInformationPartialName(String name);
    }

    interface Router{
        void goToHeroScreen(MarvelInformation information);
        void goToFavoritesScreen();
    }
}
