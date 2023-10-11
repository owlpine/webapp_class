package ee.eek.bigsmall.web;

import ee.eek.bigsmall.dto.GameResponse;
import ee.eek.bigsmall.dto.NewGameRequest;
import ee.eek.bigsmall.dto.NewGameResponse;
import ee.eek.bigsmall.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("game")
public class GameController {
    private final GameService gameService;

    @GetMapping("/")
    public  NewGameResponse newGame() {
        return gameService.newGame();
    }

    @PostMapping
    public NewGameResponse newGame(@RequestBody NewGameRequest newGameRequest) {
        return gameService.newGame(newGameRequest);
    }

    @GetMapping("{gameID}/guess/{guess}")
    public GameResponse guess(@PathVariable Integer gameID, @PathVariable Integer guess) {
        return gameService.guess(gameID, guess);
    }
}
