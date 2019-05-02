import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void applyModifiersToCharacter(Planet planet,Character character){
        if(character instanceof Hero) {
            character.setAttack(character.getAttack() + planet.getModifiers().get(0));
            character.setHealth(character.getHealth() + planet.getModifiers().get(1));
        }
        else {
            character.setAttack(character.getAttack() + planet.getModifiers().get(2));
            character.setHealth(character.getHealth() + planet.getModifiers().get(3));
        }
    }

    public static void main(String[] args) {

        System.out.println("Select a planet, a villain and a superhero.\n" +
                "After this the fight begins, the villain and hero attack turn by turn until someone's health reaches 0.\n" +
                "The damage that a character does each round is random, and it varies from 60% to 100% of his attack stats.\n" +
                "Since most villains are more powerful than heroes, you could allow the user to create an 'Avengers' team, that contain multiple heroes to defend a villain.");

        Reader reader = new Reader();
        ArrayList<Character> characters = reader.getCharcters();//citesc din fisier eroii si raufactorii
        for(Character c : characters)
            System.out.println(c.toString());

        ArrayList<Planet> planets = reader.getPlanets();//citesc din fisier planetele
        System.out.println("Planets:");
        for(Planet p : planets)
            System.out.println(p.getName());
        //citirea(de la tastatura) planetei, raufacatorului si a eroilor in functie de numarul de eroi ales
        Scanner in =  new Scanner(System.in);
        System.out.println();
        System.out.println("Select planet");
        String planetName = in.nextLine();
        System.out.println("Select Villain");
        String villainName = in.nextLine();
        System.out.println("Select number of heroes(max 3)");
        int nrHeroes = Integer.parseInt(in.nextLine());
        System.out.println("Select Heroes");
        int nr=nrHeroes;
        ArrayList<Character> heroes = new ArrayList<Character>();
        boolean okInput;
        if(nrHeroes>3){
            System.out.println("Too many heroes");
            System.exit(1);
        }
        while(nrHeroes>0){
            //System.out.println(nrHeroes);
            okInput=true;
            String heroName = in.nextLine();
            for(Character hero : heroes)
                if(heroName.equalsIgnoreCase(hero.getName())) {//verific ca eroii sa fie diferiti
                    System.out.println("Select another hero.This already is in team");
                    okInput=false;
                }
            if(okInput) {
                for (Character c : characters)
                    if (heroName.equalsIgnoreCase(c.getName()) && c instanceof Hero)
                        heroes.add(c);
                nrHeroes--;
            }
        }

        Planet planet = null;

        for(Planet p : planets)
            if(planetName.equalsIgnoreCase(p.getName()))
                planet  = p;

        Character villain = null;

        for(Character c : characters)
            if(villainName.equalsIgnoreCase(c.getName()) && c instanceof Villain)
                villain = c;

        if(heroes.size()!=nr || villain==null || planet==null) {
            System.out.println("Incorect hero, villain or planet! Run again the app.");
            System.exit(1);
        }

        System.out.println("You selected:");
        System.out.println("Planet: " + planet.getName());
        System.out.println("Heroes: " + heroes);
        System.out.println("Villain: " + villain.getName());
        System.out.println();

        for(Character c : heroes) {
            applyModifiersToCharacter(planet,c);//aplic modificatorii pentru viata si atac pentru supereroi
            System.out.println("Hero health: " + c.getHealth() + " attack: " + c.getAttack());
        }
        applyModifiersToCharacter(planet,villain);//aplic modificatorii pentru viata si atac prentru raufacator
        System.out.println("Villain health: " + villain.getHealth() + " attack: " + villain.getAttack());
        System.out.println();
        int heroesDead;
        while(villain.getHealth()>0){
            heroesDead=0;
            for(Character hero : heroes)
                if(hero.getHealth()>0 && villain.getHealth()>0) {
                    hero.setHealth(hero.getHealth() - villain.damage());//raufacatorul ataca primul tot timpul
                    if(hero.getHealth()>0)
                        villain.setHealth(villain.getHealth() - hero.damage());//daca eroul ramane in viata ataca si el
                    System.out.println("Health hero: " + hero.getName()+ " " + hero.getHealth());
                }
                else
                    heroesDead++;
            System.out.println("Health villain: " + villain.getHealth());
            if(heroesDead==nr)
              break;
        }

        if(villain.getHealth()>0)
            System.out.println("Villain win");
        else
            System.out.println("Hero win");

    }
}
