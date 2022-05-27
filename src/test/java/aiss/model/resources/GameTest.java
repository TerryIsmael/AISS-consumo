package aiss.model.resources;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import aiss.model.game.Game;


public class GameTest {

	@Test
	public void getMoviesTest() throws UnsupportedEncodingException {
		String title = "star wars";
		GameResource gameR = new GameResource();
		Game[] gameResults = gameR.getGames(null, null, title, null, null);
		String id = "G1869";
		Game gameResult = gameR.getGame(id);
		
		assertNotNull("The search returned null", gameResults);
		assertFalse("The number of albums of " + title + " is zero", gameResults.length==0);
		
		System.out.println("The search for " + title + "'s title returned " +  gameResults.length + " games.");
		
		
		//Print movies data
		for(Game game : gameResults) {
			System.out.println("Game: " + game.getName());
		}
		System.out.println(String.format("The search for game which id is %s is %s", id, gameResult.getName()));
	}
	
}
