package view;
import controller.ControladorContacto;
import javax.swing.*;
import model.Usuario;
public class FrmContactos extends javax.swing.JFrame {
    private Usuario usuarioLogueado;
    public FrmContactos() {
        initComponents();
        setLocationRelativeTo(null);
        new ControladorContacto(this); // Pasa esta instancia al controlador
        usuarioLogueado = null;
        cargarUsuario();
        addCloseButtonListener();
    }
    // Constructor sobrecargado para aceptar un usuario logueado
    public FrmContactos(Usuario usuario) {
        initComponents();
        setLocationRelativeTo(null);
        this.usuarioLogueado = usuario;
        new ControladorContacto(this); // Para asegurar que controlador se asigne incluso aquí
        cargarUsuario();
        addCloseButtonListener();
    }
    private void cargarUsuario() {
        if (usuarioLogueado != null) {
            lblContacUsuario.setText("Usuario: " + usuarioLogueado.getUsuario());
        } else {
            lblContacUsuario.setText("Usuario: Invitado");
        }
        lblContacConexion.setText("Conectado: OK");
    }
    private void addCloseButtonListener() {
        btnContacCerrar.addActionListener(e -> {
            this.dispose(); // Cierra la ventana
            new FrmDashboard(usuarioLogueado).setVisible(true);
        });
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnContacCerrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        txtContacNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtContacTelefono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtContacDireccion = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblContactos = new javax.swing.JTable();
        btnContacNuevo = new javax.swing.JButton();
        btnContacActualizar = new javax.swing.JButton();
        btnContacElimina = new javax.swing.JButton();
        btnContacCancelar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        lblContacConexion = new javax.swing.JLabel();
        lblContacUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Usuarios");

        btnContacCerrar.setText("Cerrar");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("Listado de Contactos");

        jSeparator1.setAlignmentY(1.0F);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setText("Nombre Completo");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setText("Telefono");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel4.setText("Email");

        tblContactos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblContactos.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        tblContactos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Telefono", "Direccion"
            }
        ));
        jScrollPane1.setViewportView(tblContactos);

        btnContacNuevo.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnContacNuevo.setText("Nuevo");

        btnContacActualizar.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnContacActualizar.setText("Actualizar");

        btnContacElimina.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnContacElimina.setText("Eliminar");

        btnContacCancelar.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnContacCancelar.setText("Cancelar");

        lblContacConexion.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblContacConexion.setText("Conected: OK");

        lblContacUsuario.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblContacUsuario.setText("Usuario: pepito");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator2))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblContacConexion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblContacUsuario)
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnContacCerrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtContacTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                            .addComponent(txtContacNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtContacDireccion)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(btnContacNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnContacActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(btnContacElimina)
                        .addGap(18, 18, 18)
                        .addComponent(btnContacCancelar)))
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnContacCerrar)
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContacNombre)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtContacTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtContacDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnContacNuevo)
                    .addComponent(btnContacActualizar)
                    .addComponent(btnContacElimina)
                    .addComponent(btnContacCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContacConexion)
                    .addComponent(lblContacUsuario))
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmContactos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmContactos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnContacActualizar;
    public javax.swing.JButton btnContacCancelar;
    public javax.swing.JButton btnContacCerrar;
    public javax.swing.JButton btnContacElimina;
    public javax.swing.JButton btnContacNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JLabel lblContacConexion;
    public javax.swing.JLabel lblContacUsuario;
    public javax.swing.JTable tblContactos;
    public javax.swing.JTextField txtContacDireccion;
    public javax.swing.JTextField txtContacNombre;
    public javax.swing.JTextField txtContacTelefono;
    // End of variables declaration//GEN-END:variables
}
