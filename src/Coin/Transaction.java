package Coin;

import Entities.Casino;

import java.util.List;
import java.util.Map;

public class Transaction extends Wallet{

    public Transaction(Map<Coins, List<Coin>> transactionCoinMap) {
        super();
        totalCoins = transactionCoinMap;
    }

}
