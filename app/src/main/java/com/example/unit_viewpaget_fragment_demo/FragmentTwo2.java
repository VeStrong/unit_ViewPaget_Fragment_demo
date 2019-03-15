package com.example.unit_viewpaget_fragment_demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentTwo2 extends Fragment implements DataCall{


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


           View inflate = inflater.inflate(R.layout.fragmenttwo2, container, false);


        return inflate;
    }

    @Override
    public void data(Object s) {
        if(s instanceof String){
            String s1 = (String) s;
        }
    }
}
