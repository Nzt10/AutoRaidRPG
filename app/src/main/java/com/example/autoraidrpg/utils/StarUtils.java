package com.example.autoraidrpg.utils;

import android.view.View;
import android.widget.ImageView;

import com.example.autoraidrpg.R;

import java.util.ArrayList;
import java.util.List;

public class StarUtils {

    public static void rewriteStar(View parent, int numOfStars) {
        List<ImageView> ratingImages = new ArrayList<>();

        ratingImages.add(parent.findViewById(R.id.rating1));
        ratingImages.add(parent.findViewById(R.id.rating2));
        ratingImages.add(parent.findViewById(R.id.rating3));
        ratingImages.add(parent.findViewById(R.id.rating4));
        ratingImages.add(parent.findViewById(R.id.rating5));

        // remove all the star first
        removeStars(ratingImages);

        // set rating
        for(int i = 0; i < numOfStars; i++) {
            ratingImages.get(i).setVisibility(View.VISIBLE);
        }
    }

    // remove all stars
    private static void removeStars(List<ImageView> ratingImages) {
        ratingImages.forEach(view -> view.setVisibility(View.GONE));
    }

}
