
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ConsultasMetha;
import modelo.Methamphetamine;
import vista.frmMetha;


public class CtrlMetha implements ActionListener{
    
    private Methamphetamine mod;
    private ConsultasMetha modC;
    private frmMetha frm;
    
    public CtrlMetha (Methamphetamine mod, ConsultasMetha modC, frmMetha frm){
        
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        
    }
    
    public void iniciarMetha(){
        frm.setTitle("Methamphetamine");
        frm.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == frm.btnGuardar){
            
            mod.setCodigo(Integer.parseInt(frm.txtCodigo.getText()));
            mod.setNombre(frm.txtNombre.getText());
            mod.setGramos(Integer.parseInt(frm.txtGramos.getText()));
            mod.setPureza(Integer.parseInt(frm.txtPureza.getText()));
            mod.setColor(frm.txtColor.getText());
            
            if(modC.registrar(mod)){
                
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiarCajas();
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al guardar Registro");
                limpiarCajas();
            }
            
        }
        
        if(ae.getSource() == frm.btnModificar){
            
            mod.setCodigo(Integer.parseInt(frm.txtCodigo.getText()));
            mod.setNombre(frm.txtNombre.getText());
            mod.setGramos(Integer.parseInt(frm.txtGramos.getText()));
            mod.setPureza(Integer.parseInt(frm.txtPureza.getText()));
            mod.setColor(frm.txtColor.getText());
            
            if(modC.modificar(mod)){
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiarCajas();
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al Modificar Registro");
                limpiarCajas();
            }
            
        }
        
        if(ae.getSource() == frm.btnEliminar){
            
            mod.setCodigo(Integer.parseInt(frm.txtCodigo.getText()));
            
            if(modC.eliminar(mod)){
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiarCajas();
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al Eliminar Registro");
                limpiarCajas();
            }
            
        }
        
        if(ae.getSource() == frm.btnBuscar){
            
            mod.setCodigo(Integer.parseInt(frm.txtCodigo.getText()));
            
            if(modC.buscar(mod)){
                
                frm.txtCodigo.setText(String.valueOf(mod.getCodigo()));
                frm.txtNombre.setText(mod.getNombre());
                frm.txtGramos.setText(String.valueOf(mod.getGramos()));
                frm.txtPureza.setText(String.valueOf(mod.getPureza()));
                frm.txtColor.setText(mod.getColor());
                
                JOptionPane.showMessageDialog(null, "Registro Encontrado");
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Error al Encontrar Registro");
                limpiarCajas();
            }
            
        }
        
        if(ae.getSource() == frm.btnLimpiar){
            limpiarCajas();
        }
        
    }
    
    private void limpiarCajas(){
        
        frm.txtCodigo.setText(null);
        frm.txtNombre.setText(null);
        frm.txtGramos.setText(null);
        frm.txtPureza.setText(null);
        frm.txtColor.setText(null);
        
    }

}
