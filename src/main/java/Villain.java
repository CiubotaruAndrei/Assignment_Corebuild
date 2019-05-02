public class Villain extends Character{


    public Villain(long id, String name, String description, long attack, long health) {
        super(id, name, description, attack, health);
    }

    public String toString() {
        return "I am a villain: " + super.getName();
    }
}
