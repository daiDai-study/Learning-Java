package org.daistudy.onjava.collections.iterator;

import org.daistudy.onjava.collections.entity.pets.Pet;
import org.daistudy.onjava.collections.entity.pets.Pets;

import java.util.*;

/**
 * Collection 继承 Iterable，Map 没有继承，但 Map 的具体实现类（如 HashMap）通过内部类实现了 Iterator 接口
 * 简化了代码，使用 Iterable 接口替代 Iterator 接口，在 display 方法内进行转化
 */
public class CrossCollectionIterationWithoutTypeInfo2 {
    public static void display(Iterable<Pet> ip) {
        Iterator<Pet> it = ip.iterator();
        while(it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        List<Pet> pets = Pets.list(8);
        LinkedList<Pet> petsLL = new LinkedList<>(pets);
        HashSet<Pet> petsHS = new HashSet<>(pets);
        TreeSet<Pet> petsTS = new TreeSet<>(pets);
        display(pets);
        display(petsLL);
        display(petsHS);
        display(petsTS);
    }
}
/* Output:
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug
7:Manx
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug
7:Manx
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug
7:Manx
5:Cymric 2:Cymric 7:Manx 1:Manx 3:Mutt 6:Pug 4:Pug
0:Rat
*/
