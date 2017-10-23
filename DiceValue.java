import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public enum DiceValue {
	CROWN, ANCHOR, HEART, DIAMOND, CLUB, SPADE;
	
	private static Random RANDOM = new Random();
	
	private static final Map<DiceValue, String> VALUE_REPR_MAP= new HashMap<DiceValue, String>();
	static {
		VALUE_REPR_MAP.put(DiceValue.CROWN, "Crown");
		VALUE_REPR_MAP.put(DiceValue.ANCHOR, "Anchor");
		VALUE_REPR_MAP.put(DiceValue.HEART, "Heart");
		VALUE_REPR_MAP.put(DiceValue.DIAMOND, "Diamond");
		VALUE_REPR_MAP.put(DiceValue.CLUB, "Club");
		VALUE_REPR_MAP.put(DiceValue.SPADE, "Spade");
	}
	
	public String toString(DiceValue val) {
		return VALUE_REPR_MAP.get(val);
	}
	
	public static DiceValue getRandom() {
		int random = RANDOM.nextInt(DiceValue.SPADE.ordinal()+1);
		//System.out.printf("\nSPADE ORDINAL is %d and random is %d\nValue being returned is %s\n",DiceValue.SPADE.ordinal(), random, values()[random]);
		return values()[random];
	}
	
}
