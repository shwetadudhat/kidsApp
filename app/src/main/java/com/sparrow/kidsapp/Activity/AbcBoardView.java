package com.sparrow.kidsapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sparrow.kidsapp.Adapter.CustomPagerAdapter;
import com.sparrow.kidsapp.R;

public class AbcBoardView extends AppCompatActivity {

    LinearLayout container;

    ViewPager pager;
    ImageView btnLeft,btnRight,btnHome,imageView;
    int[] images = new int[]{R.drawable.a_big, R.drawable.b_big, R.drawable.c_big,R.drawable.d_big,R.drawable.e_big,R.drawable.f_big,R.drawable.g_big,R.drawable.h_big,
            R.drawable.i_big,R.drawable.j_big,R.drawable.k_big,R.drawable.l_big,R.drawable.m_big,R.drawable.n_big,R.drawable.o_big,R.drawable.p_big,R.drawable.q_big,
            R.drawable.r_big,R.drawable.s_big,R.drawable.t_big,R.drawable.u_big,R.drawable.v_big,R.drawable.w_big,R.drawable.x_big,R.drawable.y_big,R.drawable.z_big};

    int[] BigLetter = new int[]{R.drawable.a, R.drawable.b, R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,
            R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n,R.drawable.o,R.drawable.p,R.drawable.q,
            R.drawable.r,R.drawable.s,R.drawable.t,R.drawable.u,R.drawable.v,R.drawable.w,R.drawable.x,R.drawable.y,R.drawable.z};

    int[] ContentLetter = new int[]{R.drawable.afor, R.drawable.bfor, R.drawable.cfor,R.drawable.dfor,R.drawable.efor,R.drawable.ffor,R.drawable.gfor,R.drawable.hfor,
            R.drawable.ifor,R.drawable.jfor,R.drawable.kfor,R.drawable.lfor,R.drawable.mfor,R.drawable.nfor,R.drawable.ofor,R.drawable.pfor,R.drawable.qfor,
            R.drawable.rfor,R.drawable.sfor,R.drawable.tfor,R.drawable.ufor,R.drawable.vfor,R.drawable.wfor,R.drawable.xfor,R.drawable.yfor,R.drawable.zfor};


    int[] fullSound = new int[]{R.raw.a_for_apple, R.raw.b_for_ball, R.raw.c_for_car,R.raw.d_for_dog,R.raw.e_for_elephant,R.raw.f_for_fox,R.raw.g_for_goat,R.raw.h_for_hat,
            R.raw.i_for_igloo,R.raw.j_for_joker,R.raw.k_for_kangaroo,R.raw.l_for_lion,R.raw.m_for_mouse,R.raw.n_for_nest,R.raw.o_for_owl,R.raw.p_for_pig,R.raw.q_for_queen,
            R.raw.r_for_rabbit,R.raw.s_for_sun,R.raw.t_for_train,R.raw.u_for_umbrella,R.raw.v_for_violin,R.raw.w_for_whale,R.raw.x_for_xlyophone,R.raw.y_for_yak,R.raw.z_for_zebra};


    int[] shortSound = new int[]{R.raw.a, R.raw.b, R.raw.c,R.raw.d,R.raw.e,R.raw.f,R.raw.g,R.raw.h,
            R.raw.i,R.raw.j,R.raw.k,R.raw.l,R.raw.m,R.raw.n,R.raw.o,R.raw.p,R.raw.q,
            R.raw.r,R.raw.s,R.raw.t,R.raw.u,R.raw.v,R.raw.w,R.raw.x,R.raw.y,R.raw.z};

    CustomPagerAdapter customPagerAdapter;
     MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_abc_board_view);

        container=findViewById(R.id.container);
        pager=findViewById(R.id.pager);
        btnLeft=findViewById(R.id.btnLeft);
        btnRight=findViewById(R.id.btnRight);
        btnHome=findViewById(R.id.btnHome);
        btnLeft.setVisibility(View.GONE);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


      /*  LayoutInflater inflater = LayoutInflater.from(this);
        for (int i=0 ; i<images.length; i++){
            View view  = inflater.inflate(R.layout.row_img, container, false);
            view.setBackgroundResource (images[i]);
            container.addView(view);


            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int id = view.getId();
                    pager.setCurrentItem(id);
                }
            });
        }*/

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.fragment_page, images.length) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View row = super.getView(position, convertView, parent);
                ImageView left = (ImageView) row.findViewById(R.id.image);

                return row;
            }
        };



        customPagerAdapter = new CustomPagerAdapter(this,BigLetter,ContentLetter,fullSound,shortSound);
        pager.setAdapter(customPagerAdapter);
        addImagesToThegallery();

        try {
            mp = MediaPlayer.create(AbcBoardView.this, fullSound[0]);
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
                    mp = MediaPlayer.create(AbcBoardView.this, fullSound[pager.getCurrentItem()]);
                }else{
                    mp = MediaPlayer.create(AbcBoardView.this, fullSound[pager.getCurrentItem()]);
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
                    mp = MediaPlayer.create(AbcBoardView.this, fullSound[pager.getCurrentItem()]);
                }else{
                    mp = MediaPlayer.create(AbcBoardView.this, fullSound[pager.getCurrentItem()]);
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


        for (int i1=0 ; i1<images.length; i1++){
            View view  = inflater.inflate(R.layout.row_img, container, false);
            view.setBackgroundResource (images[i1]);
            container.addView(view);
            mp = MediaPlayer.create(this,fullSound[i1]);



            int finalI = i1;
            int finalI1 = i1;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (finalI==0){
                        Log.d("thiss","00000");
                    }
                    int id = view.getId();
                    pager.setCurrentItem(finalI);
                    try {
                        if (mp.isPlaying()) {
                            mp.stop();
                            mp.release();
                            mp = MediaPlayer.create(AbcBoardView.this, fullSound[finalI]);
                        }else{
                            mp = MediaPlayer.create(AbcBoardView.this, fullSound[finalI]);
                        }
                        mp.start();
                    } catch(Exception e) { e.printStackTrace(); }
                    Animation animZoomOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
                    view.startAnimation(animZoomOut);

                }
            });

            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mp) {
                    //code
                    mp.release();
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