import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reader {

    JSONParser parser = new JSONParser();
    ArrayList<Planet> planets = new ArrayList<Planet>();
    ArrayList<Character> characters = new ArrayList<Character>();


    public ArrayList<Character> getCharcters(){

        CharacterFactory characterFactory = new CharacterFactory();

        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("characters.json"));

            for(Object o : a){

                JSONObject jsonObject = (JSONObject) o;
                Long id = (Long) jsonObject.get("id");
                String name = (String) jsonObject.get("name");
                String description = (String) jsonObject.get("description");
                Long attack = (Long) jsonObject.get("attack");
                Long health = (Long) jsonObject.get("health");
                Boolean isVillain = (Boolean) jsonObject.get("isVillain");

                characters.add(characterFactory.getCharacter(id,name,description,attack,health,isVillain));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return characters;
    }

    public ArrayList<Planet> getPlanets(){
        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("planets.json"));

            for(Object o : a){

                JSONObject jsonObject = (JSONObject) o;
                Long id = (Long) jsonObject.get("id");
                String name = (String) jsonObject.get("name");
                String description = (String) jsonObject.get("description");
                JSONObject modifiers  = (JSONObject) jsonObject.get("modifiers");
                ArrayList<Long> modifiersArray = new ArrayList<Long>();
                modifiersArray.add((Long) modifiers.get("heroAttackModifier"));
                modifiersArray.add((Long) modifiers.get("heroHealthModifier"));
                modifiersArray.add((Long) modifiers.get("villainAttackModifier"));
                modifiersArray.add((Long) modifiers.get("villainHealthModifier"));

                //System.out.println(modifiersArray);

                planets.add(new Planet(id, name, description, modifiersArray));

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return planets;
    }
}
