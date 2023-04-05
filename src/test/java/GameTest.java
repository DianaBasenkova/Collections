import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player Sergey = new Player(1, "Sergey", 10);
    Player Anton = new Player(2, "Anton", 5);
    Player Alexandr = new Player(3, "Alexandr", 4);
    Player Roman = new Player(4, "Roman", 6);
    Player Grigory = new Player(5, "Grigory", 10);
    Player Harry = new Player(6, "Harry", 7);

    @Test
    public void firstPlayerWin() {
        Game manager = new Game();
        manager.register(Sergey);
        manager.register(Harry);
        int expected = 1;
        int actual = manager.round("Sergey", "Harry");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWin() {
        Game manager = new Game();
        manager.register(Alexandr);
        manager.register(Grigory);
        int expected = 2;
        int actual = manager.round("Alexandr", "Grigory");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void drawGame() {
        Game manager = new Game();
        manager.register(Sergey);
        manager.register(Grigory);
        int expected = 0;
        int actual = manager.round("Sergey", "Grigory");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void throwExceptionFirstPlayer() {
        Game manager = new Game();
        manager.register(Grigory);
        manager.register(Roman);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            manager.round("Anton", "Harry");
        });
    }

    @Test
    public void throwExceptionSecondPlayer() {
        Game manager = new Game();
        manager.register(Anton);
        manager.register(Roman);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            manager.round("Anton", "Harry");
        });


    }
}
