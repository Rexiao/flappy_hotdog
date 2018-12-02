package com.example.xr.flappy_bird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap background;
    Bitmap[] bird;

    public BitmapBank(Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.scroll);
        background = scaleImage(background);
        bird = new Bitmap[2];
        bird[0] = BitmapFactory.decodeResource(res, R.drawable.frame_1);
        bird[1] = BitmapFactory.decodeResource(res, R.drawable.frame_2);
    }


    //return bird bitmap
    public Bitmap getBird(int index) {
        return bird[index];
    }

    //return birdWidth
    public int getBirdWidth() {
        return bird[0].getWidth();
    }

    //return birdHeight
    public int getBirdHeight() {
        return bird[0].getHeight();
    }


    //Return background bitmap
    public Bitmap getBackground(){
        return background;
    }

    //Return background width
    public int getBackgroundWidth(){
        return background.getWidth();
    }

    //Return background height
    public int getBackgroundHeight(){
        return background.getHeight();
    }

    public Bitmap scaleImage(Bitmap bitmap){
        float widthHeightRatio = getBackgroundWidth() / getBackgroundHeight();
        /*
        We'll multiply widthHeightRatio with screenHeight to get scaled width of the bitmap.
        Then call createScaledBitmap() to create a new bitmap, scaled from an existing bitmap, when possible.
         */
        int backgroundScaledWidth = (int) widthHeightRatio * AppConstants.SCREEN_HEIGHT;
        return Bitmap.createScaledBitmap(bitmap, backgroundScaledWidth, AppConstants.SCREEN_HEIGHT, false);
    }
}
