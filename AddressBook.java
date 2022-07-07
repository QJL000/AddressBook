package AddressBook;

public class AddressBook {
    public static void main(String[] args) {
        System.setProperty("sun.java2d.noddraw", "true");//设置透明窗体,解决输入中文变白
        MainMenu menu = new MainMenu();
    }

}
