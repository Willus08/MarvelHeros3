package com.helpmeproductions.willus08.marvelheros.view.activities.home_screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.helpmeproductions.willus08.marvelheros.R;
import com.helpmeproductions.willus08.marvelheros.model.MarvelInformation;
import com.helpmeproductions.willus08.marvelheros.model.Result;
import com.helpmeproductions.willus08.marvelheros.view.injection.home_screen.DaggerHomeScreenComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeScreen extends AppCompatActivity implements HomeScreenContract.View{

    @Inject HomeScreenPresenter presenter;
    @BindView(R.id.ivHomeHeroImage)ImageView heroImage;
    @BindView(R.id.tvHomeHeroName) TextView heroName;
    @BindView(R.id.tvHomeHeroDescription)TextView heroDescription;
    @BindView(R.id.etSearchName)EditText searchedName;
    @BindView(R.id.cvHeroContainer)CardView container;

    HomeScreenRouter router;
    String searched;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        setupDagger();
        ButterKnife.bind(this);
        container.setVisibility(View.GONE);
        presenter.addView(this);
        router = new HomeScreenRouter(this);
    }

    public void showMoreDetails(View view) {

    }

    public void beginSearch(View view) {
        searched = searchedName.getText().toString();
       if(!searched.equals("")){
        presenter.getInformationFullName(searched);
       }else {
           showError("You must type a name to start a search");
       }
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setupDagger() {
        DaggerHomeScreenComponent.create().inject(this);
    }

    @Override
    public void showInformation(MarvelInformation info) {
        container.setVisibility(View.VISIBLE);

        if(!info.getEtag().equals(getString(R.string.empty_data_tag))){
            Result heroInfo = info.getData().getResults().get(0);
            Glide.with(this).load(heroInfo.getThumbnail().getPath()).into(heroImage);
            heroName.setText(heroInfo.getName());
            heroDescription.setText(heroInfo.getDescription());
        }else {
            presenter.getInformationPartialName(searched);
        }
    }


}
