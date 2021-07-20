package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TeamTest {
    private Team teamGroup1;
    private Team teamGroup2;
    private static final int MAX_MEMBER_IN_A_TEAM = 4;
    private Hero sampleHero1;
    private Hero sampleHero2;
    private Hero sampleHero3;

    @BeforeEach
    void runBefore(){
        teamGroup1 = new Team("team1");
        teamGroup2 = new Team("team2");
        sampleHero1 = new Hero("Good boy",100,10,1,"Hacker",false);
        sampleHero2 = new Hero("Mike",40,12,1,"Unknown",false);
        sampleHero3 = new Hero("Simon",40,12,1,"Unknown",true);
    }



    @Test
    void  testAddHero(){
        assertEquals(0,teamGroup1.size());
        teamGroup1.addHero(sampleHero1);
        assertEquals(1,teamGroup1.size());

        assertEquals(0,teamGroup2.size());
        teamGroup2.addHero(sampleHero1);
        teamGroup2.addHero(sampleHero1);
        teamGroup2.addHero(sampleHero1);
        teamGroup2.addHero(sampleHero2);
        teamGroup2.addHero(sampleHero1);
        assertEquals(4,teamGroup2.size());
        assertTrue(teamGroup2.checkContain(sampleHero2));
    }

    @Test
    void testRemoveHero(){
        assertEquals(0,teamGroup1.size());
        teamGroup1.addHero(sampleHero3);
        assertEquals(1,teamGroup1.size());
        teamGroup1.removeDeadHero(sampleHero3);
        assertEquals(0,teamGroup1.size());


        assertEquals(0,teamGroup1.size());
        teamGroup1.addHero(sampleHero1);
        assertEquals(1,teamGroup1.size());
        teamGroup1.removeDeadHero(sampleHero1);
        assertEquals(1,teamGroup1.size());
    }


    @Test
    void testCheckContain(){
        assertEquals(0,teamGroup1.size());
        teamGroup1.addHero(sampleHero1);
        assertEquals(1,teamGroup1.size());
        assertTrue(teamGroup1.checkContain(sampleHero1));

        assertEquals(1,teamGroup1.size());
        teamGroup1.addHero(sampleHero2);
        assertEquals(2,teamGroup1.size());
        assertTrue(teamGroup1.checkContain(sampleHero2));

    }

    @Test
    void testSize(){
        teamGroup1.addHero(sampleHero1);
        teamGroup1.addHero(sampleHero2);
        assertEquals(2,teamGroup1.size());
    }

    @Test
    void testHowManyHeroDead(){
        teamGroup1.addHero(sampleHero1);
        teamGroup1.addHero(sampleHero3);
        assertEquals(1,teamGroup1.howManyHeroDead());

        teamGroup2.addHero(sampleHero1);
        assertEquals(0,teamGroup2.howManyHeroDead());
    }
    @Test
    void testToString(){
        assertEquals(0,teamGroup1.size());
        teamGroup1.addHero(sampleHero1);
        assertEquals(1,teamGroup1.size());
        assertEquals("Hero name: Good boy, health: 100, power: 10;" + "\n",teamGroup1.toString());

        assertEquals(0,teamGroup2.size());
        teamGroup2.addHero(sampleHero1);
        teamGroup2.addHero(sampleHero2);
        assertEquals(2,teamGroup2.size());
        assertEquals("Hero name: Good boy, health: 100, power: 10;\n" +
                        "Hero name: Mike, health: 40, power: 12;\n",
                teamGroup2.toString());
    }
    @Test
    void testGetName() {
        assertEquals("team1",teamGroup1.getName());
        assertEquals("team2",teamGroup2.getName());
    }

}
