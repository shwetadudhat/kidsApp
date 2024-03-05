package com.sparrow.kidsapp.Adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.viewpager.widget.PagerAdapter;

import com.sparrow.kidsapp.Activity.AbcBoardView;
import com.sparrow.kidsapp.R;

public class CustomPagerAdapter extends PagerAdapter {

    int[] bigLetter;
    int[] ContentLetter;
    int[] fullSound;
    int[] shortSound;

    Context mContext;

    LayoutInflater mLayoutInflater;
    MediaPlayer mp1,mp2;



    public CustomPagerAdapter(Context context, int[] bigLetter, int[] contentLetter, int[] fullSound, int[] shortSound) {

        mContext = context;
        this.bigLetter = bigLetter;
        this.ContentLetter = contentLetter;
        this.fullSound = fullSound;
        this.shortSound = shortSound;




        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }



    @Override

    public int getCount() {

        return bigLetter.length;

    }



    @Override

    public boolean isViewFromObject(View view, Object object) {

        return view == ((RelativeLayout) object);

    }



    @Override

    public Object instantiateItem(ViewGroup container, int position) {

        View itemView = mLayoutInflater.inflate(R.layout.item_image2, container, false);


        mp1 = MediaPlayer.create(mContext,fullSound[position]);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.img_thumb);
        ImageView img_desc = (ImageView) itemView.findViewById(R.id.img_desc);

        imageView.setImageResource(bigLetter[position]);
        img_desc.setImageResource(ContentLetter[position]);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (imageView.getTag().equals("clock")){
                    imageView.setTag("");
                    Animation animZoomOut = AnimationUtils.loadAnimation(mContext, R.anim.clockwise);
                    view.startAnimation(animZoomOut);
            }else{
                    imageView.setTag("clock");
                    Animation animZoomOut = AnimationUtils.loadAnimation(mContext, R.anim.blink);
                    view.startAnimation(animZoomOut);
                }


                if (mp1 !=null &&  mp1.isPlaying()) {
                    mp1.stop();
                    mp1.release();
                    mp1 = null;
                    mp1 = MediaPlayer.create(mContext, shortSound[position]);
                }else{
                    mp1 = MediaPlayer.create(mContext, shortSound[position]);
                }
                mp1.start();

            }
        });

        img_desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (img_desc.getTag().equals("clock")){
                    img_desc.setTag("");
                    Animation animZoomOut = AnimationUtils.loadAnimation(mContext, R.anim.clockwise);
                    view.startAnimation(animZoomOut);
                }else{
                    img_desc.setTag("clock");
                    Animation animZoomOut = AnimationUtils.loadAnimation(mContext, R.anim.blink);
                    view.startAnimation(animZoomOut);
                }

                if (mp1 !=null &&  mp1.isPlaying()) {
                    mp1.stop();
                    mp1.release();
                    mp1 = null;
                    mp1 = MediaPlayer.create(mContext, fullSound[position]);
                }else{
                    mp1 = MediaPlayer.create(mContext, fullSound[position]);
                }
                mp1.start();

            }
        });

       /* if (position == 0) {

            try {
                mp1 = MediaPlayer.create(mContext, fullSound[0]);
                mp1.start();
            } catch(Exception e) { e.printStackTrace(); }
        }*/

        container.addView(itemView);



        return itemView;

    }

    @Override

    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((RelativeLayout) object);

    }


}
