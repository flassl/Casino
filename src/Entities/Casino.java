package Entities;

import Coin.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Casino {
    private int balance;

    public void addToBalance(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public static Map<Coins, List<Coin>> moneyToCoins(int money){
        Map<Coins, List<Coin>> totalCoins = new HashMap<>();
        for (Coins coin_enum : Coins.values()){
            totalCoins.put(coin_enum, new ArrayList<>());
        }
        int coinTypeAmount = Coins.values().length;
        while (money >= Coins.values()[0].getCoinValue()){
            for (Coins coin_enum : Coins.values()){
                List<Coin> coinList = new ArrayList<>();
                int specificBoughtCoinValue = 0;
                if(money >= coin_enum.getCoinValue()){
                    if (isNotBiggestCoinType(coinTypeAmount, coin_enum)) {
                        int nextBiggestCoinValue = Coins.values()[coin_enum.ordinal() + 1].getCoinValue();
                        while (canAffordAndIsSmallerThanNext(coin_enum, specificBoughtCoinValue, nextBiggestCoinValue, money)) {
                            coinList.add(coin_enum.getCoin());
                            specificBoughtCoinValue += coin_enum.getCoinValue();
                            money -= coin_enum.getCoinValue();
                        }
                    } else {
                        coinList.add(coin_enum.getCoin());
                        money -= coin_enum.getCoinValue();
                    }
                }
                totalCoins.get(coin_enum).addAll(coinList);
            }
        }

        //for (Coins coin_enum : Coins.values()){
        //    System.out.println(totalCoins.get(coin_enum));
        //}
        return totalCoins;
    }
    private static boolean isNotBiggestCoinType(int coinTypeAmount, Coins coin_enum) {
        return coin_enum.ordinal() < coinTypeAmount - 1;
    }

    private static boolean canAffordAndIsSmallerThanNext(Coins coin_enum, int specificBoughtCoinValue, int nextBiggestCoinValue, int money) {
        return (specificBoughtCoinValue < nextBiggestCoinValue - nextBiggestCoinValue % coin_enum.getCoinValue()) && (money >= coin_enum.getCoinValue());
    }

    public static int coinsToMoney(Map<Coins, List<Coin>> inputCoinMap){
        int coinsWorth = 0;
        for (Coins coin_enum : Coins.values()){
            for (Coin coin : inputCoinMap.get(coin_enum)){
                coinsWorth += coin.getValue();
            }
        }
        return coinsWorth;
    }
    public static int coinsToMoney(List<Coin> inputCoinList){
        int coinsWorth = 0;
        for (Coin coin : inputCoinList){
            coinsWorth += coin.getValue();
        }
        return coinsWorth;
    }

}
