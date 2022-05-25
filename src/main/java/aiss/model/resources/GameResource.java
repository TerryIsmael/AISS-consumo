package aiss.model.resources;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.function.Predicate;

import org.restlet.resource.ClientResource;

import aiss.model.game.Game;

public class GameResource {
	
	Predicate<String> isNull = v->v==null || v.equals("") ;

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
	
}
