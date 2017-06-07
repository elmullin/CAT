package test;

import static org.junit.Assert.*;

import java.util.*;
import org.junit.*;
import game.*;

public class TestWorld {
	private game.CAT cat;
    World world;
    int n;
    
    public List<Actor> setup() {
        world = new World(null, null, null, cat);
        List<Actor> actorList;
        for (int i = 0; i < n; i++) {
            world.addActor(new Actor(null, i * 10, i * 10, cat));
        }
        
        actorList = world.getActors();
        
        for (int i = 0; i < actorList.size(); i++) {
           world.markDeletion(actorList.get(i));
        }
        
        return world.updateDeletionList();
    }
    
    @Test
    public void test0Actors() { // loop body not executed at all
       n = 0;
       List<Actor> deletionList = setup();
       assertEquals(0, deletionList.size());
    }
    
    @Test
    public void test1Actors() { // loop body executed exactly once
       n = 1;
       List<Actor> deletionList = setup();
       assertEquals(0, deletionList.size());
    }
    
    @Test
    public void test2Actors() { // loop body executed exactly twice
       n = 2;
       List<Actor> deletionList = setup();
       assertEquals(0, deletionList.size());
    }
    
    @Test
    public void test10Actors() { // loop body executed a typical number of times
    	n = 10;
        List<Actor> deletionList = setup();
        assertEquals(0, deletionList.size());
    }
}