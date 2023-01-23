
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


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
    
private static void afficherMenu() {
    ArrayList<String> menus = new ArrayList<>();
    menus.add("          ⥤ MENU ⥢");
    menus.add("1-   ⌈    Jouer solo !  ⌋");
    menus.add("2-   ⌈   Jouer à deux   ⌋");
    menus.add("3-   ⌈    Classement    ⌋");
    menus.add("q-   ⌈     Quitter      ⌋");
    Iterator<String> iterator = menus.iterator();

    while(iterator.hasNext()) {
        String menu = iterator.next();
        System.out.println(menu);
    }
}
}