package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Usuario;
import model.UsuarioDAO;
import view.FrmDashboard;
import view.FrmLogin;
import view.FrmInicio;

public class LoginController {

    private FrmLogin vista;
    private UsuarioDAO modelo;

    public LoginController(FrmLogin vista, UsuarioDAO modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.getBtnCancelar().addActionListener(e -> cancelar());

        this.vista.getBtnIngresar().addActionListener(e -> login());
    }

    private void login() {
        String user = vista.getTxtUsuario().getText();
        String pass = new String(vista.getTxtPassword().getPassword());

        Usuario u = modelo.login(user, pass);

        if (u != null) {
            vista.dispose();
            FrmDashboard dashboard = new FrmDashboard(u);
            dashboard.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(vista, "Usuario o clave incorrectos");
        }
    }
    private void cancelar() {
    vista.dispose(); // Cierra el login
    FrmInicio inicio = new FrmInicio(); // Abre el inicio nuevamente
    inicio.setVisible(true);
}
}