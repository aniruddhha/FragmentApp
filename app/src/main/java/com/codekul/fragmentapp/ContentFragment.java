package com.codekul.fragmentapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment {

    public static final String KEY_COUNTRY = "country";

    private View rootView;
    private ImageView imageView;

    public ContentFragment() {
        // Required empty public constructor
    }

    public static ContentFragment getInstance(String country){

        ContentFragment fragment = new ContentFragment();

        Bundle arguments = new Bundle();
        arguments.putString(KEY_COUNTRY,country);

        fragment.setArguments(arguments);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_content, container, false);

        imageView = (ImageView) rootView.findViewById(R.id.imageCountry);

        Bundle arguments = getArguments();

        String country = arguments.getString(KEY_COUNTRY);

        if(country.equals("India")) {
            imageView.setImageResource(R.drawable.indai);
        }
        else if (country.equals("Japan")) {
            imageView.setImageResource(R.drawable.japan);

        } else if (country.equals("Chiana")) {
            imageView.setImageResource(R.drawable.china);

        } else if (country.equals("Shri Lanka")) {
            imageView.setImageResource(R.drawable.shrilanka);

        } else {

            imageView.setImageResource(R.drawable.us);
        }
        return rootView;
    }

}
