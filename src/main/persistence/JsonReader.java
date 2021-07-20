package persistence;

import model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

public class JsonReader {
    private String source;

    // Represents a reader that reads team from JSON data stored in file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads team from file and return it, throws IOException if an error occurs
    public Team read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseTeam(jsonObject);
    }

    // EFFECTS: reads source file as string and return it
    private String readFile(String source) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> stringBuilder.append(s));
        }
        return stringBuilder.toString();
    }

    // EFFECTS: parses team from JSON object and returns it
    private Team parseTeam(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Team team = new Team(name);
        addTeam(team,jsonObject);
        return team;
    }

    // MODIFIES: team
    // EFFECTS: parses hero from JSON object and adds them to team
    private void addTeam(Team team, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("Heroes");
        for (Object json : jsonArray) {
            JSONObject nextHero = (JSONObject) json;
            addHero(team,nextHero);
        }
    }

    // MODIFIES: team
    // EFFECTS: parses Hero from JSON object and adds it to workroom
    private void addHero(Team team, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int health = jsonObject.getInt("health");
        int attack = jsonObject.getInt("attackPower");
        int level = jsonObject.getInt("level");
        String occupation = jsonObject.getString("occupation");
        boolean isDead = jsonObject.getBoolean("isDead");
        Hero hero = new Hero(name,health,attack,level,occupation,isDead);
        team.addHero(hero);
    }
}
