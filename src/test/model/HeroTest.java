package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HeroTest {
    private Hero myHero1;
    private Hero myHero2;
    private Hero myHero3;


    @BeforeEach
    void runBefore(){
        myHero1 = new Hero("Venus",100,10,1,"Wizard",false);
        myHero2 = new Hero("Apollo",120,15,1,"Cleric",false);
        myHero3 = new Hero("Mars",50,99,1,"Ranger",false);
    }

    @Test
    void testGetName(){
        assertEquals("Venus",myHero1.getName());
        assertEquals("Apollo",myHero2.getName());
        assertEquals("Mars",myHero3.getName());

    }

    @Test
    void testSetName(){
        assertEquals("Venus",myHero1.getName());
        myHero1.setName("Nice");
        assertEquals("Nice",myHero1.getName());

        assertEquals("Apollo",myHero2.getName());
        myHero2.setName("Simon");
        assertEquals("Simon",myHero2.getName());
    }

    @Test
    void testGetHealth(){
        assertEquals(100,myHero1.getHealth());
        assertEquals(120,myHero2.getHealth());
        assertEquals(50,myHero3.getHealth());
    }

    @Test
    void testSetHealth(){
        assertEquals(100,myHero1.getHealth());
        myHero1.setHealth(200);
        assertEquals(200,myHero1.getHealth());
        assertEquals(120,myHero2.getHealth());
        myHero2.setHealth(120);
        assertEquals(120,myHero2.getHealth());
    }

    @Test
    void testGetAttackPower(){
        assertEquals(10,myHero1.getAttackPower());
        assertEquals(15,myHero2.getAttackPower());
    }

    @Test
    void testSetAttackPower(){
        assertEquals(10,myHero1.getAttackPower());
        myHero1.setAttackPower(100);
        assertEquals(100,myHero1.getAttackPower());

        assertEquals(15,myHero2.getAttackPower());
        myHero2.setAttackPower(20);
        assertEquals(20,myHero2.getAttackPower());

    }

    @Test
    void testGetLevel(){
        assertEquals(1,myHero1.getLevel());
        assertEquals(1,myHero2.getLevel());
    }

    @Test
    void testSetLevel(){
        assertEquals(1,myHero1.getLevel());
        myHero1.setLevel(10);
        assertEquals(10,myHero1.getLevel());

        assertEquals(1,myHero2.getLevel());
        myHero2.setLevel(11);
        assertEquals(11,myHero2.getLevel());

    }

    @Test
    void testGetOccupation(){
        assertEquals("Wizard",myHero1.getOccupation());
        assertEquals("Cleric",myHero2.getOccupation());
    }

    @Test
    void testSetOccupation(){
        assertEquals("Wizard",myHero1.getOccupation());
        myHero1.setOccupation("Thief");
        assertEquals("Thief",myHero1.getOccupation());


        assertEquals("Cleric",myHero2.getOccupation());
        myHero2.setOccupation("No");
        assertEquals("No",myHero2.getOccupation());
    }

    @Test
    void testIsDead(){
        assertFalse(myHero1.isDead());
        assertFalse(myHero2.isDead());
    }

    @Test
    void testSetDead(){
        assertFalse(myHero1.isDead());
        myHero1.setDead(true);
        assertTrue(myHero1.isDead());

        assertFalse(myHero2.isDead());
        myHero2.setDead(true);
        assertTrue(myHero2.isDead());


    }






}
