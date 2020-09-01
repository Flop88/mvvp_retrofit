package ru.mvlikhachev.Service;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.mvlikhachev.Model.CountryInfo;

public interface CountryService {

    @GET("country/get/all")
    Call<CountryInfo> getResults();
}
