/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorTelefono;
import ec.edu.ups.controlador.ControladorUsuario;
import ec.edu.ups.modelo.Telefono;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author ariel
 */
public class VentanaGestionTelefonos extends javax.swing.JInternalFrame {

    private List<String> operadoras;
    private ControladorUsuario controladorUsuario;
    private ControladorTelefono controladorTelefono;
    private Locale localizacion;
    private ResourceBundle mensaje;
    private String alerta11;
    private String alerta12;
    private String alerta13;
    private String alerta14;
    private String alerta15;

    /**
     * Creates new form VentanaGestionTelefonos
     */
    public VentanaGestionTelefonos(ControladorUsuario controladorUsuario, ControladorTelefono controladorTelefono) {
        this.controladorUsuario = controladorUsuario;
        this.controladorTelefono = controladorTelefono;
        initComponents();
        cargarDatosOperadoras();
        alerta11= "Por favor seleccione un tipo de Telefono";
        alerta12="Telefono agregado correctamente";
        alerta13="Telefono actualizado correctamente";
        alerta14="Estas seguro que deceas eliminar el telefono seleccionado";
        alerta15="Telefono eliminado correctamente";

    }

    public Locale getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Locale localizacion) {
        this.localizacion = localizacion;
    }

    public ResourceBundle getMensaje() {
        return mensaje;
    }

    public void setMensaje(ResourceBundle mensaje) {
        this.mensaje = mensaje;
    }
    public void cambiarIdioma(String idioma, String localidad){
        labelGestionDeTelefonos.setText(mensaje.getString("TituloG"));
        labelCodigo.setText(mensaje.getString("Codigo"));
        labelTipo.setText(mensaje.getString("Tipo"));
        labelNumero.setText(mensaje.getString("Numero"));
        labelOperadora.setText(mensaje.getString("Operadora"));
       jButtonActualizar.setText(mensaje.getString("Actualizar"));
       jButtonAgregar.setText(mensaje.getString("Agregar"));
       jButtonCancelar.setText(mensaje.getString("Cancelar"));
       jButtonEliminar.setText(mensaje.getString("Eliminar"));
       TableColumnModel modelo = tablaTelefonos.getColumnModel();
       modelo.getColumn(0).setHeaderValue(mensaje.getString("Codigo"));
       modelo.getColumn(1).setHeaderValue(mensaje.getString("Tipo"));
       modelo.getColumn(2).setHeaderValue(mensaje.getString("Numero"));
       modelo.getColumn(3).setHeaderValue(mensaje.getString("Operadora"));
       
       jComboBoxOperadora.getItemAt(0);
      
      
       
       
       alerta11=mensaje.getString("alerta11");
       alerta12=mensaje.getString("alerta12");
       alerta13=mensaje.getString("alerta13");
       alerta14=mensaje.getString("alerta14");
       alerta15=mensaje.getString("alerta15");
       
    }

    public void cargarDatosOperadoras() {
        operadoras = new ArrayList<>();
        operadoras.add("Movistar");
        operadoras.add("Claro");
        operadoras.add("CNT");
        operadoras.add("Tuenti");
        operadoras.add("Etapa");
        cargarDatosJComboBoxOperadora();
    }

    public void cargarDatosJComboBoxOperadora() {
        DefaultComboBoxModel modelo = (DefaultComboBoxModel) jComboBoxOperadora.getModel();
        for (String operadora : operadoras) {
            modelo.addElement(operadora);
        }
    }

    public void cargarTelefonosTblTelefonos() {
        DefaultTableModel modelo = (DefaultTableModel) tablaTelefonos.getModel();
        modelo.setRowCount(0);
        for (Telefono telefono : controladorUsuario.listarTelefonos()) {
            Object[] rowData = {telefono.getCodigo(), telefono.getTipo(), telefono.getNumero(), telefono.getOperadora()};
            modelo.addRow(rowData);
        }
        tablaTelefonos.setModel(modelo);
    }

    public void cargarSiguienteCodigo() {
        txtCodigo.setText(controladorTelefono.obtenerSiguienteCodigo());
    }

    public void activarEdicion() {
        jButtonActualizar.setEnabled(true);
        jButtonEliminar.setEnabled(true);
        jButtonCancelar.setEnabled(true);
    }

    public void desactivarEdicion() {
        jButtonActualizar.setEnabled(false);
        jButtonEliminar.setEnabled(false);
        jButtonCancelar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        labelGestionDeTelefonos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTelefonos = new javax.swing.JTable();
        txtCodigo = new javax.swing.JTextField();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jFormattedTextFieldNumero = new javax.swing.JFormattedTextField();
        jComboBoxOperadora = new javax.swing.JComboBox<>();
        labelCodigo = new javax.swing.JLabel();
        labelTipo = new javax.swing.JLabel();
        labelNumero = new javax.swing.JLabel();
        labelOperadora = new javax.swing.JLabel();
        jButtonAgregar = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanelPrincipal.setBackground(new java.awt.Color(97, 105, 119));
        jPanelPrincipal.setAutoscrolls(true);

        labelGestionDeTelefonos.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelGestionDeTelefonos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelGestionDeTelefonos.setText("Gestion de Telefonos");

        tablaTelefonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Tipo", "Numero", "Operadora"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaTelefonos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTelefonosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaTelefonos);

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(153, 153, 153));
        txtCodigo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCodigo.setText("0");
        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione una opcion--", "Casa", "Trabajo", "Movil", "Convencional", "Fax", "Localizador", " ", " ", " " }));
        jComboBoxTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoActionPerformed(evt);
            }
        });

        jFormattedTextFieldNumero.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jFormattedTextFieldNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldNumeroActionPerformed(evt);
            }
        });

        jComboBoxOperadora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Seleccione una Operadora--" }));
        jComboBoxOperadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxOperadoraActionPerformed(evt);
            }
        });

        labelCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelCodigo.setText("Codigo :");

        labelTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTipo.setText("Tipo :");

        labelNumero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNumero.setText("Numero :");

        labelOperadora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelOperadora.setText("Operadora :");

        jButtonAgregar.setText("Agregar");
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(labelGestionDeTelefonos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(86, 86, 86))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNumero)
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                                .addComponent(labelOperadora)
                                .addGap(73, 73, 73))
                            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelTipo)
                                    .addComponent(labelCodigo))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxOperadora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCodigo)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jFormattedTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(81, 81, 81))
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jButtonAgregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCancelar)
                .addGap(76, 76, 76))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelGestionDeTelefonos)
                .addGap(36, 36, 36)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCodigo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNumero))
                .addGap(10, 10, 10)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelOperadora)
                    .addComponent(jComboBoxOperadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAgregar)
                        .addComponent(jButtonActualizar)
                        .addComponent(jButtonEliminar)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void jComboBoxOperadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxOperadoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxOperadoraActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing

    }//GEN-LAST:event_formInternalFrameClosing

    private void jComboBoxTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoActionPerformed

        try {
            String item = (String) jComboBoxTipo.getSelectedItem();
            if (item.equals("Casa")) {
                jFormattedTextFieldNumero.setFormatterFactory(
                        new javax.swing.text.DefaultFormatterFactory(
                                new javax.swing.text.MaskFormatter("(+593)#-####-###")));
            } else if (item.equals("Movil")) {
                jFormattedTextFieldNumero.setFormatterFactory(
                        new javax.swing.text.DefaultFormatterFactory(
                                new javax.swing.text.MaskFormatter("(+593)#-####-####")));
            } else {
                jFormattedTextFieldNumero.setFormatterFactory(
                        new javax.swing.text.DefaultFormatterFactory(
                                new javax.swing.text.MaskFormatter("(+593)#-####-###")));
            }
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jComboBoxTipoActionPerformed

    private void jFormattedTextFieldNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldNumeroActionPerformed

        if (jComboBoxTipo.getSelectedIndex() == 0) {
            jComboBoxTipo.requestFocus();
            JOptionPane.showMessageDialog(this,alerta11);
        }
    }//GEN-LAST:event_jFormattedTextFieldNumeroActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        controladorUsuario.agregarTelefono(Integer.valueOf(txtCodigo.getText()), jFormattedTextFieldNumero.getText(), jComboBoxTipo.getSelectedItem().toString(), jComboBoxOperadora.getSelectedItem().toString());
        cargarTelefonosTblTelefonos();
        limpiar();
        JOptionPane.showMessageDialog(this, alerta12);
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        cargarSiguienteCodigo();
        cargarTelefonosTblTelefonos();
        desactivarEdicion();
    }//GEN-LAST:event_formInternalFrameActivated

    private void tablaTelefonosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTelefonosMouseClicked
        int filaIndex = tablaTelefonos.getSelectedRow();
        if (filaIndex >= 0) {
            activarEdicion();
            jButtonAgregar.setEnabled(false);

            String codigo = tablaTelefonos.getValueAt(filaIndex, 0).toString();
            String tipo = tablaTelefonos.getValueAt(filaIndex, 1).toString();
            String numero = tablaTelefonos.getValueAt(filaIndex, 2).toString();
            String operadora = tablaTelefonos.getValueAt(filaIndex, 3).toString();

            txtCodigo.setText(codigo);
            jComboBoxTipo.setSelectedItem(tipo);
            jFormattedTextFieldNumero.setValue(numero);
            jComboBoxOperadora.setSelectedItem(operadora);
        }
    }//GEN-LAST:event_tablaTelefonosMouseClicked

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        controladorUsuario.editarTelefono(Integer.valueOf(txtCodigo.getText()), jFormattedTextFieldNumero.getText(), jComboBoxTipo.getSelectedItem().toString(), jComboBoxOperadora.getSelectedItem().toString());
        cargarTelefonosTblTelefonos();
        limpiar();
        desactivarEdicion();
        jButtonAgregar.setEnabled(true);
        JOptionPane.showMessageDialog(this, alerta13);
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jButtonAgregar.setEnabled(true);
        limpiar();
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, alerta14);
        if (respuesta == JOptionPane.YES_OPTION) {
            controladorUsuario.eliminarTelefono(Integer.valueOf(txtCodigo.getText()));
            cargarTelefonosTblTelefonos();
            limpiar();
            desactivarEdicion();
            jButtonAgregar.setEnabled(true);
            JOptionPane.showMessageDialog(this, alerta15);
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JComboBox<String> jComboBoxOperadora;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JFormattedTextField jFormattedTextFieldNumero;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelGestionDeTelefonos;
    private javax.swing.JLabel labelNumero;
    private javax.swing.JLabel labelOperadora;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JTable tablaTelefonos;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables

    private void limpiar() {
        txtCodigo.setText("");
        jFormattedTextFieldNumero.setValue("");
        jComboBoxTipo.setSelectedIndex(0);
        jComboBoxOperadora.setSelectedIndex(0);
        cargarSiguienteCodigo();
    }
}
