import java.util.ArrayList;

/**
 * The BigTwo class is a public class to represent the BigTwo object and contains the overall flow of the BigTwo card game.
 * 
 * @author Pranav Talwar
 * 
 */
public class BigTwo {
	
	/*
	 * A deck object for the BigTwo game.
	 */
	private Deck deck;
	
	/*
	 * A list of all players in the game 
	 */
	private ArrayList<CardGamePlayer> playerList;  
	
	/*
	 * A list of hands played on the table.
	 */
	private ArrayList<Hand> handsOnTable; 
	
	/*
	 * An int type specifying the index of the active player.
	 */
	private int currentIdx; 
	
	/*
	 * A bigTwoConsole object which is providing the user interface.
	 */
	private BigTwoConsole bigTwoConsole; 
	
	/**
	 *  A constructor for creating the BigTwo card game. 
	 */
	public BigTwo()
	{
		playerList = new ArrayList<CardGamePlayer> ();
		for(int i = 0; i < 4;i++)
		{
			CardGamePlayer player = new CardGamePlayer();
			playerList.add(player);
		}
		handsOnTable = new ArrayList<Hand>();
		bigTwoConsole = new BigTwoConsole(this);
	}
	
	
	/**
	 * This is a getter method to retrieve the deck of cards being played.
	 *  
	 * @return Returns a deck object containing the deck of cards currently being played 
	 */
	public Deck getDeck()
	{
		return deck;
	}
	
	/**
	 * A getter method to retrieve the list of players.
	 * 
	 * @return An ArrayList containing the list of players.
	 */
	public ArrayList<CardGamePlayer> getPlayerList()
	{
		return playerList;		
	}
	
	/**
	 * A getter method the current cards that have been played on the table by the previous player.
	 * 
	 * @return An ArrayList containing the cards played by the previous player.
	 */
	public ArrayList<Hand> getHandsOnTable()
	{
		return handsOnTable;
	}
	
	/**
	 * A getter method which retrieves the index of the active player.
	 * 
	 * @return an Int type which could either be 0, 1, 2 or 3. 
	 */
	public int getCurrentIdx()
	{
		return currentIdx;	
	}
	
	/**
	 * A method to start to the game with a shuffled deck of cards as given in the BigTwoDeck object deck.
	 * 
	 * @param Deck the BigTwoDeck object supplied as the shuffled deck of cards used to play the game.
	 */
	public void start(BigTwoDeck Deck)
	{

		int y = -1;
		int previous_player = -1;
		int player = 0;
		
		// giving cards to all players
		for(int i = 0; i <52; i++)   
		{
			playerList.get(player%4).addCard(Deck.getCard(i));
			player++;
		}
		
		// setting the starting player that has the 3 of diamonds
		Card beginningCard = new Card(0,2);
		for(int i = 0; i < 4;i++) 
		{
			if(playerList.get(i).getCardsInHand().contains(beginningCard))
			{
				bigTwoConsole.setActivePlayer(i);
				y = i;
				break;
			}
		}
		
		// sorting cards in players hands
		playerList.get(0).getCardsInHand().sort();
		playerList.get(1).getCardsInHand().sort();
		playerList.get(2).getCardsInHand().sort();
		playerList.get(3).getCardsInHand().sort();
		
		CardList cardlist = new CardList();
		boolean gameEnd = false; 
		boolean isValid = true;
		
		// logic of the game
		while(!gameEnd)
		{
			if(isValid)
			{
				bigTwoConsole.repaint(); 
			}
	
			int[] selectedCards = bigTwoConsole.getSelected(); 
			if(selectedCards!=null)
			{
				cardlist = playerList.get(y).play(selectedCards);
				Hand hand = composeHand(playerList.get(y), cardlist);
				if(handsOnTable.isEmpty())
				{
					if(hand.contains(beginningCard) && hand.isEmpty()==false && hand.isValid()==true)
						isValid = true; 
					else
						isValid = false;
				}
				else
				{
					if(previous_player != y)
						isValid = hand.beats(handsOnTable.get(handsOnTable.size() - 1));
					else
						isValid = true;
				}
				if(isValid && hand.isValid())
				{
					previous_player = y;
					for(int i=0;i<cardlist.size();i++)
					{
						playerList.get(y).getCardsInHand().removeCard(cardlist.getCard(i)); 
						
						if(playerList.get(y).getCardsInHand().isEmpty()==true) 
						{
							gameEnd = true;
						}
					}
					System.out.println("{" + hand.getType() + "}" + " " + hand);
					handsOnTable.add(hand);
					y = (y+1)%4;
					bigTwoConsole.setActivePlayer(y); 
					System.out.println("");
				}
				else
				{
					System.out.println("Not a legal move!!!"); 
				}	
			}
			else
			{
				if(handsOnTable.isEmpty()==false && previous_player != y) 
				{
					y = (y+1)%4;
					bigTwoConsole.setActivePlayer(y);
					System.out.println("{Pass}");  
					System.out.println("");
					isValid = true;
				}
				else
				{
					System.out.println("Not a legal move");
				} 
			}
			
		}
		
		//ending game
		if(gameEnd) 
		{
			bigTwoConsole.setActivePlayer(-1); 
			bigTwoConsole.repaint();
			System.out.println("");
			System.out.println("Game ends");
			for(int i = 0; i < playerList.size();i++)
			{
				if(playerList.get(i).getNumOfCards() == 0)
					System.out.println("Player " + i + " wins the game"); 
				else
					System.out.println("Player " + i + " has " + playerList.get(i).getNumOfCards() + " cards in hand"); 
			}
		}
	}
	
	/**
	 * A method to return a valid hand from all the list of cards played by the player. 
	 * 
	 * @param player A CardGamePlayer object which contains the list of players in the game.
	 * @param cards A CardList object which contains list of cards played by the active player.
	 * 
	 * @return Hand The type of hand.
	 */
	public Hand composeHand(CardGamePlayer player, CardList cards)
	{
		Single single = new Single(player,cards); 
		Pair pair = new Pair(player,cards); 
		Triple triple = new Triple(player,cards); 
		Straight straight = new Straight(player,cards); 
		Flush flush = new Flush(player,cards); 
		FullHouse fullhouse = new FullHouse(player,cards); 
		Quad quad = new Quad(player,cards); 
		StraightFlush straightflush = new StraightFlush(player,cards); 
	
		if(straightflush.isValid())
		{
			return straightflush; 
		}
		
		if(quad.isValid())
		{
			return quad; 
		}
		
		if(fullhouse.isValid())
		{
			return fullhouse; 
		}
		
		if(flush.isValid())
		{
			return flush; 
		}
		
		if(straight.isValid())
		{	
			return straight; 
		}
		
		if(triple.isValid())
		{
			return triple; 
		}
		
		if(pair.isValid())
		{
			return pair; 
		}
		
		if(single.isValid())
		{
			return single; 
		}	
		return new Hand(player, cards); 
	}
	 
	
	/**
	 * Main helps in creating BigTwo and BigTwoDeck objects and shuffle and start the game by calling the void start function.
	 * 
	 * @param args unused
	 */
	public static void main(String [] args)
	{
		BigTwo game = new BigTwo();
		BigTwoDeck deck = new BigTwoDeck();
		deck.shuffle(); 
		game.start(deck);
	}
	
}