package sample;

import java.util.Stack;

public class PokDeng extends Card{

    // create Stack of Card using Stack ADT
    private Stack<Card> deck = new Stack<Card>();

    // this method is for create PokDeng game
    public PokDeng(Card DECK){
        for(Card i : DECK.getCard()){
            deck.push(i);
        }
    }

    // this method is for pick the top deck
    public Card top(){
        return deck.pop();
    }

    // this method is for card score
    public int checkScore(Card[] card){
        int score = 0;

        for(Card i : card){
            try{
                if ("A".equals(i.getValue())) {
                    score += 1;
                }else if("J".equals(i.getValue())){
                    score += 10;
                }else if("Q".equals(i.getValue())){
                    score += 10;
                }else if("K".equals(i.getValue())){
                    score += 10;
                }else{
                    score += Integer.parseInt(i.getValue());
                }
            }catch (Exception e){
                System.out.println("Let Play");
            }

        }

        return score%10;
    }

    //this method is for check whether is same type or not
    public boolean is2Deng(Card[] card){
        try {
            return (card[0].getType().equals(card[1].getType())
                    || card[0].getType().equals(card[2].getType())
                    || card[1].getType().equals(card[2].getType()));
        }catch (Exception e){
            System.out.println("Let Play");
        }
        return false;
    }

    // this method is for given name for type of card
    public String result(Card[] card){
        String showResult = "";
        int score = checkScore(card);
        try{
            switch (score){

                case 0:
                    showResult += "Pai Bod";
                    break;
                case 8:
                    showResult += "Pok 8";
                    break;
                case 9:
                    showResult += "Pok 9";
                    break;
                default:
                    showResult += "bad luck you got only " + score + " point";
            }
        }catch (Exception e){
            System.out.println("Let Play");
        }

        if (is2Deng(card)){
            showResult += " 2 Deng";
        }
        return showResult;
    }

    // this method is for show full type of card
    public int gameResult(Player i){

        if("Pok 9 2 Deng".equals(result(i.showCard()))){
            return 11;
        }else if("Pok 8 2 Deng".equals(result(i.showCard()))){
            return 10;
        }else if("Pok 9".equals(result(i.showCard()))){
            return 9;
        }else if("Pok 8".equals(result(i.showCard()))){
            return 8;
        }
        return checkScore(i.showCard());

    }
}
