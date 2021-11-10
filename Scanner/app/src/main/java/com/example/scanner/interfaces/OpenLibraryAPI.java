package com.example.scanner.interfaces;

import com.example.scanner.models.OpenLibrary;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenLibraryAPI {

    @GET("search.json")
    public Call<OpenLibrary> find(@Query("q") String isbn);


}
