package test;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.*;

/**
 * The test class tes.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Test_Pedido
{
    private Pedido pedido;
    private Platillo platilloPrueba;
    /**
     * Default constructor for test class tes
     */
    public Test_Pedido()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        pedido = new Pedido();
        platilloPrueba = new Platillo();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void testComportamientoPlatilloEnPedido() {
        pedido.agregarPlatillo(platilloPrueba);
    }

    @Test
    public void test() {
        
    }
}
