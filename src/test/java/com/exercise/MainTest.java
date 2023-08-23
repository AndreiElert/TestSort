package com.exercise;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;

class MainTest {
    public File fileAct = new File("testFiles/out.txt");
    public File fileExp;
    public String[] arguments;

    @AfterEach
    void endCheck() {
        Main.main(arguments);
        try {
            boolean isTwoEqual = FileUtils.contentEquals(fileExp, fileAct);
            Assertions.assertTrue(isTwoEqual);
        } catch (IOException e) {
            Assertions.fail();
        } finally {
            fileAct.delete();
        }
    }

    @Test
    void mainTest1() {
        arguments = new String[] {"-i", "-a", "testFiles/out.txt", "testFiles/in1.txt", "testFiles/in2.txt", "testFiles/in3.txt"};
        fileExp = new File("testFiles/outTest1.txt");
    }

    @Test
    void mainTest2() throws IOException {
        arguments = new String[] {"-i", "-d", "testFiles/out.txt", "testFiles/in4.txt", "testFiles/in5.txt", "testFiles/in6.txt"};
        fileExp = new File("testFiles/outTest2.txt");
    }

    @Test
    void mainTest3() throws IOException {
        arguments = new String[] {"-i", "testFiles/out.txt", "testFiles/in1.txt", "testFiles/in3.txt", "testFiles/in5.txt"};
        fileExp = new File("testFiles/outTest3.txt");
    }

    @Test
    void mainTest4() throws IOException {
        arguments = new String[] {"-s", "-a", "testFiles/out.txt", "testFiles/in7.txt", "testFiles/in8.txt", "testFiles/in9.txt"};
        fileExp = new File("testFiles/outTest4.txt");
    }

    @Test
    void mainTest5() throws IOException {
        arguments = new String[] {"-s", "-d", "testFiles/out.txt", "testFiles/in10.txt", "testFiles/in11.txt"};
        fileExp = new File("testFiles/outTest5.txt");
    }

    @Test
    void mainTest6() throws IOException {
        arguments = new String[] {"-s", "-i", "testFiles/out.txt", "testFiles/in8.txt", "testFiles/in12.txt"};
        fileExp = new File("testFiles/outTest6.txt");
    }

    @Test
    void mainTest7() throws IOException {
        arguments = new String[] {"-s", "testFiles/out.txt", "testFiles/in5.txt", "testFiles/in7.txt", "testFiles/in8.txt", "testFiles/in12.txt"};
        fileExp = new File("testFiles/outTest7.txt");
    }
}