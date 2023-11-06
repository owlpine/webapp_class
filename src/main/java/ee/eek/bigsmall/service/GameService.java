package ee.eek.bigsmall.service;

import ee.eek.bigsmall.dto.GameResponse;
import ee.eek.bigsmall.dto.GuessResponse;
import ee.eek.bigsmall.dto.NewGameRequest;
import ee.eek.bigsmall.dto.NewGameResponse;
import ee.eek.bigsmall.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository bigsmallRepository;
    private final Map<Integer, Integer> games = new HashMap<>();
    private final Random random = new Random();
    private static final int ANSWER_UPPER_BOUND = 101;

//    public Iterable

    public NewGameResponse createGame(NewGameRequest newGameRequest) {
        Integer gameID = newGameID();
        games.put(gameID, newGameRequest.getAnswer());
        return new NewGameResponse()
                .setGameID(gameID);
    }

    public NewGameResponse createGame() {
        Integer gameID = newGameID();
        games.put(gameID, newAnswer());
        return new NewGameResponse()
                .setGameID(gameID);
    }

    public GuessResponse guess(Integer gameID, Integer guess) {
        Integer answer = games.get(gameID);
        GuessResponse guessResponse = new GuessResponse();
        if (guess.equals(answer)) {
            guessResponse.setResponse("Correct! Thanks for playing :)");
            games.remove(gameID);
        } else if (guess.compareTo(answer) < 0) {
            guessResponse.setResponse("Too small!");
        } else if (guess.compareTo(answer) > 0) {
            guessResponse.setResponse("Too big!");
        }
        return guessResponse;
    }

    public List<GameResponse> getAll() {
        return bigsmallRepository.findAll()
                .stream().map(game -> new GameResponse()
                        .setId(game.getId())
                        .setName(game.getName())).toList();
    }

    private Integer newGameID() {
        return Math.abs(random.nextInt());
    }

    private Integer newAnswer() {
        return random.nextInt(ANSWER_UPPER_BOUND);
    }
}
