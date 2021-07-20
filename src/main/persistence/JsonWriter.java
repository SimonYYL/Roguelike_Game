package persistence;

import model.Team;
import org.json.JSONObject;

import java.io.*;

// Represents a writer that writes JSON representation of team to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // MODIFIES : this
    // EFFECTS: opens writer; throws FileNotException if destination file can not open and write
    public  void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // MODIFIES: this
    // EFFECTS:  writes JSON representation of team to file
    public void write(Team team) {
        JSONObject j = team.toJson();
        saveToFile(j.toString(TAB));
    }

    // MODIFIES: this
    // MODIFIES: closes writer
    public  void close() {
        writer.close();
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private  void saveToFile(String j) {
        writer.print(j);
    }
}
