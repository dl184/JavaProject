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
    DinosaurFood dinosaurFood;


    @Before
    public void setup(){
        paddock1 = new Paddock("Zone A", 8, DinosaurFood.COW);
        paddock2 = new Paddock("Dino World",500,DinosaurFood.PLANTS);
        dinosaur = new Dinosaur(paddock1, "Tyrannosaurus Rex","Carnivores",1500,"Green");
    }

    @Test
    public void dinosaurHasType(){
        assertEquals("Tyrannosaurus Rex", dinosaur.getType());
    }

    @Test
    public void dinosaurEats(){
        assertEquals("Carnivores",dinosaur.getDiet());
    }

    @Test
    public void dinosaurHasHeight(){
        assertEquals(1500, dinosaur.getHeight());
    }

    @Test
    public void dinosaurHasColor(){
        assertEquals("Green", dinosaur.getColor());
    }

    @Test
    public void testDinosaurRampage(){
        assertEquals("IM LOVELY AND FULL UP", dinosaur.dinosaurRampage());
        dinosaur.setHealthValue(25);
        assertEquals("ROARRRR I'M HUNGRY", dinosaur.dinosaurRampage());
    }

    @Test
    public void canFeedDinosaur(){
        dinosaur.feedDinosaur(DinosaurFood.COW);
        assertEquals(1, dinosaur.getBelly().size());
    }
}
