package com.lap.demofragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by HuyQuyet on 4/25/17.
 */

public class DemoFragment2 extends Fragment {

    public static DemoFragment2 newInstance() {
        Bundle bundle = new Bundle();
        DemoFragment2 fragment = new DemoFragment2();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_demo_2, container, false);
    }
}
