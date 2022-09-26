package Game;

import Coin.*;
import Entities.Casino;

import java.util.List;
import java.util.Map;

public abstract class Game {

    Casino house;

    public Game(Casino house) {
        this.house = house;
    }

    public abstract Transaction getPlayed(Transaction transaction);
}
