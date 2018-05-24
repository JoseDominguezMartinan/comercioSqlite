/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comercio;

import javax.swing.JOptionPane;

/**
 *
 * @author jose
 */
public class Comercio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Ticket ticket;
        Arrays arrays1=new Arrays();
        arrays1.utilizarNomePrecio(JOptionPane.showInputDialog("inserte o numero de referencia"));
        ticket=arrays1.crearTicket("2");
        System.out.println(ticket.toString());
        
        System.out.println(Arrays.nomeProducto+" "+Arrays.precioProducto);
        
    }
    
}
