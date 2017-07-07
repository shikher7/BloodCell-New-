package com.example.shikher.bloodcell.Utils.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shikher.bloodcell.R;
import com.example.shikher.bloodcell.Utils.DataGenerator;

import java.util.List;

/**
 * Created by shikher on 30/6/17.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.MyViewHolder> {

    private List<DataGenerator> bloodbanklist;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView place;
        public TextView phone;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.bloodbank_name);
            place = (TextView) view.findViewById(R.id.bloodbank_place);
            phone = (TextView) view.findViewById(R.id.bloodbank_phone);

        }
    }


    public SearchAdapter(List<DataGenerator> bloodbanklist) {
        this.bloodbanklist = bloodbanklist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_search_card_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.name.setText(bloodbanklist.get(position).getBloodBank(position));
        holder.phone.setText(bloodbanklist.get(position).getBloodBankPlace(position));
        holder.place.setText(bloodbanklist.get(position).getBloodBankPhone(position));

    }

    @Override
    public int getItemCount() {
        return bloodbanklist.size();
    }
}