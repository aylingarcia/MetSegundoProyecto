package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import org.mockito.*;

import clases.*;

public class Test_main {
    private Platillo platilloPrueba;
    public Test_main()
    {
    }

    @BeforeEach
    public void setUp()
    {
        platilloPrueba = new Platillo("carne asada");
    }

    @AfterEach
    public void tearDown()
    {
    }
    @Test
    public void testInexistenciaComponente() {
        assertFalse(platilloPrueba.existe("papa"));
    }
    
    @Test
    public void testExistenciaComponente() {
        Componente c = new Componente("papa");
        platilloPrueba = mock(Platillo.class);
        when(platilloPrueba.insertarComponente(c)).thenReturn(true);
        platilloPrueba.insertarComponente(c);
        assertTrue(platilloPrueba.existe("papa"));
    }
    
    @Test
    public void testComponentePrincipal() {
        
    }
}
