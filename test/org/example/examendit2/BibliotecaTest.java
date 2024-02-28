package org.example.examendit2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Clase de prueba para la clase Biblioteca.
 */
class BibliotecaTest {

    private Biblioteca biblioteca;


    /**
     * Configuración inicial para las pruebas.
     */
    @BeforeEach
    void setUp() {
        biblioteca = new Biblioteca();
    }


    /**
     * Prueba el método Prestar cuando el libro no existe.
     */
    @Test
    void testPrestarLibroNoExiste() {
        assertThrows(IllegalArgumentException.class, () -> biblioteca.Prestar(1, "12345678A"));
    }


    /**
     * Prueba el método Prestar cuando el usuario no existe.
     */
    @Test
    public void testPrestarUsuarioNoExiste() {
        int idLibro = 1;
        String dniUsuario = "12345678A";
        biblioteca.AltaLibro(idLibro, "El Quijote", "123456789");
        biblioteca.Prestar(idLibro, dniUsuario);
        assertEquals(1, biblioteca.getUsuarios().size());
    }


    /**
     * Prueba el método Prestar cuando el libro y el usuario existen.
     */
    @Test
    void testPrestarLibroExisteUsuarioExiste() {
        biblioteca.AltaLibro(1, "El Quijote", "123456789");
        biblioteca.Prestar(1, "12345678A");
        assertEquals(1, biblioteca.getPrestamos().size());
    }


    /**
     * Prueba el método Devolver dentro de la fecha..
     */
    @Test
    void testDevolverEnFecha() {
        biblioteca.AltaLibro(1, "El Quijote", "123456789");
        biblioteca.Prestar(1, "12345678A");
        biblioteca.Devolver(1, "12345678A");
        assertFalse(biblioteca.getUsuarios().getFirst().isSancionado());
    }

    /**
     * Prueba el método Devolver fuera de la fecha.
     */
    @Test
    void testDevolverFueraDeFecha() {
        Usuario usuario = new Usuario("12345678A");
        biblioteca.getUsuarios().add(usuario); // Add the user to the library's user list
        biblioteca.AltaLibro(1, "El Quijote", "123456789");
        biblioteca.Prestar(1, usuario.getDniUsuario());
        // primero se establece la fecha de devolución a 15 días después de la fecha actual
        biblioteca.getPrestamos().getFirst().setFechaDevolucion(LocalDate.now().plusDays(15));
        // después se establece la fecha de devolución a 1 día antes de la fecha actual
        biblioteca.getPrestamos().getFirst().setFechaDevolucion(LocalDate.now().minusDays(1));
        biblioteca.Devolver(1, usuario.getDniUsuario());
        assertTrue(biblioteca.getUsuarios().getFirst().isSancionado());
    }


    /**
     * Prueba el método AltaLibro con atributos únicos no repetidos.
     */
    @Test
    void testAltaLibroAtributosUnicosNoRepetidos() {
        biblioteca.AltaLibro(1, "El Quijote", "123456789");
        assertEquals(1, biblioteca.getLibros().size());
    }

    /**
     * Prueba el método AltaLibro con atributos únicos repetidos.
     */
    @Test
    void testAltaLibroAtributosUnicosRepetidos() {
        biblioteca.AltaLibro(1, "El Quijote", "123456789");
        assertThrows(IllegalArgumentException.class, () -> biblioteca.AltaLibro(1, "El Quijote", "123456789"));
    }
}