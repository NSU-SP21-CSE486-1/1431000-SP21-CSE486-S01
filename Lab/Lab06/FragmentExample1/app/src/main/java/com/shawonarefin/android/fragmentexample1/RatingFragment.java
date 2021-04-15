package com.shawonarefin.android.fragmentexample1;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class RatingFragment extends Fragment {

    public static final int YES = 0;
    public static final int NO = 1;

    public RatingFragment() {

    }


    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_rating, container,
                false);
        final RadioGroup radioGroup = rootView.findViewById(R.id.radio_group);
        final RatingBar ratingBar = rootView.findViewById(R.id.ratingBar);

          radioGroup.setOnCheckedChangeListener(((group, checkedId) ->  {
            View radioButton = radioGroup.findViewById(radioButton);
            int index = radioGroup.indexOfChild(radioButton);
            TextView textView = rootView.findViewById(R.id.Fheader);

            switch (index){
                case YES:
                    textView.setText("ARTICLE: Like");
                    break;
                case NO: // User "No".
                    textView.setText(R.string.no_message);
                    break;
                default: // No choice made.
                    // Do nothing.
                    break;
            }
        });

                ratingBar.setOnRatingBarChangeListener(
                        (ratingBar1, rating, fromUser) -> {
                    String UserRating = ("User Rating: " + String.valueOf(ratingBar1.getRating()));
                    Toast.makeText(getContext(), UserRating, Toast.LENGTH_LONG).show();
                }
        ); return rootView; //return the message


    }
}






