package model;

import model.exceptions.MonsterAlreadyGoneException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.HttpRetryException;
import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.*;

public class BattleTest {
    private Team team1;
    private Team team2;
    private Team team3;
    private Monster monster1;
    private Monster monster2;
    private Monster monster3;
    private Hero sampleHero1;
    private Hero sampleHero2;
    private Hero sampleHero3;
    private Hero sampleHero4;
    private Battle battle1;
    private Battle battle2;
    private Battle battle3;

    @BeforeEach
    void runBefore(){
        team1 = new Team("team1");
        team2 = new Team("team2");
        team3 = new Team("team3");
        battle1 = new Battle();
        battle2 = new Battle();
        battle3 = new Battle();
        sampleHero1 = new Hero("Good boy",100,10,1,"Hacker",false);
        sampleHero2 = new Hero("Mike",40,12,1,"Unknown",false);
        sampleHero3 = new Hero("Simon",40,12,1,"Unknown",true);
        sampleHero4 = new Hero("J",10000,100,1,"Unknow",false);
        monster1 = new Monster("T-2000",250,50,false);
        monster2 = new Monster("Erebus",1,2000,false);
        monster3 = new Monster("Jacker",100,20,true);

    }

    @Test
    void testAttack(){
        // TODO: no hero, monster not dead
        battle1.attack();
        assertEquals("LOST!",battle3.attack());



        // TODO: have hero , monster not dead
        team2.addHero(sampleHero1);
        battle2.addPlayer(team2);
        battle2.attack();
        assertEquals(1,team2.size());
        assertEquals("LOST!",battle2.attack());

        // TODO: have hero, monster dead
        team3.addHero(sampleHero1);
        team3.addHero(sampleHero2);
        team3.addHero(sampleHero4);
        battle3.addPlayer(team3);
        battle3.attack();
        assertEquals("VICTORY!",battle3.attack());

    }


    @Test
    void testHeroAttackMonster() {
        // TODO: hero is dead already
        battle1.heroAttackMonster(monster1, sampleHero3);
        assertFalse(monster1.isDead());
        assertEquals(250, monster1.getHealth());


        // TODO: hero is alive and start battle, mosnter did not been killed
        battle2.heroAttackMonster(monster1, sampleHero1);
        assertEquals(250 - 10, monster1.getHealth());
        assertFalse(monster1.isDead());


        // TODO: hero is alive and start battle, monster been killed
        battle3.heroAttackMonster(monster2, sampleHero2);
        assertEquals(0, monster2.getHealth());
        assertTrue(monster2.isDead());
    }

    @Test
    void testMonsterAttackHero(){
        // TODO: monster itself is dead already
        try {
            battle1.monsterAttackHero(monster3,sampleHero1);
            fail();
            assertFalse(sampleHero1.isDead());
            assertEquals(100,sampleHero1.getHealth());
        } catch (MonsterAlreadyGoneException e) {

        }

        // TODO: monster is alive and attack hero, hero not been killed
        try {
            battle2.monsterAttackHero(monster1, sampleHero1);
            assertFalse(sampleHero1.isDead());
            assertEquals(50, sampleHero1.getHealth());
        } catch (MonsterAlreadyGoneException e) {
            fail();
        }



        // TODO: monster is alive and attack hero, hero been killed
        try {
            battle3.monsterAttackHero(monster2, sampleHero2);
            assertEquals(0, sampleHero2.getHealth());
            assertTrue(sampleHero2.isDead());
        } catch (MonsterAlreadyGoneException e) {
            fail();
        }
    }


}
