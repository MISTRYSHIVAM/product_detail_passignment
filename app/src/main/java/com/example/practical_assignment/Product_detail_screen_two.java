package com.example.practical_assignment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Product_detail_screen_two#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Product_detail_screen_two extends Fragment {

    Product product;
    Product_detail_screen_two(Product product){
        this.product = product;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.e("Tag","e : "+product.getPdTitle());
        return inflater.inflate(R.layout.fragment_product_detail_screen_two, container, false);
    }
}