package model;

// Represent a monster with name, health, attack power
public class Monster {
    private String name;
    private int health;
    private int attackPower;
    private boolean isDead;

    /*
     * REQUIRES : health > 0
     * EFFECTS: constructs monster with name, health, attack power and is dead
     */
    public Monster(String name,int health,int attackPower,boolean isDead) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.isDead = isDead;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }
}
