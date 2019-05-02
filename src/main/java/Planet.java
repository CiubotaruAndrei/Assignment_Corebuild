import java.util.ArrayList;

public class Planet {

    private long id;
    private String name;
    private String description;
    private ArrayList<Long> modifiers;

    public Planet(long id, String name, String description, ArrayList<Long> modifiers) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.modifiers = modifiers;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
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

    public ArrayList<Long> getModifiers() {
        return modifiers;
    }

    public void setModifiers(ArrayList<Long> modifiers) {
        this.modifiers = modifiers;
    }

}
