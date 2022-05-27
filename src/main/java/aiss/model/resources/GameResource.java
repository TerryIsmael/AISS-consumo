package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.function.Predicate;

import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import aiss.model.game.Game;

public class GameResource {
	
	Predicate<String> isNull = v->v==null || v.equals("") ;
	String uri = "https://indigo-computer-349516.ew.r.appspot.com/api/games";
	public Game[] getGames (String order, String order2, String q, Integer limit, Integer offset) throws UnsupportedEncodingException {
		String orderE = null;
		String order2E = null;
		if(!isNull.test(order)) {
			orderE=URLEncoder.encode(order,"UTF-8");
		}
		if(!isNull.test(order2)) {
			order2E=URLEncoder.encode(order2,"UTF-8");
		}
		
		String URI = "https://indigo-computer-349516.ew.r.appspot.com/api/games?" + (!isNull.test(order)?("order="+orderE+"&"):"") +
				(!isNull.test(order2)?("order2="+order2E+"&"):"") + (limit!=null?("limit="+limit+"&"):"") + (offset!=null?("offset="+offset):"") ;
		
		ClientResource cr = new ClientResource(URI);
		System.out.println(URI);
		Game[] games = cr.get(Game[].class);
		
		return games;
	}
	public Game getGame (String id) {
		ClientResource cr = null;
		Game game = null;
		try {
			cr = new ClientResource(uri +"/" + id);
			
			game = cr.get(Game.class);
		} catch (ResourceException e){
			System.err.println("Error when getting a game " + cr.getResponse().getStatus());
			throw e;
		}
		return game;
	}
	public Game addGame(Game game) {
		ClientResource cr = null;
		Game result = null;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);
			result = cr.post(game, Game.class);
		} catch (ResourceException e) {
			System.err.println("Error when adding a game " + cr.getResponse().getStatus());
			throw e;
		}
		return result;
	}
	public boolean updateGame(Game game) {
		ClientResource cr = null;
		Boolean success = true;
		try {
			cr = new ClientResource(uri);
			cr.setEntityBuffering(true);
			cr.put(game);
		} catch (ResourceException e) {
			System.err.println("Error when updating a game " + cr.getResponse().getStatus());
			success = false;
		}
		return success;
	}
	public boolean deleteGame(String gameId) {
		ClientResource cr = null;
		Boolean success = true;
		try {
			cr= new ClientResource(uri + "/" + gameId);
			cr.setEntityBuffering(true);
			cr.delete();
		} catch (ResourceException e) {
			System.err.println("Error when deleting a game " + cr.getResponse().getStatus());
			success=false;
		}
		return success;
	}
}
