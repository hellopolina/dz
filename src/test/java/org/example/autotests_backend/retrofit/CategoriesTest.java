package org.example.autotests_backend.retrofit;

import org.example.autotests_backend.Retrofit.Category;
import org.example.autotests_backend.Retrofit.CategoryService;
import org.example.autotests_backend.Retrofit.utils.RetrofitUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoriesTest {
    static Retrofit retrofit;
    static CategoryService categoryService;

    @BeforeAll
    static void beforeAll() {
        retrofit = RetrofitUtils.getRetrofit();
        categoryService = retrofit.create(CategoryService.class);
    }

    @Test
    void getFoodCategoryTest() throws IOException {
        Response<Category> response = categoryService
                .getCategory(1)
                .execute();
        assertThat(response.body().getTitle()).isEqualTo("Food");
        response.
                body().
                getProducts().
                forEach(e -> assertThat(e.getCategoryTitle()).isEqualTo("Food"));
//        try {
//            System.out.println(response.body().string());
//        } catch (NullPointerException a) {
//            System.out.println(response.errorBody().string());
//        }
    }
}
