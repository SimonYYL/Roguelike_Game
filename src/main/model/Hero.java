package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents a Hero having name, health level, attack power, level, occupation
public class Hero implements Writable {
    private String name;
    private int health;
    private int attackPower;
    private int level;
    private String occupation;
    private boolean isDead;

    /*
     * REQUIRES: health is in range [1-200], attack power is in range [0-100]
     * EFFECTS:  constructs hero with name, health level, attack power, level, occupation and is dead
     */
    public Hero(String name,int health,int attackPower,int level,String occupation,boolean isDead) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.level = level;
        this.occupation = occupation;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    @Override
    // TODO: NEED TEST
    public JSONObject toJson() {
        JSONObject j = new JSONObject();
        j.put("name",name);
        j.put("health",health);
        j.put("attackPower",attackPower);
        j.put("level",level);
        j.put("occupation",occupation);
        j.put("isDead",isDead);
        return j;
    }
}


