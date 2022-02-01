package org.example.autotests_backend.fabric;

public class CatFabric extends AnimalFabric{
    @Override
    public Cat create() {
        return new Cat();
    }
}
