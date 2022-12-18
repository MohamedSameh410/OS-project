/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os2;

/**
 *
 * @author Amira
 */
import java.util.*;

public class Admin extends User implements Runnable{
   // List<Integer> products;

    public Admin(List<Integer> products) {
        this.products = products;
    }

   public void produce(int i) {
       synchronized (products) {

            while (products.size() >= maxSize) {
                try {
                    products.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " Admin add product " + i);
            products.add(i);
            products.notifyAll();
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 20; i++) {
            produce(i);
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
