
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
    }
 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        lblEstado = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
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

        lblLogo.setText("Logo");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Lorem Ipsum Lorem Ipsum");
        jScrollPane1.setViewportView(jTextArea1);

        lblEstado.setText("Conected: Ok");

        lblUsuario.setText("Username: pepito");

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
                .addGap(29, 29, 29)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblUsuario)
                .addGap(17, 17, 17))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEstado)
                    .addComponent(lblUsuario))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
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
