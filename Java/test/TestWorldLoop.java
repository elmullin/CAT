// Liam Gow //

package test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import game.*;

public class TestWorldLoop {
	
	private game.CAT cat;
	
	@Before
	public void setup(){
		cat = new game.CAT();
	}

	@Test
	public void testGetActorNone() {
		World world = new World(cat);
		
		assertEquals(new ArrayList<Actor>(), world.getActors(Actor.class));
	}
	
	@Test
	public void testGetActorOne() {
		World world = new World(cat);
		ArrayList<Actor> actors = new ArrayList<>();
		
		Actor actor = new Actor(cat);
		
		world.addActor(actor);
		actors.add(actor);
		
		assertEquals(actors, world.getActors(Actor.class));
	}
	
	@Test
	public void testGetActorTwo() {
		World world = new World(cat);
		ArrayList<Actor> players = new ArrayList<>();
		
		Actor actor = new Actor(cat);
		Player player = new Player(null, 0,0, cat);
		
		world.addActor(actor);
		world.addActor(player);
		players.add(player);
		
		assertEquals(players, world.getActors(Player.class));
	}
	
	@Test
	public void testGetActorMany() {
		World world = new World(cat);
		ArrayList<Actor> players = new ArrayList<>();
		
		Actor actor = new Actor(cat);
		Actor actor2 = new Actor(cat);
		Actor actor3 = new Actor(cat);
		Player player = new Player(null, 0,0, cat);
		Player player2 = new Player(null, 0,0, cat);
		
		world.addActor(actor);
		world.addActor(actor2);
		world.addActor(actor3);
		world.addActor(player);
		world.addActor(player2);
		players.add(player);
		players.add(player2);
		
		assertEquals(players, world.getActors(Player.class));
	}
}
