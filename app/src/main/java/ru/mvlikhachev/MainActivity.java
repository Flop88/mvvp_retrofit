package ru.mvlikhachev;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.mvlikhachev.Adapter.CountryAdapter;
import ru.mvlikhachev.Model.CountryInfo;
import ru.mvlikhachev.Model.Result;
import ru.mvlikhachev.Service.CountryService;
import ru.mvlikhachev.Service.RetrofitInstance;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Result> resultArrayList;
    private CountryAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getCountries();
    }

    private Object getCountries() {
        CountryService countryService = RetrofitInstance.getService();
        Call<CountryInfo> call = countryService.getResults();
        call.enqueue(new Callback<CountryInfo>() {
            @Override
            public void onResponse(Call<CountryInfo> call, Response<CountryInfo> response) {
                CountryInfo countryInfo = response.body();

                if(countryInfo != null && countryInfo.getRestResponse() != null) {
                    resultArrayList = (ArrayList<Result>) countryInfo.getRestResponse().getResult();
                }

//                for (Result result: resultArrayList) {
//                    Log.d("resultArray", result.getName());
//                }

                fillRecyclerView();

            }

            @Override
            public void onFailure(Call<CountryInfo> call, Throwable t) {

            }
        });
        return resultArrayList;
    }

    private void fillRecyclerView() {

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new CountryAdapter(resultArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
}