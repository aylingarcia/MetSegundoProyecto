package PaqueteBD;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ExpresionesRegularesTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ExpresionesRegularesTest
{
    private RegularExp reg;
    /**
     * Default constructor for test class ExpresionesRegularesTest
     */
    public ExpresionesRegularesTest()
    {
        reg = new RegularExp();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
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
    public void testVErificiar() {
        assertTrue(reg.verifyCSV("a.csv"));
    }

    @Test 
    public void testVerificiar() {
        assertFalse(reg.verifyCSV("a.txt"));
    }

    @Test
    public void verificarTXTSERIALIZACION() {
        assertTrue(reg.verifySerializable("fdjskf.txt"));
    }

    @Test
    public void verificarBINSERIALIZACION() {
        assertTrue(reg.verifySerializable("fdjskf.bin"));
    }

    @Test
    public void verificarSERSERIALIZACION() {
        assertTrue(reg.verifySerializable("fdjskf.ser"));
    }

    @Test
    public void testPath() {
        try {
            reg.verifyPath("f/.");
            fail("hola");
        } catch (Exception e) {
        }
    }

    public void verificar() {
        try {
            reg.verifyPath("/kfasd/dfak\\sflka/");
            fail("j");
        } catch (Exception e) {System.out.print("corre");}
    }
}
