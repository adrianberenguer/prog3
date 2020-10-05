package model;

//@author ADRIÁN BERENGUER AGULLÓ, 74445262N

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class ShippreTest {

    @Test
    public void testGetAbsPos() {
        Ship ship = new Ship(Orientation.NORTH, 'P', "Portaaviones");
        ship.setPosition(new Coordinate(2, 2));
        
        //Coordinate c= new Coordinate(4,4);
        ship.hit(new Coordinate(4,4));

        for (int i = 0; i < 25; i ++) {
            System.out.print(ship.getShape()[0][i]);
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }

        System.out.println(ship.isShotDown());

        ship.hit(new Coordinate(4, 3));

        //ship.hit(new Coordinate(4, 5));


        System.out.println(ship.isShotDown());
        
        System.out.println(ship.isHit(new Coordinate(4,4)));
        
        System.out.println(ship.toString());
    }

}