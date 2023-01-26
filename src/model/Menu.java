package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Menu {

    private int nbjoueur;
    static List<String> couleur = new ArrayList<String>(); // Cette ligne déclare une liste statique de chaînes de caractères nommée couleur.

    private ArrayList<String> name = new ArrayList<>(); // Cette ligne déclare une variable privée de type ArrayList nommée name.

    public static String coul; // Cette ligne déclare une variable publique statique de type chaîne de caractères nommée coul.


    public Menu() {
        nbjoueur = getNbjoueur(); // Cette ligne assigne la valeur de retour de la méthode getNbjoueur à la variable nbjoueur.

        couleur = getCouleur(); // Cette ligne assigne la valeur de retour de la méthode getCouleur à la variable couleur.
    }

    public ArrayList<String> getName() { // Cette ligne déclare une méthode publique qui retourne un ArrayList de chaînes de caractères nommé name.
        return name;
    }

    public void setName(String nom) { // Cette ligne déclare une méthode publique qui permet d'ajouter un nom à la liste name.
        name.add(nom);
    }

    public int getNbjoueur() { // Cette ligne déclare une méthode publique qui retourne un entier nommé nbjoueur.
        return nbjoueur;
    }

    public void setNbjoueur(int nbjoueur) { // Cette ligne déclare une méthode publique qui permet d'ajouter un nombre de joueur à la variable nbjoueur.
        this.nbjoueur = nbjoueur;
    }

    public ArrayList<String> getCouleur() { // Cette ligne déclare une méthode publique qui retourne une liste d'ArrayList de chaînes de caractères nommée couleur.
        return (ArrayList<String>) couleur;
    } 

    public void setCouleur(String coul) { // Cette ligne déclare une méthode publique qui permet d'ajouter une couleur à la liste couleur.
        if(coul.equals("1")){
            couleur.add("🔴");
        }
        else if(coul.equals("2")){
            couleur.add("🟡");
        }
    }


    public void afficherMenu(String choix) { // Cette ligne déclare une méthode publique qui permet d'afficher un menu à l'écran en fonction du paramètre choix.

        ArrayList<String> menus = new ArrayList<>(); // Cette ligne crée un objet ArrayList qui permet de stocker des chaînes de caractères pour l'affichage du menu.

        if (choix == "principale"){ // Cette condition permet d'afficher le menu principal si le paramètre choix est égal à "principale".
    menus.add("          \u001B[4m⥤ MENU ⥢\u001B[0m\n");
    menus.add("\u001B[32m1-   ⌈    Jouer solo !  ⌋\u001B[0m");
    menus.add("\u001B[93m2-   ⌈   Jouer à deux   ⌋\u001B[0m");
    menus.add("\u001B[33m3-   ⌈    Classement    ⌋\u001B[0m");
    menus.add("\u001B[35m4-   ⌈     Quitter      ⌋\u001B[0m\n"); // Ces lignes ajoutent des options au menu principal.
    Iterator<String> iterator = menus.iterator(); // Cette ligne crée un itérateur qui permet de parcourir la liste des menus pour les afficher.
    while(iterator.hasNext()) { // Cette boucle while permet de parcourir l'ensemble des menus et de les afficher l'un après l'autre.
        System.out.println(iterator.next()); // Cette ligne affiche chaque menu à l'écran.
    }
} // Cette ligne ferme la condition if.
else if (choix == "couleur"){ // Cette condition permet d'afficher le menu des couleurs si le paramètre choix est égal à "couleur".
    menus.add (" 1 : 🔴"); // Cette ligne ajoute une couleur à la liste des menus.
    menus.add (" 2 : 🟡"); // Cette ligne ajoute une couleur à la liste des menus.
    Iterator<String> iterator = menus.iterator(); // Cette ligne crée un itérateur qui permet de parcourir la liste des couleurs pour les afficher.
    while(iterator.hasNext()) { // Cette boucle while permet de parcourir l'ensemble des couleurs et de les afficher l'un après l'autre.
        System.out.println(iterator.next()); // Cette ligne affiche chaque couleur à l'écran.
    }
} // Cette ligne ferme la condition else if.
else if (choix == "niveau"){ // Cette condition permet d'afficher le menu des niveaux si le paramètre choix est égal à "niveau".
    menus.add("          \u001B[4m⥤ Niveau IA ⥢\u001B[0m");
    menus.add("\u001B[32m1-   ⌈       Easy !    ⌋\u001B[0m");
    menus.add("\u001B[93m2-   ⌈      Medium     ⌋\u001B[0m");
    menus.add("\u001B[34m3-   ⌈       Hard      ⌋\u001B[0m");
    menus.add("\u001B[35m4-   ⌈    Impossible   ⌋\u001B[0m");
    menus.add("\u001B[38mq-   ⌈      Quitter    ⌋\u001B[0m"); // Ces lignes ajoutent des options au menu des niveaux.
    Iterator<String> iterator = menus.iterator(); // Cette ligne crée un itérateur qui permet de parcourir la liste des niveaux pour les afficher.
    while(iterator.hasNext()) { // Cette boucle while permet de parcourir l'ensemble des niveaux et de les afficher l'un après l'autre.
        System.out.println(iterator.next()); // Cette ligne affiche chaque niveau à l'écran.
    }
} // Cette ligne ferme la condition else if.
else{ // Cette condition permet d'afficher le message "Veuillez choisir une option" si aucun des paramètres choix n'est égal aux autres conditions.
    menus.add("Veuillez choisir une option :"); // Cette ligne ajoute le message à la liste des menus.
        }
    }

    public void setNiveau(String niv) {
    }
    

} // Cette ligne ferme la condition else.