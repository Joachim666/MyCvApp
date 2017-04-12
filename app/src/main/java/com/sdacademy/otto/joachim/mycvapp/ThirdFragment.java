package com.sdacademy.otto.joachim.mycvapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ThirdFragment extends Fragment {
    public ThirdFragment(){

    }



    public static ThirdFragment newInstance() {
        ThirdFragment thirdFragment = new ThirdFragment();
        return thirdFragment;
    }






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_thrid, container, false);

        return view;
    }
}