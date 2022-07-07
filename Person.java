package AddressBook;

import java.io.*;
import java.util.ArrayList;

public class Person {
    String name,address,email,type,sex,no,telenum;

    public Person(String no,String name,String sex,String type,String telenum,String address,String email){
        this.no = no;
        this.name = name;
        this.type = type;
        this.telenum = telenum;
        this.address = address;
        this.email = email;
        this.sex = sex;
    }

    public String getNo(){
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

    public String getTelenum(){
        return this.telenum;
    }

    public String getaddress(){
        return this.address;
    }

    public String getEmail(){
        return this.email;
    }

    public void setNo(String no){
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

    public void setTelenum(String telenum){
        this.telenum = telenum;
    }

    public void setaddress(String address){
        this.address = address;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public static ArrayList<Person> getInformation() {
        ArrayList<Person> list = new ArrayList<>();
        File fp = new File("Person.txt");
        if(!fp.exists()) {
            try {
                fp.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (FileReader inOne = new FileReader(fp)){
            BufferedReader inTwo = new BufferedReader(inOne);
            String[] s;
            String n;
            while((n=inTwo.readLine())!=null){
                s = n.split(" ");
                list.add(new Person(s[0],s[1],s[2],s[3],s[4],s[5],s[6]));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static boolean find(ArrayList<Person> list, String n){
        for(Person s : list){
            if(s.getNo().equals(n))
                return true;
        }
        return false;
    }

    public static void savefile(ArrayList<Person> list){
        try(PrintStream writer = new PrintStream("Person.txt")){
            for(Person ss:list){
                writer.print(ss.getNo()+" "+ss.getName()+" "+ss.getSex()+" "+ss.getType()+" "+ss.getTelenum()+" "+ss.getaddress()+" "+ss.getEmail()+"\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
