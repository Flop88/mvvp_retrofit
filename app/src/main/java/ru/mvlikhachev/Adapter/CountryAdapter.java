package ru.mvlikhachev.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.mvlikhachev.Model.Result;
import ru.mvlikhachev.R;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {


    private ArrayList<Result> resultArrayList;

    public CountryAdapter(ArrayList<Result> resultArrayList) {
        this.resultArrayList = resultArrayList;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.country_item, parent, false);

        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {

        holder.countryNameTextView.setText(resultArrayList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return resultArrayList.size();
    }

    class CountryViewHolder extends RecyclerView.ViewHolder {

        TextView countryNameTextView;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            countryNameTextView = itemView.findViewById(R.id.countryNameTextView);
        }
    }
}
