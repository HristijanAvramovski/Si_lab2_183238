import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculaatorTest {
    Calculaator cal=new Calculaator();
    @Test
    void addTest()
    {
        assertEquals(8,cal.add(4,4));
        assertEquals(30,cal.add(15,15));
    }
    @Test
    void divideTest()
    {
        assertEquals(3,cal.divide(9,3));
        assertEquals(5,cal.divide(25,5));
    }

}