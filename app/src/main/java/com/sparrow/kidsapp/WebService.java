package com.sparrow.kidsapp;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sparrow.kidsapp.Model.MatchQuiz;
import com.sparrow.kidsapp.Model.QuizData;

import java.util.concurrent.TimeUnit;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public class WebService {
    private static WebServiceInterface webApiInterface;

    public static WebServiceInterface getClient() {
        if (webApiInterface == null) {

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient okclient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                   /* .connectTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(15, TimeUnit.SECONDS)*/
                    .connectTimeout(5, TimeUnit.MINUTES) // connect timeout
                    .writeTimeout(5, TimeUnit.MINUTES) // write timeout
                    .readTimeout(5, TimeUnit.MINUTES) // read timeout


                    /*.connectTimeout(60, TimeUnit.SECONDS)
                    .readTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)*/
                    .build();

            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .setLenient()
                    .create();

            // Post post = gson.fromJson(reader, Post.class);

            Retrofit client = new Retrofit.Builder()
                    .baseUrl("https://dreamcatcherbykashish.com/kids/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(okclient)
                    .build();

            webApiInterface = client.create(WebServiceInterface.class);
        }
        return webApiInterface;
    }

    public interface WebServiceInterface {
        @GET("quiz.php")
        Call<QuizData> getQuizData();

        @GET("random_quiz.php")
        Call<MatchQuiz> getMatchQuizData();


    }
}



