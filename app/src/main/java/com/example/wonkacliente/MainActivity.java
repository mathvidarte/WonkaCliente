package com.example.wonkacliente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.wonkacliente.model.Comida;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button burrito;
    private Button pizza;
    private Button hotDog;
    private Button burger;
    UDPConection udp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        burrito = findViewById(R.id.burrito);
        pizza = findViewById(R.id.pizza);
        hotDog = findViewById(R.id.hotDog);
        burger = findViewById(R.id.burger);

        burrito.setOnClickListener(this);
        pizza.setOnClickListener(this);
        hotDog.setOnClickListener(this);
        burger.setOnClickListener(this);

        udp = new UDPConection();
        udp.start();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.burrito:

                Gson gson = new Gson();

                Comida food = new Comida ("burrito");

                String json = gson.toJson(food);

                udp.sendMessage(json);
                Log.d("<<<<<<<<<<<<", ""+json);

                break;

            case R.id.pizza:

                break;

            case R.id.hotDog:

                break;

            case R.id.burger:

                break;
        }

    }
}