package persostence;

import model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class JsonTest {
    protected void  checkHero(String name, int health, Hero hero) {
        assertEquals(name, hero.getName());
        assertEquals(health, hero.getHealth());
    }
}
