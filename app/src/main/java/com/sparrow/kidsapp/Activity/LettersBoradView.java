package com.sparrow.kidsapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sparrow.kidsapp.Adapter.CustomLetterPagerAdapter;
import com.sparrow.kidsapp.Adapter.CustomPagerAdapter;
import com.sparrow.kidsapp.Adapter.RecyclerAdapter;
import com.sparrow.kidsapp.R;

import java.util.ArrayList;

public class LettersBoradView extends AppCompatActivity {

    LinearLayout container;

    ViewPager pager;
    ImageView btnLeft,btnRight,btnHome,imageView;
    int[] images = new int[]{R.drawable.n_1, R.drawable.n_2, R.drawable.n_3,R.drawable.n_4,R.drawable.n_5,R.drawable.n_6,R.drawable.n_7,R.drawable.n_8,
            R.drawable.n_9,R.drawable.n_10,R.drawable.n_11,R.drawable.n_12,R.drawable.n_13,R.drawable.n_14,R.drawable.n_15,R.drawable.n_16,R.drawable.n_17,
            R.drawable.n_18,R.drawable.n_19,R.drawable.n_20};

    int[] imagesBox = new int[]{R.drawable.n1, R.drawable.n2, R.drawable.n3,R.drawable.n4,R.drawable.n5,R.drawable.n6,R.drawable.n7,R.drawable.n8,
            R.drawable.n9,R.drawable.n10,R.drawable.n11,R.drawable.n12,R.drawable.n13,R.drawable.n14,R.drawable.n15,R.drawable.n16,R.drawable.n17,
            R.drawable.n18,R.drawable.n19,R.drawable.n20};

    int[] imagesDesc = new int[]{R.drawable.one1, R.drawable.two2, R.drawable.three3,R.drawable.four4,R.drawable.five5,R.drawable.six6,R.drawable.seven7,R.drawable.eight8,
            R.drawable.ning9,R.drawable.ten10,R.drawable.eleven11,R.drawable.twelve12,R.drawable.thirteen13,R.drawable.forteen14,R.drawable.fifteen15,R.drawable.sixteen16,R.drawable.seventeen17,
            R.drawable.eighteen18,R.drawable.nineteen19,R.drawable.twenty20};


    int[] fullSound = new int[]{R.raw.one, R.raw.two, R.raw.three,R.raw.four,R.raw.five,R.raw.six,R.raw.seven,R.raw.eight,
            R.raw.nine,R.raw.ten,R.raw.eleven,R.raw.twelve,R.raw.thirteen,R.raw.fourteen,R.raw.fifteen,R.raw.sixteen,R.raw.seventeen,
            R.raw.eighteen,R.raw.nineteen,R.raw.twenty};


    CustomLetterPagerAdapter customPagerAdapter;
    MediaPlayer mp;
    RecyclerView rv_list;

    ArrayList<String> fullList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_letters_borad_view);

        container=findViewById(R.id.container);
        pager=findViewById(R.id.pager);
        btnLeft=findViewById(R.id.btnLeft);
        btnRight=findViewById(R.id.btnRight);
        btnHome=findViewById(R.id.btnHome);
        rv_list=findViewById(R.id.rv_list);
        btnLeft.setVisibility(View.GONE);


        for (int i=0;i<imagesBox.length;i++)
        {
            fullList.add(String.valueOf(imagesBox[i]));
        }

        rv_list.setLayoutManager(new LinearLayoutManager(LettersBoradView.this,LinearLayoutManager.HORIZONTAL,false));
        RecyclerAdapter adapter=new RecyclerAdapter(fullList,LettersBoradView.this);
        rv_list.setAdapter(adapter);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        customPagerAdapter = new CustomLetterPagerAdapter(this,images,imagesBox,fullSound,imagesDesc);
        pager.setAdapter(customPagerAdapter);
        addImagesToThegallery();

        try {
            mp = MediaPlayer.create(LettersBoradView.this, fullSound[0]);
            mp.start();
        } catch(Exception e) { e.printStackTrace(); }




        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == (pager.getAdapter().getCount() - 1)) {
                    btnRight.setVisibility(View.GONE);
                } else {
                    btnRight.setVisibility(View.VISIBLE);
                }

                if (position == 0) {
                    btnLeft.setVisibility(View.GONE);
                } else {
                    btnLeft.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pager.setCurrentItem(getItem(-1), true);
                if (mp.isPlaying()) {
                    mp.stop();
                    mp.release();
                    mp = MediaPlayer.create(LettersBoradView.this, fullSound[pager.getCurrentItem()]);
                }else{
                    mp = MediaPlayer.create(LettersBoradView.this, fullSound[pager.getCurrentItem()]);
                }
                mp.start();
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pager.setCurrentItem(getItem(+1), true);
                if (mp.isPlaying()) {
                    mp.stop();
                    mp.release();
                    mp = MediaPlayer.create(LettersBoradView.this, fullSound[pager.getCurrentItem()]);
                }else{
                    mp = MediaPlayer.create(LettersBoradView.this, fullSound[pager.getCurrentItem()]);
                }
                mp.start();
            }
        });

    }

    private void addImagesToThegallery() {
        final LinearLayout imageGallery = (LinearLayout) findViewById(R.id.container);
        LayoutInflater inflater = LayoutInflater.from(this);

//        int i = 0;
//        for ( Integer image : images) {
//            imageGallery.addView(getImageView(image,i));
//            i += 1;
//        }


        for (int i1=0 ; i1<imagesBox.length; i1++){
            View view  = inflater.inflate(R.layout.row_img, container, false);
            view.setBackgroundResource (imagesBox[i1]);
            container.addView(view);


            int finalI = i1;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int id = view.getId();
                    pager.setCurrentItem(finalI);

                    if (mp.isPlaying()) {
                        mp.stop();
                        mp.release();
                        mp = MediaPlayer.create(LettersBoradView.this, fullSound[finalI]);
                    }else{
                        mp = MediaPlayer.create(LettersBoradView.this, fullSound[finalI]);
                    }
                    mp.start();

                    Animation animZoomOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
                    view.startAnimation(animZoomOut);

                }
            });


        }
    }

    private View getImageView(final Integer image, int index) {
        imageView = new ImageView(getApplicationContext());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//        lp.setMargins(5, 0, 5, 0);
        imageView.setLayoutParams(lp);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //use the index here
                Animation animZoomOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
                imageView.startAnimation(animZoomOut);

                pager.setCurrentItem(index);

            }
        });



        imageView.setImageResource(image);

        return imageView;
    }


    private int getItem(int i) {
        return pager.getCurrentItem() + i;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}