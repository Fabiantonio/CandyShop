
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.management.StringValueExp;
import javax.swing.JOptionPane;
import modelo.ConsultasWeed;
import modelo.Weed;
import vista.frmWeed;


public class CtrlWeed implements ActionListener{
    
    private Weed mod;
    private ConsultasWeed modC;
    private frmWeed frm;
    
    public CtrlWeed (Weed mod, ConsultasWeed modC, frmWeed frm){
        
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        
    }
    
    public void iniciarWeed(){
        frm.setTitle("Weed");
        frm.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == frm.btnGuardar){
            
            mod.setCodigo(Integer.parseInt(frm.txtCodigo.getText()));
            mod.setNombre(frm.txtNombre.getText());
            mod.setGramos(Integer.parseInt(frm.txtGramos.getText()));
            mod.setRaza(frm.txtRaza.getText());
            mod.setGenero(frm.cbxGenero.getSelectedItem().toString());
            
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
            mod.setRaza(frm.txtRaza.getText());
            mod.setGenero(frm.cbxGenero.getSelectedItem().toString());
            
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
                frm.txtRaza.setText(mod.getRaza());
                frm.cbxGenero.setSelectedItem(mod.getGenero());
                
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
        frm.txtRaza.setText(null);
        frm.cbxGenero.setSelectedIndex(0);
        
    }
    
}
