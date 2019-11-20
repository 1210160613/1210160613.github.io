import java.util.Random;

public class Player {
	public String name;
	 Random random = new Random();
	 JankenStrategy strategy = new RandomStrategy();
	
	
	public Player(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	public JankenStrategy getStrategy() {
		return this.strategy;
	}
	
	public void setStrategy(JankenStrategy strategy) {
		this.strategy = strategy;
	}
	
	
	public void prevHands(Jankenrekkyo myHand, Jankenrekkyo opponentHand) {
		strategy.prevHands(myHand , opponentHand);
	}
	
	public Jankenrekkyo hand() {
		return strategy.hand();
				
	}

}
