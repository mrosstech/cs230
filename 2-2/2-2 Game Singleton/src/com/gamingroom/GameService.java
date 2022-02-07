package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

// MR - Include Iterator to allow for the iterator pattern in code below.
import java.util.Iterator;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	// FIXME: Add missing pieces to turn this class a singleton
	
	/*
	 * Purpose of Singleton Pattern:
	 * The purpose of utilizing the singleton pattern in this class is to ensure
	 * that only one copy of the GameService class can be present at one time.  If
	 * more than one copy were present, multiple games with the same ID could be
	 * updated at the same time causing corruption or other player issues.
	 * 
	 * Characteristics of Singleton Pattern:
	 * The singleton pattern uses a private constructor to ensure that the class can only
	 * be created by going through the gatekeeper method to ensure that the class hasn't been
	 * created already.   The private static member myGameService can only be instantiated if
	 * it hasn't been instantiated already.   Private static ensures that only one copy per 
	 * program run can be used.
	 */
	
	// Create private static GameService member variable to ensure that across *all* instances of
	// the class this member is the same.
	private static GameService myGameService;

	// Private constructor ensures that this class can't be instantiated without going through the
	// public method addGameService()
	private GameService() {
		
	}
	
	// Public method addGameService() checks for the presence of the privatemyGameService member
	// if it is not instantiated (null) then it instantiates it.   If it is already instantiated
	// it returns an informative message and returns the existing object.
	public static GameService addGameService() {
		if (myGameService == null) {
			myGameService = new GameService();
			System.out.println("New game service created!");
		} else {
			System.out.println("Game service already created.  Can only have one instance of a game service!");
		}
		return myGameService;
	}
	
	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;
		Game tempGame;
		
		// FIXME: Use iterator to look for existing game with same name
		// if found, simply return the existing instance
		
		/*
		 * Purpose and Characteristics of an Iterator:
		 * The purpose of using an iterator is to abstract the underlying data
		 * structure while granting access to it.  The iterator could be used
		 * for an Array, List, or any other similar data structure and provides
		 * a way to step through the elements of the data structure.  It also
		 * enhances security by not exposing the underlying data structure in 
		 * the iterator.
		 */
		
		// Instantiate the iterator for games
		Iterator<Game> it = games.iterator();
		
		// Loop through the values of the iterator and compare against the 
		// passed name value.
		while(it.hasNext()) {
			tempGame = it.next();
			if (tempGame.name == name) {
				// Matched the name, so assign the tempGame to game
				game = tempGame;
				
				// Exit the while loop to conserve CPU cycles
				break;
			}
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;
		Game tempGame;

		// FIXME: Use iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable
		Iterator<Game> it = games.iterator();
		while(it.hasNext()) {
			tempGame = it.next();
			if (tempGame.id == id) {
				game = tempGame;
				break;
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;
		Game tempGame;

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		Iterator<Game> it = games.iterator();
		while(it.hasNext()) {
			tempGame = it.next();
			if (tempGame.name == name) {
				game = tempGame;
				break;
			}
		}
		
		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}
