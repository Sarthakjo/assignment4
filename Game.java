import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Game {

	private List<Dice> rollingdice;
	private List<DiceValue> val;
	
	public Game(Dice die1, Dice die2, Dice die3) {
		if (die1 == null || die2 == null || die3 == null) throw new IllegalArgumentException("Dice cannot be null.");
		rollingdice = new ArrayList<Dice>();
		rollingdice.add(die1);
		rollingdice.add(die2);
		rollingdice.add(die3);
		val = new ArrayList<DiceValue>();
	}

	public List<DiceValue> getDiceValues() {
		val.clear();
		for (Dice d : rollingdice) {
			val.add(d.getValue());
		}
		return Collections.unmodifiableList(val);
	}	
	
	public int playRound(Player player, DiceValue pick, int bet ) {		
		if (player == null) throw new IllegalArgumentException("Player cannot be null.");
		if (pick == null) throw new IllegalArgumentException("Pick cannot be negative.");
		if (bet < 0) throw new IllegalArgumentException("Bet cannot be negative.");
				    
		int matches = 0;
		for ( Dice d : rollingdice) {
			d.roll();
			if (d.getValue().equals(pick)) { 
				matches += 1;
			}
		}
		
		int winnings = matches * bet;

		if (matches > 0) {			
			player.receiveWinnings(winnings);
		} else {
			player.takeBet(bet);
		}
		
        return winnings;		
	}
	
}