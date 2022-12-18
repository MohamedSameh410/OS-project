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
public class User {
    char name;
    int phoneNumber;
    int id;
    protected static int maxSize = 20;
    List<Integer> products;
 
    public void setname(char name){
        name=this.name;
    }
    public char getname(){
        return name;
    }
    public void setphoneNumber(int phoneNumber){
        phoneNumber=this.phoneNumber;
    }
    public int getphoneNumber(){
        return phoneNumber;
    }

    public void setid(int id){
        id=this.id;
    }
    public int getid(){
        return id;
    } 
}