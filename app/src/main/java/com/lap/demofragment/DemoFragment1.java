package com.lap.demofragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by HuyQuyet on 4/25/17.
 */

public class DemoFragment1 extends Fragment {
    TextView txtNumber;
    Button btnStart;
    Button btnAdd;
    Button btnReplace;
    Handler handler;
    Runnable runnable;
    int i;

    public static DemoFragment1 newInstance() {
        Bundle bundle = new Bundle();
        DemoFragment1 fragment = new DemoFragment1();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo_1, container, false);
        txtNumber = (TextView) view.findViewById(R.id.txt_number);
        btnStart = (Button) view.findViewById(R.id.btn_start);
        btnAdd = (Button) view.findViewById(R.id.btn_add);
        btnReplace = (Button) view.findViewById(R.id.btn_replace);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        i= 0;
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                txtNumber.setText(String.valueOf(i));
                i++;
                handler.postDelayed(runnable, 1000);
            }
        };
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.postDelayed(runnable, 1000);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frame_main, DemoFragment2.newInstance());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        btnReplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_main, DemoFragment2.newInstance());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

    }

    @Override
    public void onPause() {
        Toast.makeText(getActivity(), "onPause", Toast.LENGTH_SHORT).show();
        handler.removeCallbacks(runnable);
        super.onPause();
    }
}
