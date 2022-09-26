package Game;

import Coin.Coin;
import Coin.Coins;

import java.util.List;
import java.util.Map;
import Coin.*;
import Entities.Casino;

public class Roulette extends Game{

    public Roulette(Casino house) {
        super(house);
    }

    @Override
    public Transaction getPlayed(Transaction transaction) {
        int numberSlot = (int) (Math.random() * 38);
        if(numberSlot <= 18){
            transaction.addCoins(new Transaction(Casino.moneyToCoins(transaction.getCoinsWorth())));
            System.out.println("Player WON " + transaction.getCoinsWorth() +"!");
            System.out.println();
        }else {
            house.addToBalance(transaction.getCoinsWorth());
            transaction.setTotalCoins(Casino.moneyToCoins(0));
            System.out.println("Player LOST!");
            System.out.println();
        }
        return transaction;
    }
}
