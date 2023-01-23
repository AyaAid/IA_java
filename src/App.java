
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

<<<<<<< HEAD
=======

>>>>>>> 17e0cfd48f269b7748265cc0aeac05a792a3c968
public class App {

    public static void main(String[] args) throws Exception{
        afficherMenu();
    }
    private static Scanner _scan;

    static {
        _scan = new Scanner(System.in);
    }

    public App() {
    }
    
public static void afficherMenu() {
    ArrayList<String> menus = new ArrayList<>();
    menus.add("          \u001B[4m⥤ MENU ⥢\u001B[0m");
    menus.add("\u001B[32m1-   ⌈    Jouer solo !  ⌋\u001B[0m");
    menus.add("\u001B[93m2-   ⌈   Jouer à deux   ⌋\u001B[0m");
    menus.add("\u001B[33m3-   ⌈    Classement    ⌋\u001B[0m");
    menus.add("\u001B[35m4-   ⌈     Quitter      ⌋\u001B[0m");
    Iterator<String> iterator = menus.iterator();

    while(iterator.hasNext()) {
        String menu = iterator.next();
        System.out.println(menu);
    }
}
}