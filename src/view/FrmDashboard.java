
package view;

import javax.swing.JOptionPane;
import model.Usuario;
public class FrmDashboard extends javax.swing.JFrame {
    private Usuario usuarioLogueado;
    public FrmDashboard(Usuario usuario) {
        initComponents();
        this.usuarioLogueado = usuario;
        // Verificar si el usuario es null antes de acceder a sus métodos
        if (usuario != null) {
            lblUsuario.setText("Username: " + usuario.getUsuario());
        } else {
            lblUsuario.setText("Usuario no logueado");
        }
        setLocationRelativeTo(null);
        
        // ActionListener para el menú "Usuarios"
        menuUsuarios.addActionListener(e -> {
            this.dispose(); // Cierra el Dashboard
            FrmUsuarios frmUsuarios = new FrmUsuarios(); // Abre FrmUsuarios
            frmUsuarios.setVisible(true);
            frmUsuarios.setLocationRelativeTo(null); // Centrar ventana
        });
        
        // ActionListener para el menú "Cerrar"
        menuCerrar.addActionListener(e -> cerrarSesion());
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Cierra toda la app al cerrar
        //accion entrar al listado de contactos
        menuListado.addActionListener(e -> {
        this.dispose(); // Cierra el Dashboard
        FrmContactos frmContactos = new FrmContactos(usuarioLogueado); // Pasa el usuario si es necesario
        frmContactos.setVisible(true);
        frmContactos.setLocationRelativeTo(null); // Centrar ventana
});
    }
 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogo = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuUsuarios = new javax.swing.JMenuItem();
        menuCerrar = new javax.swing.JMenuItem();
        menuContactos = new javax.swing.JMenu();
        menuListado = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda Contactos");
        setBackground(new java.awt.Color(255, 255, 255));
        setFocusCycleRoot(false);
        setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Screenshot_19.png"))); // NOI18N

        lblEstado.setText("Conected: Ok");

        lblUsuario.setText("Username: pepito");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("<html>\n  <div style='font-family: Arial, sans-serif; padding:10px;'>\n    <h2 style='color: #2E86C1;'>👋 ¡Bienvenido al Panel de Control!</h2>\n    <p style='font-size: 13pt; color: #333;'>\n      Desde aquí puedes gestionar tus contactos de forma fácil y eficiente.\n    </p>\n    <ul style='font-size: 12pt;'>\n      <li>📋 Ver lista de contactos</li>\n      <li>➕ Agregar nuevos contactos</li>\n      <li>✏️ Editar información existente</li>\n      <li>🗑️ Eliminar registros</li>\n    </ul>\n    <p style='font-size: 10pt; color: gray;'>\n      Recuerda hacer una copia de seguridad de tus datos periódicamente.\n    </p>\n  </div>\n</html>");

        menuArchivo.setText("Archivo");

        menuUsuarios.setText("Usuarios");
        menuArchivo.add(menuUsuarios);

        menuCerrar.setText("Cerrar");
        menuArchivo.add(menuCerrar);

        jMenuBar1.add(menuArchivo);

        menuContactos.setText("Contactos");

        menuListado.setText("Listado");
        menuContactos.add(menuListado);

        jMenuBar1.add(menuContactos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                        .addComponent(lblUsuario)
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(lblUsuario))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuItem menuCerrar;
    private javax.swing.JMenu menuContactos;
    private javax.swing.JMenuItem menuListado;
    private javax.swing.JMenuItem menuUsuarios;
    // End of variables declaration//GEN-END:variables

    private void cerrarSesion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
