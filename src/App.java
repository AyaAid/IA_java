
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App {
    private static Scanner _scan;

    public static void main(String[] args) throws Exception{
        while(true){
            afficherMenu();
            switch (_scan.nextLine()) {
                case "1":
                     //  JouerSolo();
                    break;
                case "2":
                       // JoueràDeux();
                    break;
                case "3":
                       // Classement();
                    break;
                case "q":
                    return;
                }
                
            }
    }

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