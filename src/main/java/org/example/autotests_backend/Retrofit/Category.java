package org.example.autotests_backend.Retrofit;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Category {
    private Integer id;
    private String title;
    private List<Product> products = new ArrayList<>();
}
