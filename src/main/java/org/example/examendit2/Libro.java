package org.example.examendit2;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase que representa un libro.
 */
public class Libro {

    private int idLibro; // Obligatorio/Único
    private String titulo; // Obligatorio
    private String isbn; // Obligatorio/Único
    private String autor;
    private Tematica tematica;
    private LocalDate fechaEdicion;


    /**
     * Constructor para la clase Libro con todos los atributos.
     *
     * @param idLibro      Identificador del libro.
     * @param titulo       Título del libro.
     * @param isbn         ISBN del libro.
     * @param autor        Autor del libro.
     * @param tematica     Temática del libro.
     * @param fechaEdicion Fecha de edición del libro.
     */
    public Libro(int idLibro, String titulo, String isbn, String autor, Tematica tematica, LocalDate fechaEdicion) {
        if (idLibro == 0 || titulo == null || titulo.isEmpty() || isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("El id del Libro, el titulo y el Isbn son obligatorios");
        }
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.tematica = tematica;
        this.fechaEdicion = fechaEdicion;
    }


    /**
     * Constructor para la clase Libro.
     *
     * @param idLibro Identificador del libro.
     * @param titulo  Título del libro.
     * @param isbn    ISBN del libro.
     */
    public Libro(int idLibro, String titulo, String isbn) {
        if (idLibro == 0 || titulo == null || titulo.isEmpty() || isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("El id del Libro, el titulo y el Isbn son obligatorios");
        }
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.isbn = isbn;
    }

    /**
     * Devuelve el identificador del libro.
     *
     * @return Identificador del libro.
     */
    public int getIdLibro() {
        return idLibro;
    }

    /**
     * Establece el identificador del libro.
     *
     * @param idLibro Identificador del libro.
     */
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    /**
     * Devuelve el título del libro.
     *
     * @return Título del libro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del libro.
     *
     * @param titulo Título del libro.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Devuelve el ISBN del libro.
     *
     * @return ISBN del libro.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Establece el ISBN del libro.
     *
     * @param isbn ISBN del libro.
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Devuelve el autor del libro.
     *
     * @return Autor del libro.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Establece el autor del libro.
     *
     * @param autor Autor del libro.
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Devuelve la temática del libro.
     *
     * @return Temática del libro.
     */
    public Tematica getTematica() {
        return tematica;
    }

    /**
     * Establece la temática del libro.
     *
     * @param tematica Temática del libro.
     */
    public void setTematica(Tematica tematica) {
        this.tematica = tematica;
    }

    /**
     * Devuelve la fecha de edición del libro.
     *
     * @return Fecha de edición del libro.
     */
    public LocalDate getFechaEdicion() {
        return fechaEdicion;
    }

    /**
     * Establece la fecha de edición del libro.
     *
     * @param fechaEdicion Fecha de edición del libro.
     */
    public void setFechaEdicion(LocalDate fechaEdicion) {
        this.fechaEdicion = fechaEdicion;
    }

    /**
     * Comprueba si este libro es igual a otro objeto.
     * Un libro se considera igual a otro si su idLibro e isbn son iguales.
     *
     * @param o El objeto con el que comparar.
     * @return true si son iguales, false en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return idLibro == libro.idLibro && isbn.equals(libro.isbn);
    }

    /**
     * Genera un hash basado en el idLibro e isbn del libro.
     *
     * @return El hash del libro.
     */
    @Override
    public int hashCode() {
        return Objects.hash(idLibro, isbn);
    }

    /**
     * Devuelve una representación en cadena del libro.
     *
     * @return Una cadena que representa al libro.
     */
    @Override
    public String toString() {
        return "Libro{" +
                "idLibro=" + idLibro +
                ", titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autor='" + autor + '\'' +
                ", tematica=" + tematica +
                ", fechaEdicion=" + fechaEdicion +
                '}';
    }
}
