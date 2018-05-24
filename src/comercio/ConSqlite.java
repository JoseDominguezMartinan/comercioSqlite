/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comercio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author jdominguezmartinan
 */
public class ConSqlite
{
    public static String nomeProducto;
    public static String precioProducto;
    
    // generamos la base de datos y metemos datos en ella
    private String url = "/home/local/DANIELCASTELAO/jdominguezmartinan/NetBeansProjects/comercio/coches.db"; // al conectar si no existe se generara automaticamente 
    private Connection connect; // objeto de tipo connection, proporciona metodos para manexar a base de datos
    private PreparedStatement st; // objeto de tipo PreparedStatement, usado para enviar sentenzas sql a base de datos
    private ResultSet datos; // para traballar coa fila actual da taboa 
    
    /**
     * unha vez conectados a base de datos , pode ser que a taboa da que estamos
     * a falar non haxa sido creada nunca, para non usar un xestor a parte que
     * NetBeans o que fixen foi crear este mmetodo que crea a tabla en caso de
     * que non exista
     */
    public void crearTablaProducto()
    {
        try
        {
            st = connect.prepareStatement("create table if not exists productos(refProdu varchar primary key, nome varchar(40),refPrecio varchar(40))"); // enviamos a sentenza na cal se di que se cree a taboa en caso de non existir
            st.execute();
        } catch(SQLException ex)
        { // en caso de erro salta a excepcion 
            System.out.println("No se pudo crear la tabla "+ex.getMessage());
        }
    }
    public void crearTablaVentas()
    {
        try
        {
            st = connect.prepareStatement("create table if not exists ventas(numventa varchar primary key, refproducto varchar(40),cantidade float)"); // enviamos a sentenza na cal se di que se cree a taboa en caso de non existir
            st.execute();
        } catch(SQLException ex)
        { // en caso de erro salta a excepcion 
            System.out.println("No se pudo crear la tabla "+ex.getMessage());
        }
    }
    public void crearTablaTicket()
    {
        try
        {
            st = connect.prepareStatement("create table if not exists tickets(numventa varchar primary key, nome varchar(40),precioTotal float)"); // enviamos a sentenza na cal se di que se cree a taboa en caso de non existir
            st.execute();
        } catch(SQLException ex)
        { // en caso de erro salta a excepcion 
            System.out.println("No se pudo crear la tabla "+ex.getMessage());
        }
    }
    
    
    /**
     * metodo para conectase a base de datos
     */
    public void connect()
    {
        try
        { // lanzamos una excepcion en caso de non poder conectarse a  base de datos 
            connect = DriverManager.getConnection("jdbc:sqlite:"+url); // co obxeto Connection realizamos a conexion enviando a url da base de datos a que nos imos conectar 
            if(connect!=null)
            { //se conseguimos conectarnos con exito mostranos un mensaxe satisfactorio
                System.out.println("Conectado");
            }
        } catch(SQLException ex)
        { // se non se pode conectar salta a excepcion 
            System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
        }
    }
     /**
     * metodo para cerrar a conexion coa base de datos
     */
    public void close()
    {
        try
        {
            connect.close(); // cerramos a conexion 
            System.out.println("desconectado ");
        } catch(SQLException ex)
        { // en caso de erro lanzamos a excepcion
            System.out.println("ha ocurrido un error \n"+ex.getMessage());
        }

    }
    public void insertarProducto(Producto producto)
    {
        try
        {
            st = connect.prepareStatement("insert into productos (refProducto, nome, refPrecio) values (?,?,?)"); // prepara unha sentenza na cal o que esta entre parentesis vai ser sustituido
            st.setString(1,producto.getRefProducto().toUpperCase()); // sustituimos cada un dos valores polo que nos interesa , ponemos la primera letra en mayuscula
            st.setString(2,producto.getNome().toUpperCase());
            st.setString(3,producto.getRefPrecio().toUpperCase());
            st.execute();
        } catch(SQLException ex)
        { // en caso de erro salta a excepcion 
            System.out.println("No se pudo insertar el producto"+ex.getMessage());
        }
    }
    public void insertarProducto(Producto producto)
    {
        try
        {
            st = connect.prepareStatement("insert into productos (refProducto, nome, refPrecio) values (?,?,?)"); // prepara unha sentenza na cal o que esta entre parentesis vai ser sustituido
            st.setString(1,producto.getRefProducto().toUpperCase()); // sustituimos cada un dos valores polo que nos interesa , ponemos la primera letra en mayuscula
            st.setString(2,producto.getNome().toUpperCase());
            st.setString(3,producto.getRefPrecio().toUpperCase());
            st.execute();
        } catch(SQLException ex)
        { // en caso de erro salta a excepcion 
            System.out.println("No se pudo insertar el producto"+ex.getMessage());
        }
    }
}
