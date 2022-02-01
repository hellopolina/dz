package org.example.autotests_backend.fabric;

public class AnimalProducer {

    public Animal produce(AnimalFabric fabric) {
        return fabric.create();
    }
}
