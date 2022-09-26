package Simulation;

import Coin.Coin;
import Entities.Casino;
import Entities.Player;
import Game.Roulette;


public class Simulation {

    public static void main(String[] args) {
        Casino bellagio = new Casino();
        Player player = new Player(20000);
        player.buyCoins();
        System.out.println("Player starts with: " + Casino.coinsToMoney(player.getWallet().getTotalCoins()));
        player.getWallet().printWallet();
        for (int i = 0; i < Math.random() * 2000; i++){
            if (player.getWallet().getCoinsWorth() >= 5){
                int bet = 5 + (int) (Math.random() * (player.getWallet().getCoinsWorth() - 4)/ 5) * 5;
                player.play(new Roulette(bellagio), bet);
                player.getWallet().printWallet();
            }
            else break;
            System.out.println("Player played " + i + " rounds");
        }

    }
}
