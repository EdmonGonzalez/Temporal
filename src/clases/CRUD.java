
package clases;
import java.util.ArrayList;
import java.sql.*;

public class CRUD {
    
    Database db = new Database();
    Empleado emp = new Empleado();
    
    public ArrayList<Object[]> seleccionar(String tabla){
        ArrayList<Object[]> data = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet  rs;
        ResultSetMetaData meta;
        String sql ="select * from " + tabla;   
        try {
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(
                db.getUrl(),
                db.getUsuario(),
                db.getContraseña()
            );
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        meta = rs.getMetaData();
        
        while(rs.next()){
            Object[] fila = new Object[meta.getColumnCount()];
            for(int i=0; i<fila.length; i++){
                fila[i]=rs.getObject(i+1);
            }
            data.add(fila);
        }     
        con.close(); 
        } catch (ClassNotFoundException | SQLException e) {
            
        }finally{
            return data;
        }
    }
    
    public boolean insertar(Object obj, String tabla){
        Connection con;
        PreparedStatement pst;
        String sql="";
        switch(tabla){
            case "empleado":
                emp = (Empleado)obj;
                sql="inset into empleado values("+
                        emp.getCarnet()+ ",'"+
                        emp.getNombres()+"','"+
                        emp.getApellidos()+"',"+
                        emp.getSalario()+")";
                break;
            case "otraTabla":
                break;
        }
        try {
            Class.forName(db.getDriver());
            con= DriverManager.getConnection(
                    db.getUrl(),
                    db.getUsuario(),
                    db.getContraseña()
            );
            pst= con.prepareStatement(sql);
            pst.executeUpdate();
            con.close();
            return true;
        } catch (ClassNotFoundException | SQLException e) {       
            return false;
        }
            
        
        
        
        
        
    }
    
    
    
    
}
    
    
    
    
    
    
    
    
    

