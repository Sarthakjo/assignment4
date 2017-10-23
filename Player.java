public class Player {
	private String playerName;
	private int currentBalance;
	private int maxLimit;
	
	public Player(String playerName, int currentBalance) {
		if (playerName == null || playerName .isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
		if (currentBalance < 0) throw new IllegalArgumentException("Balance cannot be negative");
		this.playerName = playerName;
		this.currentBalance = currentBalance;
		this.maxLimit = 0;
	}
		
	public String getName() { return playerName; }
	public int getBalance() { return currentBalance; }
	public int getLimit() { return maxLimit; }
	
	public void setLimit(int maxLimit) {
		if (maxLimit < 0) throw new IllegalArgumentException("Limit cannot be negative.");
		if (maxLimit > currentBalance)  throw new IllegalArgumentException("Limit cannot be greater than currentBalance.");
		this.maxLimit = maxLimit;
	}

	public boolean balanceExceedsLimit() {
		return (currentBalance > maxLimit);
	}
	
	public boolean balanceExceedsLimitBy(int amount) {
		//System.out.printf("\nbalance - amount > maxLimit = %d - %d > %d ---- Which means return %b\n\n", currentBalance, amount, maxLimit, (currentBalance - amount > maxLimit));
		return (currentBalance - amount >= maxLimit);
	}
	
	public void takeBet(int bet) {
		if (bet < 0) throw new IllegalArgumentException("Bet cannot be negative.");
		if (!balanceExceedsLimitBy(bet)) throw new IllegalArgumentException("Placing bet would go below maxLimit.");
		currentBalance = currentBalance - bet;
	}
	
	public void receiveWinnings(int winnings) {
		if (winnings < 0) throw new IllegalArgumentException("Winnings cannot be negative.");
		currentBalance = currentBalance + winnings;		
	}
	
	public String toString() {
		return String.format("Player: %s, Balance: %d, Limit: %d", playerName, currentBalance, maxLimit);
	}
}