package org.example.autotests_backend.retrofit;

import org.example.autotests_backend.Retrofit.Product;
import org.example.autotests_backend.Retrofit.ProductService;
import org.example.autotests_backend.Retrofit.utils.RetrofitUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

import static jdk.javadoc.internal.tool.Main.execute;
import static org.assertj.core.api.Assertions.assertThat;

public class ProductsTest {
    static Retrofit retrofit;
    static ProductService productService;
    Product product;

    @BeforeAll
    static void beforeAll() {
        retrofit = RetrofitUtils.getRetrofit();
        productService = retrofit.create(ProductService.class);
    }

    @Test
    void getProductCategoryTest() throws IOException {
        Response<Product> response = productService
                .getProducts()
                .execute();
        assertThat(response.errorBody()).withFailMessage("Internal Server Error");
    }

    @Test
    void createNewProductTest() throws IOException {
        Response<Product> response = productService
                .createProduct(product);
                .execute();
        assertThat(response.body().getTitle()).isEqualTo("Milk");
    }

    @Test
    void getProductByIdTest() throws IOException {
        Response<Product> response = productService
                .getProductById(136)
                .execute();
        assertThat(response.errorBody()).withFailMessage("Unable to find product with id: 136");
    }

    @Test
    void deleteProduct() throws IOException {
        Response<Product> response = productService
                .deleteProduct(1411)
                .execute();
        assertThat(response.errorBody()).withFailMessage("Internal Server Error");
    }

}
