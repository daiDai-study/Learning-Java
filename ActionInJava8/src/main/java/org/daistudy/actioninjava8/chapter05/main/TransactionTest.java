package org.daistudy.actioninjava8.chapter05.main;

import org.daistudy.actioninjava8.chapter05.model.Trader;
import org.daistudy.actioninjava8.chapter05.model.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class TransactionTest {
    public static void main(String[] args) {
        final List<Transaction> transactions = Transaction.init();

        // 1.找出2011年发生的所有交易，并按交易额排序（从低到高）
        System.out.println("1.找出2011年发生的所有交易，并按交易额排序（从低到高）");
        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .forEach(System.out::println);

        // 2.交易员都在哪些不同的城市工作过
        System.out.println("\n2.交易员都在哪些不同的城市工作过");
        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .forEach(System.out::println);

        // 3.查找所有来自于剑桥的交易员，并按姓名排序
        System.out.println("\n3.查找所有来自于剑桥的交易员，并按姓名排序");
        transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .filter(trader -> Objects.equals(trader.getCity(), "Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .forEach(System.out::println);

        // 4.返回所有交易员的姓名字符串，并按字母顺序排序（返回一个字符串）
        System.out.println("\n4.返回所有交易员的姓名字符串，并按字母顺序排序（返回一个字符串）");
        System.out.println(transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .map(Trader::getName)
                .sorted()
                .reduce("", (a, b) -> a + ", " + b));

        // 5.有没有交易员实在米兰工作的
        System.out.println("\n5.有没有交易员是在米兰工作的");
        System.out.println(transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .anyMatch(trader -> Objects.equals(trader.getCity(), "Milan")));

        // 6.打印生活在剑桥的交易员的所有交易额
        System.out.println("\n6.打印生活在剑桥的交易员的所有交易额");
        transactions.stream()
                .filter(transaction -> Objects.equals(transaction.getTrader().getCity(), "Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        // 7.所有交易中，最高的交易额是多少
        System.out.println("\n7.所有交易中，最高的交易额是多少");
        transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo)
                .ifPresent(System.out::println);

        // 8.找到交易额最小的交易
        System.out.println("\n8.找到交易额最小的交易");
        transactions.stream()
                .min(Comparator.comparing(Transaction::getValue))
                .ifPresent(System.out::println);
    }
}
