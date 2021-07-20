package ui;

import model.Battle;
import model.Hero;
import model.Monster;
import model.Team;

import persistence.JsonReader;
import persistence.JsonWriter;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

//  Game application
public class GameApp {

    private static final  String JSON_STORE = "./data/team.json";
    private Monster boss;
    private Hero hero;
    private Battle battle;
    private Scanner input;
    private Team team;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: ru the  game application
    public GameApp() throws FileNotFoundException {
        initializeFields();
        runGame();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runGame() {
        boolean keepGoing = true;
        String command = null;

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nSee you next time!");
    }

    // MODIFIES: this
    // EFFECTS: process user command
    private void processCommand(String command) {
        if (command.equals("c")) {
            doCreate();
        } else if (command.equals("v")) {
            doViewTeam();
        } else if (command.equals("b")) {
            doBattle();
        } else if (command.equals("s")) {
            saveTeam();
        } else if (command.equals("l")) {
            loadTeam();
        } else {
            System.out.println("Selection not valid!");
        }
    }

    // MODIFIES: this
    // EFFECTS: loads team from file
    private void loadTeam() {
        try {
            team = jsonReader.read();
            System.out.println("Loaded " + team.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    // EFFECTS : saves the team to the file
    private void saveTeam() {
        try {
            jsonWriter.open();
            jsonWriter.write(team);
            jsonWriter.close();
            System.out.println("Saved " + team.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }


    // MODIFIES: this
    // EFFECTS: make team and monster battle
    private void doBattle() {
        System.out.println("Now! It's Time!");
        System.out.println("Team vs Monster");
        battle.addPlayer(team);
        System.out.println(battle.attack());
    }

    // MODIFIES: this
    // EFFECTS: view the team
    private void doViewTeam() {
        if (team.size() == 0) {
            System.out.println("No hero in team!");
        } else {
            System.out.println("This is the team: " + "\n" + team.toString() + " ");

        }

    }

    // MODIFIES: this
    // EFFECTS: create new hero then add into team auto
    private void doCreate() {
        if (team.size() < 4) {
            hero = new Hero("", 0, 0, 1, "", false);
            System.out.println("Give your hero a name:");
            String name = input.next();

            if (!name.isEmpty()) {
                hero.setName(name);
            } else {
                doCreate();
            }
            setHeroHealth();
        } else {
            System.out.println("Sorry your team is full");
        }
    }

    // MODIFIES: this
    // EFFECTS: set hero health value
    private void setHeroHealth() {
        System.out.println("Set your hero health value:");
        System.out.println("in range [1 - 200]");
        System.out.println("num only");
        int amount = input.nextInt();
        if (inHealthRange(amount)) {
            hero.setHealth(amount);
        } else {
            System.out.println("Sorry invalid input");
            setHeroHealth();
        }
        setHeroAttackPower();


    }

    // MODIFIES: this
    // EFFECTS: set hero attack power value
    private void setHeroAttackPower() {
        System.out.println("Set your hero attack power:");
        System.out.println("in range [0-100]");
        System.out.println("num only");
        int amount = input.nextInt();
        if (inAttackPower(amount)) {
            hero.setAttackPower(amount);
        } else {
            System.out.println("Sorry invalid input");
            setHeroAttackPower();
        }
        setHeroOccupation();
    }

    // MODIFIES: this
    // EFFECTS: set hero an occupation
    private void setHeroOccupation() {
        System.out.println("What's your hero's occupation?");
        String name = input.next();
        hero.setOccupation(name);
        team.addHero(hero);
        System.out.println("Hero have been created and join in team");
        runGame();
    }


    // MODIFIES: this
    // EFFECTS: display menu of option for player
    private void displayMenu() {
        System.out.println("\nWelcome to Hero Monster Battle!");
        System.out.println("\nSelect from :");
        System.out.println("\tc -> Create New Hero");
        System.out.println("\tv -> View Team");
        System.out.println("\tb -> Battle");
        System.out.println("\ts -> Save team to file");
        System.out.println("\tl -> Load team from file");
        System.out.println("\tq -> Quit");

    }

    // MODIFIES: this
    // EFFECTS: initialize the team
    private void initializeFields() {
        this.team = new Team("Simon's team");
        this.boss = new Monster("T-2000", 250, 50, false);
        input = new Scanner(System.in);
        this.battle = new Battle();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    // EFFECTS: return true if num in range
    private boolean inHealthRange(int num) {
        return num >= 1 && num <= 200;
    }

    // EFFECTS: return true if num in range
    private boolean inAttackPower(int num) {
        return num >= 0 && num <= 100;
    }


}
