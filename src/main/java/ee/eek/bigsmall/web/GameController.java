package ee.eek.bigsmall.web;

import ee.eek.bigsmall.dto.GameResponse;
import ee.eek.bigsmall.dto.GuessResponse;
import ee.eek.bigsmall.dto.NewGameRequest;
import ee.eek.bigsmall.dto.NewGameResponse;
import ee.eek.bigsmall.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("game")
public class GameController {
    private final GameService gameService;
    // @RequestBody, @PathVariable, @RequestParam

    @GetMapping
    public  NewGameResponse createGame() {
        return gameService.createGame();
    }

    @PostMapping
    public NewGameResponse createGame(@RequestBody NewGameRequest newGameRequest) {
        return gameService.createGame(newGameRequest);
    }

    @GetMapping("{gameID}/guess/{guess}")
    public GuessResponse guess(@PathVariable Integer gameID, @PathVariable Integer guess) {
        return gameService.guess(gameID, guess);
    }

    @GetMapping
    public List<GameResponse> getAll() {
        return gameService.getAll();
    }
}
