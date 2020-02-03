/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliar;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MIPC
 */
public class ConexionTest {
    
    public ConexionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ejecutarSentencia method, of class Conexion.
     */
    @Test
    public void testEjecutarSentencia() {
        System.out.println("ejecutarSentencia");
        Conexion instance = new Conexion();
        boolean expResult = true;
        boolean result = instance.ejecutarSentencia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      //  fail("The test case is a prototype.");
    }

    /**
     * Test of iniciar_conexion method, of class Conexion.
     */
    @Test
    public void testIniciar_conexion() {
        System.out.println("iniciar_conexion");
        Conexion instance = new Conexion();
        instance.iniciar_conexion();
        // TODO review the generated test code and remove the default call to fail.
     //   fail("The test case is a prototype.");
    }

    /**
     * Test of anular_puentes method, of class Conexion.
     */
    @Test
    public void testAnular_puentes() {
        System.out.println("anular_puentes");
        Conexion instance = new Conexion();
        instance.anular_puentes();
        // TODO review the generated test code and remove the default call to fail.
       //fail("The test case is a prototype.");
    }

    /**
     * Test of getConexion method, of class Conexion.
     */
    @Test
    public void testGetConexion() {
        System.out.println("getConexion");
        Conexion instance = new Conexion();
        Connection expResult = null;
        Connection result = instance.getConexion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getProcedimiento method, of class Conexion.
     */
    @Test
    public void testGetProcedimiento() {
        System.out.println("getProcedimiento");
        Conexion instance = new Conexion();
        CallableStatement expResult = null;
        CallableStatement result = instance.getProcedimiento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of getResultado method, of class Conexion.
     */
    @Test
    public void testGetResultado() {
        System.out.println("getResultado");
        Conexion instance = new Conexion();
        ResultSet expResult = null;
        ResultSet result = instance.getResultado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setConexion method, of class Conexion.
     */
    @Test
    public void testSetConexion() {
        System.out.println("setConexion");
        Connection conexion = null;
        Conexion instance = new Conexion();
        instance.setConexion(conexion);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setProcedimiento method, of class Conexion.
     */
    @Test
    public void testSetProcedimiento() {
        System.out.println("setProcedimiento");
        CallableStatement procedimiento = null;
        Conexion instance = new Conexion();
        instance.setProcedimiento(procedimiento);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of setResultado method, of class Conexion.
     */
    @Test
    public void testSetResultado() {
        System.out.println("setResultado");
        ResultSet resultado = null;
        Conexion instance = new Conexion();
        instance.setResultado(resultado);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
