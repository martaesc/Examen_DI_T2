package org.example.examendit2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Controlador de la interfaz de usuario de la aplicación.
 */
public class HelloController {
    ;
    @FXML
    private Button btnAlta;

    @FXML
    private Button btnBaja;

    @FXML
    private Button btnNuevoPrestamo;

    @FXML
    private DatePicker fechaEdicion;

    @FXML
    private ListView<Libro> listView;

    @FXML
    private TextField txtAutor;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtISBN;

    @FXML
    private ChoiceBox<Tematica> choicetematica;

    @FXML
    private TextField txtTitulo;

    public List<Libro> libros;
    private Biblioteca biblioteca;


    /**
     * Devuelve la lista de libros en la biblioteca.
     *
     * @return Lista de libros.
     */
    public List<Libro> getLibros() {
        return libros;
    }

    /**
     * Devuelve una lista obervable de los libros en la biblioteca para mostrar en la interfaz de usuario.
     *
     * @return Lista observable de libros.
     */
    public ObservableList<Libro> getLibrosParaMostrar() {
        return FXCollections.observableArrayList(libros);
    }

    /**
     * Inicializa la interfaz de usuario al cargar el archivo FXML.
     */
    @FXML
    public void initialize() {
        biblioteca = new Biblioteca();
        Tematica[] tipos = Tematica.values();
        ObservableList<Tematica> tiposList = FXCollections.observableArrayList(tipos);
        choicetematica.setItems(tiposList);

        actualizarListaLibros();
    }


    /**
     * Actualiza la lista de libros en la interfaz de usuario.
     */
    public void actualizarListaLibros() {
        listView.setItems(getLibrosParaMostrar());
    }

    /**
     * Da de alta un libro y lo añade a la lista de libros.
     */
    @FXML
    private void btnAltaLibro() {
        int idLibro = Integer.parseInt(txtID.getText());
        String titulo = txtTitulo.getText();
        String isbn = txtISBN.getText();
        String autor = txtAutor.getText();
        Tematica tematica = choicetematica.getValue();
        LocalDate fecha = fechaEdicion.getValue();

        if (idLibro == 0 || titulo == null || titulo.isEmpty() || isbn == null || isbn.isEmpty()) {
            throw new IllegalArgumentException("El id del Libro, el titulo y el Isbn son obligatorios");
        }

        Libro libro = new Libro(idLibro, titulo, isbn, autor, tematica, fecha);
        biblioteca.AltaLibro(idLibro, titulo, isbn);

        listView.getItems().add(libro);

        actualizarListaLibros();
    }

    /**
     * Elimina un libro de la lista de libros.
     */
    @FXML
    private void btnBajaLibro() {
        int idLibro = Integer.parseInt(txtID.getText());
        biblioteca.BajaLibro(idLibro);
        actualizarListaLibros();
    }

    /**
     * Presta un libro a un usuario.
     */
    @FXML
    private void btnNuevoPrestamo() {
        int idLibro = Integer.parseInt(txtID.getText());
        String dniUsuario = txtAutor.getText();
        biblioteca.Prestar(idLibro, dniUsuario);

        actualizarListaLibros();
    }

    /**
     * Limpia los campos de entrada en la interfaz de usuario.
     */
    public void limpiarCampos() {
        txtID.clear();
        txtTitulo.clear();
        txtISBN.clear();
        txtAutor.clear();
        choicetematica.setValue(null);
        fechaEdicion.setValue(null);

    }


}