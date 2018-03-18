
package clases;

public class Database {
    private String url;
    private String driver;
    private String usuario;
    private String contraseña;

    public Database() {
        this.url = "jdbc:mysql://localhost:3306/repit";
        this.driver = "com.mysql.jdbc.Driver";
        this.usuario = "root";
        this.contraseña = "";
    }

    public String getUrl() {
        return url;
    }

    public String getDriver() {
        return driver;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }
    
    
    
    
    
}
