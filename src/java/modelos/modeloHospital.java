package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import objetos.Departamento;
import objetos.Empleado;
import objetos.Subordinado;
import objetos.Usuario;
import oracle.jdbc.OracleDriver;

public class modeloHospital {

    CachedRowSet rs;
    Connection cn;

    private void conectarOracle() throws SQLException {
        DriverManager.registerDriver(new OracleDriver());
        this.rs
                = RowSetProvider.newFactory().createCachedRowSet();
        this.cn = DriverManager.getConnection("jdbc:oracle:thin:@LOCALHOST:1521:XE", "SYSTEM", "java");
        this.rs.setUrl("jdbc:oracle:thin:@LOCALHOST:1521:XE");
        this.rs.setUsername("SYSTEM");
        this.rs.setPassword("java");
    }

    public Empleado buscarEmpleado(int empno) throws SQLException {
        this.conectarOracle();
        String consulta = "SELECT * FROM EMP WHERE EMP_NO = ?";
        this.rs.setCommand(consulta);
        this.rs.setInt(1, empno);
        this.rs.execute();
        this.rs.beforeFirst();
        if (this.rs.next()) {
            Empleado emp = new Empleado();
            emp.setApellido(this.rs.getString("APELLIDO"));
            emp.setOficio(this.rs.getString("OFICIO"));
            emp.setSalario(this.rs.getString("SALARIO"));
            return emp;
        } else {
            return null;
        }
    }

    public ArrayList<Departamento> getDepartamentos() throws SQLException {
        this.conectarOracle();
        String consulta = "SELECT * FROM DEPT";
        this.rs.setCommand(consulta);
        this.rs.execute();
        this.rs.beforeFirst();
        ArrayList<Departamento> lista = new ArrayList();
        while (this.rs.next()) {
            Departamento d = new Departamento();
            d.setNumero(this.rs.getInt("DEPT_NO"));
            d.setNombre(this.rs.getString("DNOMBRE"));
            d.setLocalidad(this.rs.getString("LOC"));
            lista.add(d);
        }
        return lista;
    }

    public ArrayList<Empleado> getEmpleadosDepartamento(int deptno) throws SQLException {
        this.conectarOracle();
        String consulta = "SELECT * FROM EMP WHERE DEPT_NO = ?";
        this.rs.setCommand(consulta);
        this.rs.setInt(1, deptno);
        this.rs.execute();
        this.rs.beforeFirst();
        ArrayList<Empleado> lista = new ArrayList();
        while (this.rs.next()) {
            Empleado e = new Empleado();
            e.setApellido(this.rs.getString("APELLIDO"));
            e.setOficio(this.rs.getString("OFICIO"));
            e.setSalario(this.rs.getString("SALARIO"));
            lista.add(e);
        }
        return lista;
    }

    public ArrayList<Empleado> getEmpleados() throws SQLException {
        this.conectarOracle();
        String consulta = "SELECT * FROM EMP";
        this.rs.setCommand(consulta);
        this.rs.execute();
        this.rs.beforeFirst();
        ArrayList<Empleado> lista = new ArrayList();
        while (this.rs.next()) {
            Empleado e = new Empleado();
            e.setApellido(this.rs.getString("APELLIDO"));
            e.setOficio(this.rs.getString("OFICIO"));
            e.setSalario(this.rs.getString("SALARIO"));
            lista.add(e);
        }
        return lista;
    }

    public void insertarDepartamento(int deptno, String nombre, String localidad) throws SQLException {
        this.conectarOracle();
        String consulta = "INSERT INTO DEPT VALUES (?,?,?)";
        PreparedStatement pst = this.cn.prepareStatement(consulta);
        pst.setInt(1, deptno);
        pst.setString(2, nombre);
        pst.setString(3, localidad);
        pst.execute();
    }

    public Usuario validarEmpleado(String apellido, int empno) throws SQLException {
        this.conectarOracle();
        String consulta = "SELECT * FROM EMP WHERE UPPER(APELLIDO)=UPPER(?)"
                + " AND EMP_NO=?";
        this.rs.setCommand(consulta);
        this.rs.setString(1, apellido);
        this.rs.setInt(2, empno);
        this.rs.execute();
        this.rs.beforeFirst();
        if (this.rs.next()) {
            Usuario user = new Usuario();
            user.setApellido(this.rs.getString("APELLIDO"));
            user.setIdempleado(this.rs.getInt("EMP_NO"));
            user.setRol(this.rs.getString("OFICIO"));
            return user;
        } else {
            return null;
        }
    }

    public ArrayList<Subordinado> getSubordinados(int idempleado) throws SQLException {
        this.conectarOracle();
        String consulta = "SELECT * FROM EMP WHERE DIR = ?";
        this.rs.setCommand(consulta);
        this.rs.setInt(1, idempleado);
        this.rs.execute();
        this.rs.beforeFirst();
        ArrayList<Subordinado> lista = new ArrayList();
        while (this.rs.next()) {
            Subordinado emp = new Subordinado();
            emp.setApellido(this.rs.getString("APELLIDO"));
            emp.setEmpno(this.rs.getInt("EMP_NO"));
            lista.add(emp);
        }
        return lista;
    }

    public void eliminarEmpleado(int idempleado) throws SQLException {
        this.conectarOracle();
        String consulta = "DELETE FROM EMP WHERE EMP_NO = ?";
        PreparedStatement pst = this.cn.prepareStatement(consulta);
        pst.setInt(1, idempleado);
        pst.executeUpdate();
    }
    
    
    
    

}
