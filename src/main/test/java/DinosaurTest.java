import models.Dinosaur;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DinosaurTest {

     Dinosaur dinosaur;


    @Before
    public void setup(){
        dinosaur = new Dinosaur("Tyrannosaurus rex", "Prehistoric Animals","Carnivores",609,"Green");
    }

    @Test
    public void dinosaurHasname(){
        assertEquals("Tyrannosaurus rex", dinosaur.getName());
    }

    @Test
    public void dinosaurHasType(){
        assertEquals("Prehistoric Animals", dinosaur.getType());
    }

    @Test
    public void dinosaurEats(){
        assertEquals("Carnivores",dinosaur.getEats());
    }

    @Test
    public void dinosaurHasHeight(){
        assertEquals(609, dinosaur.getHeight());
    }

    @Test
    public void dinosaurHasColor(){
        assertEquals("Green", dinosaur.getColor());
    }
}
