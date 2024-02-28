package org.example.examendit2;

import java.time.LocalDate;

/**
 * Esta clase representa un préstamo de un libro a un usuario con un identificador de libro, un DNI de usuario y una fecha de devolución.
 */
public class Prestamo {
    private int idLibro;
    private String dniUsuario;
    private LocalDate fechaDevolucion;

    /**
     * Constructor para la clase Prestamo.
     *
     * @param idLibro         Identificador del libro.
     * @param dniUsuario      DNI del usuario.
     * @param fechaDevolucion Fecha de devolución del libro.
     */
    public Prestamo(int idLibro, String dniUsuario, LocalDate fechaDevolucion) {
        this.idLibro = idLibro;
        this.dniUsuario = dniUsuario;
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * Constructor sin argumentos para la clase Prestamo.
     */
    public Prestamo() {
    }

    /**
     * Devuelve el id del libro.
     *
     * @return id del libro.
     */
    public int getIdLibro() {
        return idLibro;
    }

    /**
     * Establece el id del libro.
     *
     * @param idLibro id del libro.
     */
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    /**
     * Devuelve el DNI del usuario.
     *
     * @return DNI del usuario.
     */
    public String getDniUsuario() {
        return dniUsuario;
    }

    /**
     * Establece el DNI del usuario.
     *
     * @param dniUsuario DNI del usuario.
     */
    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    /**
     * Devuelve la fecha de devolución.
     *
     * @return Fecha de devolución.
     */
    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    /**
     * Establece la fecha de devolución.
     *
     * @param fechaDevolucion Fecha de devolución.
     */
    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * Devuelve una representación en forma de cadena de la clase Prestamo.
     *
     * @return Representación en forma de cadena de la clase Prestamo.
     */
    @Override
    public String toString() {
        return "Prestamo{" +
                "idLibro=" + idLibro +
                ", dniUsuario='" + dniUsuario + '\'' +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }
}

