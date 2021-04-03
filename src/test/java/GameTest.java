import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Game game = new Game();

    private static Stream<Arguments> allWinInput() {
        return Stream.of(
                Arguments.of("rock", "scissors", "Player 1 win!"),
                Arguments.of("paper", "rock", "Player 1 win!"),
                Arguments.of("scissors", "paper", "Player 1 win!")
        );
    }

    private static Stream<Arguments> allLoseInput() {
        return Stream.of(
                Arguments.of("scissors", "rock" ,"Player 2 win!"),
                Arguments.of("rock", "paper", "Player 2 win!"),
                Arguments.of("paper", "scissors", "Player 2 win!")
        );
    }

    private static Stream<Arguments> allDrawInput() {
        return Stream.of(
                Arguments.of("rock", "rock", "Draw!"),
                Arguments.of("paper", "paper", "Draw!"),
                Arguments.of("scissors", "scissors", "Draw!")
        );
    }

    private static Stream<Arguments> validInput() {
        return Stream.of(
                Arguments.of("rock"),
                Arguments.of("paper"),
                Arguments.of("scissors")
        );
    }

    private static Stream<Arguments> invalidInput() {
        return Stream.of(
                Arguments.of("Rock"),
                Arguments.of("paper!"),
                Arguments.of("scisors")
        );
    }

    @ParameterizedTest(name = "#{index} - Test with argument={0}, {1}, {2}")
    @MethodSource("allWinInput")
    void winCaseTest(String p1, String p2, String expectOutput) {
        assertEquals(expectOutput, game.winnerIs(p1, p2));
    }

    @ParameterizedTest(name = "#{index} - Test with argument={0}, {1}, {2}")
    @MethodSource("allLoseInput")
    void loseCaseTest(String p1, String p2, String expectOutput) {
        assertEquals(expectOutput, game.winnerIs(p1, p2));
    }

    @ParameterizedTest(name = "#{index} - Test with argument={0}, {1}, {2}")
    @MethodSource("allDrawInput")
    void drawCaseTest(String p1, String p2, String expectOutput) {
        assertEquals(expectOutput, game.winnerIs(p1, p2));
    }

    @ParameterizedTest(name = "#{index} - Test with argument={0}")
    @MethodSource("validInput")
    void validInputTest(String input) {
        assertDoesNotThrow(() -> {
            game.inputCheck(input);
        });
    }

    @ParameterizedTest(name = "#{index} - Test with argument={0}")
    @MethodSource("invalidInput")
    void invalidInputTest(String input) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            game.inputCheck(input);
        });

        String expectedMsg = "Bad Choice!";
        String actualMsg = exception.getMessage();
        assertTrue(actualMsg.contains(expectedMsg));
    }
}