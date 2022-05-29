package aiss.model.resources;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.restlet.resource.ResourceException;

import aiss.model.game.Game;


public class GameTest {
	static GameResource gameR = new GameResource();
	@Test
	public void getGamesTest() throws UnsupportedEncodingException {
		String title = "Borderlands";
		
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
	
	@Test(expected = ResourceException.class)
	public void deleteGameTest() {
		String id = "G218";
		boolean success = gameR.deleteGame(id);
		assertTrue("Error while deleting a game ", success);
		Game game = gameR.getGame(id);
		assertNull("The game has not been deleted correctly", game);
	}
	
	@Test
    public void createFilmTest(){
		List<String> consoles=new ArrayList<>();
		consoles.add("PC");
		Game g=new Game(consoles,"Borderlands 4",10);
		boolean success = gameR.createGame(g);
		assertTrue("Error while creating a game ", success);
    }
	
}
