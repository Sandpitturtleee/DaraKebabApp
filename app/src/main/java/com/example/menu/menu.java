package com.example.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class menu extends Fragment{

    int flag1,flag2,flag3,flag4;

    int kurczakMini,wolowinaMini,mieszanyMini;
    int kurczakStudencki,wolowinaStudencki,mieszanyStudencki;
    int kurczakDarollo,wolowinaDarollo,mieszanyDarollo;
    int kurczakDoner,wolowinaDoner,mieszanyDoner;

    FirebaseFirestore firestore;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu, container, false);

        Context context = getContext();

        TextView miniPrices = (TextView) view.findViewById(R.id.TV_TextViewMenu6);
        TextView studenckiPrices = (TextView) view.findViewById(R.id.TV_TextViewMenu9);
        TextView darolloPrices = (TextView) view.findViewById(R.id.TV_TextViewMenu13);
        TextView donerPrices = (TextView) view.findViewById(R.id.TV_TextViewMenu16);

        firestore = FirebaseFirestore.getInstance();

        DocumentReference documentReference = firestore.collection("prices").document("gN2KLecK26aRil5J8FSe");
        documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                DocumentSnapshot documentSnapshot = task.getResult();
                miniPrices.setText(documentSnapshot.getString("mini"));
                studenckiPrices.setText(documentSnapshot.getString("studencki"));
                darolloPrices.setText(documentSnapshot.getString("darollo"));
                donerPrices.setText(documentSnapshot.getString("doner"));
            }
        });



        /** section1  **/
        ImageButton down1 = (ImageButton)  view.findViewById(R.id.removeBtn1);
        ImageButton up1 = (ImageButton) view.findViewById(R.id.addBtn1);
        Button cart1 = (Button) view.findViewById(R.id.button1);
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

            }

            public void onNothingSelected(AdapterView<?> parentView)
            {

            }

        });
        cart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = spinner1.getSelectedItem().toString();
                if (text.equals("Kurczak")) {
                    kurczakMini +=flag1;
                } else if (text.equals("Wołowina")) {
                    wolowinaMini +=flag1;
                } else {
                    mieszanyMini +=flag1;
                }
                text += String.valueOf(kurczakMini);
                Toast.makeText(view.getContext(),"Dodano do koszyka",Toast.LENGTH_SHORT).show();
                flag1 =0;
                textView1.setText("0");
            }
        });
        /** section2  **/
        ImageButton down2 = (ImageButton) view.findViewById(R.id.removeBtn2);
        ImageButton up2 = (ImageButton) view.findViewById(R.id.addBtn2);
        Button cart2 = (Button) view.findViewById(R.id.button2);
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

            }

            public void onNothingSelected(AdapterView<?> parentView)
            {

            }
        });
        cart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = spinner2.getSelectedItem().toString();
                if (text.equals("Kurczak")) {
                   kurczakStudencki +=flag2;
                } else if (text.equals("Wołowina")) {
                    wolowinaStudencki +=flag2;
                } else {
                    mieszanyStudencki +=flag2;
                }
                text += String.valueOf(kurczakStudencki);
                Toast.makeText(view.getContext(),"Dodano do koszyka",Toast.LENGTH_SHORT).show();
                flag2 =0;
                textView2.setText("0");
            }
        });
        /** section3  **/
        ImageButton down3 = (ImageButton) view.findViewById(R.id.removeBtn3);
        ImageButton up3 = (ImageButton) view.findViewById(R.id.addBtn3);
        Button cart3 = (Button) view.findViewById(R.id.button3);
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

            }

            public void onNothingSelected(AdapterView<?> parentView)
            {

            }

        });
        cart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = spinner3.getSelectedItem().toString();
                if (text.equals("Kurczak")) {
                    kurczakDarollo +=flag3;
                } else if (text.equals("Wołowina")) {
                    wolowinaDarollo +=flag3;
                } else {
                    mieszanyDarollo +=flag3;
                }
                text += String.valueOf(kurczakDarollo);
                Toast.makeText(view.getContext(),"Dodano do koszyka",Toast.LENGTH_SHORT).show();
                flag3 =0;
                textView3.setText("0");
            }
        });
        /** section4  **/
        ImageButton down4 = (ImageButton) view.findViewById(R.id.removeBtn);
        ImageButton up4 = (ImageButton) view.findViewById(R.id.addBtn);
        Button cart4 = (Button) view.findViewById(R.id.button4);
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

            }

            public void onNothingSelected(AdapterView<?> parentView)
            {

            }
        });
        cart4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = spinner4.getSelectedItem().toString();
                if (text.equals("Kurczak")) {
                    kurczakDoner +=flag4;
                } else if (text.equals("Wołowina")) {
                    wolowinaDoner +=flag4;
                } else {
                    mieszanyDoner +=flag4;
                }
                text += String.valueOf(kurczakDoner);
                Toast.makeText(view.getContext(),"Dodano do koszyka",Toast.LENGTH_SHORT).show();
                flag4 =0;
                textView4.setText("0");
            }
        });


        Button buy = (Button) view.findViewById(R.id.buttonBuy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firestore = FirebaseFirestore.getInstance();

                Map<String,Object> orders = new HashMap<>();
                orders.put("kurczakMini",kurczakMini);
                orders.put("wolowinaMini",wolowinaMini);
                orders.put("mieszanyMini",mieszanyMini);
                orders.put("kurczakStudencki",kurczakStudencki);
                orders.put("wolowinaStudencki",wolowinaStudencki);
                orders.put("mieszanyStudencki",mieszanyStudencki);
                orders.put("kurczakDarollo",kurczakDarollo);
                orders.put("wolowinaDarollo",wolowinaDarollo);
                orders.put("mieszanyDarollo",mieszanyDarollo);
                orders.put("kurczakDoner",kurczakDoner);
                orders.put("wolowinaDoner",wolowinaDoner);
                orders.put("mieszanyDoner",mieszanyDoner);


                firestore.collection("orders").add(orders).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(view.getContext(),"Dziękujemy za zamówienie",Toast.LENGTH_SHORT).show();
                        kurczakMini = 0;
                        wolowinaMini = 0;
                        mieszanyMini = 0;
                        kurczakStudencki = 0;
                        wolowinaStudencki = 0;
                        mieszanyStudencki =0;
                        kurczakDarollo = 0;
                        wolowinaDarollo = 0;
                        mieszanyDarollo = 0;
                        kurczakDoner = 0;
                        wolowinaDoner = 0;
                        mieszanyDoner = 0;
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
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