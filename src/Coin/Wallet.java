package Coin;

import Entities.Casino;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wallet {
    protected Map<Coins, List<Coin>> totalCoins = new HashMap<>();

    public Wallet() {
        inflateWallet();
    }

    private void inflateWallet(){
        for (Coins coin_enum : Coins.values()){
            totalCoins.put(coin_enum, new ArrayList<Coin>());
        }
    }

    public Map<Coins, List<Coin>> getTotalCoins() {
        return totalCoins;
    }

    public void setTotalCoins(Map<Coins, List<Coin>> totalCoins) {
        this.totalCoins = totalCoins;
    }


    public int getCoinsWorth() {
        return Casino.coinsToMoney(totalCoins);
    }

    public Transaction subtractCoins(int amount){
        Transaction subtractedCoins = new Transaction(Casino.moneyToCoins(0));
        for (int i = Coins.values().length - 1; i >= 0; i--){
            List<Coin> toBeRemoved = new ArrayList<>();
            for (Coin coin : totalCoins.get(Coins.values()[i])){
                if (coin.getValue() <= amount){
                    toBeRemoved.add(coin);
                    amount -= coin.getValue();
                    subtractedCoins.addCoin(coin);
                }
            }
            for (Coin coin : toBeRemoved){
                totalCoins.get(Coins.values()[i]).remove(coin);
            }
        }

        if (amount != 0){
            System.out.println("Subtracted      " + Casino.coinsToMoney(subtractedCoins.totalCoins));
            System.out.println("Rest amount:    " + amount);
            System.out.println();
        }
        return subtractedCoins;
    }

    public void addCoins(Transaction transaction){
        for (Coins coin_enum : Coins.values()){
            List<Coin> toBeAdded = new ArrayList<>(transaction.getTotalCoins().get(coin_enum));
            for (Coin coin: toBeAdded){
                totalCoins.get(coin_enum).add(coin);
            }
        }


    }

    public void addCoin(Coin coin){
        for (Coins coin_enum : Coins.values()){
            if (coin_enum.getCoin().getClass().isInstance(coin)){
                totalCoins.get(coin_enum).add(coin);
            }
        }
    }

    public void printWallet(){
        System.out.println(getClass().toString() + " amount :     " + Casino.coinsToMoney(totalCoins));
        for (Coins coin_enum : Coins.values()){
            String stack = "";
            stack += String.format("|%-10s|", coin_enum);
            stack += "    ";
            for (Coin coin : totalCoins.get(coin_enum)){
                stack += "|";
            }
            System.out.println(stack);
        }
        System.out.println();
    }
}
