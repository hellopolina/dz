package org.example.autotests_backend.Retrofit;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.*;

public interface ProductService {
    @GET("products")
    Call<Product> getProducts();

    @POST("products")
    Response<Product> createProduct(@Body Product createProductRequest);

    @GET("products/{id}")
    Call<Product> getProductById(@Path("id") int id);

    @DELETE("products/{id}")
    Call<Product> deleteProduct(@Path("id") int id);

}