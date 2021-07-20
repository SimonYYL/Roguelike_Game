package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

// Represents a team of hero
public class Team implements Writable {
    private String name;
    private List<Hero> team;
    private static final int MAX_MEMBER_IN_A_TEAM = 4;


    /*
     * EFFECTS: constructs team with a list of hero
     */
    public Team(String name) {
        this.name = name;
        team = new ArrayList<Hero>();
    }

    public String getName() {
        return name;
    }

    /*
     * MODIFIES: this
     * EFFECTS: if the number of hero in the term not reach the max, add hero into the Team.
     */
    public void addHero(Hero h) {
        if (team.size() < MAX_MEMBER_IN_A_TEAM) {
            team.add(h);
        }
    }

    /*
     * MODIFIES: this
     * EFFECTS: if hero is dead remove the hero from the team
     */
    public void removeDeadHero(Hero h) {
        if (h.isDead()) {
            team.remove(h);
        }
    }

    /*
     * EFFECTS: return the size of team
     */
    public int size() {
        return team.size();
    }

    /*
     * EFFECTS: get the team
     */
    public List<Hero> getTeam() {
        return team;
    }

    /*
     * EFFECTS: return true if hero is in the team, false otherwise
     */
    public boolean checkContain(Hero h) {
        return team.contains(h);
    }

    /*
     * MODIFIES: this
     * EFFECTS: count the number of hero who is already dead
     */
    public int howManyHeroDead() {
        int count;
        count = 0;
        for (Hero h: team) {
            if (h.isDead()) {
                count = count + 1;
            }
        }
        return count;
    }

    /*
     * EFFECTS : return the string of hero name and health
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Hero hero: team) {
            stringBuilder.append("Hero name: ").append(hero.getName());
            stringBuilder.append(", health: ").append(hero.getHealth());
            stringBuilder.append(", power: ").append(hero.getAttackPower());
            stringBuilder.append(";");
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    // TODO: NEED TEST
    public JSONObject toJson() {
        JSONObject j = new JSONObject();
        j.put("name",name);
        j.put("Heroes",teamToJson());
        return j;
    }

    // EFFECTS: returns hero in this team as a JSON array
    // TODO: NEED TEST
    private JSONArray teamToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Hero h: team) {
            jsonArray.put(h.toJson());
        }

        return jsonArray;
    }

}
