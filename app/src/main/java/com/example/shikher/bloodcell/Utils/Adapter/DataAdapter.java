package com.example.shikher.bloodcell.Utils.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.shikher.bloodcell.Background.city_JSONResponse;
import com.example.shikher.bloodcell.R;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> implements Filterable {
    private ArrayList<city_JSONResponse.AndroidVersion> mArrayList;
    private ArrayList<city_JSONResponse.AndroidVersion> mFilteredList;

    public DataAdapter(ArrayList<city_JSONResponse.AndroidVersion> arrayList) {
        mArrayList = arrayList;
        mFilteredList = arrayList;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.name.setText(mFilteredList.get(i).getBankName());
        viewHolder.city.setText(mFilteredList.get(i).getCity());
        viewHolder.phone.setText(mFilteredList.get(i).getPhone());
    }

    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    mFilteredList = mArrayList;
                } else {

                    ArrayList<city_JSONResponse.AndroidVersion> filteredList = new ArrayList<>();

                    for (city_JSONResponse.AndroidVersion androidVersion : mArrayList) {

                        if (androidVersion.getPhone().toLowerCase().contains(charString) || androidVersion.getBankName().toLowerCase().contains(charString) || androidVersion.getCity().toLowerCase().contains(charString)) {

                            filteredList.add(androidVersion);
                        }
                    }

                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<city_JSONResponse.AndroidVersion>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView name,phone,city;
        public ViewHolder(View view) {
            super(view);

            name = (TextView)view.findViewById(R.id.bloodbank_name);
            phone = (TextView)view.findViewById(R.id.bloodbank_phone);
            city = (TextView)view.findViewById(R.id.bloodbank_city);

        }
    }

}