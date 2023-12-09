package sfd;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class FizzBuzz {
    private int n;
    private int current;
    private Lock lock;

    public FizzBuzz(int n) {
        this.n = n;
        this.current = 1;
        this.lock = new ReentrantLock();
    }

    public void fizz() {
        while (true) {
            try {
                lock.lock();
                if (current > n) {
                    return;
                }
                if (current % 3 == 0 && current % 5 != 0) {
                    System.out.print("fizz ");
                    current++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void buzz() {
        while (true) {
            try {
                lock.lock();
                if (current > n) {
                    return;
                }
                if (current % 3 != 0 && current % 5 == 0) {
                    System.out.print("buzz ");
                    current++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void fizzbuzz() {
        while (true) {
            try {
                lock.lock();
                if (current > n) {
                    return;
                }
                if (current % 3 == 0 && current % 5 == 0) {
                    System.out.print("fizzbuzz ");
                    current++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public void number() {
        while (true) {
            try {
                lock.lock();
                if (current > n) {
                    return;
                }
                if (current % 3 != 0 && current % 5 != 0) {
                    System.out.print(current + " ");
                    current++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);

        Thread threadA = new Thread(() -> fizzBuzz.fizz());
        Thread threadB = new Thread(() -> fizzBuzz.buzz());
        Thread threadC = new Thread(() -> fizzBuzz.fizzbuzz());
        Thread threadD = new Thread(() -> fizzBuzz.number());

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        try {
            threadA.join();
            threadB.join(); 
            threadC.join();
            threadD.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}