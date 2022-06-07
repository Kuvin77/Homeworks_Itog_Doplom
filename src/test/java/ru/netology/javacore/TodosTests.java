package ru.netology.javacore;

import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class TodosTests {

    Todos todos = new Todos();
    public static int i = 1;
    public List<String> list = new ArrayList<>();

    @BeforeAll
    public static void started() {
        System.out.println("Start tests");
    }

    @BeforeEach
    public void startTest() {
        System.out.println("Start test " + i);
    }

    @AfterEach
    public void finishTest() {
        System.out.println("Finish test " + i);
        i++;
    }

    @AfterAll
    public static void finished() {
        System.out.println("Testing finish");
    }

    @Test
    public void testAddTask(){
        todos.addTask("A");
        boolean actual = todos.getAllTask().contains("A");
        Assertions.assertTrue(actual);
    }

    @Test
    public void testRemoveTask2(){
        todos.addTask("B");
        todos.removeTask("B");
        Assertions.assertTrue(todos.list.isEmpty());
    }
    @Test
    public void testGetAllTask(){
        String expected = "A" + " " + "B" + " " + "C" +" ";
        todos.addTask("C");
        todos.addTask("B");
        todos.addTask("A");
        Assertions.assertEquals(expected, todos.getAllTask());
    }

    @Test
    public void testGetAllTaskError(){
        String expected = "V" + " " + "D" + " " + "S" +" ";
        todos.addTask("C");
        todos.addTask("B");
        todos.addTask("A");
        Assertions.assertNotEquals(expected, todos.getAllTask());
    }


}
