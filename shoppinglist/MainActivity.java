package com.nvk.shoppinglist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.nvk.shoppinglist.ShoppingItemsActivity.KEY_MONAN;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 123;
    private static final String KEY_SAVE = "MonS";
    private static final String KEY_SAVE_VISIBLE = "Visible";
    private TextView tvSPs[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSPs = new TextView[10];
        tvSPs[0] = findViewById(R.id.tvSP1);
        tvSPs[1] = findViewById(R.id.tvSP2);
        tvSPs[2] = findViewById(R.id.tvSP3);
        tvSPs[3] = findViewById(R.id.tvSP4);
        tvSPs[4] = findViewById(R.id.tvSP5);
        tvSPs[5] = findViewById(R.id.tvSP6);
        tvSPs[6] = findViewById(R.id.tvSP7);
        tvSPs[7] = findViewById(R.id.tvSP8);
        tvSPs[8] = findViewById(R.id.tvSP9);
        tvSPs[9] = findViewById(R.id.tvSP10);

    }

    public void ThemSanPham(View view) {
        Intent intent = new Intent(this,ShoppingItemsActivity.class);
        startActivityForResult(intent,REQUEST_CODE);

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        for (int i = 0; i <tvSPs.length ; i++) {
            if (tvSPs[i].getVisibility() == View.VISIBLE){
                outState.putString(KEY_SAVE+i,tvSPs[i].getText().toString());
                outState.putBoolean(KEY_SAVE_VISIBLE+i,true);
            }
        }
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null){
            for (int i = 0; i <tvSPs.length ; i++) {
                Boolean isVisible = savedInstanceState.getBoolean(KEY_SAVE_VISIBLE+i);
                if (isVisible){
                   tvSPs[i].setText(savedInstanceState.getString(KEY_SAVE+i));
                   tvSPs[i].setVisibility(View.VISIBLE);
                }else{
                    break;
                }
            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == RESULT_OK){
                String result = data.getExtras().getString(KEY_MONAN);
                for (int i = 0; i < tvSPs.length ; i++) {
                    if (tvSPs[i].getVisibility() != View.VISIBLE){
                        tvSPs[i].setVisibility(View.VISIBLE);
                        tvSPs[i].setText(result);
                        break;
                    }
                }
            }
        }
    }
}
