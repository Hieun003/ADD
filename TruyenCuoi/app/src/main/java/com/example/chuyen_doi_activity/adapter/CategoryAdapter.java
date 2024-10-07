package com.example.chuyen_doi_activity.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chuyen_doi_activity.R;
import com.example.chuyen_doi_activity.activity.Story_activity;
import com.example.chuyen_doi_activity.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>{
    private List<Category> listCategory;
    // Lưu Context để dễ dàng truy cập
    private Context mContext;

    public CategoryAdapter(List<Category> listCategory, Context mContext) {
        this.listCategory = listCategory;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.category_iteam, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        Category category = (Category) listCategory.get(position);
        holder.txtStory.setText(category.getNameCategory());
        holder.imgStory.setImageResource(category.getImgCategory());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Story_activity.class);
                intent.putExtra("categoryID", category.getIdCategory());
                intent.putExtra("categoryName", category.getNameCategory());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listCategory.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView imgStory;
        TextView txtStory;


        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imgStory = itemView.findViewById(R.id.imgCategory);
            txtStory = itemView.findViewById(R.id.nameCategory);
        }
    }
}
