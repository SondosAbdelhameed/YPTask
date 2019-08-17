package com.yptask.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.yptask.R;
import com.yptask.controllers.ApiClient;
import com.yptask.controllers.adapters.CityAdapter;
import com.yptask.controllers.adapters.CompanyAdapter;
import com.yptask.controllers.interfaces.InterfacServiceApi;
import com.yptask.models.CityResponse;
import com.yptask.models.CompanyResponse;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Result extends AppCompatActivity {

    @BindView(R.id.rcv_city)
    RecyclerView rcvCity;
    @BindView(R.id.linear_error)
    LinearLayout linearError;
    @BindView(R.id.relative_progress)
    RelativeLayout relativeProgress;

    CityAdapter cAdapter;
    CompanyAdapter CoAdapter;
    @BindView(R.id.linear_data)
    LinearLayout linearData;

    int type;
    List<CityResponse> cityList;
    List<CompanyResponse> companyList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        ButterKnife.bind(this);
        rcvCity.setLayoutManager(new LinearLayoutManager(this));
        type = getIntent().getIntExtra("type", 0);
        if (type == 1)
            get_city();
        else
            get_company();
    }

    void get_city() {
        InterfacServiceApi serviceApi = ApiClient.getClient().create(InterfacServiceApi.class);
        Call<CityResponse[]> call = serviceApi.get_city();
        call.enqueue(new Callback<CityResponse[]>() {
            @Override
            public void onResponse(Call<CityResponse[]> call, Response<CityResponse[]> response) {
                Toast.makeText(Result.this, "Done", Toast.LENGTH_SHORT).show();
                relativeProgress.setVisibility(View.GONE);
                linearData.setVisibility(View.VISIBLE);
                cityList = Arrays.asList(response.body());
                cAdapter = new CityAdapter(cityList);
                rcvCity.setAdapter(cAdapter);
            }

            @Override
            public void onFailure(Call<CityResponse[]> call, Throwable t) {
                relativeProgress.setVisibility(View.GONE);
                linearError.setVisibility(View.VISIBLE);
                Log.d("Test",t.toString());
            }
        });
    }

    void get_company() {
        InterfacServiceApi serviceApi = ApiClient.getClient().create(InterfacServiceApi.class);
        Call<CompanyResponse[]> call = serviceApi.get_company();
        call.enqueue(new Callback<CompanyResponse[]>() {
            @Override
            public void onResponse(Call<CompanyResponse[]> call, Response<CompanyResponse[]> response) {
                relativeProgress.setVisibility(View.GONE);
                linearData.setVisibility(View.VISIBLE);

                companyList = Arrays.asList(response.body());
                CoAdapter = new CompanyAdapter(companyList);
                rcvCity.setAdapter(CoAdapter);
            }

            @Override
            public void onFailure(Call<CompanyResponse[]> call, Throwable t) {
                relativeProgress.setVisibility(View.GONE);
                linearError.setVisibility(View.VISIBLE);
                Log.d("Test",t.toString());
            }
        });
    }

    @OnClick(R.id.btn_map)
    public void onViewClicked() {

        Intent intent = new Intent(this,Locations.class);
        //Bundle args = new Bundle();
       /// args.putSerializable("City", (Serializable) cityList);
        intent.putExtra("type",type);

        if (type == 1)
            intent.putExtra("City",(Serializable)cityList);
        else
            intent.putExtra("Company",(Serializable)companyList);

        startActivity(intent);
    }
}
