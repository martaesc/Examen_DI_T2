package org.example.examendit2;

import java.time.LocalDate;
import java.util.List;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Esta clase representa una biblioteca con libros, préstamos y usuarios.
 */
public class Biblioteca {

    private List<Libro> libros;
    private List<Prestamo> prestamos;
    private List<Usuario> usuarios;


    /**
     * Constructor para la clase Biblioteca.
     * Inicializa las listas de libros, préstamos y usuarios.
     */
    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    /**
     * Devuelve la lista de libros en la biblioteca.
     *
     * @return Lista de libros.
     */
    public List<Libro> getLibros() {
        return libros;
    }

    /**
     * Establece la lista de libros en la biblioteca.
     *
     * @param libros Lista de libros.
     */
    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    /**
     * Devuelve la lista de préstamos en la biblioteca.
     *
     * @return Lista de préstamos.
     */
    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    /**
     * Establece la lista de préstamos en la biblioteca.
     *
     * @param prestamos Lista de préstamos.
     */
    public void setPrestamos(List<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    /**
     * Devuelve la lista de usuarios en la biblioteca.
     *
     * @return Lista de usuarios.
     */
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Establece la lista de usuarios en la biblioteca.
     *
     * @param usuarios Lista de usuarios.
     */
    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }


    /**
     * Añade un nuevo libro a la biblioteca.
     *
     * @param idLibro El ID del libro.
     * @param titulo  El título del libro.
     * @param isbn    El ISBN del libro.
     * @throws IllegalArgumentException Si ya existe un libro con el mismo ID o ISBN.
     */
    public void AltaLibro(int idLibro, String titulo, String isbn) {
        Libro libro = new Libro(idLibro, titulo, isbn);
        if (libros.stream().anyMatch(l -> l.getIdLibro() == idLibro || l.getIsbn().equals(isbn))) {
            throw new IllegalArgumentException("Ya existe un libro con el mismo id o el mismo ISBN");
        }
        libros.add(libro);
    }

    /**
     * Elimina un libro de la biblioteca.
     *
     * @param idLibro El ID del libro.
     */
    public void BajaLibro(int idLibro) {
        libros.removeIf(libro -> libro.getIdLibro() == idLibro);
    }


    /**
     * Presta un libro a un usuario.
     *
     * @param idLibro    El ID del libro a prestar.
     * @param dniUsuario El DNI del usuario que va a tomar prestado el libro.
     * @throws IllegalArgumentException Si el libro no existe.
     */
    public void Prestar(int idLibro, String dniUsuario) {
        Optional<Libro> libro = libros.stream().filter(l -> l.getIdLibro() == idLibro).findFirst();
        if (!libro.isPresent()) {
            throw new IllegalArgumentException("El libro no existe");
        }

        Usuario usuario;
        Optional<Usuario> usuarioOpt = usuarios.stream().filter(u -> u.getDniUsuario().equals(dniUsuario)).findFirst();
        if (!usuarioOpt.isPresent()) {
            usuario = new Usuario(dniUsuario);
            usuarios.add(usuario);
        } else {
            usuario = usuarioOpt.get();
            if (usuario.isSancionado()) {
                return;
            }
        }
        Prestamo prestamo = new Prestamo(idLibro, dniUsuario, null);
        prestamos.add(prestamo);
    }


    /**
     * Devuelve un libro prestado por un usuario.
     *
     * @param idLibro    El ID del libro a devolver.
     * @param dniUsuario El DNI del usuario que va a devolver el libro.
     * @throws IllegalArgumentException Si el préstamo no existe.
     */
    public void Devolver(int idLibro, String dniUsuario) {
        Optional<Prestamo> prestamoOpt = prestamos.stream()
                .filter(p -> p.getIdLibro() == idLibro && p.getDniUsuario().equals(dniUsuario))
                .findFirst();

        if (!prestamoOpt.isPresent()) {
            throw new IllegalArgumentException("El prestamo no existe");
        }

        Prestamo prestamo = prestamoOpt.get();
        if (LocalDate.now().isAfter(prestamo.getFechaDevolucion())) {
            Optional<Usuario> usuarioOpt = usuarios.stream()
                    .filter(u -> u.getDniUsuario().equals(dniUsuario))
                    .findFirst();

            if (usuarioOpt.isPresent()) {
                Usuario usuario = usuarioOpt.get();
                usuario.Sancionar();
            }
        }
        prestamos.remove(prestamo);
    }
}








