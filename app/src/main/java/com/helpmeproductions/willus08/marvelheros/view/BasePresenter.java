package com.helpmeproductions.willus08.marvelheros.view;



public interface BasePresenter<V extends BaseView> {
    void addView(V view);
    void removeView();
}
