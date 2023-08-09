package com.exercise;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class MainTest {

    @Test
    void mainTest1() throws IOException {
        String[] arguments = new String[] {"-i", "-a", "testFiles/out.txt", "testFiles/in1.txt", "testFiles/in2.txt", "testFiles/in3.txt"};
        Main.main(arguments);
        File fileExp = new File("testFiles/outTest1.txt");
        File fileAct = new File("testFiles/out.txt");
        boolean isTwoEqual = FileUtils.contentEquals(fileExp, fileAct);
        Assertions.assertTrue(isTwoEqual);
        fileAct.delete();
    }

    @Test
    void mainTest2() throws IOException {
        String[] arguments = new String[] {"-i", "-d", "testFiles/out.txt", "testFiles/in4.txt", "testFiles/in5.txt", "testFiles/in6.txt"};
        Main.main(arguments);
        File fileExp = new File("testFiles/outTest2.txt");
        File fileAct = new File("testFiles/out.txt");
        boolean isTwoEqual = FileUtils.contentEquals(fileExp, fileAct);
        Assertions.assertTrue(isTwoEqual);
        fileAct.delete();
    }

    @Test
    void mainTest3() throws IOException {
        String[] arguments = new String[] {"-i", "testFiles/out.txt", "testFiles/in1.txt", "testFiles/in3.txt", "testFiles/in5.txt"};
        Main.main(arguments);
        File fileExp = new File("testFiles/outTest3.txt");
        File fileAct = new File("testFiles/out.txt");
        boolean isTwoEqual = FileUtils.contentEquals(fileExp, fileAct);
        Assertions.assertTrue(isTwoEqual);
        fileAct.delete();
    }

    @Test
    void mainTest4() throws IOException {
        String[] arguments = new String[] {"-s", "-a", "testFiles/out.txt", "testFiles/in7.txt", "testFiles/in8.txt", "testFiles/in9.txt"};
        Main.main(arguments);
        File fileExp = new File("testFiles/outTest4.txt");
        File fileAct = new File("testFiles/out.txt");
        boolean isTwoEqual = FileUtils.contentEquals(fileExp, fileAct);
        Assertions.assertTrue(isTwoEqual);
        fileAct.delete();
    }

    @Test
    void mainTest5() throws IOException {
        String[] arguments = new String[] {"-s", "-d", "testFiles/out.txt", "testFiles/in10.txt", "testFiles/in11.txt"};
        Main.main(arguments);
        File fileExp = new File("testFiles/outTest5.txt");
        File fileAct = new File("testFiles/out.txt");
        boolean isTwoEqual = FileUtils.contentEquals(fileExp, fileAct);
        Assertions.assertTrue(isTwoEqual);
        fileAct.delete();
    }

    @Test
    void mainTest6() throws IOException {
        String[] arguments = new String[] {"-s", "-i", "testFiles/out.txt", "testFiles/in8.txt", "testFiles/in12.txt"};
        Main.main(arguments);
        File fileExp = new File("testFiles/outTest6.txt");
        File fileAct = new File("testFiles/out.txt");
        boolean isTwoEqual = FileUtils.contentEquals(fileExp, fileAct);
        Assertions.assertTrue(isTwoEqual);
        fileAct.delete();
    }

    @Test
    void mainTest7() throws IOException {
        String[] arguments = new String[] {"-s", "testFiles/out.txt", "testFiles/in5.txt", "testFiles/in7.txt", "testFiles/in8.txt", "testFiles/in12.txt"};
        Main.main(arguments);
        File fileExp = new File("testFiles/outTest7.txt");
        File fileAct = new File("testFiles/out.txt");
        boolean isTwoEqual = FileUtils.contentEquals(fileExp, fileAct);
        Assertions.assertTrue(isTwoEqual);
        fileAct.delete();
    }

}