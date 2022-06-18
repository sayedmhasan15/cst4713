package edu.citytech.cst.webdev;

import com.citytech.games.thegame.business.GameService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class T1_TicTacToe {

    @ParameterizedTest
    @CsvSource({
            "XXXNNNNNN, true",
            "NXXNNNNNN, false",
            "ONNXONNXO, true",
            "NNONNONNO, true",
            "NNNNNNNNN, false",
            "NNNNNNNN, false",
            "NNNXXXNNN, true",
    })
    void testWithCsvSource(String position, boolean status) {
        var mapResults = new GameService().getWinner(position);
        assertEquals(status, mapResults.get("status"), mapResults.toString());
    }
}