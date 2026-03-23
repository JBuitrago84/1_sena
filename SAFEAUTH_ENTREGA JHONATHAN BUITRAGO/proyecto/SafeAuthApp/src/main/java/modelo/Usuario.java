package modelo;

public class Usuario {
    
    private int id;
    private String usuario;
    private String email;
    private String contrasena;
    private int estado;

    // Constructor vacío
    public Usuario() {}

    // Constructor con parámetros
    public Usuario(String usuario, String email, String contrasena, int estado) {
        this.usuario = usuario;
        this.email = email;
        this.contrasena = contrasena;
        this.estado = estado;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}