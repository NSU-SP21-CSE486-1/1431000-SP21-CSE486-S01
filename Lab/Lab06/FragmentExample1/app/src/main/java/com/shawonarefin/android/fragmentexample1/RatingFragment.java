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

    //Article Like? Yes-No RadioButtons
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_rating,
                container, false);

        final RadioGroup radioGroup = rootView.findViewById(R.id.radio_group);
        final RatingBar ratingBar = rootView.findViewById(R.id.ratingBar);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            View radioButton = radioGroup.findViewById(checkedId);
            int index = radioGroup.indexOfChild(radioButton);
            TextView textView = rootView.findViewById(R.id.Fheader);

            switch (index) {
                case YES: //User "Yes"
                    textView.setText("ARTICLE Liked!");
                    break;
                case NO: // User "No".
                    textView.setText("ARTICLE Disliked!");
                    break;
                default: // No choice made.
                    // Do nothing.
                    break;
            }
        });

        //Setting the rating is set in onCheckedChanged Listener; The sliding StarRating
        ratingBar.setOnRatingBarChangeListener(
                (ratingBar1, rating, fromUser) -> {
                    String UserRating = ("User Rating: " + String.valueOf(ratingBar1.getRating()));
                    Toast.makeText(getContext(), UserRating, Toast.LENGTH_LONG).show(); //Return Toast Messages.
                }
        );
        return rootView; //return the message

    }
}