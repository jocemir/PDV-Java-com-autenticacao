/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author JJV
 */
public class Utilitarios {
    
    //Método Limpa Campos
    public void LimpaTela(JPanel container){
        Component components[] = container.getComponents();
        for (Component component : components){
            if(component instanceof JTextField){
                ((JTextField)component).setText(null);
            }
        }
    }
    
}
