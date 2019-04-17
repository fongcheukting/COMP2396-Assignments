import java.util.ArrayList;
/**
 * The BigTwo class is a public class to represent the BigTwo object and contains the overall flow of the BigTwo card game.
 * @author Pranav Talwar
 * 
 */
public class BigTwo implements CardGame {
	
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
	 * A BigTwoTable object which is provides the necessary GUI.
	 */
	private BigTwoTable bigTwoTable; 
	
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
		bigTwoTable = new BigTwoTable(this);
		currentIdx = -1;
	}
	
	/* A getter method to get the number of players.
	 * 
	 * @return an integer that is the number of players.
	 */
	public int getNumOfPlayers() {
		return playerList.size();
	}
	
	/**
	 * A getter method to retrieve the deck of cards being played.
	 * 
	 * @return Returns a deck object containing the deck of cards currently being played.
	 */
	public Deck getDeck()
	{
		return deck;
	}
	
	/**
	 * A getter method to retrieve the list of players.
	 * 
	 * @return an Arraylist containing the list of players.
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
	 * @param Deck the BigTwoDeck object supplied as a shuffled deck of cards that is used to play the game. 
	 */
	public void start(Deck Deck)
	{
		// removing all cards from the table
		handsOnTable.clear();
		
		//removing cards from players hands
		for(int i=0;i<4;i++) {
			playerList.get(i).getCardsInHand().removeAllCards();
		}
		
		// giving cards to players
		int player = 0;
		for(int i = 0; i <52; i++)   
		{
			playerList.get(player%4).addCard(Deck.getCard(i));
			player++;
		}
		
		// sorting cards present in player's hands
		playerList.get(0).getCardsInHand().sort();
		playerList.get(1).getCardsInHand().sort();
		playerList.get(2).getCardsInHand().sort();
		playerList.get(3).getCardsInHand().sort();
		
		//finding the beginner player
		Card beginningCard = new Card(0,2);
		for(int i = 0; i < 4;i++) 
		{
			if(playerList.get(i).getCardsInHand().contains(beginningCard))
			{
				currentIdx= i;
				bigTwoTable.setActivePlayer(currentIdx);
				break;
			}
		}
		bigTwoTable.printMsg(getPlayerList().get(currentIdx).getName() + "'s turn");
		bigTwoTable.repaint();
	}
	
	/**
	 * Makes a move by the player.
	 * 
	 * @param playerID the playerID of the player who makes the move.
	 * @param cardIdx the list of the indices of the cards selected by the player.
	 */
	public void makeMove(int playerID, int [] cardIdx)
	{
		checkMove(playerID,cardIdx);
	}
	
	/**
	 * Checks the move made by the player.
	 * 
	 * @param playerID the playerID of the player who makes the move.
	 * @param cardIdx the list of the indices of the cards selected by the player.
	 */
	public void checkMove(int playerID, int [] cardIdx)
	{
		CardList cardlist = new CardList(); 
		boolean isValid = true; 
		Card beginningCard = new Card(0,2);
		
		if(cardIdx!= null) {
			cardlist = playerList.get(playerID).play(cardIdx);
			Hand hand = composeHand(playerList.get(playerID), cardlist);
			
			if(handsOnTable.isEmpty())
			{
				//checks if beginning move contains 3 of diamonds
				if(hand.contains(beginningCard) && hand.isEmpty()==false && hand.isValid()==true)
					isValid = true; 
				else
					isValid = false;
			}
			else {
				if(handsOnTable.get(handsOnTable.size() - 1).getPlayer() != playerList.get(playerID))
				{
					if(!hand.isEmpty()) {
						isValid = hand.beats(handsOnTable.get(handsOnTable.size() - 1));
					}
					else {
						isValid = false;
					}
				}
				else {
					if(!hand.isEmpty()) {
						isValid = true;
					}
					else {
						isValid= false;
					}
				}	
			}
			if(isValid && hand.isValid()) {
				
				//removing played cards from the players hands
				for(int i=0;i<cardlist.size();i++)
				{
					playerList.get(playerID).getCardsInHand().removeCard(cardlist.getCard(i)); 
				}
				
				bigTwoTable.printMsg("{" + hand.getType() + "} " + hand);
				handsOnTable.add(hand);
				currentIdx = (currentIdx + 1) % 4;
				bigTwoTable.setActivePlayer(currentIdx);
				bigTwoTable.printMsg("Player " + (currentIdx) + "'s turn");
			}
			else
			{
				bigTwoTable.printMsg(cardlist +" <= Not a legal move!!!");
			}
		}
		else {
			
			// handles passing by a player
			if(!handsOnTable.isEmpty() && handsOnTable.get(handsOnTable.size()-1).getPlayer() != playerList.get(playerID)) {
				currentIdx = (currentIdx+1)%4;
				bigTwoTable.setActivePlayer(currentIdx);
				bigTwoTable.printMsg("{Pass}");
				bigTwoTable.printMsg("Player " + currentIdx + "'s turn");
				isValid = true;
			}
			else {
				bigTwoTable.printMsg("Not a legal move!!!");
				isValid= false;
			}
		}
		
		bigTwoTable.repaint();
		
		// checking for end of game
		if(endOfGame()) {
			
			bigTwoTable.setActivePlayer(-1);
			bigTwoTable.repaint();
			bigTwoTable.printMsg("Game ends");
			
			//check who wins and how many cards the other players have
			for(int i = 0; i < playerList.size();i++)
			{
					if(playerList.get(i).getCardsInHand().size() == 0)
					{
						bigTwoTable.printMsg("Player " + i + " wins the game"); 
					}
				
				else
				{
					bigTwoTable.printMsg("Player " + i + " has " + playerList.get(i).getCardsInHand().size() + " cards in hand"); // list the number of cards left in the other players' hand
				}
			}
			bigTwoTable.disable();
		}
	}
	
	/**
	 * a method that checks for the end of the game.
	 * 
	 * @return boolean true if the game ends; false otherwise.
	 */
	public boolean endOfGame() {
		for(int i=0;i<playerList.size();i++)
		{
			if(playerList.get(i).getNumOfCards() == 0) {
				
				return true;
			}
		}
		return false;
	}
	
	/**
	 * A method to return a valid hand from all the list of cards played by the player. 
	 * 
	 * @param player A CardGamePlayer object which contains the list of players in the game.
	 * @param cards A CardList object which contains list of cards played by the active player.
	 * 
	 * @return the type of hand 
	 */
	public static Hand composeHand(CardGamePlayer player, CardList cards)
	{
		StraightFlush straightflush = new StraightFlush(player,cards); 
		if(straightflush.isValid())
		{
			return straightflush; 
		}
		Quad quad = new Quad(player,cards); 
		if(quad.isValid())
		{
			return quad; 
		}
		FullHouse fullhouse = new FullHouse(player,cards); 
		if(fullhouse.isValid())
		{
			return fullhouse; 
		}
		Flush flush = new Flush(player,cards); 
		if(flush.isValid())
		{
			return flush; 
		}
		Straight straight = new Straight(player,cards); 
		if(straight.isValid())
		{	
			return straight; 
		}
		Triple triple = new Triple(player,cards); 
		if(triple.isValid())
		{
			return triple; 
		}
		Pair pair = new Pair(player,cards); 
		if(pair.isValid())
		{
			return pair; 
		}
		Single single = new Single(player,cards); 
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