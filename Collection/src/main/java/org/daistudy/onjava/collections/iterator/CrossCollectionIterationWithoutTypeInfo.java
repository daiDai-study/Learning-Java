package org.daistudy.onjava.collections.iterator;

import org.daistudy.onjava.collections.entity.pets.Pet;
import org.daistudy.onjava.collections.entity.pets.Pets;

import java.util.*;

/**
 * 所有 Collection 的具体实现类都能够以一个 已存在的 Colletion 对象 进行初始化
 */
public class CrossCollectionIterationWithoutTypeInfo {
    public static void display(Iterator<Pet> it) {
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
        display(pets.iterator());
        display(petsLL.iterator());
        display(petsHS.iterator());
        display(petsTS.iterator()); // 此处的结果会与以下结果有出入：原因在于自定义的 Pet 类内部根据类名（不区分大小写）的字符串比较方法实现（comparable 接口） compareTo 方法
    }
}
/* Output:
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
5:Cymric 2:Cymric 7:Manx 1:Manx 3:Mutt 6:Pug 4:Pug 0:Rat
*/