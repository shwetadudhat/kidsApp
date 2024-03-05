package com.sparrow.kidsapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MatchQuiz {

    @SerializedName("quiz")
    @Expose
    private List<String> quiz = null;

    public List<String> getQuiz() {
        return quiz;
    }

    public void setQuiz(List<String> quiz) {
        this.quiz = quiz;
    }
}
