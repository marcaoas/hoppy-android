package com.marcaoas.hoppy.presentation.base;

import android.support.v4.app.Fragment;

import com.marcaoas.hoppy.presentation.di.ApplicationComponent;

/**
 * Created by marco on 15/04/17.
 */

public abstract class BaseFragment<T extends BaseActivity> extends Fragment {

    protected T getHostingActivity() {
        return (T) getActivity();
    }

    protected ApplicationComponent getApplicationComponent() {
        return getHostingActivity().getApplicationComponent();
    }

}
