package AddressBook;

public class Person {
    String name,adress,email;
    int no,telenum;

    public Person(int no,String name,int telenum,String adress,String email){
        this.no = no;
        this.name = name;
        this.telenum = telenum;
        this.adress = adress;
        this.email = email;
    }

    public int getNo(){
        return this.no;
    }

    public String getName(){
        return this.name;
    }

    public int getTelenum(){
        return this.telenum;
    }

    public String getAdress(){
        return this.adress;
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

    public void setTelenum(int telenum){
        this.telenum = telenum;
    }

    public void setAdress(String adress){
        this.adress = adress;
    }

    public void setEmail(String email){
        this.email = email;
    }


}
