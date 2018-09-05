package com.dmantz.ecommerceapp;

import android.content.Context;
import android.content.Intent;
import android.service.autofill.Dataset;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private ProductList mproductList;
    private Context mcontext;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView mTextView;
        CardView cv;

        public ViewHolder(View itemView) {
            super(itemView);

            mTextView = itemView.findViewById(R.id.card_view_text);
            cv = itemView.findViewById(R.id.card_view);
        }
    }


    public RecyclerViewAdapter(ProductList productList,Context context) {
        mproductList = productList;
        mcontext = context;


        //  holder.mTextView.setText(mDataset.get(Integer.parseInt(appData.getItemName())));

        //    mDataset.add(appData.getItemName() +  appData.getItemPrice() + appData.getItemSize());
        Log.d("TAG", "entered into add method");
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.card_view_activity, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        // - get element from your dataset at this position
        // - replace the contents of the view with that element
          holder.mTextView.setText(mproductList.getProductList().get(position).getItemName());
          holder.cv.setOnClickListener(new View.OnClickListener() {
         @Override
          public void onClick(View view) {
              view.getContext().startActivity(new Intent(view.getContext(), AfterItemSelected.class));
            }
       });


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mproductList.getProductList().size();
    }

}

