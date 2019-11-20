import java.util.Random;


public interface JankenStrategy {
	public default void prevHands(Jankenrekkyo myHand , Jankenrekkyo opponentHand) {}
	
	public Jankenrekkyo hand();
}

class RandomStrategy implements JankenStrategy {
	Random random = new Random();
	
	public Jankenrekkyo hand() {
		int i = random.nextInt(3);
		return Jankenrekkyo.fromInt(i);
	}
	
}

class FixedHandStrategy implements JankenStrategy {
	
	public Jankenrekkyo hand;
	public FixedHandStrategy(Jankenrekkyo hand) {
		this.hand = hand;
	}
	public Jankenrekkyo hand() {
		return this.hand;
	}
}

class wiseStrategy implements JankenStrategy {
	
	public Jankenrekkyo prevMyHand;
	public Jankenrekkyo prevOpponentHand;
	
	
	public  void prevHands(Jankenrekkyo myHand , Jankenrekkyo opponentHand) {
		prevMyHand = myHand;
		prevOpponentHand = opponentHand;
}

	public Jankenrekkyo hand() {
		if (prevMyHand == null || prevOpponentHand == null) {
			return new RandomStrategy().hand();
		}
		if (prevMyHand.winTo(prevOpponentHand)) {
			return Jankenrekkyo.fromInt(prevMyHand.ordinal() + 1);
			
		} else if (prevMyHand.loseTo(prevOpponentHand)) {
			return prevOpponentHand;
			
		} else {
			return prevMyHand;
		}
	}
}