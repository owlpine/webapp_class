package ee.eek.bigsmall.service;

import ee.eek.bigsmall.dto.GameResponse;
import ee.eek.bigsmall.dto.NewGameRequest;
import ee.eek.bigsmall.dto.NewGameResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class GameService {
    private final Map<Integer, Integer> games = new HashMap<>();
    private final Random random = new Random();

    public NewGameResponse newGame(NewGameRequest newGameRequest) {
        Integer gameID = newGameID();
        games.put(gameID, newGameRequest.getAnswer());
        return new NewGameResponse()
                .setGameID(gameID);
    }

    public NewGameResponse newGame() {
        Integer gameID = newGameID();
        games.put(gameID, newAnswer());
        return new NewGameResponse()
                .setGameID(gameID);
    }

    public GameResponse guess(Integer gameID, Integer guess) {
        Integer answer = games.get(gameID);
        GameResponse gameResponse = new GameResponse();
        if (guess.equals(answer)) {
            gameResponse.setResponse("Correct! Thanks for playing :)");
            games.remove(gameID);
        } else if (guess.compareTo(answer) < 0) {
            gameResponse.setResponse("Too small!");
        } else if (guess.compareTo(answer) > 0) {
            gameResponse.setResponse("Too big!");
        }
        return gameResponse;
    }

    private Integer newGameID() {
        return Math.abs(random.nextInt());
    }

    private Integer newAnswer() {
        return random.nextInt(101);
    }
}
