package com.demo.customviews;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.demo.R;
import com.demo.model.Row;
import com.squareup.picasso.Picasso;


/**
 * Created by vijayaraj_s on 3/24/2018.
 */

public class CustomAdapterView extends LinearLayout {

    public CustomAdapterView(Context context, Row mRow) {
        super(context);

        // Container is a horizontal layout
        setOrientation(LinearLayout.HORIZONTAL);
        setPadding(10, 10, 10, 10);
        setWeightSum(1);

        // Null Checking
        if (null != mRow.getTitle() || null != mRow.getDescription() || null != mRow.getImageHref()) {

            // Vertical layout container
            LinearLayout.LayoutParams mainParams = new LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT);
            mainParams.weight = 0.95f;
            LinearLayout mainContainer = new LinearLayout(context);
            mainContainer.setOrientation(LinearLayout.VERTICAL);

            // Dynamic TextView - To display title
            TextView textTitle = new TextView(context);
            textTitle.setTextSize(18);
            textTitle.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            textTitle.setTextColor(Color.BLUE);
            textTitle.setText(mRow.getTitle());
            mainContainer.addView(textTitle);

            //Horizontal layout for text and image
            RelativeLayout.LayoutParams subParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.WRAP_CONTENT,
                    RelativeLayout.LayoutParams.WRAP_CONTENT);
            RelativeLayout relPanel = new RelativeLayout(context);

            // Dynamic TextView - To display description
            TextView textName = new TextView(context);
            textName.setId(View.generateViewId());

            // Dynamic ImageView - To display image
            ImageView ivLogo = new ImageView(context);
            ivLogo.setId(View.generateViewId());


            RelativeLayout.LayoutParams relParams;
            relParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            relParams.addRule(RelativeLayout.ALIGN_PARENT_START);
            relParams.addRule(RelativeLayout.LEFT_OF, ivLogo.getId());

            textName.setTextSize(14);
            textName.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
            textName.setText(mRow.getDescription());
            relPanel.addView(textName, relParams);

            relParams = new RelativeLayout.LayoutParams(200, 150);
            relParams.addRule(RelativeLayout.ALIGN_PARENT_END);
            relParams.addRule(RelativeLayout.CENTER_VERTICAL);
            ivLogo.setScaleType(ImageView.ScaleType.FIT_XY);

            // Picasso library used to load image url into imageview efficiently
            Picasso.get()
                    .load(mRow.getImageHref())
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(ivLogo);
            relPanel.addView(ivLogo, relParams);
            mainContainer.addView(relPanel, subParams);
            addView(mainContainer, mainParams);

            // Layout container to represent arrow icon
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LayoutParams.WRAP_CONTENT);
            params.weight = 0.05f;
            params.gravity = Gravity.CENTER_VERTICAL;
            LinearLayout arrowPanel = new LinearLayout(context);
            ImageView ivArrow = new ImageView(context);
            ivArrow.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_arrow_right));
            arrowPanel.addView(ivArrow);
            addView(arrowPanel, params);

        }
    }
}
