import models.Dinosaur;
import models.DinosaurFood;
import models.Paddock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DinosaurTest {

    Paddock paddock;
    Dinosaur dinosaur;


    @Before
    public void setup(){
        paddock = new Paddock("Dino World",500,DinosaurFood.PLANTS);
        dinosaur = new Dinosaur(paddock, "Tyrannosaurus rex", "Prehistoric Animals","Carnivores",609,"Green", 24);

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

    @Test
    public void dinosaurRampage(){
        assertEquals("ROARRRR I'M HUNGRY", dinosaur.dinosaurRampage());
    }
}
