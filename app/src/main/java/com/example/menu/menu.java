package com.example.menu;

import android.content.Context;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;

public class menu extends Fragment{

    int flag1;
    int flag2;
    int flag3;
    int flag4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu, container, false);

        Context context = getContext();

        /** section1  **/
        Button down1 = (Button) view.findViewById(R.id.removeBtn1);
        Button up1 = (Button) view.findViewById(R.id.addBtn1);
        TextView textView1 = (TextView) view.findViewById(R.id.itemQuanEt1);
        up1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag1+=1;
                textView1.setText(""+flag1);
            }
        });
        down1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag1-=1;
                if (flag1<0){
                    textView1.setText(""+0);
                    flag1=0;
                }else{
                    textView1.setText(""+flag1);
                }
            }
        });

        Spinner spinner1 = (Spinner) view.findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(context,R.array.kebabs_mini, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                String text = parentView.getItemAtPosition(position).toString();
                text += " ";
                text += String.valueOf(flag1);
                Toast.makeText(parentView.getContext(),text,Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> parentView)
            {

            }
        });
        /** section2  **/
        Button down2 = (Button) view.findViewById(R.id.removeBtn2);
        Button up2 = (Button) view.findViewById(R.id.addBtn2);
        TextView textView2 = (TextView) view.findViewById(R.id.itemQuanEt2);
        up2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag2+=1;
                textView2.setText(""+flag2);
            }
        });
        down2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag2-=1;
                if (flag2<0){
                    textView2.setText(""+0);
                    flag2=0;
                }else{
                    textView2.setText(""+flag2);
                }
            }
        });

        Spinner spinner2 = (Spinner) view.findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(context,R.array.kebabs_studencki, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                String text = parentView.getItemAtPosition(position).toString();
                text += " ";
                text += String.valueOf(flag2);
                Toast.makeText(parentView.getContext(),text,Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> parentView)
            {

            }
        });
        /** section3  **/
        Button down3 = (Button) view.findViewById(R.id.removeBtn3);
        Button up3 = (Button) view.findViewById(R.id.addBtn3);
        TextView textView3 = (TextView) view.findViewById(R.id.itemQuanEt3);
        up3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag3+=1;
                textView3.setText(""+flag3);
            }
        });
        down3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag3-=1;
                if (flag3<0){
                    textView3.setText(""+0);
                    flag3=0;
                }else{
                    textView3.setText(""+flag3);
                }
            }
        });

        Spinner spinner3 = (Spinner) view.findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(context,R.array.kebabs_darollo, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                String text = parentView.getItemAtPosition(position).toString();
                text += " ";
                text += String.valueOf(flag3);
                Toast.makeText(parentView.getContext(),text,Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> parentView)
            {

            }
        });
        /** section4  **/
        Button down4 = (Button) view.findViewById(R.id.removeBtn);
        Button up4 = (Button) view.findViewById(R.id.addBtn);
        TextView textView4 = (TextView) view.findViewById(R.id.itemQuanEt);
        up4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag4+=1;
                textView4.setText(""+flag4);
            }
        });
        down4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag4-=1;
                if (flag4<0){
                    textView4.setText(""+0);
                    flag4=0;
                }else{
                    textView4.setText(""+flag4);
                }
            }
        });

        Spinner spinner4 = (Spinner) view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(context,R.array.kebabs_doner, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                String text = parentView.getItemAtPosition(position).toString();
                text += " ";
                text += String.valueOf(flag4);
                Toast.makeText(parentView.getContext(),text,Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> parentView)
            {

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