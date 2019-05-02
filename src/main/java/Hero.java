public class Hero implements Character{

        private long id;
        private String name;
        private String description;
        private long attack;
        private long health;

    public Hero(long id, String name, String description, long attack, long health) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.attack = attack;
        this.health = health;
    }

    public long damage() {
        int power = (int)(Math.random() * 40) + 60;
        System.out.println(name + " damage: " + (attack*power)/100);
        return (attack*power)/100;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getAttack() {
        return attack;
    }

    public void setAttack(long attack) {
        this.attack = attack;
    }

    public long getHealth() {
        return health;
    }

    public void setHealth(long health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return "I am a hero: " + name;
    }
}
