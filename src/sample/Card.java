package sample;

public class Card {
    /* Card Attribute */
    private final int size = 52; // size of the deck
    private Card[] card = new Card[size];
    private int[] order = new int[size]; // for started order
    protected String Type; // normal Attribute
    protected String Value; // normal Attribute
    /*=================*/

    // when the Card get Instant this method will functional and then generate the stack of card
    private void gen() {

        int cnt = 0;

        // this method is just generate the stack of card
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= 13; j++) {
                card[cnt] = new Card(i, j);
                cnt++;
            }
        }

    }

    // this method is for shuffle the card
    public void shuffle(){
        int cnt = 0;
        int[] arr = new int[this.size];

        while(cnt < this.size){

            int number = (int)(Math.random()*53);

            while(number == 0){
                number = (int)(Math.random()*53);
            }
            if(!(isContain(arr,number))){
                arr[cnt] = number;
                cnt++;
            }
        }

        int cnt2 = 0;
        for(int i : arr){
            Card temp = card[i-1];
            card[i-1] = card[cnt2];
            card[cnt2] = temp;
            cnt2++;
        }
    }

    // this method is for provide the duplicate value
    private boolean isContain(int[] arr,int n){
        for(int i : arr){
            if( i == n ) {
                return true;
            }
        }
        return false;
    }

    //Empty constructors
    public Card(){
        gen();
    }

    //Overload constructors
    public Card(int type,int value){

        switch (type){
            case 1 :
                this.Type = "heart";
                break;
            case 2 :
                this.Type = "diamond";
                break;
            case 3 :
                this.Type = "spade";
                break;
            case 4 :
                this.Type = "clover";
                break;
            default:
                this.Type = "undefine";
        }

        switch (value){
            case 1:
                this.Value = "A";
                break;
            case 11 :
                this.Value = "J";
                break;
            case 12 :
                this.Value = "Q";
                break;
            case 13:
                this.Value = "K";
                break;
            default:
                this.Value = Integer.toString(value);
        }

    }
    /* Encapsulation */

    //return size which is 52
    public int getSize(){
        return this.size;
    }

    // also for Order
    public int[] getOrder(){
        return this.order;
    }

    //also for Card
    public Card[] getCard(){ return this.card; }

    //also for type of card
    public String getType() {
        return Type;
    }

    //also for value of card
    public String getValue() {
        return Value;
    }

    /* End Encapsulation */

    // this method is for turn any Card Object into String which ready for output
    @Override
    public String toString() {
        return "Card{" +
                "type='" + Type + '\'' +
                ", value='" + Value + '\'' +
                '}';
    }
}
