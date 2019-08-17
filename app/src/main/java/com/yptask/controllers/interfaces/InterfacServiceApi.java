package com.yptask.controllers.interfaces;


import com.yptask.models.CityResponse;
import com.yptask.models.CompanyResponse;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.yptask.controllers.Constants.*;


public interface InterfacServiceApi {

        @GET(CITY_PATH)
        Call<CityResponse[]> get_city();

        @GET(COMPANY_PATH)
        Call<CompanyResponse[]> get_company();

}
