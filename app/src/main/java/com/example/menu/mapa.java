package com.example.menu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class mapa extends Fragment {

    FirebaseFirestore firestore;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mapa, container, false);
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
        EditText editText1 = (EditText) view.findViewById(R.id.ET_EditTextKontakt1);
        EditText editText2 = (EditText) view.findViewById(R.id.ET_EditTextKontakt2);
        EditText editText3 = (EditText) view.findViewById(R.id.ET_EditTextKontakt3);
        editText1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                editText1.setText("");
            }
        });

        editText2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                editText2.setText("");
            }
        });
        editText3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                editText3.setText("");
            }
        });
        Button contactButton = (Button) view.findViewById(R.id.BT_ButtonKontakt1);
        contactButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String name = editText1.getText().toString();
                String email = editText2.getText().toString();
                String message = editText3.getText().toString();

                firestore = FirebaseFirestore.getInstance();

                Map<String,Object> contactForms = new HashMap<>();
                contactForms.put("name",name);
                contactForms.put("email",email);
                contactForms.put("message",message);

                firestore.collection("contactForms").add(contactForms).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
                editText1.setText("Imię i Nazwisko");
                editText2.setText("Email");
                editText3.setText("...");
                Toast.makeText(getActivity(), "Dziękujemy!", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}