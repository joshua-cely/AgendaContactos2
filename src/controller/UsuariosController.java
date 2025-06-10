package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Usuario;
import model.UsuarioDAO;
import view.FrmUsuarios;

public class UsuariosController implements ActionListener {

    private FrmUsuarios vista;
    private UsuarioDAO dao;
    private DefaultTableModel modeloTabla;

    public UsuariosController(FrmUsuarios vista) {
        this.vista = vista;
        this.dao = new UsuarioDAO();

        // Configurar listener para botones
        this.vista.btnNuevo.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnCancelar.addActionListener(this);

        // Evento de selección en la tabla para cargar datos en formulario
        this.vista.tblUsuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila = vista.tblUsuarios.getSelectedRow();
                if (fila != -1) {
                    vista.txtDocumento.setText(vista.tblUsuarios.getValueAt(fila, 0).toString());
                    vista.txtNombreCompleto.setText(vista.tblUsuarios.getValueAt(fila, 1).toString());
                    vista.txtUsuario.setText(vista.tblUsuarios.getValueAt(fila, 2).toString());
                    vista.txtContrasena.setText(vista.tblUsuarios.getValueAt(fila, 3).toString());
                }
            }
        });

        // Inicialmente listar usuarios
        listarUsuarios();
    }

    private void listarUsuarios() {
        List<Usuario> lista = dao.listarUsuarios();
        modeloTabla = (DefaultTableModel) vista.tblUsuarios.getModel();
        modeloTabla.setRowCount(0); // limpiar tabla antes de agregar

        for (Usuario u : lista) {
            Object[] row = {
                u.getDocumento(),
                u.getNombreCompleto(),
                u.getUsuario(),
                u.getClave()
            };
            modeloTabla.addRow(row);
        }
    }

    private void limpiarCampos() {
        vista.txtDocumento.setText("");
        vista.txtNombreCompleto.setText("");
        vista.txtUsuario.setText("");
        vista.txtContrasena.setText("");
        vista.tblUsuarios.clearSelection();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnNuevo) {
            if (vista.txtDocumento.getText().isEmpty() || vista.txtNombreCompleto.getText().isEmpty() ||
                vista.txtUsuario.getText().isEmpty() || vista.txtContrasena.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Por favor llena todos los campos");
                return;
            }
            Usuario u = new Usuario();
            u.setDocumento(vista.txtDocumento.getText());
            u.setNombreCompleto(vista.txtNombreCompleto.getText());
            u.setUsuario(vista.txtUsuario.getText());
            u.setClave(vista.txtContrasena.getText());

            if (dao.insertarUsuario(u)) {
                JOptionPane.showMessageDialog(vista, "Usuario agregado correctamente.");
                listarUsuarios();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al agregar usuario.");
            }
        }

        if (e.getSource() == vista.btnActualizar) {
            int fila = vista.tblUsuarios.getSelectedRow();
            if (fila != -1) {
                String documento = vista.tblUsuarios.getValueAt(fila, 0).toString();
                Usuario u = dao.buscarPorDocumento(documento);
                if (u == null) {
                    JOptionPane.showMessageDialog(vista, "Usuario no encontrado para actualizar.");
                    return;
                }
                u.setNombreCompleto(vista.txtNombreCompleto.getText());
                u.setUsuario(vista.txtUsuario.getText());
                u.setClave(vista.txtContrasena.getText());

                if (dao.actualizarUsuario(u)) {
                    JOptionPane.showMessageDialog(vista, "Usuario actualizado correctamente.");
                    listarUsuarios();
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(vista, "Error al actualizar usuario.");
                }
            } else {
                JOptionPane.showMessageDialog(vista, "Seleccione un usuario de la tabla antes de actualizar.");
            }
        }

        if (e.getSource() == vista.btnEliminar) {
            int fila = vista.tblUsuarios.getSelectedRow();
            if (fila != -1) {
                String documento = vista.tblUsuarios.getValueAt(fila, 0).toString();
                Usuario u = dao.buscarPorDocumento(documento);
                if (u == null) {
                    JOptionPane.showMessageDialog(vista, "Usuario no encontrado para eliminar.");
                    return;
                }
                int confirm = JOptionPane.showConfirmDialog(vista, "¿Está seguro de eliminar este usuario?", "Confirmar", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    if (dao.eliminarUsuario(u.getId())) {
                        JOptionPane.showMessageDialog(vista, "Usuario eliminado correctamente.");
                        listarUsuarios();
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(vista, "Error al eliminar usuario.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(vista, "Seleccione un usuario de la tabla.");
            }
        }

        if (e.getSource() == vista.btnCancelar) {
            limpiarCampos();
        }
    }
}
