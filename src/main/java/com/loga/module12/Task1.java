package com.loga.module12;

public class Task1 {

    public static void main(String[] args) throws InterruptedException {
        Thread timeThread = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            while (true) {
                long elapsedTime = System.currentTimeMillis() - startTime;
                System.out.println("Минуло 5 секунд :" + elapsedTime / 1000 + " Секунди");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread messageThread = new Thread(() -> {
            int counter = 0;
            while (counter < 4) {
                try {
                    Thread.sleep(5000);
                    counter++;
                    System.out.println("Минуло 5 секунд");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        timeThread.start();
        messageThread.start();
//+ Доробив закінчення програми за 15 секунд
        Thread.sleep(15000);

        timeThread.interrupt();
        messageThread.interrupt();
    }
}

