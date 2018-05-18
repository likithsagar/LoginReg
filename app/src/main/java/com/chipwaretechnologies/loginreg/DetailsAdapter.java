package com.chipwaretechnologies.loginreg;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by likit on 5/11/2018.
 */

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.MyHolder>{

    List<User> list;

    public DetailsAdapter(List<User> list){

        this.list=list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.details_blueprint,parent,false);

        return new MyHolder(itemview);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {

        User user = this.list.get(position);
        Log.v("List_size",String.valueOf(list.size()));
        holder.date.setText(user.getDate());
        holder.pname.setText(user.getProject_name());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{
        TextView date,pname;
        public MyHolder(View itemView) {
            super(itemView);
            date=(TextView) itemView.findViewById(R.id.date);
            pname=(TextView) itemView.findViewById(R.id.projectn);
        }

    }
}