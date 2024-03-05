package com.sparrow.kidsapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sparrow.kidsapp.R;

import java.util.ArrayList;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    ArrayList<String> quiz;
    private Context context;
    MediaPlayer mp1;


    String sms = "";//The message you want to text to the phone

    public RecyclerAdapter(ArrayList<String> quiz, Context context) {
        this.quiz = quiz;
        this.context = context;

    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.row_img1, parent, false);
        RecyclerAdapter.ViewHolder viewHolder = new RecyclerAdapter.ViewHolder(listItem);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {


       holder.image.setImageResource(Integer.parseInt(quiz.get(position)));

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Animation animZoomOut = AnimationUtils.loadAnimation(context, R.anim.clockwise);
                view.startAnimation(animZoomOut);


            }
        });


    }



    @Override
    public int getItemCount() {
        return quiz.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
      ImageView image;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.image);
        }
    }


    public interface RecyclerInterface{
        public void itemClick(int position,ImageView imageView);
    }
}
