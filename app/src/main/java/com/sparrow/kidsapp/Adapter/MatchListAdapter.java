package com.sparrow.kidsapp.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.sparrow.kidsapp.R;

import java.util.List;
import java.util.Random;


public class MatchListAdapter  extends RecyclerView.Adapter<MatchListAdapter.ViewHolder> {
    List<String> quiz;
    private Context context;
    MediaPlayer mp1;


    String sms = "";//The message you want to text to the phone

    public MatchListAdapter(List<String> quiz, Context context) {
        this.quiz = quiz;
        this.context = context;

    }

    @NonNull
    @Override
    public MatchListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.row_img1, parent, false);
        MatchListAdapter.ViewHolder viewHolder = new MatchListAdapter.ViewHolder(listItem);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {


        if (quiz.get(position).equals("A")){
            holder.image.setImageResource(R.drawable.a_big);
        } if (quiz.get(position).equals("A1")){
            holder.image.setImageResource(R.drawable.a_big);
        }
        if (quiz.get(position).equals("B")){
             holder.image.setImageResource(R.drawable.b_big);
        }if (quiz.get(position).equals("B1")){
             holder.image.setImageResource(R.drawable.b_big);
        }
        if (quiz.get(position).equals("C")){
             holder.image.setImageResource(R.drawable.c_big);
        } if (quiz.get(position).equals("C1")){
             holder.image.setImageResource(R.drawable.c_big);
        }
        if (quiz.get(position).equals("D")){
             holder.image.setImageResource(R.drawable.d_big);
        } if (quiz.get(position).equals("D1")){
             holder.image.setImageResource(R.drawable.d_big);
        }
        if (quiz.get(position).equals("E")){
             holder.image.setImageResource(R.drawable.e_big);
        } if (quiz.get(position).equals("E1")){
             holder.image.setImageResource(R.drawable.e_big);
        }
        if (quiz.get(position).equals("F")){
             holder.image.setImageResource(R.drawable.f_big);
        }if (quiz.get(position).equals("F1")){
             holder.image.setImageResource(R.drawable.f_big);
        }
        if (quiz.get(position).equals("G")){
             holder.image.setImageResource(R.drawable.g_big);
        }if (quiz.get(position).equals("G1")){
             holder.image.setImageResource(R.drawable.g_big);
        }
        if (quiz.get(position).equals("H")){
             holder.image.setImageResource(R.drawable.h_big);
        }if (quiz.get(position).equals("H1")){
             holder.image.setImageResource(R.drawable.h_big);
        }
        if (quiz.get(position).equals("I")){
             holder.image.setImageResource(R.drawable.i_big);
        }if (quiz.get(position).equals("I1")){
             holder.image.setImageResource(R.drawable.i_big);
        }
        if (quiz.get(position).equals("J")){
             holder.image.setImageResource(R.drawable.j_big);
        }if (quiz.get(position).equals("J1")){
             holder.image.setImageResource(R.drawable.j_big);
        }if (quiz.get(position).equals("K")){
             holder.image.setImageResource(R.drawable.k_big);
        }if (quiz.get(position).equals("K1")){
             holder.image.setImageResource(R.drawable.k_big);
        }if (quiz.get(position).equals("L")){
             holder.image.setImageResource(R.drawable.l_big);
        }if (quiz.get(position).equals("L1")){
             holder.image.setImageResource(R.drawable.l_big);
        }if (quiz.get(position).equals("M")){
             holder.image.setImageResource(R.drawable.m_big);
        }if (quiz.get(position).equals("M1")){
             holder.image.setImageResource(R.drawable.m_big);
        }
        if (quiz.get(position).equals("N")){
             holder.image.setImageResource(R.drawable.n_big);
        }if (quiz.get(position).equals("N1")){
             holder.image.setImageResource(R.drawable.n_big);
        } if (quiz.get(position).equals("O")){
             holder.image.setImageResource(R.drawable.o_big);
        }if (quiz.get(position).equals("O1")){
             holder.image.setImageResource(R.drawable.o_big);
        }if (quiz.get(position).equals("P")){
             holder.image.setImageResource(R.drawable.p_big);
        }if (quiz.get(position).equals("P1")){
             holder.image.setImageResource(R.drawable.p_big);
        } if (quiz.get(position).equals("Q")){
             holder.image.setImageResource(R.drawable.q_big);
        }if (quiz.get(position).equals("Q1")){
             holder.image.setImageResource(R.drawable.q_big);
        }if (quiz.get(position).equals("R")){
             holder.image.setImageResource(R.drawable.r_big);
        }if (quiz.get(position).equals("R1")){
             holder.image.setImageResource(R.drawable.r_big);
        }if (quiz.get(position).equals("S")){
             holder.image.setImageResource(R.drawable.s_big);
        } if (quiz.get(position).equals("S1")){
             holder.image.setImageResource(R.drawable.s_big);
        } if (quiz.get(position).equals("T")){
             holder.image.setImageResource(R.drawable.t_big);
        }if (quiz.get(position).equals("T1")){
             holder.image.setImageResource(R.drawable.t_big);
        }if (quiz.get(position).equals("U")){
             holder.image.setImageResource(R.drawable.u_big);
        } if (quiz.get(position).equals("U1")){
             holder.image.setImageResource(R.drawable.u_big);
        } if (quiz.get(position).equals("V")){
             holder.image.setImageResource(R.drawable.v_big);
        } if (quiz.get(position).equals("V1")){
             holder.image.setImageResource(R.drawable.v_big);
        } if (quiz.get(position).equals("W")){
             holder.image.setImageResource(R.drawable.w_big);
        }if (quiz.get(position).equals("W1")){
             holder.image.setImageResource(R.drawable.w_big);
        }if (quiz.get(position).equals("X")){
             holder.image.setImageResource(R.drawable.x_big);
        }if (quiz.get(position).equals("X1")){
             holder.image.setImageResource(R.drawable.x_big);
        }if (quiz.get(position).equals("Y")){
             holder.image.setImageResource(R.drawable.y_big);
        }if (quiz.get(position).equals("Y1")){
             holder.image.setImageResource(R.drawable.y_big);
        } if (quiz.get(position).equals("Z")){
             holder.image.setImageResource(R.drawable.z_big);
        } if (quiz.get(position).equals("Z1")){
             holder.image.setImageResource(R.drawable.z_big);
        }


        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                holder.image.setVisibility(View.GONE);
                holder.image.setTag(quiz.get(position));

                if (holder.image.getTag().equals(quiz.get(position)+"1") || holder.image.getTag().toString().contains(quiz.get(position))){
                    holder.image.setVisibility(View.GONE);

                    if (mp1 !=null &&  mp1.isPlaying()) {
                        mp1.stop();
                        mp1.release();
                        mp1 = null;
                        mp1 = MediaPlayer.create(context,R.raw.great);
                    }else{
                        mp1 = MediaPlayer.create(context,R.raw.great);
                    }
                    mp1.start();
                    Animation animZoomOut = AnimationUtils.loadAnimation(context, R.anim.clockwise);
                    view.startAnimation(animZoomOut);






                }

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
}
