package com.sparrow.kidsapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import com.sparrow.kidsapp.Activity.MainActivity;
import com.sparrow.kidsapp.Activity.SplashActivity;
import com.sparrow.kidsapp.Model.Quiz;
import com.sparrow.kidsapp.R;

import java.util.List;
import java.util.Random;

public class CustomQuizPagerAdapter extends PagerAdapter {


    int[] fullSound = new int[]{R.raw.app_excellent,
            R.raw.applause_terrific,
            R.raw.applause_greatjob,
            R.raw.applause_intelligent,
            R.raw.great,
            R.raw.applause_youdid};



    Context mContext;

    LayoutInflater mLayoutInflater;
    MediaPlayer mp1,mp2;

    private List<Quiz> quiz;

    private RecyclerViewItemInterface viewItemInterface;

    public void setViewItemInterface(RecyclerViewItemInterface viewItemInterface) {
        this.viewItemInterface = viewItemInterface;
    }




    public CustomQuizPagerAdapter(Context context, List<Quiz> quiz) {

        mContext = context;

        this.quiz = quiz;

        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @Override

    public int getCount() {

        return quiz.size();

    }



    @Override

    public boolean isViewFromObject(View view, Object object) {

        return view == ((LinearLayout) object);

    }



    @Override

    public Object instantiateItem(ViewGroup container, int position) {

        View itemView = mLayoutInflater.inflate(R.layout.alphabet_find, container, false);

        TextView tvShape = (TextView) itemView.findViewById(R.id.tvShape);
        ImageView imageView1 = (ImageView) itemView.findViewById(R.id.imageView1);
        ImageView imageView2 = (ImageView) itemView.findViewById(R.id.imageView2);
        ImageView imageView3 = (ImageView) itemView.findViewById(R.id.imageView3);


        if (quiz.get(position).getOption1().equals("A")){
            imageView1.setImageResource(R.drawable.a);
        }else if (quiz.get(position).getOption2().equals("A")){
            imageView2.setImageResource(R.drawable.a);
        }else if (quiz.get(position).getOption3().equals("A")){
            imageView3.setImageResource(R.drawable.a);
        }
        if (quiz.get(position).getOption1().equals("B")){
            imageView1.setImageResource(R.drawable.b);
        }else if (quiz.get(position).getOption2().equals("B")){
            imageView2.setImageResource(R.drawable.b);
        }else if (quiz.get(position).getOption3().equals("B")){
            imageView3.setImageResource(R.drawable.b);
        }
        if (quiz.get(position).getOption1().equals("C")){
            imageView1.setImageResource(R.drawable.c);
        }else if (quiz.get(position).getOption2().equals("C")){
            imageView2.setImageResource(R.drawable.c);
        }else if (quiz.get(position).getOption3().equals("C")){
            imageView3.setImageResource(R.drawable.c);
        }
        if (quiz.get(position).getOption1().equals("D")){
            imageView1.setImageResource(R.drawable.d);
        }else if (quiz.get(position).getOption2().equals("D")){
            imageView2.setImageResource(R.drawable.d);
        }else if (quiz.get(position).getOption3().equals("D")){
            imageView3.setImageResource(R.drawable.d);
        }
        if (quiz.get(position).getOption1().equals("E")){
            imageView1.setImageResource(R.drawable.e);
        }else if (quiz.get(position).getOption2().equals("E")){
            imageView2.setImageResource(R.drawable.e);
        }else if (quiz.get(position).getOption3().equals("E")){
            imageView3.setImageResource(R.drawable.e);
        }
        if (quiz.get(position).getOption1().equals("F")){
            imageView1.setImageResource(R.drawable.f);
        }else if (quiz.get(position).getOption2().equals("F")){
            imageView2.setImageResource(R.drawable.f);
        }else if (quiz.get(position).getOption3().equals("F")){
            imageView3.setImageResource(R.drawable.f);
        }
        if (quiz.get(position).getOption1().equals("G")){
            imageView1.setImageResource(R.drawable.g);
        }else if (quiz.get(position).getOption2().equals("G")){
            imageView2.setImageResource(R.drawable.g);
        }else if (quiz.get(position).getOption3().equals("G")){
            imageView3.setImageResource(R.drawable.g);
        }
        if (quiz.get(position).getOption1().equals("H")){
            imageView1.setImageResource(R.drawable.h);
        }else if (quiz.get(position).getOption2().equals("H")){
            imageView2.setImageResource(R.drawable.h);
        }else if (quiz.get(position).getOption3().equals("H")){
            imageView3.setImageResource(R.drawable.h);
        }
        if (quiz.get(position).getOption1().equals("I")){
            imageView1.setImageResource(R.drawable.i);
        }else if (quiz.get(position).getOption2().equals("I")){
            imageView2.setImageResource(R.drawable.i);
        }else if (quiz.get(position).getOption3().equals("I")){
            imageView3.setImageResource(R.drawable.i);
        }
        if (quiz.get(position).getOption1().equals("J")){
            imageView1.setImageResource(R.drawable.j);
        }else if (quiz.get(position).getOption2().equals("J")){
            imageView2.setImageResource(R.drawable.j);
        }else if (quiz.get(position).getOption3().equals("J")){
            imageView3.setImageResource(R.drawable.j);
        } if (quiz.get(position).getOption1().equals("K")){
            imageView1.setImageResource(R.drawable.k);
        }else if (quiz.get(position).getOption2().equals("K")){
            imageView2.setImageResource(R.drawable.k);
        }else if (quiz.get(position).getOption3().equals("K")){
            imageView3.setImageResource(R.drawable.k);
        } if (quiz.get(position).getOption1().equals("L")){
            imageView1.setImageResource(R.drawable.l);
        }else if (quiz.get(position).getOption2().equals("L")){
            imageView2.setImageResource(R.drawable.l);
        }else if (quiz.get(position).getOption3().equals("L")){
            imageView3.setImageResource(R.drawable.l);
        } if (quiz.get(position).getOption1().equals("M")){
            imageView1.setImageResource(R.drawable.m);
        }else if (quiz.get(position).getOption2().equals("M")){
            imageView2.setImageResource(R.drawable.m);
        }else if (quiz.get(position).getOption3().equals("M")){
            imageView3.setImageResource(R.drawable.m);
        }
        if (quiz.get(position).getOption1().equals("N")){
            imageView1.setImageResource(R.drawable.n);
        }else if (quiz.get(position).getOption2().equals("N")){
            imageView2.setImageResource(R.drawable.n);
        }else if (quiz.get(position).getOption3().equals("N")){
            imageView3.setImageResource(R.drawable.n);
        } if (quiz.get(position).getOption1().equals("O")){
            imageView1.setImageResource(R.drawable.o);
        }else if (quiz.get(position).getOption2().equals("O")){
            imageView2.setImageResource(R.drawable.o);
        }else if (quiz.get(position).getOption3().equals("O")){
            imageView3.setImageResource(R.drawable.o);
        } if (quiz.get(position).getOption1().equals("P")){
            imageView1.setImageResource(R.drawable.p);
        }else if (quiz.get(position).getOption2().equals("P")){
            imageView2.setImageResource(R.drawable.p);
        }else if (quiz.get(position).getOption3().equals("P")){
            imageView3.setImageResource(R.drawable.p);
        } if (quiz.get(position).getOption1().equals("Q")){
            imageView1.setImageResource(R.drawable.q);
        }else if (quiz.get(position).getOption2().equals("Q")){
            imageView2.setImageResource(R.drawable.q);
        }else if (quiz.get(position).getOption3().equals("Q")){
            imageView3.setImageResource(R.drawable.q);
        } if (quiz.get(position).getOption1().equals("R")){
            imageView1.setImageResource(R.drawable.r);
        }else if (quiz.get(position).getOption2().equals("R")){
            imageView2.setImageResource(R.drawable.r);
        }else if (quiz.get(position).getOption3().equals("R")){
            imageView3.setImageResource(R.drawable.r);
        } if (quiz.get(position).getOption1().equals("S")){
            imageView1.setImageResource(R.drawable.s);
        }else if (quiz.get(position).getOption2().equals("S")){
            imageView2.setImageResource(R.drawable.s);
        }else if (quiz.get(position).getOption3().equals("S")){
            imageView3.setImageResource(R.drawable.s);
        } if (quiz.get(position).getOption1().equals("T")){
            imageView1.setImageResource(R.drawable.t);
        }else if (quiz.get(position).getOption2().equals("T")){
            imageView2.setImageResource(R.drawable.t);
        }else if (quiz.get(position).getOption3().equals("T")){
            imageView3.setImageResource(R.drawable.t);
        } if (quiz.get(position).getOption1().equals("U")){
            imageView1.setImageResource(R.drawable.u);
        }else if (quiz.get(position).getOption2().equals("U")){
            imageView2.setImageResource(R.drawable.u);
        }else if (quiz.get(position).getOption3().equals("U")){
            imageView3.setImageResource(R.drawable.u);
        } if (quiz.get(position).getOption1().equals("V")){
            imageView1.setImageResource(R.drawable.v);
        }else if (quiz.get(position).getOption2().equals("V")){
            imageView2.setImageResource(R.drawable.v);
        }else if (quiz.get(position).getOption3().equals("V")){
            imageView3.setImageResource(R.drawable.v);
        } if (quiz.get(position).getOption1().equals("W")){
            imageView1.setImageResource(R.drawable.w);
        }else if (quiz.get(position).getOption2().equals("W")){
            imageView2.setImageResource(R.drawable.w);
        }else if (quiz.get(position).getOption3().equals("W")){
            imageView3.setImageResource(R.drawable.w);
        } if (quiz.get(position).getOption1().equals("X")){
            imageView1.setImageResource(R.drawable.x);
        }else if (quiz.get(position).getOption2().equals("X")){
            imageView2.setImageResource(R.drawable.x);
        }else if (quiz.get(position).getOption3().equals("X")){
            imageView3.setImageResource(R.drawable.x);
        } if (quiz.get(position).getOption1().equals("Y")){
            imageView1.setImageResource(R.drawable.y);
        }else if (quiz.get(position).getOption2().equals("Y")){
            imageView2.setImageResource(R.drawable.y);
        }else if (quiz.get(position).getOption3().equals("Y")){
            imageView3.setImageResource(R.drawable.y);
        } if (quiz.get(position).getOption1().equals("Z")){
            imageView1.setImageResource(R.drawable.z);
        }else if (quiz.get(position).getOption2().equals("Z")){
            imageView2.setImageResource(R.drawable.z);
        }else if (quiz.get(position).getOption3().equals("Z")){
            imageView3.setImageResource(R.drawable.z);
        }

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quiz.get(position).getAnswer().equals(quiz.get(position).getOption1())){
                    if (mp1 !=null &&  mp1.isPlaying()) {
                        mp1.stop();
                        mp1.release();
                        mp1 = null;
                        mp1 = MediaPlayer.create(mContext,fullSound[new Random().nextInt(fullSound.length)]);
                    }else{
                        mp1 = MediaPlayer.create(mContext,fullSound[new Random().nextInt(fullSound.length)]);
                    }
                    mp1.start();
                    Animation animZoomOut = AnimationUtils.loadAnimation(mContext, R.anim.clockwise);
                    view.startAnimation(animZoomOut);

                    new Handler().postDelayed(new Runnable() {
                        public void run() {


                            if (viewItemInterface != null) {
                                viewItemInterface.onItemClick(position,quiz);
                            }

                        }
                    }, /*secondsDelayed **/ 1600);


                }else{
                    if (mp1 !=null &&  mp1.isPlaying()) {
                        mp1.stop();
                        mp1.release();
                        mp1 = null;
                        mp1 = MediaPlayer.create(mContext,R.raw.wrong2);
                    }else{
                        mp1 = MediaPlayer.create(mContext,R.raw.wrong2);
                    }
                    mp1.start();
                    Animation animZoomOut = AnimationUtils.loadAnimation(mContext, R.anim.shake);
                    view.startAnimation(animZoomOut);
                }
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quiz.get(position).getAnswer().equals(quiz.get(position).getOption2())){
                    if (mp1 !=null &&  mp1.isPlaying()) {
                        mp1.stop();
                        mp1.release();
                        mp1 = null;
                        mp1 = MediaPlayer.create(mContext,fullSound[new Random().nextInt(fullSound.length)]);
                    }else{
                        mp1 = MediaPlayer.create(mContext,fullSound[new Random().nextInt(fullSound.length)]);
                    }
                    mp1.start();
                    Animation animZoomOut = AnimationUtils.loadAnimation(mContext, R.anim.clockwise);
                    view.startAnimation(animZoomOut);

                    new Handler().postDelayed(new Runnable() {
                        public void run() {

                            if (viewItemInterface != null) {
                                viewItemInterface.onItemClick(position,quiz);
                            }

                        }
                    }, /*secondsDelayed **/ 1600);

                }else{
                    if (mp1 !=null &&  mp1.isPlaying()) {
                        mp1.stop();
                        mp1.release();
                        mp1 = null;
                        mp1 = MediaPlayer.create(mContext,R.raw.wrong2);
                    }else{
                        mp1 = MediaPlayer.create(mContext,R.raw.wrong2);
                    }
                    mp1.start();
                    Animation animZoomOut = AnimationUtils.loadAnimation(mContext, R.anim.shake);
                    view.startAnimation(animZoomOut);
                }
            }
        });


        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quiz.get(position).getAnswer().equals(quiz.get(position).getOption3())){
                    if (mp1 !=null &&  mp1.isPlaying()) {
                        mp1.stop();
                        mp1.release();
                        mp1 = null;
                        mp1 = MediaPlayer.create(mContext,fullSound[new Random().nextInt(fullSound.length)]);
                    }else{
                        mp1 = MediaPlayer.create(mContext,fullSound[new Random().nextInt(fullSound.length)]);
                    }
                    mp1.start();
                    Animation animZoomOut = AnimationUtils.loadAnimation(mContext, R.anim.clockwise);
                    view.startAnimation(animZoomOut);


                    new Handler().postDelayed(new Runnable() {
                        public void run() {

                            if (viewItemInterface != null) {
                                viewItemInterface.onItemClick(position,quiz);
                            }
                        }
                    }, /*secondsDelayed **/ 1600);


                }else{
                    if (mp1 !=null &&  mp1.isPlaying()) {
                        mp1.stop();
                        mp1.release();
                        mp1 = null;
                        mp1 = MediaPlayer.create(mContext,R.raw.wrong2);
                    }else{
                        mp1 = MediaPlayer.create(mContext,R.raw.wrong2);
                    }
                    mp1.start();
                    Animation animZoomOut = AnimationUtils.loadAnimation(mContext, R.anim.shake);
                    view.startAnimation(animZoomOut);
                }
            }
        });


        tvShape.setText("Touch "+quiz.get(position).getQuestion());




        container.addView(itemView);



        return itemView;

    }

    @Override

    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((LinearLayout) object);

    }


    public interface RecyclerViewItemInterface {

        void onItemClick(int position,List<Quiz> mcatlist);


    }


}
