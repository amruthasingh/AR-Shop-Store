package com.example.ar_store_shop;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;




public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ViewHolder> {



    List<ShopItems> ShopItemList;
    Context context;

    public ShopAdapter(List<ShopItems>ShopItemList)
    {
        this.ShopItemList = ShopItemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        ShopItems shop = ShopItemList.get(position);

        holder.imgDescription.setText(shop.getShopItems());
        holder.imgItem.setImageResource(shop.getImgItems());
        holder.cost.setText(shop.getAmount());
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"The position is:"+position,Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(context, MainActivity.class);

                intent.putExtra("Selected Item", shop.getShopItems());
                intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                view.getContext().startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return ShopItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgItem;
        TextView imgDescription, cost;
        CardView cv;

        public ViewHolder(View itemView)
        {
            super(itemView);
            imgItem = (ImageView)itemView.findViewById(R.id.imgItem);
            imgDescription = (TextView)itemView.findViewById(R.id.imgDescription);
            cost = (TextView)itemView.findViewById(R.id.cost);
            cv = (CardView)itemView.findViewById(R.id.cv);
        }

    }
}
