package Entities;

import Coin.Coin;

import java.util.HashMap;
import java.util.List;
import Coin.*;
import Game.Game;

import java.util.Map;

public class Player {
    private int money;
    private Wallet wallet = new Wallet();

    public Player(int money) {
        this.money = money;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void buyCoins() {
        wallet.setTotalCoins(Casino.moneyToCoins(money));
    }

    public void changeCoins(){
        wallet.setTotalCoins(Casino.moneyToCoins(wallet.getCoinsWorth()));
    }

    public void play(Game game, int bet){
        System.out.println("Player plays " + game.getClass().toString() + " and bets: " + bet);
        Transaction betInCoins = wallet.subtractCoins(bet);
        wallet.addCoins(game.getPlayed(betInCoins));
        changeCoins();
    }


}
