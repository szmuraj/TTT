package com.example.demo;

import org.junit.jupiter.api.*;

import static com.example.demo.GameController.*;

public class GameTests {
    Logic gameLogic = new Logic();

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: BEGIN");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: END");
    }

    @Nested
    @DisplayName("Test for game logic")
    class test3x3 {
        @Test
        void testWin3x3() {
            for (int player = 1; player < 3; player++) {
                for (int y = 0; y < 3; y++) {
                    for (int x = 0; x < 3; x++) {
                        gameLogic.setValue(y, x, player);
                    }
                    Assertions.assertTrue(gameLogic.verifyWhoWon()); // tests for lines
                    gameLogic.clearBoard();
                }
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        gameLogic.setValue(y, x, player);
                    }
                    System.out.println(gameLogic.verifyWhoWon());
                    Assertions.assertTrue(gameLogic.verifyWhoWon()); // tests for columns
                    gameLogic.clearBoard();
                }
                gameLogic.setValue(0,0,player);
                gameLogic.setValue(1,1,player);
                gameLogic.setValue(2,2,player);
                Assertions.assertTrue(gameLogic.verifyWhoWon());     // tests for cross win
                gameLogic.clearBoard();

                gameLogic.setValue(0,2,player);
                gameLogic.setValue(1,1,player);
                gameLogic.setValue(2,0,player);
                Assertions.assertTrue(gameLogic.verifyWhoWon());
                gameLogic.clearBoard();
            }
        }

        @Test
        void testDraw3x3() {
            int turnsX = 0;
            int turnsO = 0;
            GameController gameController = new GameController();
            gameController.setterController = true;

            gameController.onMouseClicked(gameController.cross111, gameController.cross112, gameController.circle11);  //X
            if (player == 1) {
                turnsX++;
            } else {
                turnsO++;
            }
            gameController.onMouseClicked(gameController.cross211, gameController.cross212, gameController.circle21);  //O
            if (player == 1) {
                turnsX++;
            } else {
                turnsO++;
            }
            gameController.onMouseClicked(gameController.cross121, gameController.cross122, gameController.circle12);  //X
            if (player == 1) {
                turnsX++;
            } else {
                turnsO++;
            }
            gameController.onMouseClicked(gameController.cross221, gameController.cross222, gameController.circle22);  //O
            if (player == 1) {
                turnsX++;
            } else {
                turnsO++;
            }
            gameController.onMouseClicked(gameController.cross231, gameController.cross232, gameController.circle23);  //X
            if (player == 1) {
                turnsX++;
            } else {
                turnsO++;
            }
            gameController.onMouseClicked(gameController.cross131, gameController.cross132, gameController.circle13);  //O
            if (player == 1) {
                turnsX++;
            } else {
                turnsO++;
            }
            gameController.onMouseClicked(gameController.cross331, gameController.cross332, gameController.circle33);  //X
            if (player == 1) {
                turnsX++;
            } else {
                turnsO++;
            }
            gameController.onMouseClicked(gameController.cross321, gameController.cross322, gameController.circle32);  //O
            if (player == 1) {
                turnsX++;
            } else {
                turnsO++;
            }
            gameController.onMouseClicked(gameController.cross311, gameController.cross312, gameController.circle31);  //X
            if (player == 1) {
                turnsX++;
            } else {
                turnsO++;
            }

            System.out.println(turnsX);
            Assertions.assertEquals(5, turnsX);
            Assertions.assertEquals(4, turnsO);

        }
    }
}
