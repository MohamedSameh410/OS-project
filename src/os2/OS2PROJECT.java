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
import java.util.List;
import java.lang.RuntimeException;
import java.io.*; 
import java.lang.Thread;
import java.lang.IndexOutOfBoundsException;
public class OS2PROJECT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     List<Integer> products = new ArrayList<>();
    Customer cu = new Customer(products);
    Admin a = new Admin(products);
    Thread Customer1 = new Thread(cu);
    Thread Customer2 = new Thread(cu);

    Thread Admin1 = new Thread(a);
    Thread Admin2 = new Thread(a);

    Customer1.start();
    Customer2.start();
    Admin1.start();
    Admin2.start();

    try {
        Customer1.join();
        Customer2.join();
        Admin1.join();
        Admin2.join();
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    System.out.println("Job completed >>>>");
}

}
   