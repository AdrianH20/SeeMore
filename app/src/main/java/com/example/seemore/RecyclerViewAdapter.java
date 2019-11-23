package com.example.seemore;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mTitle = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mExpDates = new ArrayList<>();
    private ArrayList<String> mQuantities = new ArrayList<>();

    private Context mContext;

    public RecyclerViewAdapter(Context mContext, ArrayList<String> mTitle, ArrayList<String> mImages, ArrayList<String> mExpDates, ArrayList<String> mQuantities ) {
        this.mTitle = mTitle;
        this.mImages = mImages;
        this.mExpDates = mExpDates;
        this.mQuantities = mQuantities;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_recyclerview,parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        // Set images for products
         Log.d(TAG,"onBindViewHolder: called");
        Log.d(TAG, mImages.get(position));
        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);

        // Setting the index and name of the product
        holder.countNr.setText("   "+position+1+".  ");
        holder.productName.setText(mTitle.get(position));

        //Setting exp dates and quantities for products
        holder.expirationDate.setText("     Expiration date :"+mExpDates.get(position));
        holder.quantity.setText("     Quantity :"+mQuantities.get(position));

        /*holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: clicked on :" + mTitle.get(position));
                Toast.makeText(mContext,mTitle.get(position), Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return mTitle.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout parentLayout;

        CircleImageView image;
        RelativeLayout description;

        LinearLayout title;
        TextView countNr;
        TextView productName;

        TextView expirationDate;
        TextView quantity;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parentLayout = itemView.findViewById(R.id.parent_layout);
            image = itemView.findViewById(R.id.imageId);

            description = itemView.findViewById(R.id.description);
            title = itemView.findViewById(R.id.title);
            countNr = itemView.findViewById(R.id.count_nr);
            productName = itemView.findViewById(R.id.product_name);
            expirationDate = itemView.findViewById(R.id.expiration_date);
            quantity = itemView.findViewById(R.id.quantity);


        }
    }
}
