
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
    menus.add("1-   ⌈     Jouez !      ⌋");
    menus.add("2-   ⌈    Classement    ⌋");
    menus.add("3-   ⌈Choix des couleurs⌋");
    menus.add("4-   ⌈    Difficulté    ⌋");
    menus.add("q-   ⌈     Quitter      ⌋");
    Iterator<String> iterator = menus.iterator();

    while(iterator.hasNext()) {
        String menu = iterator.next();
        System.out.println(menu);
    }
}
}