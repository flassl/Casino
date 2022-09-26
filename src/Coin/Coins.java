package Coin;

public enum Coins {
    COIN5{
        @Override public int getCoinValue(){return 5;}
        @Override public Coin getCoin(){return new Coin5();}
    },
    COiN20{
        @Override public int getCoinValue(){return 20;}
        @Override public Coin getCoin(){return new Coin20();}
    },
    COIN50{
        @Override public int getCoinValue(){return 50;}
        @Override public Coin getCoin(){return new Coin50();}
    },
    COIN100{
        @Override public int getCoinValue(){return 100;}
        @Override public Coin getCoin(){return new Coin100();}
    };
    public abstract int getCoinValue();
    public abstract Coin getCoin();
}
