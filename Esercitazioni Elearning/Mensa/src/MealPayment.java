import java.io.NotActiveException;
import java.io.Serializable;
import java.util.ArrayList;

public class MealPayment implements Serializable {
    private ArrayList<Card> cards;
    private double totaleGuadagnato;

    public MealPayment() {
        cards = new ArrayList<>();
        totaleGuadagnato = 0;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    void addCard(Card card) {
        cards.add(card);
    }

    boolean useCard(int codice) throws ExpiredCardException, InsufficientBalanceException, NotActiveException {
        for(Card card : cards) {
            if(card.getCodice()==codice) {
                if(card.getClass().equals(StudentCard.class)) {
                    StudentCard studentCard = (StudentCard) card;
                    double prezzo = studentCard.simulatePayment();
                    totaleGuadagnato += prezzo;
                }
                else {
                    StaffCard staffCard = (StaffCard) card;
                    totaleGuadagnato += staffCard.pay();
                }
                return true;
            }
        }
        return false;
    }

    double computeTotal() {
        return totaleGuadagnato;
    }

    MealPayment getCardByType(int x) throws InvalidParametereException {
        if(x<0 || x>1) throw new InvalidParametereException("Parametro non corretto");
        MealPayment mealPayment = new MealPayment();
        for(Card card : cards) {
            if(card.getClass().equals(StudentCard.class) && x==0) {
                mealPayment.addCard(card);
            }
            else if(card.getClass().equals(StaffCard.class) && x==1) {
                mealPayment.addCard(card);
            }
        }
        return mealPayment;
    }
}
