package org.example.examendit2;

/**
 * Clase que representa un usuario de la biblioteca con un DNI, una fecha de alta de sanción y un estado de sanción.
 */
public class Usuario {

    private String dniUsuario;
    private String fechaAltaSancion;
    private boolean isSancionado;


    /**
     * Constructor para la clase Usuario.
     *
     * @param dniUsuario DNI del usuario.
     */
    public Usuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
        this.isSancionado = false;
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
     * Devuelve la fecha de alta de sanción del usuario.
     *
     * @return Fecha de alta de sanción del usuario.
     */
    public String getFechaAltaSancion() {
        return fechaAltaSancion;
    }

    /**
     * Establece la fecha de alta de sanción del usuario.
     *
     * @param fechaAltaSancion Fecha de alta de sanción del usuario.
     */
    public void setFechaAltaSancion(String fechaAltaSancion) {
        this.fechaAltaSancion = fechaAltaSancion;
    }

    /**
     * Devuelve el estado de sanción del usuario.
     *
     * @return Estado de sanción del usuario.
     */
    public boolean isSancionado() {
        return isSancionado;
    }


    /**
     * Sanciona al usuario.
     */
    public void Sancionar() {
        this.isSancionado = true;

    }

    /**
     * Quita la sanción al usuario.
     */
    public void QuitarSanción() {
        this.isSancionado = false;

    }

    /**
     * Devuelve una representación en forma de cadena de la clase Usuario.
     * <p>
     * Returns: Representación en forma de cadena de la clase Usuario.
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "dniUsuario='" + dniUsuario + '\'' +
                ", fechaAltaSancion='" + fechaAltaSancion + '\'' +
                ", isSancionado=" + isSancionado +
                '}';
    }
}
