import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Card {
    private String suit; // Масть
    private String rank; // Ранг

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " " + suit;
    }
}

class Deck {
    private List<Card> cards;
    private Set<Card> drawnCards; // Для контроля дублирования при возврате карт

    public Deck() {
        this.cards = new ArrayList<>();
        this.drawnCards = new HashSet<>();
        initializeDeck();
    }

    private void initializeDeck() {
        String[] suits = {"Червы", "Бубны", "Трефы", "Пики"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Валет", "Дама", "Король", "Туз"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            System.out.println("Колода пуста!");
            return null;
        }
        Card drawnCard = cards.remove(cards.size() - 1);
        drawnCards.add(drawnCard);
        return drawnCard;
    }

    public boolean returnCard(Card card) {
        if (drawnCards.contains(card)) {
            drawnCards.remove(card);
            cards.add(card);
            return true;
        } else {
            System.out.println("Эта карта не была выдана, возврат невозможен.");
            return false;
        }
    }

    public List<Card> getCards() {
        return cards;
    }
}

public class CardDeckDemo {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        // Сдача карт
        Card card1 = deck.drawCard();
        Card card2 = deck.drawCard();
        System.out.println("Сданные карты: " + card1 + ", " + card2);

        // Возврат карты в колоду
        boolean returned = deck.returnCard(card1);
        if (returned) {
            System.out.println("Карта " + card1 + " возвращена в колоду.");
        }

        // Попытка возврата карты, которая не была выдана
        Card fakeCard = new Card("Червы", "Туз");
        deck.returnCard(fakeCard); // Должно вывести сообщение об ошибке

        // Проверка оставшихся карт в колоде
        System.out.println("Оставшиеся карты в колоде: " + deck.getCards());
    }
}