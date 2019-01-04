package co.test.bowlingtest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    private Game game;

    @Before
    public void init() {
        game = new Game();
    }

    private void rollMany(int rolls, int pins) {
        for (int rollIndex = 0; rollIndex < rolls; rollIndex++) {
            game.roll(pins);
        }
    }

    @Test
    public void test_game_isEmpty() {
        //Arrange
        //Act
        rollMany(20, 0);
        //Assert
        assertEquals(0, game.score());
    }

    @Test
    public void test_game_allOnes() {
        //Arrange
        //Act
        rollMany(20, 1);
        //Assert
        assertEquals(20, game.score());
    }

    @Test
    public void test_game_spare() {
        //Arrange
        //Act
        rollSpare();
        game.roll(2);


        rollMany(17, 0);
        //Assert
        assertEquals(14, game.score());
    }

    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }

    @Test
    public void test_game_strike() {
        //Arrange
        //Act
        game.roll(10);
        game.roll(4);
        game.roll(3);


        rollMany(16, 0);
        //Assert
        assertEquals(24, game.score());
    }

    @Test
    public void test_perfectGame() {
        //Arrange
        //Act

        rollMany(11, 10);
        //Assert
        assertEquals(300, game.score());
    }

    @Test
    public void test_goodGame() {
        //Arrange
        //Act

        rollMany(9, 10);
        game.roll(2);
        game.roll(1);
        //Assert
        assertEquals(248, game.score());
    }

    @Test
    public void test_allSpare() {
        //Arrange

        //Act
        rollMany(21, 5);

        //Assert
        assertEquals(150, game.score());
    }


}