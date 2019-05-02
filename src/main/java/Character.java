public interface Character {

    String getName();
    long getAttack();
    long getHealth();
    void setAttack(long attack);
    void setHealth(long health);
    String toString();
    long damage();

}
