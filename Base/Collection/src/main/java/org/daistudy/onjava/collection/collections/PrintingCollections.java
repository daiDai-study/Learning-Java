package org.daistudy.onjava.collection.collections;

// collections/PrintingCollections.java
// Collections print themselves automatically
import java.util.*;

/**
 * 整个集合分两类：Collection 和 Map
 *      Collection：每个槽存一个元素，其又可分为 List、Set、Queue
 *          List：有 ArrayList 和 LinkedList，都是按插入顺序存储元素
 *              ArrayList：数组存储 Object[]
 *              LinkedList：链表存储 Node<E>
 *          Set：分 HashSet、TreeSet、LinkedHashSet，元素不能重复【Set 的内部实现依赖于 Map】
 *              HashSet：元素检索最快，不关心存储顺序（没有一定的存储顺序）
 *              TreeSet：按比较结果的升序存储
 *              LinkedHashSet：按插入顺序存储
 *      Map：每个槽可以存两个元素，一个作为键，一个作为值，键不能重复，可分为 HashMap、TreeMap、LinkedHashMap
 *          HashMap：元素检索最快，不关心存储顺序（没有一定的存储顺序）
 *          TreeMap：按比较结果的升序存储
 *          LinkedHashMap：按插入顺序存储
 */
public class PrintingCollections {
    static Collection fill(Collection<String> collection) {
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }
    static Map fill(Map<String, String> map) {
        map.put("rat", "Fuzzy");
        map.put("cat", "Rags");
        map.put("dog", "Bosco");
        map.put("dog", "Spot");
        return map;
    }
    public static void main(String[] args) {
        System.out.println(fill(new ArrayList<>()));
        System.out.println(fill(new LinkedList<>()));
        System.out.println(fill(new HashSet<>()));
        System.out.println(fill(new TreeSet<>()));
        System.out.println(fill(new LinkedHashSet<>()));
        System.out.println(fill(new HashMap<>()));
        System.out.println(fill(new TreeMap<>()));
        System.out.println(fill(new LinkedHashMap<>()));
    }
}
/* Output:
[rat, cat, dog, dog]
[rat, cat, dog, dog]
[rat, cat, dog]
[cat, dog, rat]
[rat, cat, dog]
{rat=Fuzzy, cat=Rags, dog=Spot}
{cat=Rags, dog=Spot, rat=Fuzzy}
{rat=Fuzzy, cat=Rags, dog=Spot}
*/
