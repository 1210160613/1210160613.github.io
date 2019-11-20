
public enum Jankenrekkyo {
	Rock,
	Scissors,
	Paper;
	
	public String toString() {
		switch (this) {
		case Rock:
			return "Paper";
			
		case Scissors:
			return "Rock";
		
		case Paper:
			return "Scissors";
		}
	return null;
	}
	
	public static Jankenrekkyo fromInt(int i) {
		switch (i % 3) {
		case 0:
			return Rock;
		case 1:
			return Scissors;
		case 2:
			return Paper;
		}
		return null;
	}
	public boolean winTo(Jankenrekkyo hand) {
		switch (this) {
		case Rock:
			return hand == Scissors;
			
			
		case Scissors:
			return hand == Paper;
			
			
		case Paper:
			return hand == Rock;
			
		}
	return false;
	}
	
	public boolean loseTo(Jankenrekkyo hand) {
		return this != hand && !winTo(hand);
	}
	
}
