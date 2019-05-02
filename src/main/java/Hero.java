public class Hero extends Character{

    public Hero(long id, String name, String description, long attack, long health) {
        super(id, name, description, attack, health);
    }

    @Override
    public String toString() {
        return "I am a hero: " + super.getName();
    }
}
