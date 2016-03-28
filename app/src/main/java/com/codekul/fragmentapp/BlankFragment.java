package com.codekul.fragmentapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private View rootView;
    private ListView listViewCountries;
    private ArrayList<String> arrayListCountries;
    private ArrayAdapter<String> arrayAdapter;

    private MainActivity parentActivity;

    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment getInstance(){

        BlankFragment fragment = new BlankFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        parentActivity = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_blank, container, false);

        arrayListCountries = new ArrayList<>();
        arrayListCountries.add("India");
        arrayListCountries.add("Chiana");
        arrayListCountries.add("Japan");
        arrayListCountries.add("Shri Lanka");
        arrayListCountries.add("America");

        listViewCountries = (ListView) rootView.findViewById(R.id.listViewCountries);
        listViewCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView textView = (TextView) view;
                String country = textView.getText().toString();
                parentActivity.runFragmentTransaction(R.id.frameContentContainer, ContentFragment.getInstance(country));
            }
        });

        arrayAdapter = new ArrayAdapter<String>(parentActivity,android.R.layout.simple_list_item_1,arrayListCountries);

        listViewCountries.setAdapter(arrayAdapter);
        return rootView;
    }
}
