package AddressBook;

import java.io.*;
import java.util.ArrayList;

public class Person {
    String name,address,email,type,sex;
    int no,telenum;

    public Person(int no,String name,String sex,String type,int telenum,String address,String email){
        this.no = no;
        this.name = name;
        this.type = type;
        this.telenum = telenum;
        this.address = address;
        this.email = email;
        this.sex = sex;
    }

    public int getNo(){
        return this.no;
    }

    public String getName(){
        return this.name;
    }

    public String getSex(){
        return this.sex;
    }

    public String getType(){
        return this.type;
    }

    public int getTelenum(){
        return this.telenum;
    }

    public String getaddress(){
        return this.address;
    }

    public String getEmail(){
        return this.email;
    }

    public void setNo(int no){
        this.no = no;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSex(String sex){
        this.sex = sex;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setTelenum(int telenum){
        this.telenum = telenum;
    }

    public void setaddress(String address){
        this.address = address;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public ArrayList<Person> getInformation() throws Exception{
        ArrayList<Person> information = new ArrayList<>();
        String[] s = new String[7];
        File fp = new File("Person.txt");
        FileReader inOne = null;

        inOne = new FileReader(fp);
        BufferedReader inTwo = new BufferedReader(inOne);
        String n = null;
        while((n=inTwo.readLine())!=null){

        }


        return information;
    }
}
