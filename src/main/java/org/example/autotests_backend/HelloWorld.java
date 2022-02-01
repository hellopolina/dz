package org.example.autotests_backend;

import java.io.IOException;
import java.util.Arrays;

public class HelloWorld {

    private int[] arr;

    public HelloWorld() throws IOException {
        arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100000);
        }

        User user = User.builder()
                .name("Ivan")
                .surname("Ivanov")
                .birthday("23.06.91")
                .build();

        User user1 = new UserBuilder()
                .setName("Ivan")
                .setSurname("Ivanon")
                .build();

    }

    public int foo() {
        return 1;
    }

    public int sum(int a, int b) {
        return a + b;
    }

    public int badFoo(int x) {
        return  x / 0;
    }

    public int[] longFoo() {
        Arrays.sort(arr);
        return arr;
    }
}
