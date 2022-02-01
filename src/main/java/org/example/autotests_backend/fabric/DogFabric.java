package org.example.autotests_backend.fabric;

public class DogFabric extends AnimalFabric{
    @Override
    public Dog create() {
        return new Dog();
    }
}
