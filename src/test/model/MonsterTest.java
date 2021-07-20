package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MonsterTest {
    private Monster monster1;
    private Monster monster2;
    private Monster monster3;

    @BeforeEach
    void runBefore(){
        monster1 = new Monster("T-2000",3000,1,false);
        monster2 = new Monster("Erebus",50,2000,false);
        monster3 = new Monster("Jacker",100,20,false);
    }
    @Test
    void testGetName(){
        assertEquals("Jacker",monster3.getName());
        assertEquals("Erebus",monster2.getName());
        assertEquals("T-2000",monster1.getName());
    }

    @Test
    void testSetName(){
        assertEquals("Jacker",monster3.getName());
        monster3.setName("Darkness");
        assertEquals("Darkness",monster3.getName());
        assertEquals("Erebus",monster2.getName());
        monster2.setName("T-X");
        assertEquals("T-X",monster2.getName());
    }

    @Test
    void testGetHealth(){
        assertEquals(3000,monster1.getHealth());
        assertEquals(50,monster2.getHealth());
    }

    @Test
    void testSetHealth(){
        assertEquals(3000,monster1.getHealth());
        monster1.setHealth(6000);
        assertEquals(6000,monster1.getHealth());

        assertEquals(50,monster2.getHealth());
        monster2.setHealth(10);
        assertEquals(10,monster2.getHealth());

    }
    @Test
    void testGetAttackPower(){
        assertEquals(1,monster1.getAttackPower());
        assertEquals(2000,monster2.getAttackPower());
    }

    @Test
    void testSetAttackPower(){
        assertEquals(1,monster1.getAttackPower());
        monster1.setAttackPower(100);
        assertEquals(100,monster1.getAttackPower());

        assertEquals(2000,monster2.getAttackPower());
        monster2.setAttackPower(20);
        assertEquals(20,monster2.getAttackPower());

    }
    @Test
    void testIsDead(){
        assertFalse(monster2.isDead());
        assertFalse(monster1.isDead());
    }

    @Test
    void testSetDead(){
        assertFalse(monster1.isDead());
        monster1.setDead(true);
        assertTrue(monster1.isDead());

        assertFalse(monster2.isDead());
        monster2.setDead(true);
        assertTrue(monster2.isDead());


    }



}
