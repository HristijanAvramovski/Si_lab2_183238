import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SiLab2Test {
    private List<Time> createList(Time... elems) {
        return new ArrayList<Time>(Arrays.asList(elems));
    }
    SiLab2 obj=new SiLab2();
    @Test
    void everyBranch() {
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class,()->obj.function(createList(new Time(-5,20,45))));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        ex=assertThrows(RuntimeException.class,()->obj.function(createList(new Time(27,44,50))));
        assertTrue(ex.getMessage().contains("The hours are greater than the maximum"));

        ex=assertThrows(RuntimeException.class,()->obj.function(createList(new Time(2,77,30))));
        assertTrue(ex.getMessage().contains("The minutes are not valid"));

        ex=assertThrows(RuntimeException.class,()->obj.function(createList(new Time(4,20,90))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        ex=assertThrows(RuntimeException.class,()->obj.function((createList(new Time(24,43,20)))));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        //samo za koga pominuva normalno programta neznam kako
    }
    @Test
    void multipleConditions() {
        //if(h<0 || h>24)
        //T|X
        //F|T
        //F|F
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> obj.function(createList(new Time(-5, 20, 45))));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));
        ex = assertThrows(RuntimeException.class, () -> obj.function(createList(new Time(27, 44, 50))));
        assertTrue(ex.getMessage().contains("The hours are greater than the maximum"));
        ex = assertThrows(RuntimeException.class, () -> obj.function(createList(new Time(2, 77, 30))));
        assertTrue(ex.getMessage().contains("The minutes are not valid"));
        /*if(min<0 || min>60)
       T|X
        F|T
        F|F
         */
        ex = assertThrows(RuntimeException.class, () -> obj.function(createList(new Time(2, 77, 30))));
        assertTrue(ex.getMessage().contains("The minutes are not valid"));
        ex = assertThrows(RuntimeException.class, () -> obj.function(createList(new Time(2, -3, 30))));
        assertTrue(ex.getMessage().contains("The minutes are not valid"));
        ex = assertThrows(RuntimeException.class, () -> obj.function(createList(new Time(4, 20, 90))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));
    }

}