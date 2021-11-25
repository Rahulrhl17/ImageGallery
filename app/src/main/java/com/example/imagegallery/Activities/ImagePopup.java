package com.example.imagegallery.Activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Display;
import android.view.Window;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.example.imagegallery.R;
import com.squareup.picasso.Picasso;

public class ImagePopup extends Dialog {
    private Context context;

    public ImagePopup(@NonNull Context context, String url) {
        super(context);
        this.context = context;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.regular_image);
        Display d = ((Activity) context).getWindowManager().getDefaultDisplay();
        int w = d.getWidth();
        int h = d.getHeight();
        getWindow().setLayout((int)( w/100)*90, (int)( h/100)*40);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
        setCancelable(true);
        ImageView regularImage = (ImageView)findViewById(R.id.regularImage);
        Picasso.get()
                .load(url)
                .noFade()
                .into(regularImage);
        show();

    }
}
