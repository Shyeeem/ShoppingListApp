package com.example.shoplist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoplist.provider.Item;

import java.util.List;

public class shopListAdapter extends RecyclerView.Adapter<shopListAdapter.ViewHolder> {
    public List<Item> items;

    public void setItems(List<Item> newList){
        items = newList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;}

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemName.setText(items.get(position).getItemName());
        holder.cost.setText(items.get(position).getItemCost() + "");
        holder.cost.setText(items.get(position).getItemQuan() + "");
        holder.total.setText("$" +( items.get(position).getItemCost() * items.get(position)
        .getItemQuan())  + "");
    }





    @Override
    public int getItemCount() {
        if(items == null)
            return 0;
        else
            return  items.size();}


    public class ViewHolder extends RecyclerView.ViewHolder{
        public View itemHolder;
        public TextView itemName;
        public TextView cost;
        public TextView quantity;
        public TextView total;
        public ViewHolder(View itemView){
            super(itemView);
            itemHolder = itemView;
            itemName = itemView.findViewById(R.id.itemNameView);
            cost = itemView.findViewById(R.id.priceView);
            quantity = itemView.findViewById(R.id.quantityView);
            total = itemView.findViewById(R.id.totalCostView);
        }
    }
}
