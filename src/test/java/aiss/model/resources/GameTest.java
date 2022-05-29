package aiss.model.resources;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import aiss.model.game.Game;


public class GameTest {
	static GameResource gameR = new GameResource();
	static Game game1,game2;
	@BeforeClass
	public static void setup() {
		Game juego1 = new Game(List.of("Nintendo 64"), "Game title 1", "A game example",5);
		game1 = gameR.addGame(juego1);
		game2 = gameR.addGame(new Game(List.of("PC","Nintendo 3DS"), "Game title 2", "A game example",5));
	}
	@Test
	public void getGamesTest() throws UnsupportedEncodingException {
		String title = "star wars";
		
		Game[] gameResults = gameR.getGames(null, null, title, null, null);
		
		
		
		assertNotNull("The search returned null", gameResults);
		assertFalse("The number of albums of " + title + " is zero", gameResults.length==0);
		
		System.out.println("The search for " + title + "'s title returned " +  gameResults.length + " games.");
		
		
		//Print movies data
		for(Game game : gameResults) {
			System.out.println("Game: " + game.getName());
		}
		
	}
	@Test 
	public void getGameTest() throws UnsupportedEncodingException {
		String id = "G1869";
		Game gameResult = gameR.getGame(id);
		assertNotNull("The search returned null", gameResult);
		
		System.out.println(String.format("The search for game which id is %s is %s", id, gameResult.getName()));
	}
	
	
}
