package assignment;

import java.util.List;
import java.util.*;
import java.io.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/* 
 * Any comments and methods here are purely descriptions or suggestions.
 * This is your test file. Feel free to change this as much as you want.
 */


public class InterpreterTest {

    // This will run ONCE before all other tests. It can be useful to setup up
    // global variables and anything needed for all of the tests.
    @BeforeAll
    static void setupAll() {

    }

    // This will run before EACH test.
    @BeforeEach
    void setupEach() {

    }

    // You can test execute critter here. You may want to make additional tests and
    // your own testing harness. See spec section 2.5 for more details.
    @Test
    void testExecuteCritter() {
     
    }

    // void testIfEnemy() {
    //  CritterTest testCritter = new CritterTest ("species\\FlyTrap.cri");
    //  testCritter.setCellContent(Critter.ENEMY);
    //  Interpreter interpreter = new Interpreter();
    //  interpreter.executeCritter(testCritter);
    //  Assert.assertTrue(testCritter.getNextCodeLine() == 10);
    // }

    // void testIfAlly() {
    //  CritterTest testCritter = new CritterTest ("species\\FlyTrap.cri");
    //  testCritter.setCellContent(Critter.ALLY);
    //  Interpreter interpreter = new Interpreter();
    //  interpreter.executeCritter(testCritter);
    //  Assert.assertTrue(testCritter.getNextCodeLine() == 10);
    // }

    // void testIfWALL() {
    //  CritterTest testCritter = new CritterTest ("species\\FlyTrap.cri");
    //  testCritter.setCellContent(Critter.WALL);
    //  Interpreter interpreter = new Interpreter();
    //  interpreter.executeCritter(testCritter);
    //  Assert.assertTrue(testCritter.getNextCodeLine() == 10);
    // }

    // void testGo() {
    //  CritterTest testCritter = new CritterTest ("species\\FlyTrap.cri");
    //  Interpreter interpreter = new Interpreter();
    //  interpreter.executeCritter(testCritter);
    //  Assert.assertTrue(testCritter.getNextCodeLine() == 10);
    // }

    // void testHungry() {
    //  CritterTest testCritter = new CritterTest ("species\\FlyTrap.cri");
    //  testCritter.setHungerLevel(HungerLevel.HUNGRY);
    //  Interpreter interpreter = new Interpreter();
    //  interpreter.executeCritter(testCritter);
    //  Assert.assertTrue(testCritter.getNextCodeLine() == 10);
    // }

    // void testAngle() {
    //  CritterTest testCritter = new CritterTest ("species\\FlyTrap.cri");
    //  testCritter.setHungerLevel(HungerLevel.ALLY);
    //  Interpreter interpreter = new Interpreter();
    //  interpreter.executeCritter(testCritter);
    //  Assert.assertTrue(testCritter.getNextCodeLine() == 10);
    // }

    // void testWrite() {
    //  CritterTest testCritter = new CritterTest ("species\\FlyTrap.cri");
    //  Interpreter interpreter = new Interpreter();
    //  interpreter.executeCritter(testCritter);
    //  Assert.assertTrue(testCritter.getReg(1) == 3);
    // }

    // void testAdd() {
    //  CritterTest testCritter = new CritterTest ("species\\FlyTrap.cri");
    //  Interpreter interpreter = new Interpreter();
    //  interpreter.executeCritter(testCritter);
    //  interpreter.executeCritter(testCritter);
    //  interpreter.executeCritter(testCritter);
    //  Assert.assertTrue(testCritter.getReg(1) == 3);
    // }

    // void testInc() {
    //  CritterTest testCritter = new CritterTest ("species\\FlyTrap.cri");
    //  Interpreter interpreter = new Interpreter();
    //  interpreter.executeCritter(testCritter);
    //  Assert.assertTrue(testCritter.getReg(1) == 3);
    // }

    // void testifLT() {
    //  CritterTest testCritter = new CritterTest ("species\\FlyTrap.cri");
    //  Interpreter interpreter = new Interpreter();
    //  interpreter.executeCritter(testCritter);
    //  Assert.assertTrue(testCritter.getNextCodeLine(1) == 3);
    // }

    // Test load species. You may want to make more tests for different cases here.
    @Test
    void testLoadSpecies() {
        // CritterTest testCritter = new CritterTest("species\\Rover.cri");
        // Assert.assertTrue(testCritter.getNextCodeLine()==0);
    }

    
}
