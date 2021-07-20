package persostence;

import model.*;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Team team = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
        }
    }

    @Test
    void testReaderEmptyTeam() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyTeam.json");
        try {
            Team team = reader.read();
            assertEquals("Empty team", team.getName());
            assertEquals(0, team.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralTeam() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralTeam.json");
        try {
            Team team = reader.read();
            assertEquals("Simon's team",team.getName());
            List<Hero> heroes = team.getTeam();
            assertEquals(2,team.size());
            checkHero("killer",200,team.getTeam().get(0));
            checkHero("noob",1,team.getTeam().get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
