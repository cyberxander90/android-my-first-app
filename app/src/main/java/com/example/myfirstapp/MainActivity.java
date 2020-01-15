package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ItemApi apiInterface;

    /** Called when the activity is first created. */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView firstTextView = findViewById(R.id.first_text);
        firstTextView.setText("Primer mensaje de la app");

        Button firstButton = findViewById(R.id.first_button);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listIntent = new Intent(view.getContext(), ListActivity.class);
                startActivity(listIntent);
            }
        });

        Button getItem = findViewById(R.id.second_button);
        getItem.setOnClickListener(
                view -> {
                    Log.d("Second button", "getItem button");
                    apiInterface = ApiClient.Companion.getClient().create(ItemApi.class);
                    Call<Item> call = apiInterface.getItem("MLU452823986");
                    call.enqueue(new Callback<Item>() {
                        @Override
                        public void onResponse(Call<Item> call, Response<Item> response) {
                            Log.d("API CALL",response.code()+"");
                            Log.d ("BODY", response.body().getTitle());
                        }

                        @Override
                        public void onFailure(Call<Item> call, Throwable t) {
                            call.cancel();
                        }
                    });
                }
        );

    }


}
