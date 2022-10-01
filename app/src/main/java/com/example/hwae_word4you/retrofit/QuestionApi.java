package com.example.hwae_word4you.retrofit;

import com.example.hwae_word4you.model.Question;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface QuestionApi {

    @GET("/question/get-all")
    Call<List<Question>> getAllQuestions();

    @POST("/question/save-question")
    Call<Question> save(@Body Question question);


}