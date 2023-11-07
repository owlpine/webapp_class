package ee.eek.bigsmall.service;

import ee.eek.bigsmall.dto.GameResponse;
import ee.eek.bigsmall.dto.GuessResponse;
import ee.eek.bigsmall.dto.NewGameRequest;
import ee.eek.bigsmall.dto.NewGameResponse;
import ee.eek.bigsmall.model.Game;
import ee.eek.bigsmall.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class GameService {
    private final GameRepository gameRepository;
    private final Random random = new Random();
    private static final int ANSWER_UPPER_BOUND = 101;

    public NewGameResponse createGame(NewGameRequest newGameRequest) {
        Game game = new Game();
        game.setName(newGameRequest.getName());
        game.setAnswer(newGameRequest.getAnswer());
        Game saved = gameRepository.save(game);
        return new NewGameResponse().setGameID(saved.getId());
    }

    public NewGameResponse createGame() {
        Game game = new Game();
        game.setName(randomGameName());
        game.setAnswer(randomAnswer());
        Game saved = gameRepository.save(game);
        return new NewGameResponse().setGameID(saved.getId());
    }

    public GuessResponse guess(Long gameID, Long guess) {
        Game game = gameRepository.findById(gameID).orElseThrow();
        String name = game.getName();
        Long answer = game.getAnswer();
        GuessResponse guessResponse = new GuessResponse();
        if (guess.equals(answer)) {
            guessResponse.setResponse("Correct! Thanks for playing %s :D".formatted(name));
            gameRepository.delete(game);
        } else if (guess.compareTo(answer) < 0) {
            guessResponse.setResponse("Playing %s. Your guess is too small!".formatted(name));
        } else if (guess.compareTo(answer) > 0) {
            guessResponse.setResponse("Playing %s. Your guess is too big!".formatted(name));
        }
        return guessResponse;
    }

    public List<GameResponse> getAll() {
        return gameRepository.findAll()
                .stream().map(game -> new GameResponse()
                        .setId(game.getId())
                        .setName(game.getName())).toList();
    }

    private String randomGameName() {
        return "Game" + Math.abs(random.nextInt());
    }

    private Long randomAnswer() {
        return random.nextLong(ANSWER_UPPER_BOUND);
    }
}
