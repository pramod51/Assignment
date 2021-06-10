package com.assign.assignment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {
    @GET("rest/v2/region/Asia")
    Call<List<Post>> getPosts();
}
