package com.eric.innerclasses;

import java.util.Random;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 11/14/2018 8:12 PM
 */
public class Game17 {

    public static void playGame(GameFactory factory){
        factory.getGames().play();
    }

    public static class Test{
        public static void main(String[] args) {
            playGame(CoinTossing::new);
            playGame(DiceTossing::new);
        }

    }

}

interface Games{
    void play();
}

interface GameFactory{
    Games getGames();
}

class CoinTossing implements Games{

    Random rand = new Random();
    @Override
    public void play() {
        System.out.println("Coin Toss:" + rand.nextInt(3));
        switch (rand.nextInt(3)){
            case 0:
                System.out.println("Head");
                break;
            case 1:
                System.out.println("Tails");
                break;
            default:
                System.out.println("OnEdge");
        }
    }
    public static GameFactory factory = new GameFactory(){
        @Override
        public Games getGames() {
            return new CoinTossing();
        }
    };
}

class DiceTossing implements Games{

    Random random = new Random();

    @Override
    public void play() {
        System.out.println("Throw diss::" + (random.nextInt(6) + 1));
    }

    public static GameFactory factory = new GameFactory(){
        @Override
        public Games getGames() {
            return new DiceTossing();
        }
    };
}
