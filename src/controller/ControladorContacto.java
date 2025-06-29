package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Contacto;
import model.ContactoDAO;
import view.FrmContactos;

public class ControladorContacto implements ActionListener {
    private ContactoDAO dao = new ContactoDAO();
    private FrmContactos vista;
    private DefaultTableModel modelo = new DefaultTableModel();

    public ControladorContacto(FrmContactos vista) {
        this.vista = vista;

        // Agregar ActionListener a los botones de la vista
        this.vista.btnContacNuevo.addActionListener(this);
        this.vista.btnContacActualizar.addActionListener(this);
        this.vista.btnContacElimina.addActionListener(this);
        this.vista.btnContacCancelar.addActionListener(this);

        listar(vista.tblContactos);
    }

    // Listar contactos en la tabla
    private void listar(JTable tabla) {
    // Definir el modelo con 4 columnas, incluyendo el ID (invisible)
    modelo = new DefaultTableModel(new Object[]{"ID", "Nombre", "Teléfono", "Email"}, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Evita que el usuario edite las celdas
        }
    };
    
    this.vista.tblContactos.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        int filaSeleccionada = vista.tblContactos.getSelectedRow();
        if (filaSeleccionada != -1) {
            vista.txtContacNombre.setText(vista.tblContactos.getValueAt(filaSeleccionada, 1).toString());
            vista.txtContacTelefono.setText(vista.tblContactos.getValueAt(filaSeleccionada, 2).toString());
            vista.txtContacDireccion.setText(vista.tblContactos.getValueAt(filaSeleccionada, 3).toString());
        }
    }
});

    // Llenar el modelo
    List<Contacto> lista = dao.listar();
    for (Contacto c : lista) {
        modelo.addRow(new Object[]{c.getId(), c.getNombre(), c.getTelefono(), c.getEmail()});
    }

    // Asignar modelo a la tabla
    tabla.setModel(modelo);

    // Ocultar columna ID
    tabla.getColumnModel().getColumn(0).setMinWidth(0);
    tabla.getColumnModel().getColumn(0).setMaxWidth(0);
    tabla.getColumnModel().getColumn(0).setWidth(0);
}

    // Limpiar tabla
    private void limpiarTabla() {
        if (modelo != null) {
            modelo.setRowCount(0);
        }
    }

    // Limpiar los campos del formulario
    private void limpiarCampos() {
        vista.txtContacNombre.setText("");
        vista.txtContacTelefono.setText("");
        vista.txtContacDireccion.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == vista.btnContacNuevo) {
            Contacto c = new Contacto();
            c.setNombre(vista.txtContacNombre.getText().trim());
            c.setTelefono(vista.txtContacTelefono.getText().trim());
            c.setEmail(vista.txtContacDireccion.getText().trim());

            // Validar campos obligatorios
            if (c.getNombre().isEmpty() || c.getTelefono().isEmpty()) {
                JOptionPane.showMessageDialog(vista, "Los campos Nombre y Teléfono son obligatorios.", "Error de validación", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (dao.insertar(c)) {
                JOptionPane.showMessageDialog(vista, "Contacto agregado correctamente.");
                listar(vista.tblContactos);
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al agregar el contacto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (source == vista.btnContacActualizar) {
            // Aquí debes implementar la lógica para actualizar un contacto seleccionado de la tabla si quieres que funcione
            int filaSeleccionada = vista.tblContactos.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(vista, "Selecciona un contacto para actualizar.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int id = Integer.parseInt(vista.tblContactos.getValueAt(filaSeleccionada, 0).toString());
            Contacto c = new Contacto();
            c.setId(id);
            c.setNombre(vista.txtContacNombre.getText().trim());
            c.setTelefono(vista.txtContacTelefono.getText().trim());
            c.setEmail(vista.txtContacDireccion.getText().trim());

            if (dao.actualizar(c)) {
                JOptionPane.showMessageDialog(vista, "Contacto actualizado correctamente.");
                listar(vista.tblContactos);
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al actualizar el contacto.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (source == vista.btnContacElimina) {
            int filaSeleccionada = vista.tblContactos.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(vista, "Selecciona un contacto para eliminar.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int id = Integer.parseInt(vista.tblContactos.getValueAt(filaSeleccionada, 0).toString());
            int confirmar = JOptionPane.showConfirmDialog(vista, "¿Estás seguro de eliminar este contacto?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (confirmar == JOptionPane.YES_OPTION) {
                if (dao.eliminar(id)) {
                    JOptionPane.showMessageDialog(vista, "Contacto eliminado correctamente.");
                    listar(vista.tblContactos);
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(vista, "Error al eliminar el contacto.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (source == vista.btnContacCancelar) {
            limpiarCampos();
        }
    }
}
