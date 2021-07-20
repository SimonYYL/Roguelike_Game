package model;


import model.exceptions.MonsterAlreadyGoneException;

// Monster and hero battle mechanism, calculate attack, health value, and win or lose
public class Battle<iterable> {
    private static final String OVER1 = "VICTORY!";
    private static final String OVER2 = "LOST!";
    private Team team;
    private Monster target;


    /*
     * EFFECTS:  constructs battle with one team and one monster
     */
    public Battle() {
        this.team = new Team("Simon's team");
        this.target = new Monster("T-2000",250,50,false);

    }


    /*
     * MODIFIES: this
     * EFFECTS: set field team as t1
     */
    public void addPlayer(Team t1) {
        team = t1;
    }


    /*
     * MODIFIES: this
     * EFFECTS: hero attack monster then monster attack hero, return the result when all the hero dead or monster
     *          dead. If monster is dead, catch exception and return hero win
     */
    public String attack() {
        try {
            while (!(team.howManyHeroDead() == team.size())) {
                for (Hero h : team.getTeam()) {
                    heroAttackMonster(target, h);
                    monsterAttackHero(target, h);
                }
            }
            if (target.isDead()) {
                return OVER1;

            } else {
                return OVER2;
            }
        } catch (MonsterAlreadyGoneException e) {
            return OVER1;
        }
    }

    /*
     * REQUIRES: monster isDead produce false
     * MODIFIES: this
     * EFFECTS: hero attack monster, return monster health if not dead, set monster health 0 and isDead otherwise
     */
    public void heroAttackMonster(Monster target,Hero h) {
        if (!h.isDead()) {
            if ((target.getHealth() - h.getAttackPower()) <= 0) {
                target.setHealth(0);
                target.setDead(true);
            } else {
                target.setHealth(target.getHealth() - h.getAttackPower());
            }
        }
    }

    /*
     * REQUIRES: hero isDead produce false
     * MODIFIES: this
     * EFFECTS: monster attack hero, return hero health if not dead, set hero health 0 and isDead otherwise
     */
    public void monsterAttackHero(Monster target,Hero h) throws MonsterAlreadyGoneException {
        if (target.isDead()) {
            throw new MonsterAlreadyGoneException();
        } else {
            if ((h.getHealth() - target.getAttackPower()) <= 0) {
                h.setHealth(0);
                h.setDead(true);
            } else {
                h.setHealth(h.getHealth() - target.getAttackPower());

            }
        }
    }
}
