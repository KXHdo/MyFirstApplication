package com.jnu.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jnu.student.data.ShopItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        // 获取两个 TextView 的引用
        TextView textView1 = findViewById(R.id.text_first);
        TextView textView2 = findViewById(R.id.text_second);

// 获取按钮的引用
        Button button = findViewById(R.id.button_change);

// 设置按钮的点击事件处理程序
        button.setOnClickListener(v -> {
            // 交换两个 TextView 中的文本
            String temp = textView1.getText().toString();
            textView1.setText(textView2.getText());
            textView2.setText(temp);
            Toast.makeText(MainActivity.this, "交换成功", Toast.LENGTH_SHORT).show();
            new AlertDialog.Builder(this)
                    .setTitle("交换成功")
                    .setMessage("两个 TextView 中的文本已经成功交换！")
                    .setPositiveButton("确定", null)
                    .show();
        });
*/
        RecyclerView mainRecyclerView = findViewById(R.id.recyclerview_main);
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<ShopItem> shopItems = new ArrayList<>();
        shopItems.add(new ShopItem("软件项目管理案例教程（第4版）", 1.5, R.drawable.book_2));
        shopItems.add(new ShopItem("创新工程实践", 2.5, R.drawable.book_no_name));
        shopItems.add(new ShopItem("信息安全数学基础（第2版）", 3.5, R.drawable.book_1));

        ShopItemAdapter shopItemAdapter = new ShopItemAdapter(shopItems);
        mainRecyclerView.setAdapter(shopItemAdapter);


    }
    public class ShopItemAdapter extends RecyclerView.Adapter<ShopItemAdapter.ViewHolder> {
        private ArrayList<ShopItem> shopItemArrayList;
        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        public class ViewHolder extends RecyclerView.ViewHolder {
            private final TextView textViewName;
            private final TextView textViewPrice;
            private final ImageView imageViewItem;

            public ViewHolder(View shopItemView) {
                super(shopItemView);

                textViewName = shopItemView.findViewById(R.id.textview_item_name);
                textViewPrice = shopItemView.findViewById(R.id.textview_item_price);
                imageViewItem = shopItemView.findViewById(R.id.imageview_item);
            }

            public TextView getTextViewName() {
                return textViewName;
            }

            public TextView getTextViewPrice() {
                return textViewPrice;
            }

            public ImageView getImageViewItem() {
                return imageViewItem;
            }
        }

        /**
         * Initialize the dataset of the Adapter.
         *
         * @param shopItems String[] containing the data to populate views to be used
         *                  by RecyclerView.
         */
        public ShopItemAdapter(ArrayList<ShopItem> shopItems) {
            shopItemArrayList = shopItems;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            // Create a new view, which defines the UI of the list item
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.shop_item_row, viewGroup, false);

            return new ViewHolder(view);
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder viewHolder, final int position) {
            viewHolder.getTextViewName().setText(shopItemArrayList.get(position).getName());
            viewHolder.getTextViewPrice().setText(shopItemArrayList.get(position).getPrice() + "");
            viewHolder.getImageViewItem().setImageResource(shopItemArrayList.get(position).getImageResourceId());
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return shopItemArrayList.size();
        }
    }

    }
