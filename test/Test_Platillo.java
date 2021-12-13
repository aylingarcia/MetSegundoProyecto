package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import org.mockito.*;

import clases.*;

public class Test_Platillo {
    private Platillo platilloPrueba;
    private Componente principal;
    private Pedido pedido;
    public Test_Platillo()
    {
    }

    @BeforeEach
    public void setUp()
    {
        principal = new Componente("papa", "frita", 7);
        platilloPrueba = new Platillo(principal);
        pedido = new Pedido();
    }

    @AfterEach
    public void tearDown()
    {
    }
    @Test
    public void testInexistenciaComponente() {
        assertFalse(platilloPrueba.existeComponente(new Componente("arroz", "blanco", 15)));
    }
    
    @Test
    public void testExistenciaComponente() {
        assertTrue(platilloPrueba.existeComponente(principal));
    }
    
    @Test
    public void testEliminacionComponente() {
        Componente adicional = new Componente("huevo", "revuelto", 5);
        platilloPrueba.insertarComponente(adicional);
        platilloPrueba.removeComponente(adicional);
        assertFalse(platilloPrueba
                .existeComponente(adicional));
    }
    @Test
    public void testConservarComponentePrincipal() {
        platilloPrueba.removeComponente(principal);
        assertTrue(platilloPrueba.existeComponente(principal));
    }
    
    @Test
    public void testProbarIncrementoDecrementoComponenteEnPlatillo() {
        platilloPrueba.aumentarComponente(5,principal);
        assertEquals(6, platilloPrueba.getCantComponente(principal));
        platilloPrueba.aumentarComponente(-3, principal);
        assertEquals(3, platilloPrueba.getCantComponente(principal));
        platilloPrueba.aumentarComponente(-50, principal);
        assertEquals(1, platilloPrueba.getCantComponente(principal));
    }
    
    @Test
    public void testComponenteExistente() {
        assertFalse(platilloPrueba.insertarComponente(principal));
    }
}
