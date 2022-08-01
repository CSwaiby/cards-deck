public class Deck {
	
	class Card {

		String type;
		String num;
		
		public Card(String Type, String Num){
			type = Type;
			num = Num;
		}
		
		public Card(Card old) {
			this.type = old.type;
			this.num = old.num;
		}
		
		public String getType() {
			return type;
		}
		
		public String getNum() {
			return num;
		}
		
		public String cardShow() {
			return this.getNum() + " of " + this.getType();
		}
	}

	private Card[] tab;
	private int eltsNbr = 0;
	
	public Deck() {
		this.tab = new Card[52];
		this.eltsNbr = 0;
	}
	
	public boolean isEmpty() {
		return this.eltsNbr == 0;
	}
	
	public static String checkType(String Type) {
		if(Type.equals("clubs") || Type.equals("club") || Type.equals("Clubs") 
				|| Type.equals("Club") || Type.equals("C") || Type.equals("c") || Type.equals("100")) {
			
			return "clubs";
		}
		else if(Type.equals("diamonds") || Type.equals("diamond") || Type.equals("Diamonds") 
				|| Type.equals("Diamond") || Type.equals("D") || Type.equals("d")  || Type.equals("101")) {
			return "diamonds";
		}
		else if(Type.equals("hearts") || Type.equals("heart") || Type.equals("Hearts") 
				|| Type.equals("Heart") || Type.equals("H") || Type.equals("h")  || Type.equals("102")) {
			return "hearts";
		}
		if(Type.equals("spades") || Type.equals("spade") || Type.equals("Spades") 
				|| Type.equals("Spade") || Type.equals("S") || Type.equals("s")  || Type.equals("103")) {
			return "spades";
		}
		else {
			System.exit(1);
			return "none"; // Should not reach here
		}
	}
	
	public static String checkNum(String Num) {
		if(Num.equals("1") || Num.equals("A") || Num.equals("a")) {
			return "1";
		}
		else if(Num.equals("J") || Num.equals("j") || Num.equals("11")) {
			return "J";
		}
		else if(Num.equals("Q") || Num.equals("q") || Num.equals("12")) {
			return "Q";
		}
		else if(Num.equals("K") || Num.equals("k") || Num.equals("13")) {
			return "K";
		}
		else if(Num.equals("2") || Num.equals("3") || Num.equals("4") || Num.equals("5") || Num.equals("6") 
				|| Num.equals("7") || Num.equals("8") || Num.equals("9") || Num.equals("10")) {
			return Num;
		}
		else {
			System.exit(2);
			return "none"; // Should not reach here
		}
	}
	
	public void addCard(String Type, String Num) {
		String T = checkType(Type);
		String N = checkNum(Num);
		
		this.tab[this.eltsNbr] = new Card(T,N);
		this.eltsNbr++;
	}
	
	public void fullDeck() {
		for(int i = 100; i < 104; i++) {
			for(int j = 1; j < 14; j++) {
				this.addCard(String.valueOf(i), String.valueOf(j));
			}
		}
	}
	
	private void shuffleOnce(int rdm1 , int rdm2) {
		if(this.isEmpty())
			return;
		if(rdm1 == 0)
			return;
		// Math.floor(Math.random()*(max-min+1)+min)
		
		int j = 52-rdm1-rdm2;
		int k = 52 - rdm1;
		Card tmp = new Card(this.tab[k]);
		
		for (int i = k; i > j; i--)
			this.tab[i] = this.tab[i - 1];
		
		this.tab[j] = tmp;
		shuffleOnce(rdm1-1, rdm2);
	}
	
	public void shuffle() {
		if(this.isEmpty())
			return;
		int j = (int)Math.floor(Math.random()*(50000-30000+1)+900);
		for(int i = j; i > 0; i--) {
			int rdm1 = (int)Math.floor(Math.random()*(30-5+1)+5);
			int rdm2 = (int) Math.floor(Math.random()*((52-rdm1)-1+1)+1);
			this.shuffleOnce(rdm1, rdm2);
		}
	}
	
	public Card showAndRemove() {
		this.eltsNbr--;
		return this.tab[this.eltsNbr];
	}
	
	public void visual() {
		
		if(this.isEmpty()) 
			System.out.println("The deck is empty");
		else {
			System.out.println("			The deck has: ");
			System.out.println();
			for(int i = 0; i < this.eltsNbr; i++) {
				System.out.println("			" + this.tab[i].getNum() + "		|		" + this.tab[i].getType());
				// or: System.out.println(this.tab[i].cardShow())
			}
		}
	}
	
	public static void main(String[] args) {
		Deck test = new Deck();
		test.fullDeck();
		test.visual();
		/* Test whatever and however you like!
		// shuffleOnce() testing:
		int rdm1 = (int) Math.floor(Math.random()*(30-5+1)+5);
		int rdm2 = (int) Math.floor(Math.random()*((52-rdm1-5)-2+1)+2);
		System.out.println("rdm1: " + rdm1 + "		|	rdm2: " + rdm2 + "		|	rdm3: " + (52-rdm1-rdm2));
		test.shuffleOnce(rdm1, rdm2);
		test.visual();
		// test.shuffleOnce(27,20);
		*/
		
		test.shuffle();
		test.visual();
		/*
		// showAndRemove() testing:
		System.out.println();
		System.out.println("------------------------------------------------------------------------------");
		System.out.println();
		Card pssst = test.showAndRemove();
		System.out.println("			num: " + pssst.getNum() + "			type: " + pssst.getType());
		
		System.out.println();
		System.out.println("------------------------------------------------------------------------------");
		System.out.println();
		
		test.visual();*/
	}
}
