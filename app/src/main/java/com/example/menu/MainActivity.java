package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mlayout;
    private ActionBarDrawerToggle mtoggle;

    FirebaseFirestore firestore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black)));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mlayout = (DrawerLayout)findViewById(R.id.main_activity);
        mtoggle = new ActionBarDrawerToggle(this,mlayout,R.string.Open,R.string.Close);
        mlayout.addDrawerListener(mtoggle);
        NavigationView mnawigacja = (NavigationView)findViewById(R.id.nawigacja);
        mtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ustawContent(mnawigacja);

        firestore = FirebaseFirestore.getInstance();

        Map<String,Object> user = new HashMap<>();
        user.put("firstName","a");
        user.put("lastName","b");

//        firestore.collection("users").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
//            @Override
//            public void onSuccess(DocumentReference documentReference) {
//                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Toast.makeText(getApplicationContext(),"Failure",Toast.LENGTH_LONG).show();
//            }
//        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(mtoggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void ustawContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        wybranyElementMenu(item);
                        return false;
                    }
                });
    }

    private void wybranyElementMenu (MenuItem menuItem){
        Fragment mfragment = null;
        Class fragmentClass;
        switch(menuItem.getItemId()){
            case R.id.menu:
                fragmentClass=menu.class;
                break;
            case R.id.galeria:
                fragmentClass=galeria.class;
                break;
            case R.id.mapa:
                fragmentClass=mapa.class;
                break;
            case R.id.kontakt:
                fragmentClass=MapsFragment.class;
                break;
            default:
                fragmentClass=menu.class;
        }
        try{
            mfragment = (Fragment) fragmentClass.newInstance();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentContent,mfragment).commit();
        setTitle(menuItem.getTitle());
        mlayout.closeDrawers();
    }

}