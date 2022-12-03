package com.example.demo;

import org.junit.jupiter.api.*;

import static com.example.demo.GameController3x3.*;

public class GameTests {
    Logic3x3 gameLogic3x3 = new Logic3x3();

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
                        gameLogic3x3.setValue(y, x, player);
                    }
                    Assertions.assertTrue(gameLogic3x3.verifyWhoWon()); // tests for lines
                    gameLogic3x3.clearBoard();
                }
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        gameLogic3x3.setValue(y, x, player);
                    }
                    System.out.println(gameLogic3x3.verifyWhoWon());
                    Assertions.assertTrue(gameLogic3x3.verifyWhoWon()); // tests for columns
                    gameLogic3x3.clearBoard();
                }
                gameLogic3x3.setValue(0,0,player);
                gameLogic3x3.setValue(1,1,player);
                gameLogic3x3.setValue(2,2,player);
                Assertions.assertTrue(gameLogic3x3.verifyWhoWon());     // tests for cross win
                gameLogic3x3.clearBoard();

                gameLogic3x3.setValue(0,2,player);
                gameLogic3x3.setValue(1,1,player);
                gameLogic3x3.setValue(2,0,player);
                Assertions.assertTrue(gameLogic3x3.verifyWhoWon());
                gameLogic3x3.clearBoard();
            }
        }

        @Test
        void testDraw3x3() {
            int turnsX = 0;
            int turnsO = 0;
            GameController3x3 gameController3x3 = new GameController3x3();
            gameController3x3.setterController = true;

            gameController3x3.onMouseClicked(gameController3x3.cross111, gameController3x3.cross112, gameController3x3.circle11);  //X
            if (player == 1) {
                turnsX++;
            } else {
                turnsO++;
            }
            gameController3x3.onMouseClicked(gameController3x3.cross211, gameController3x3.cross212, gameController3x3.circle21);  //O
            if (player == 1) {
                turnsX++;
            } else {
                turnsO++;
            }
            gameController3x3.onMouseClicked(gameController3x3.cross121, gameController3x3.cross122, gameController3x3.circle12);  //X
            if (player == 1) {
                turnsX++;
            } else {
                turnsO++;
            }
            gameController3x3.onMouseClicked(gameController3x3.cross221, gameController3x3.cross222, gameController3x3.circle22);  //O
            if (player == 1) {
                turnsX++;
            } else {
                turnsO++;
            }
            gameController3x3.onMouseClicked(gameController3x3.cross231, gameController3x3.cross232, gameController3x3.circle23);  //X
            if (player == 1) {
                turnsX++;
            } else {
                turnsO++;
            }
            gameController3x3.onMouseClicked(gameController3x3.cross131, gameController3x3.cross132, gameController3x3.circle13);  //O
            if (player == 1) {
                turnsX++;
            } else {
                turnsO++;
            }
            gameController3x3.onMouseClicked(gameController3x3.cross331, gameController3x3.cross332, gameController3x3.circle33);  //X
            if (player == 1) {
                turnsX++;
            } else {
                turnsO++;
            }
            gameController3x3.onMouseClicked(gameController3x3.cross321, gameController3x3.cross322, gameController3x3.circle32);  //O
            if (player == 1) {
                turnsX++;
            } else {
                turnsO++;
            }
            gameController3x3.onMouseClicked(gameController3x3.cross311, gameController3x3.cross312, gameController3x3.circle31);  //X
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
