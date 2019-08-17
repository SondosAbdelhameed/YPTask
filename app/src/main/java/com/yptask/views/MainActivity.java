package com.yptask.views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.yptask.R;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_city, R.id.btn_company})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_city:
                goToResult(1);
                break;
            case R.id.btn_company:
                goToResult(2);
                break;
        }
    }

    void goToResult(int type){

        Intent intent = new Intent(this, Result.class);
        intent.putExtra("type",type);
        startActivity(intent);
    }
}
