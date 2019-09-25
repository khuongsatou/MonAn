package com.nvk.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ShoppingItemsActivity extends AppCompatActivity {

    public static final String KEY_MONAN = "mon";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_items);
    }

    public void ShowGao(View view) {
        ChonMon(getString(R.string.gao));
    }

    public void ChonMon(String mon){
        Intent intent = new Intent();
        intent.putExtra(KEY_MONAN,mon);
        setResult(RESULT_OK,intent);
        finish();
    }

    public void ShowBo(View view) {
        ChonMon(getString(R.string.bo));
    }

    public void ShowTao(View view) {
        ChonMon(getString(R.string.tao));
    }

    public void ShowCam(View view) {
        ChonMon(getString(R.string.cam));
    }
}
