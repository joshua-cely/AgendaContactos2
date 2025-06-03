package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FrmInicio;
import view.FrmLogin;

public class InicioController {

    private FrmInicio vista;

    public InicioController(FrmInicio vista) {
        this.vista = vista;
        iniciarEventos();
    }

    private void iniciarEventos() {
        vista.getBtnIngresar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose(); // Cierra esta ventana
                new FrmLogin().setVisible(true); // Abre Login
            }
        });
    }
}
