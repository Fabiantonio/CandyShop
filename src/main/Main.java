
package main;

import controlador.CtrlMetha;
import controlador.CtrlWeed;
import modelo.ConsultasMetha;
import modelo.ConsultasWeed;
import modelo.Methamphetamine;
import modelo.Weed;
import vista.frmInicioSesion;
import vista.frmMetha;
import vista.frmWeed;


public class Main {
    
    public static void main(String[] args) {
        
        /*Weed mod = new Weed();
        ConsultasWeed modC = new ConsultasWeed();
        frmWeed frm = new frmWeed();
        CtrlWeed ctrl = new CtrlWeed(mod, modC, frm);
        
        ctrl.iniciarWeed();
        frm.setVisible(true);*/
        
        /*Methamphetamine mod2 = new Methamphetamine();
        ConsultasMetha modC2 = new ConsultasMetha();
        frmMetha frm2 = new frmMetha();
        CtrlMetha ctrl2 = new CtrlMetha(mod2, modC2, frm2);
        
        ctrl2.iniciarMetha();
        frm2.setVisible(true);*/
        frmInicioSesion inicio = new frmInicioSesion();
        inicio.setVisible(true);
    }
    
}
