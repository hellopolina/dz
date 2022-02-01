package org.example.autotests_backend.fabric;

public class Test {

    public static void main(String[] args) {
        new AnimalProducer()
                .produce(
                new CatFabric())
                .say();
    }
}
