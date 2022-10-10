package com.example.menu;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class menu1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        /*View view = inflater.inflate(R.layout.menu, container, false);
        Button przycisk = (Button) view.findViewById(R.id.button);
        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapa mapy = new mapa();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContent,mapy, mapy.getTag())
                        .addToBackStack(null)
                        .commit();

                getActivity().setTitle("Mapa");
            }
        });*/
        return null;
    }
}