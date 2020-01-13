package sample;
import java.util.Scanner;

public class Main{
    private static final Scanner in = new Scanner(System.in);
    public static void main(String[] args){

        Card paii = new Card();

        paii.shuffle();

        PokDeng deck = new PokDeng(paii);

        Player[] Kar = new Player[4];

        for(int i=0;i<Kar.length;i++){
            Kar[i] = new Player(400);
        }

        for (Player player : Kar) {
            player.drawCard(deck.top());
        }

        for (Player player : Kar) {
            player.drawCard(deck.top());
        }

        for(int i=1;i<Kar.length;i++){
            if (deck.checkScore(Kar[i].showCard()) < 8 ){
                Kar[i].drawCard(deck.top());
            }
        }

        System.out.println(Kar[0].onHand());

        System.out.println("Will you gonna draw another card? (y/n)");
        if(in.nextLine().equals("y")){
            Kar[0].drawCard(deck.top());
        }
        int[] score = new int[Kar.length];
        for(int i=0;i<Kar.length;i++){
            score[i] = deck.gameResult(Kar[i]);
        }

        int max = score[0];
        for (int value : score) {
            if (max < value) {
                max = value;
            }
        }
        System.out.println("\nWinning Player ");
        for(int i=0;i<score.length;i++){
            if(score[i] == max){
                System.out.println("========Player " + (i+1) + " won this game========");
                System.out.println("with \n" + Kar[i].onHand());
                Kar[i].setBalance(Kar[i].getBalance()+300);
                System.out.println("================\n");
            }else{
                Kar[i].setBalance(Kar[i].getBalance()-100);
            }
        }

        System.out.println("\nScore Board");
        for(int i=0;i<Kar.length;i++){
            System.out.println("\n========Player " + (i+1) + "========");
            System.out.println(Kar[i].onHand());
            System.out.println(deck.result(Kar[i].showCard()));
            System.out.println("Remain: " + Kar[i].getBalance());
            System.out.println("================\n");
        }

    }
}