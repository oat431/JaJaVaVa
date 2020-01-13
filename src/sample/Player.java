package sample;

public class Player {
    /*Player Attribute*/
    private int balance;// money starter
    private Card[] hand = new Card[3]; // total card on hand
    private int cardAmg = 0;//total number of card on hand
    /*===============*/

    /*Constructors*/
    public Player(){
        this.hand[2] = new Card(0,0);
    }

    public Player(int balance){
        this.balance = balance;
    }
    /*============*/

    //this method for set Balance in case if you forget to set when you Instant Object
    public void setBalance(int balance) {
        this.balance = balance;
    }

    //this method for return balance
    public int getBalance() {
        return balance;
    }

    //this method is for draw card from deck
    public void drawCard(Card i){
        if(this.cardAmg <= 3){
            this.hand[cardAmg] = i;
            cardAmg++;
        }else{
            System.out.println("Cannot has more than 3");
        }
    }

    //this method is for the last result of the PokDeng game
    public Card[] showCard(){
        return this.hand;
    }
    //this method check whether card is on hand or not

    public String onHand(){
        if(cardAmg == 2){
            return "{card1 = " +this.hand[0]+ "}"
                    +"\n{card2 = " +this.hand[1]+ "}";
        }
        return "{card1 = " +this.hand[0]+ "}"
        +"\n{card2 = " +this.hand[1]+ "}"
        +"\n{card3 = " +this.hand[2]+ "}";
    }
}
