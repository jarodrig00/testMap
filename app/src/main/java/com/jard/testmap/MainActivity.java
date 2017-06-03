package com.jard.testmap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickBtn(View v){

        switch (v.getId()){
            case R.id.imgBtnAltacia:
                Toast.makeText(this, "Pulso sobre Altacia", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imgBtnCalzada:
                Toast.makeText(this, "Pulso sobre Calzada", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imgBtnExplora:
                Toast.makeText(this, "Pulso sobre Explora", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imgBtnMetropolitano:
                Toast.makeText(this, "Pulso sobre Metropolitano", Toast.LENGTH_SHORT).show();
                break;
        }
        Intent i = new Intent(this, MapsActivity.class);
        i.putExtra("localidad", v.getId());
        startActivity(i);
    }
}
