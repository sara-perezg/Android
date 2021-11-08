package com.example.scanner.interfaces;

import com.example.scanner.models.OpenLibrary;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface OpenLibraryAPI {

    @GET("{isbn}")
    public Call<OpenLibrary> find(@Path("isbn") String isbn);


}
