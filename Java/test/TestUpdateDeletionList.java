package test;

import java.util.List;
import org.junit.*;

public class TestUpdateDeletionList {
    World world;
    
    public LinkedList<Actor> setup(int n) {
        world = new World(null, null, null);
        List<Actor> actorList;
        for (int i = 0; i < n; i++) {
            world.addActors(new BreakableObject(i * 10, null, i * 10, i * 10, 1);
        }
        
        actorList = world.getActors();
        
        for (int i = 0; i < actorList.size(); i++) {
           markDeletion(actorList.get(i));
        }
        
        return world.updateDeletionList();
    }
    
    @Test
    public void test0Actors() { // loop body not executed at all
       LinkedList<Actor> deletionList = setup(0);
       assertEquals(0, deletionList.size());
    }
    
    @Test
    public void test1Actors() { // loop body executed exactly once
       LinkedList<Actor> deletionList = setup(1);
       assertEquals(0, deletionList.size());
    }
    
    @Test
    public void test2Actors() { // loop body executed exactly twice
       LinkedList<Actor> deletionList = setup(2);
       assertEquals(0, deletionList.size());
    }
    
    @Test
    public void test10Actors() { // loop body executed a typical number of times
        LinkedList<Actor> deletionList = setup(10);
        assertEquals(0, deletionList.size());
    }
}