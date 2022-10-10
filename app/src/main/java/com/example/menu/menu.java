package com.example.menu;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class menu extends Fragment {
    static int flag = 1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu, container, false);

/** Code to use in onCreate()  **/
        Button down = (Button) view.findViewById(R.id.removeBtn1);
        Button up = (Button) view.findViewById(R.id.addBtn1);
        TextView textView1 = (TextView) view.findViewById(R.id.itemQuanEt1);
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag+=1;
                textView1.setText(""+flag);
            }
        });
        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag-=1;
                if (flag<0){
                    textView1.setText(""+0);
                    flag=0;
                }else{
                    textView1.setText(""+flag);
                }
            }
        });

        // Inflate the layout for this fragment

        ImageView imageView = (ImageView) view.findViewById(R.id.IB_ImageButtonGaleria1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.facebook.com/Dara-Kebab-115598415128675/"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        TextView textView = (TextView) view.findViewById(R.id.TV_TextViewGaleria7);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MapsFragment mapy = new MapsFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContent,mapy, mapy.getTag())
                        .addToBackStack(null)
                        .commit();

                getActivity().setTitle("Mapa");
            }
        });
        return view;

    }




}