public class CharacterFactory {

    public Character getCharacter(long id, String name, String description, long attack, long health, boolean isVillain){
        if(isVillain)
            return new Villain(id, name, description, attack, health);
        else
            return new Hero(id, name, description, attack, health);
    }
}
