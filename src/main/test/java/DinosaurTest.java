import models.Dinosaur;
import models.DinosaurFood;
import models.Paddock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DinosaurTest {

    Paddock paddock1;
    Paddock paddock2;
    Dinosaur dinosaur;


    @Before
    public void setup(){

        paddock1 = new Paddock("Zone A", 8, DinosaurFood.COW);
        paddock2 = new Paddock("Dino World",500,DinosaurFood.PLANTS);

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
