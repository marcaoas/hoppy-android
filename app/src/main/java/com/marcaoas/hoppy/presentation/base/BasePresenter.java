package com.marcaoas.hoppy.presentation.base;

/**
 * Created by marco on 15/04/17.
 */

public abstract class BasePresenter<T extends BaseView>  {

    protected T view;

    public void initView(T view){
        this.view = view;
    }

    public void dimiss(){
        this.view = null;
    }

}
