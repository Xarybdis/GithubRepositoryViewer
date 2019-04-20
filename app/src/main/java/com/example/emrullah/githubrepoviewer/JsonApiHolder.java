package com.example.emrullah.githubrepoviewer;

import com.example.emrullah.githubrepoviewer.Models.ExampleModel;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonApiHolder {


    @GET ("users/{username}/repos")
    Call<List<ExampleModel>> getTheRepo(@Path("username")String userName,
                                  @Query("sort") String sort);
}
