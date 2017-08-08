package com.walloom.mobi.controlador;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.walloom.mobi.NuevoGastoFragment;
import com.walloom.mobi.NuevoVehicFragment;
import com.walloom.mobi.R;

public class Main2Activity extends AppCompatActivity {

    private String cadena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        //ab.setTitle("venta");
        ab.setDisplayHomeAsUpEnabled(true);
   //     ab.setHomeButtonEnabled(true);

  //      toolbar.setTitle("Nuevo Gasto");


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            cadena = extras.getString("direccion");

            if (cadena.equals("gastos")) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                NuevoGastoFragment frag = new NuevoGastoFragment();
                ft.add(R.id.contenedor2, frag).commit();

            }
            if (cadena.equals("vehiculo")) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                NuevoVehicFragment frag = new NuevoVehicFragment();
                ft.add(R.id.contenedor2, frag).commit();

            }
        }
    }

 /*   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent = new Intent (this, MainActivity.class);
        Log.d("cadena",cadena);
        if (id == android.R.id.home){
            if(cadena.equals("gastos")){
                intent.putExtra("direccion","gastos");
            }
            if(cadena.equals("vehiculo")){
                intent.putExtra("direccion","vehiculo");
            }
        }
        Log.d("cadenaVa",cadena);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}
