public class Cliente {
    private String nombre; // Nombre del cliente
    private String apellido; // Apellido del cliente
    private String documento; // Documento de identidad del cliente
    private String numeroDeContacto; // Número de contacto del cliente
    private String email; // Correo electrónico del cliente

    // Constructor para inicializar un nuevo cliente
    public Cliente(String nombre, String apellido, String documento, String numeroDeContacto, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.numeroDeContacto = numeroDeContacto;
        this.email = email;
    }

    // Getters para acceder a los atributos
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getDocumento() { return documento; }
    public String getNumeroDeContacto() { return numeroDeContacto; }
    public String getEmail() { return email; }

    // Método toString para representar el cliente como una cadena
    @Override
    public String toString() {
        return "Cliente{" + "nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + ", documento='" + documento + '\'' + ", numeroDeContacto='" + numeroDeContacto + '\'' + ", email='" + email + '\'' + '}';
    }
}