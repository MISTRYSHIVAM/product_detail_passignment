package com.example.practical_assignment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Product_detail_screen_one#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Product_detail_screen_one extends Fragment {

    TextInputLayout titleWrapper , descriptionWrapper , keyFeatureWrapper ;
    Button btnNext;
    Spinner categoryWrapper;

    String productCategory;
    private MainActivity mainActivity;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Product_detail_screen_one() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Product_detail_screen_one.
     */
    // TODO: Rename and change types and number of parameters
    public static Product_detail_screen_one newInstance(String param1, String param2) {
        Product_detail_screen_one fragment = new Product_detail_screen_one();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_detail_screen_one, container, false);
        init(view);
        onTextChangeListener(titleWrapper);
        onTextChangeListener(descriptionWrapper);
        onTextChangeListener(keyFeatureWrapper);
        clickListeners();

        return view;
    }

    private void init(View view){
        titleWrapper = view.findViewById(R.id.pdTitle);
        descriptionWrapper = view.findViewById(R.id.pdDescription);
        keyFeatureWrapper = view.findViewById(R.id.pdKeyFeature);
        categoryWrapper = view.findViewById(R.id.pdCategory);
        btnNext = view.findViewById(R.id.btnNext);
    }
    private void onTextChangeListener(TextInputLayout layout){
        layout.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(layout.getEditText().getText().toString().isEmpty()){
                    layout.setError("Please enter "+layout.getHint());
                }else{
                    layout.setError("");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private String getTextContent(TextInputLayout layout){
        return layout.getEditText().getText().toString();
    }

    private void clickListeners(){
        categoryWrapper.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                productCategory = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productTitle , productDescription , productKeyFeature;
                productTitle = getTextContent(titleWrapper);
                productDescription = getTextContent(descriptionWrapper);
                productKeyFeature = getTextContent(keyFeatureWrapper);

                Product product = new Product();
                product.setPdCategory(productCategory);
                product.setPdTitle(productTitle);
                product.setPdDescription(productDescription);
                product.setPdKeyFeature(productKeyFeature);

                mainActivity.loadFragment(new Product_detail_screen_two(product));
            }
        });
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        mainActivity=(MainActivity) getActivity();
    }
}