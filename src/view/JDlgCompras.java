/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Clientes;
import bean.Compras;
import bean.Fornecedores;
import bean.Funcionarios;
import bean.Vendas;
import bean.Vendedores;
import dao.Clientes_DAO;
import dao.Compras_DAO;
import dao.Fornecedores_DAO;
import dao.Funcionarios_DAO;
import dao.Vendedores_DAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author User
 */
public class JDlgCompras extends javax.swing.JDialog {
  private boolean incluindo;
    MaskFormatter mascaraData;

    /**
     * Creates new form JDlgVendas
     */
    public JDlgCompras(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        desabilitar();
        try {
            mascaraData = new MaskFormatter("##/##/####");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgCompras.class.getName()).log(Level.SEVERE, null, ex);
        }

        jFmtData.setFormatterFactory(new DefaultFormatterFactory(mascaraData));

        Fornecedores_DAO fornecedores_DAO = new Fornecedores_DAO();
        List lista = fornecedores_DAO.listAll();
        for (int i = 0; i < lista.size(); i++) {
            Fornecedores fornecedores = (Fornecedores) lista.get(i);
            jCboFornecedores.addItem(fornecedores);
        }
        Funcionarios_DAO funcionarios_DAO = new Funcionarios_DAO();
        List lista1 = funcionarios_DAO.listAll();
        for (int i = 0; i < lista1.size(); i++) {
            Funcionarios funcionarios = (Funcionarios) lista1.get(i);
            jCboFuncionarios.addItem(funcionarios);
        }
        setTitle("Vendas");
        setLocationRelativeTo(null);

    }

    public void habilitar() {
        jTxtCodigo.setEnabled(true);
        jFmtData.setEnabled(true);
        jCboFornecedores.setEnabled(true);
        jCboFuncionarios.setEnabled(true);
        jFmtTotal.setEnabled(true);

        jBtnIncluir.setEnabled(false);
        jBtnExcluir.setEnabled(false);
        jBtnAlterar.setEnabled(false);
        jBtnPesquisar.setEnabled(false);

        jBtnConfirmar.setEnabled(true);
        jBtnCancelar.setEnabled(true);
    }

    public void desabilitar() {

        jTxtCodigo.setEnabled(false);
        jFmtData.setEnabled(false);
        jCboFornecedores.setEnabled(false);
        jCboFuncionarios.setEnabled(false);
        jFmtTotal.setEnabled(false);

        jBtnIncluir.setEnabled(true);
        jBtnExcluir.setEnabled(true);
        jBtnAlterar.setEnabled(true);
        jBtnPesquisar.setEnabled(true);

        jBtnConfirmar.setEnabled(false);
        jBtnCancelar.setEnabled(false);

    }

    public void limparCampos() {
        jTxtCodigo.setText("");
        jFmtData.setText("");
        jCboFornecedores.setSelectedIndex(-1);
        jCboFuncionarios.setSelectedIndex(-1);
        jFmtTotal.setText("");
    }

    public Compras viewBean() {
        Compras compras = new Compras();
        int id = Integer.parseInt(jTxtCodigo.getText());
        double valor = Double.parseDouble(jFmtTotal.getText());

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            compras.setData(formato.parse(jFmtData.getText()));
        } catch (ParseException ex) {
            System.out.println("Erro, burro:" + ex.getMessage());
        }
        Fornecedores fornecedores1 = (Fornecedores) jCboFornecedores.getSelectedItem();
        compras.setFornecedor((fornecedores1.getIdfornecedor()));
        
        Funcionarios funcionarios1 = (Funcionarios) jCboFuncionarios.getSelectedItem();
        compras.setFuncionario(funcionarios1.getIdfuncionario());
        compras.setIdcompra(id);
        compras.setTotal(valor);
        return compras;
    }

    public void beanView(Compras compras) {
        String id = String.valueOf(compras.getIdcompra());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        jFmtData.setText(formato.format(compras.getData()));
        jTxtCodigo.setText(id);
        int idfornecedor = compras.getFornecedor();
        int idfuncionario = compras.getFuncionario();
        Fornecedores_DAO fornecedores_DAO = new Fornecedores_DAO();
        jCboFornecedores.setSelectedItem(fornecedores_DAO.list(idfornecedor));
        Funcionarios_DAO funcionarios_DAO = new Funcionarios_DAO();
        jCboFuncionarios.setSelectedItem(funcionarios_DAO.list(idfuncionario));
        jFmtTotal.setText(String.valueOf(compras.getTotal()));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCboFuncionarios = new javax.swing.JComboBox<Funcionarios>();
        jBtnAlterar1 = new javax.swing.JButton();
        jCboFornecedores = new javax.swing.JComboBox<Fornecedores>();
        jBtbExcluir1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jFmtData = new javax.swing.JFormattedTextField();
        jBtnConfirmar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jBtnCancelar = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jTxtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jBtnExcluir = new javax.swing.JButton();
        jBtnIncluir = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jFmtTotal = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jBtnIncluir1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jCboFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboFuncionariosActionPerformed(evt);
            }
        });

        jBtnAlterar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        jBtnAlterar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterar1ActionPerformed(evt);
            }
        });

        jBtbExcluir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        jBtbExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtbExcluir1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Funcionario");

        jLabel3.setText("Fornecedor");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "PRODUTO", "QUANTIDADE", "VALOR UNITARIO", "TOTAL"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jFmtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtDataActionPerformed(evt);
            }
        });

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/gravar.png"))); // NOI18N
        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        jLabel2.setText("Data");

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jTxtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCodigoActionPerformed(evt);
            }
        });

        jLabel1.setText("Num Compra");

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jFmtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtTotalActionPerformed(evt);
            }
        });

        jLabel5.setText("Total");

        jBtnIncluir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir.png"))); // NOI18N
        jBtnIncluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBtnIncluir1)
                            .addComponent(jBtbExcluir1)
                            .addComponent(jBtnAlterar1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFmtData, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCboFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCboFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jFmtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnPesquisar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jCboFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFmtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jCboFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jFmtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jBtnIncluir1)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnAlterar1)
                        .addGap(30, 30, 30)
                        .addComponent(jBtbExcluir1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnCancelar)
                        .addComponent(jBtnPesquisar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnIncluir)
                        .addComponent(jBtnExcluir)
                        .addComponent(jBtnAlterar)
                        .addComponent(jBtnConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCboFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboFuncionariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboFuncionariosActionPerformed

    private void jBtnAlterar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterar1ActionPerformed
        // TODO add your handling code here:
        JDlgAlteracaoProduto_Vendas jDlgAlteracaoProduto_Vendas  = new JDlgAlteracaoProduto_Vendas (null, true);
        jDlgAlteracaoProduto_Vendas .setVisible(true);
    }//GEN-LAST:event_jBtnAlterar1ActionPerformed

    private void jBtbExcluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtbExcluir1ActionPerformed
        // TODO add your handling code here:
        int resp = JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?",
            "Exclusão", JOptionPane.YES_NO_OPTION);

        if (resp == JOptionPane.YES_OPTION) {
            /*  Vendas_produtos vendas_produtos = viewBean();
            Vendas_produtos_DAO vendas_produtos_DAO = new Vendas_produtos_DAO();
            vendas_produtos_DAO.delete(vendas_produtos);*/
        } else {
            JOptionPane.showMessageDialog(null, "Exclusão cancelada");
        }

    }//GEN-LAST:event_jBtbExcluir1ActionPerformed

    private void jFmtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtDataActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        // TODO add your handling code here:
        Compras compras = viewBean();
        Compras_DAO compras_DAO = new Compras_DAO();

        if (incluindo == true) {
            compras_DAO.insert(compras);
        } else {
            compras_DAO.update(compras);
        }
        desabilitar();

        limparCampos();
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
        desabilitar();
        JOptionPane.showMessageDialog(null, "Cancelamento concluido");
        limparCampos();
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        // TODO add your handling code here:
        habilitar();
        incluindo = false;
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jTxtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCodigoActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed

        int resp = JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?",
            "Exclusão", JOptionPane.YES_NO_OPTION);

        if (resp == JOptionPane.YES_OPTION) {
            Compras compras = viewBean();
            Compras_DAO compras_DAO = new Compras_DAO();
            compras_DAO.delete(compras);
        } else {
            JOptionPane.showMessageDialog(null, "Exclusão cancelada");
        }
        desabilitar();
        limparCampos();
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed

        habilitar();
        incluindo = true;
        limparCampos();
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed

        JDlgComprasPesquisar jDlgComprasPesquisar = new JDlgComprasPesquisar(null, true);
        jDlgComprasPesquisar.setTelaAnterior(this);
        jDlgComprasPesquisar.setVisible(true);
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jFmtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtTotalActionPerformed

    private void jBtnIncluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluir1ActionPerformed
        // TODO add your handling code here:
        JDlgInclusaoProduto_Compras  jDlgInclusaoProduto_Compras = new JDlgInclusaoProduto_Compras (null, true);
        jDlgInclusaoProduto_Compras .setVisible(true);
    }//GEN-LAST:event_jBtnIncluir1ActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgCompras.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgCompras dialog = new JDlgCompras(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtbExcluir1;
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnAlterar1;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnIncluir1;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JComboBox<Fornecedores> jCboFornecedores;
    private javax.swing.JComboBox<Funcionarios> jCboFuncionarios;
    private javax.swing.JFormattedTextField jFmtData;
    private javax.swing.JFormattedTextField jFmtTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtCodigo;
    // End of variables declaration//GEN-END:variables
}
