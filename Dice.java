public class Dice {
			
	private DiceValue val;
	
	public Dice() {
		val =  DiceValue.getRandom();
	}
	
	public DiceValue getValue() {
		return val;
	}

	public DiceValue roll() {
		return DiceValue.getRandom();
	}		
	
	public String toString() {
		return val.toString();
	}
}