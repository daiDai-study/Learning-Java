package org.daistudy.onjava.collection.map;

import org.daistudy.onjava.collection.entity.pets.*;

import java.util.HashMap;
import java.util.Map;

public class PetMapWithoutTypeinfo {
    public static void main(String[] args) {
        Map<String, Pet> petMap = new HashMap<>();
        petMap.put("My Cat", new Cat("Molly"));
        petMap.put("My Dog", new Dog("Ginger"));
        petMap.put("My Hamster", new Hamster("Bosco"));
        petMap.put(null, null);
        System.out.println(petMap);
        Pet dog = petMap.get("My Dog");
        System.out.println(dog);
        System.out.println(petMap.containsKey("My Dog"));
        System.out.println(petMap.containsValue(dog));
    }
}
/* Output:
{My Dog=Dog Ginger, My Cat=Cat Molly, My
Hamster=Hamster Bosco}
Dog Ginger
true
true
*/