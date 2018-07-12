import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DinosaurTest {

    private Dinosaur dinosaur;

    @Before public void before(){
        Dinosaur dinosaur = new Dinosaur(" Tyrannosaurus rex", "Prehistoric Animals","Carnivores",609,"Green");
    }

    @Test
    public void dinosaurHasname(){
        assertEquals("Tyrannosaurus rex", dinosaur.getName());
    }
}
