package org.daistudy.onjava.collection.comparator;

// collections/UniqueWords.java

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 相对路径是相对当前项目的根目录
 * \W+ 是一个正则表达式，表示 一个或多个非字母和非数字的字符
 */
public class UniqueWordsAlpabetic {
    public static void main(String[] args) throws Exception {
        final Path path = Paths.get("src/main/java/org/daistudy/java/collections/SetOperations.java");
        List<String> lines = Files.readAllLines(
                path);
        Set<String> words = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        for(String line : lines) {
            final String[] split = line.split("\\W+");
            for(String word : split)
                if(word.trim().length() > 0)
                    words.add(word);
        }
        System.out.println(words);
    }
}
/* Output:
[A, B, C, Collections, D, E, F, G, H, HashSet, I, J, K,
L, M, N, Output, Set, SetOperations, String, System, X,
Y, Z, add, addAll, added, args, class, collections,
contains, containsAll, false, from, import, in, java,
main, new, out, println, public, remove, removeAll,
removed, set1, set2, split, static, to, true, util,
void]
*/
