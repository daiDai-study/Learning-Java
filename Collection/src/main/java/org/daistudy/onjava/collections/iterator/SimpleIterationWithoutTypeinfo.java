package org.daistudy.onjava.collections.iterator;

import org.daistudy.onjava.collections.entity.pets.Pet;
import org.daistudy.onjava.collections.entity.pets.Pets;

import java.util.Iterator;
import java.util.List;

/**
 * Collection 的每个具体实现类会维护自己的 Iterator 实现内部类（如 List 接口的抽象类 AbstractList 会提供默认实现）
 * remove() 之前必须先调用 next()
 */
public class SimpleIterationWithoutTypeinfo {
    public static void main(String[] args) {
        List<Pet> pets = Pets.list(12);
        Iterator<Pet> it = pets.iterator();
        while(it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
        // A simpler approach, when possible:
        for(Pet p : pets)
            System.out.print(p.id() + ":" + p + " ");
        System.out.println();
        // An Iterator can also remove elements:
        it = pets.iterator();
        for(int i = 0; i < 6; i++) {
            it.next();
            it.remove();
        }
        System.out.println(pets);
    }
}
/* Output:
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx 8:Cymric 9:Rat 10:EgyptianMau 11:Hamster
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx 8:Cymric 9:Rat 10:EgyptianMau 11:Hamster
[Pug, Manx, Cymric, Rat, EgyptianMau, Hamster]
*/
