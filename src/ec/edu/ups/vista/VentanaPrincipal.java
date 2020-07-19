/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorTelefono;
import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.dao.TelefonoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 *
 * @author ariel
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    //Ventanas
    private VentanaInciarSecion ventanaIniciarSecion;
    private VentanaRegistrarUsuario ventanaRegistrarUsuario;
    private VentanaGestionTelefonos ventanaGestionTelefonos;
    private VentanaBuscarUsuarios ventanaBuscarUsuarios;
    private VentanaGestionUsuarios ventanaGestionUsuarios;

    //Daos
    private UsuarioDAO usuarioDAO;
    private TelefonoDAO telefonoDAO;

    //Controladores
    private ControladorUsuario controladorUsuario;
    private ControladorTelefono controladorTelefono;

    //clases para la localizacion
    private Locale localizacion;
    private ResourceBundle mensajes;
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        
        localizacion = Locale.getDefault();
        mensajes = ResourceBundle.getBundle("ec.edu.ups.idiomas.mensajes", localizacion);

        //oculto ventanas
        menuAgenda.setVisible(false);
        cerrarSesionMenuItem.setVisible(false);

        //Se instancia el patron MVC
        usuarioDAO = new UsuarioDAO();
        telefonoDAO = new TelefonoDAO(usuarioDAO);

        controladorUsuario = new ControladorUsuario(usuarioDAO, telefonoDAO);
        controladorTelefono = new ControladorTelefono(telefonoDAO);

        ventanaIniciarSecion = new VentanaInciarSecion(controladorUsuario, this);
        ventanaRegistrarUsuario = new VentanaRegistrarUsuario(controladorUsuario);
        ventanaGestionTelefonos = new VentanaGestionTelefonos(controladorUsuario, controladorTelefono);
        ventanaBuscarUsuarios = new VentanaBuscarUsuarios(controladorUsuario, telefonoDAO);
        ventanaGestionUsuarios = new VentanaGestionUsuarios(controladorUsuario);

        desktopPane.add(ventanaGestionUsuarios);
        desktopPane.add(ventanaBuscarUsuarios);
        desktopPane.add(ventanaRegistrarUsuario);
        desktopPane.add(ventanaIniciarSecion);
        desktopPane.add(ventanaGestionTelefonos);
        
        cambiarIdioma();
    }
    
    public void cambiarIdioma() {
        menuInicio.setText(mensajes.getString("Inicio"));
        menuAgenda.setText(mensajes.getString("Agenda"));
        jMenuIdioma.setText(mensajes.getString("Idioma"));
        jMenuItemEspañol.setText(mensajes.getString("Español"));
        jMenuItemIngles.setText(mensajes.getString("Ingles"));
        iniciarSecionMenuItem.setText(mensajes.getString("IniciarSesion"));
        registrarMenuItem.setText(mensajes.getString("RegistrarUsuario"));
        cerrarSesionMenuItem.setText(mensajes.getString("CerrarSesion"));
        salirMenuItem.setText(mensajes.getString("Salir"));
        telefonosMenuItem.setText(mensajes.getString("Telefonos"));
        usuariosMenuItem.setText(mensajes.getString("Usuarios"));
    }

    public JMenuItem getCerrarSesionMenuItem() {
        return cerrarSesionMenuItem;
    }

    public JMenuItem getIniciarSecionMenuItem() {
        return iniciarSecionMenuItem;
    }

    public JMenu getMenuAgenda() {
        return menuAgenda;
    }

    public JMenuItem getRegistrarMenuItem() {
        return registrarMenuItem;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        menuInicio = new javax.swing.JMenu();
        iniciarSecionMenuItem = new javax.swing.JMenuItem();
        registrarMenuItem = new javax.swing.JMenuItem();
        listarTelefonosMenuItem = new javax.swing.JMenuItem();
        cerrarSesionMenuItem = new javax.swing.JMenuItem();
        salirMenuItem = new javax.swing.JMenuItem();
        menuAgenda = new javax.swing.JMenu();
        telefonosMenuItem = new javax.swing.JMenuItem();
        usuariosMenuItem = new javax.swing.JMenuItem();
        jMenuIdioma = new javax.swing.JMenu();
        jMenuItemEspañol = new javax.swing.JMenuItem();
        jMenuItemIngles = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        menuInicio.setMnemonic('f');
        menuInicio.setText("Inicio");

        iniciarSecionMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        iniciarSecionMenuItem.setMnemonic('o');
        iniciarSecionMenuItem.setText("Iniciar Sesion");
        iniciarSecionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarSecionMenuItemActionPerformed(evt);
            }
        });
        menuInicio.add(iniciarSecionMenuItem);

        registrarMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        registrarMenuItem.setMnemonic('s');
        registrarMenuItem.setText("Registrar Usuario");
        registrarMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarMenuItemActionPerformed(evt);
            }
        });
        menuInicio.add(registrarMenuItem);

        listarTelefonosMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        listarTelefonosMenuItem.setMnemonic('x');
        listarTelefonosMenuItem.setText("Listar telefonos");
        listarTelefonosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarTelefonosMenuItemActionPerformed(evt);
            }
        });
        menuInicio.add(listarTelefonosMenuItem);

        cerrarSesionMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        cerrarSesionMenuItem.setText("Cerrar sesion");
        cerrarSesionMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionMenuItemActionPerformed(evt);
            }
        });
        menuInicio.add(cerrarSesionMenuItem);

        salirMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        salirMenuItem.setText("Salir");
        salirMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirMenuItemActionPerformed(evt);
            }
        });
        menuInicio.add(salirMenuItem);

        menuBar.add(menuInicio);

        menuAgenda.setText("Agenda");

        telefonosMenuItem.setText("Telefonos");
        telefonosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefonosMenuItemActionPerformed(evt);
            }
        });
        menuAgenda.add(telefonosMenuItem);

        usuariosMenuItem.setText("Usuarios");
        usuariosMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariosMenuItemActionPerformed(evt);
            }
        });
        menuAgenda.add(usuariosMenuItem);

        menuBar.add(menuAgenda);

        jMenuIdioma.setText("Idioma");

        jMenuItemEspañol.setText("Español");
        jMenuItemEspañol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEspañolActionPerformed(evt);
            }
        });
        jMenuIdioma.add(jMenuItemEspañol);

        jMenuItemIngles.setText("Ingles");
        jMenuItemIngles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInglesActionPerformed(evt);
            }
        });
        jMenuIdioma.add(jMenuItemIngles);

        menuBar.add(jMenuIdioma);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void listarTelefonosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarTelefonosMenuItemActionPerformed
        ventanaBuscarUsuarios.setVisible(true);
    }//GEN-LAST:event_listarTelefonosMenuItemActionPerformed

    private void iniciarSecionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarSecionMenuItemActionPerformed
        ventanaIniciarSecion.setVisible(true);
    }//GEN-LAST:event_iniciarSecionMenuItemActionPerformed

    private void registrarMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarMenuItemActionPerformed
        ventanaRegistrarUsuario.setVisible(true);
    }//GEN-LAST:event_registrarMenuItemActionPerformed

    private void salirMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirMenuItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salirMenuItemActionPerformed

    private void cerrarSesionMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionMenuItemActionPerformed
        menuAgenda.setVisible(false);
        cerrarSesionMenuItem.setVisible(false);
        iniciarSecionMenuItem.setVisible(true);
        registrarMenuItem.setVisible(true);
    }//GEN-LAST:event_cerrarSesionMenuItemActionPerformed

    private void telefonosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefonosMenuItemActionPerformed
        ventanaGestionTelefonos.setVisible(true);
    }//GEN-LAST:event_telefonosMenuItemActionPerformed

    private void usuariosMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariosMenuItemActionPerformed
        ventanaGestionUsuarios.setVisible(true);
    }//GEN-LAST:event_usuariosMenuItemActionPerformed

    private void jMenuItemEspañolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEspañolActionPerformed
        localizacion = new Locale("es", "EC");
        mensajes = ResourceBundle.getBundle("ec.edu.ups.idiomas.mensajes", localizacion);
        cambiarIdioma();        
    }//GEN-LAST:event_jMenuItemEspañolActionPerformed

    private void jMenuItemInglesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInglesActionPerformed
        localizacion = new Locale("en", "EU");
        mensajes = ResourceBundle.getBundle("ec.edu.ups.idiomas.mensajes", localizacion);
        cambiarIdioma(); 
    }//GEN-LAST:event_jMenuItemInglesActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem cerrarSesionMenuItem;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem iniciarSecionMenuItem;
    private javax.swing.JMenu jMenuIdioma;
    private javax.swing.JMenuItem jMenuItemEspañol;
    private javax.swing.JMenuItem jMenuItemIngles;
    private javax.swing.JMenuItem listarTelefonosMenuItem;
    private javax.swing.JMenu menuAgenda;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuInicio;
    private javax.swing.JMenuItem registrarMenuItem;
    private javax.swing.JMenuItem salirMenuItem;
    private javax.swing.JMenuItem telefonosMenuItem;
    private javax.swing.JMenuItem usuariosMenuItem;
    // End of variables declaration//GEN-END:variables

}
