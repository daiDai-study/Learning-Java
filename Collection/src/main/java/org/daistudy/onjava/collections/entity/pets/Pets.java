package org.daistudy.onjava.collections.entity.pets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pets{
    private static List<Pet> pets = new ArrayList<>();

    static{
        Collections.addAll(pets, new Rat(), new Manx(), new Cymric(), new Mutt(), new Pug(), new Cymric(), new Pug(),
                new Manx(), new Cymric(), new Rat(), new EgyptianMau(), new Hamster());
    }

    public static List<Pet> list(int number){
        List<Pet> returnPets = new ArrayList<>();
        if(number == 4){
            Collections.addAll(returnPets, new Manx(), new Cymric(), new Rat(), new EgyptianMau());
        }
        if(number >= 5){
            returnPets = new ArrayList<>(pets.subList(0, number));
        }

        return returnPets;
    }

    public static Pet get() {
        return null;
    }

    public static Pet[] array(int i) {
        return list(i).toArray(new Pet[0]);
    }
}



