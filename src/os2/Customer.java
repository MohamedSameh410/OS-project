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
public class Customer extends User implements Runnable{
        //List<Integer> products ;

    public Customer(List<Integer> products) {
        this.products = products;
    }

    public void order() {
        synchronized (products) {

            while (products.size() <= 0) {
                try {
                    products.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " Customer buy product " + products.remove(0));
            products.notifyAll();
        }
    }
        @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            order();
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}