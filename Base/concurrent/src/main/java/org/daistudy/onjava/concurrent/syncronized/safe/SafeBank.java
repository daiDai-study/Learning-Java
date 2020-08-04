package org.daistudy.onjava.concurrent.syncronized.safe;

import org.daistudy.onjava.concurrent.syncronized.unsafe.UnsafeBuyTickets;

public class SafeBank {
    private static class Account{
        private String name;
        private int money;

        public Account(String name, int money) {
            this.name = name;
            this.money = money;
        }
    }

    private static class DrawMoney implements Runnable{
        private Account account;
        private String drawUser;
        private int drawMoney;

        public DrawMoney(Account account, String drawUser, int drawMoney) {
            this.account = account;
            this.drawUser = drawUser;
            this.drawMoney = drawMoney;
        }

        private void draw(){
            if(account.money - drawMoney < 0){
                System.out.println(drawUser + "要取" + drawMoney + "万，余额不足");
                return;
            }
            account.money = account.money - drawMoney;
            System.out.println(drawUser + "取了" + drawMoney + "万");
        }

        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (account){
                draw();
                System.out.println(account.name + "余额：" + account.money + "万");
            }
        }
    }

    public static void main(String[] args) {
        Account account = new Account("基金", 100);
        DrawMoney you = new DrawMoney(account, "你", 40);
        DrawMoney wife = new DrawMoney(account, "你媳妇", 50);
        DrawMoney daughter = new DrawMoney(account, "你女儿", 60);

        new Thread(you).start();
        new Thread(wife).start();
        new Thread(daughter).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.name + "最后余额：" + account.money + "万");
    }
}
