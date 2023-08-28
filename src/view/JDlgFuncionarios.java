/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Funcionarios;
import dao.Funcionarios_DAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author User
 */
public class JDlgFuncionarios extends javax.swing.JDialog {

    /**
     * Creates new form JDlgFuncionarios
     */
    private boolean incluindo;
    MaskFormatter mascaraCPF, mascaraDataNascimento, mascaraCelular, mascaraTelefone, mascaraCep, mascaraCarteiraTrabalho;

    public JDlgFuncionarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        desabilitar();
        setTitle("Cadastro de Funcionários");
        setLocationRelativeTo(null);

        try {
            mascaraCPF = new MaskFormatter("###.###.###-##");
            mascaraDataNascimento = new MaskFormatter("##/##/####");
            mascaraCelular = new MaskFormatter("(##)#####-####");
            mascaraTelefone = new MaskFormatter("(##)#####-####");
            mascaraCep = new MaskFormatter("#####-###");
            mascaraCarteiraTrabalho = new MaskFormatter("######-####-##");
        } catch (ParseException ex) {
            Logger.getLogger(JDlgFuncionarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        jFmtCpf.setFormatterFactory( new DefaultFormatterFactory( mascaraCPF )); 
        jFmtDataNascimento.setFormatterFactory(new DefaultFormatterFactory(mascaraDataNascimento));
        jFmtCarteiraTrabalho.setFormatterFactory( new DefaultFormatterFactory( mascaraCarteiraTrabalho )); 
        jFmtCelular.setFormatterFactory( new DefaultFormatterFactory( mascaraCelular )); 
        jFmtCep.setFormatterFactory( new DefaultFormatterFactory( mascaraCep )); 
        jFmtTelefone.setFormatterFactory( new DefaultFormatterFactory( mascaraTelefone )); 
    }

    public void habilitar() {
        jTxtCodigo.setEnabled(true);
        jTxtNome.setEnabled(true);
        jFmtCpf.setEnabled(true);
        jTxtEmail.setEnabled(true);
        jTxtEmailReserva.setEnabled(true);
        jTxtCidade.setEnabled(true);
        jTxtBairro.setEnabled(true);
        jTxtEndereco.setEnabled(true);
        jTxtPais.setEnabled(true);
        jFmtCarteiraTrabalho.setEnabled(true);
        jFmtCelular.setEnabled(true);
        jFmtCep.setEnabled(true);
        jFmtDataNascimento.setEnabled(true);
        jFmtTelefone.setEnabled(true);
        jCboSexo.setEnabled(true);
        jChbAtivo.setEnabled(true);
        jBtnIncluir.setEnabled(false);
        jBtnAlterar.setEnabled(false);
        jBtnExcluir.setEnabled(false);
        jBtnPesquisar.setEnabled(false);
        jBtnConfirmar.setEnabled(true);
        jBtnCancelar.setEnabled(true);

    }

    public void desabilitar() {
        jTxtCodigo.setEnabled(false);
        jTxtNome.setEnabled(false);
        jFmtCpf.setEnabled(false);
        jTxtEmail.setEnabled(false);
        jTxtEmailReserva.setEnabled(false);
        jTxtCidade.setEnabled(false);
        jTxtBairro.setEnabled(false);
        jTxtEndereco.setEnabled(false);
        jTxtPais.setEnabled(false);
        jFmtCarteiraTrabalho.setEnabled(false);
        jFmtCelular.setEnabled(false);
        jFmtCep.setEnabled(false);
        jFmtDataNascimento.setEnabled(false);
        jFmtTelefone.setEnabled(false);
        jCboSexo.setEnabled(false);
        jChbAtivo.setEnabled(false);
        jBtnConfirmar.setEnabled(false);
        jBtnCancelar.setEnabled(false);
        jBtnIncluir.setEnabled(true);
        jBtnAlterar.setEnabled(true);
        jBtnExcluir.setEnabled(true);
        jBtnPesquisar.setEnabled(true);

    }

    public void limparCampos() {
        jTxtCodigo.setText("");
        jTxtNome.setText("");
        jFmtCpf.setText("");
        jTxtEmail.setText("");
        jTxtEmailReserva.setText("");
        jTxtCidade.setText("");
        jTxtBairro.setText("");
        jTxtEndereco.setText("");
        jTxtPais.setText("");
        jFmtCarteiraTrabalho.setText("");
        jFmtCelular.setText("");
        jFmtCep.setText("");
        jFmtDataNascimento.setText("");
        jFmtTelefone.setText("");
        jCboSexo.setSelectedIndex(-1);
        jChbAtivo.setSelected(false);
    }

    public Funcionarios ViewBean() {
        Funcionarios funcionarios = new Funcionarios();
        int id = Integer.parseInt(jTxtCodigo.getText());
         SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            funcionarios.setDatanascimento(formato.parse(jFmtDataNascimento.getText()));
        } catch (ParseException ex) {
            System.out.println("Erro, burro:" + ex.getMessage());
        }
        //transforma para inteiro
        funcionarios.setIdfuncionario(id);
        funcionarios.setNome(jTxtNome.getText());
        funcionarios.setCpf(jFmtCpf.getText());
        funcionarios.setEmail(jTxtEmail.getText());
        funcionarios.setTelefone(jFmtTelefone.getText());
        funcionarios.setEmailreserva(jTxtEmailReserva.getText());
        funcionarios.setCelular(jFmtCelular.getText());
        funcionarios.setBairro(jTxtBairro.getText());
        funcionarios.setCidade(jTxtCidade.getText());
        funcionarios.setPais(jTxtPais.getText());
        funcionarios.setCep(jFmtCep.getText());
        funcionarios.setEndereco(jTxtEndereco.getText());
        funcionarios.setSexo(jCboSexo.getSelectedIndex());
        funcionarios.setCarteiratrabalho(jFmtCarteiraTrabalho.getText());
        if (jChbAtivo.isSelected() == true) {
            funcionarios.setAtivo("S");
        } else {
            funcionarios.setAtivo("N");
        }
        return funcionarios;
    }

    public void beanView(Funcionarios funcionarios) {
        String id = String.valueOf(funcionarios.getIdfuncionario());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        //transforma inteiro para string
        jTxtCodigo.setText(id);
        jTxtNome.setText(funcionarios.getNome());
        jFmtCpf.setText(funcionarios.getCpf());
        jTxtEmail.setText(funcionarios.getEmail());
        jFmtTelefone.setText(funcionarios.getTelefone());
        jTxtEmailReserva.setText(funcionarios.getEmailreserva());
        jFmtDataNascimento.setText(formato.format(funcionarios.getDatanascimento()));
        jFmtCelular.setText(funcionarios.getCelular());
        jTxtBairro.setText(funcionarios.getBairro());
        jTxtCidade.setText(funcionarios.getCidade());
        jTxtPais.setText(funcionarios.getPais());
        jFmtCep.setText(funcionarios.getCep());
        jTxtEndereco.setText(funcionarios.getEndereco());
        jCboSexo.setSelectedIndex(funcionarios.getSexo());
        jFmtCarteiraTrabalho.setText(funcionarios.getCarteiratrabalho());
        if (funcionarios.getAtivo().equals("S") == true) {
            jChbAtivo.setSelected(true);
        } else {
            jChbAtivo.setSelected(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTxtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxtEmailReserva = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCboSexo = new javax.swing.JComboBox<>();
        jFmtDataNascimento = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jTxtBairro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTxtCidade = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTxtPais = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jFmtTelefone = new javax.swing.JFormattedTextField();
        jFmtCep = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jFmtCarteiraTrabalho = new javax.swing.JFormattedTextField();
        jLabel15 = new javax.swing.JLabel();
        jTxtEndereco = new javax.swing.JTextField();
        jBtnIncluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jChbAtivo = new javax.swing.JCheckBox();
        jFmtCelular = new javax.swing.JFormattedTextField();
        jFmtCpf = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jTxtCodigo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome");

        jLabel2.setText("Email");

        jTxtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtEmailActionPerformed(evt);
            }
        });

        jLabel3.setText("Email Reserva");

        jTxtEmailReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtEmailReservaActionPerformed(evt);
            }
        });

        jLabel4.setText("Data de Nascimento");

        jLabel5.setText("Sexo");

        jLabel6.setText("Celular");

        jLabel7.setText("Cpf");

        jCboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Feminino", "Maculino", "Outro" }));
        jCboSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCboSexoActionPerformed(evt);
            }
        });

        jLabel9.setText("Bairro");

        jLabel10.setText("Cidade");

        jTxtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCidadeActionPerformed(evt);
            }
        });

        jLabel11.setText("País");

        jTxtPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtPaisActionPerformed(evt);
            }
        });

        jLabel12.setText("Cep");

        jLabel13.setText("Telefone");

        jFmtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtTelefoneActionPerformed(evt);
            }
        });

        jFmtCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtCepActionPerformed(evt);
            }
        });

        jLabel14.setText("Carteira de Trabalho");

        jFmtCarteiraTrabalho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtCarteiraTrabalhoActionPerformed(evt);
            }
        });

        jLabel15.setText("Endereço");

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/alterar.png"))); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Excluir.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/gravar.png"))); // NOI18N
        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancelar_1.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.png"))); // NOI18N
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jChbAtivo.setText("Ativo ");
        jChbAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChbAtivoActionPerformed(evt);
            }
        });

        jFmtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFmtCpfActionPerformed(evt);
            }
        });

        jLabel8.setText("Código");

        jTxtCodigo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTxtCodigoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtCodigoFocusLost(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtEmailReserva, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                            .addComponent(jTxtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFmtDataNascimento, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtNome)
                            .addComponent(jFmtCelular)
                            .addComponent(jFmtCpf))
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jFmtCarteiraTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel12)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addGap(140, 140, 140))
                                .addComponent(jLabel9)
                                .addComponent(jLabel10)
                                .addComponent(jLabel11)
                                .addComponent(jTxtPais)
                                .addComponent(jTxtCidade)
                                .addComponent(jTxtBairro)
                                .addComponent(jFmtTelefone, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jFmtCep)))
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jCboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 36, Short.MAX_VALUE)
                                .addComponent(jChbAtivo)
                                .addContainerGap(30, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTxtCodigo)
                                    .addComponent(jTxtEndereco))
                                .addGap(23, 23, 23))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel8))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnPesquisar))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFmtCarteiraTrabalho, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jChbAtivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtEmailReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTxtPais, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFmtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jFmtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jFmtDataNascimento)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFmtCelular))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFmtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(86, 86, 86)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnIncluir)
                    .addComponent(jBtnAlterar)
                    .addComponent(jBtnExcluir)
                    .addComponent(jBtnConfirmar)
                    .addComponent(jBtnCancelar)
                    .addComponent(jBtnPesquisar))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtEmailReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtEmailReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtEmailReservaActionPerformed

    private void jTxtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtEmailActionPerformed

    private void jCboSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCboSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCboSexoActionPerformed

    private void jTxtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCidadeActionPerformed

    private void jTxtPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtPaisActionPerformed

    private void jFmtCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtCepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtCepActionPerformed

    private void jChbAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChbAtivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jChbAtivoActionPerformed

    private void jFmtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtTelefoneActionPerformed

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        // TODO add your handling code here:
        incluindo = true;
        habilitar();
        limparCampos();
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        // TODO add your handling code here:
        incluindo = false;
        habilitar();
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        // TODO add your handling code here:
        int resp = JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?",
                "Exlusão", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_NO_OPTION) {
            Funcionarios funcionarios = ViewBean();
            Funcionarios_DAO funcionarios_DAO = new Funcionarios_DAO();
            funcionarios_DAO.delete(funcionarios);
        } else {
            JOptionPane.showMessageDialog(null, "Exclusão cancelada");
        }
        desabilitar();
        limparCampos();
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        // TODO add your handling code here:
        Funcionarios funcionarios = ViewBean();
        Funcionarios_DAO funcionarios_DAO = new Funcionarios_DAO();
        if (incluindo == true) {
            funcionarios_DAO.insert(funcionarios);
        } else {
            funcionarios_DAO.update(funcionarios);
        }

        desabilitar();
        limparCampos();
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Cancelamento concluído");
        desabilitar();
        limparCampos();
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
        // TODO add your handling code here:
        /*String resp = JOptionPane.showInputDialog(null, "Entre com o código (PK)", "Pesquisar", 2);
        int id = Integer.parseInt(resp);
        //transformou string em inteiro

        Funcionarios_DAO funcionarios_DAO = new Funcionarios_DAO();
        Funcionarios funcionarios = (Funcionarios) funcionarios_DAO.list(id);
        //retorna um bean e mostra na tela
        beanView(funcionarios);*/
        JDlgFuncionariosPesquisa jDlgFuncionariosPesquisa = new JDlgFuncionariosPesquisa(null, true);
        jDlgFuncionariosPesquisa.setTelaAnterior(this);
        jDlgFuncionariosPesquisa.setVisible(true);
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jTxtCodigoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtCodigoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCodigoFocusGained

    private void jTxtCodigoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtCodigoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtCodigoFocusLost

    private void jFmtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtCpfActionPerformed

    private void jFmtCarteiraTrabalhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFmtCarteiraTrabalhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFmtCarteiraTrabalhoActionPerformed

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
            java.util.logging.Logger.getLogger(JDlgFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDlgFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDlgFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDlgFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDlgFuncionarios dialog = new JDlgFuncionarios(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JComboBox<String> jCboSexo;
    private javax.swing.JCheckBox jChbAtivo;
    private javax.swing.JFormattedTextField jFmtCarteiraTrabalho;
    private javax.swing.JFormattedTextField jFmtCelular;
    private javax.swing.JFormattedTextField jFmtCep;
    private javax.swing.JFormattedTextField jFmtCpf;
    private javax.swing.JFormattedTextField jFmtDataNascimento;
    private javax.swing.JFormattedTextField jFmtTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTxtBairro;
    private javax.swing.JTextField jTxtCidade;
    private javax.swing.JTextField jTxtCodigo;
    private javax.swing.JTextField jTxtEmail;
    private javax.swing.JTextField jTxtEmailReserva;
    private javax.swing.JTextField jTxtEndereco;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtPais;
    // End of variables declaration//GEN-END:variables
}
