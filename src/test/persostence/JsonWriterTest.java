package persostence;

import model.*;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Team team = new Team("your Team");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {

        }

    }

    @Test
    void testWriterEmptyTeam() {
        try {
            Team team = new Team("Empty team");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyTeam.json");
            writer.open();
            writer.write(team);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyTeam.json");
            team = reader.read();
            assertEquals("Empty team", team.getName());
            assertEquals(0,team.size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralTeam() {
        try {
            Team team = new Team("Simon's team");
            team.addHero(new Hero("noob",1,0,1,"",false));
            team.addHero(new Hero("killer",200,100,1,"",false));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralTeam.json");
            writer.open();
            writer.write(team);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralTeam.json");
            team = reader.read();
            assertEquals("Simon's team",team.getName());
            checkHero("noob",1,team.getTeam().get(0));
            checkHero("killer",200,team.getTeam().get(1));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
