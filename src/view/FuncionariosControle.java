/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Funcionarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u49558987859
 */
public class FuncionariosControle extends AbstractTableModel{
    private List lista;
    public void setList(List lista){
    this.lista = lista;
    }

    public Funcionarios getBean (int row){
    return (Funcionarios) lista.get(row);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 16;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Funcionarios funcionarios =(Funcionarios) lista.get(rowIndex);
         if (columnIndex == 0 ) {
            return funcionarios.getIdfuncionario();
        }
        if (columnIndex == 1 ) {
            return funcionarios.getNome();
        }
        if (columnIndex == 2 ) {
            return funcionarios.getCpf();
        }
        if (columnIndex == 3 ) {
            return funcionarios.getEmail();
        }
        if (columnIndex == 4 ) {
            return funcionarios.getTelefone();  
        }
        if (columnIndex == 5 ) {
            return funcionarios.getEmailreserva();
        }
        if (columnIndex == 6 ) {
            return funcionarios.getDatanascimento();
        }
        if (columnIndex == 7 ) {
            return funcionarios.getCelular();
        }
        if (columnIndex == 8) {
            return funcionarios.getBairro();
        }
        if (columnIndex == 9 ) {
            return funcionarios.getCidade();
        }
        if (columnIndex == 10 ) {
            return funcionarios.getPais();
        }
        if (columnIndex == 11 ) {
            return funcionarios.getCep();
        }
        if (columnIndex == 12) {
            return funcionarios.getEndereco();
        }
         if (columnIndex == 13 ) {
            return funcionarios.getSexo();
        }
        if (columnIndex == 14 ) {
            return funcionarios.getAtivo();
        }
        if (columnIndex == 15) {
            return funcionarios.getCarteiratrabalho();
        }
         return "";
    }
    @Override
    public String getColumnName(int column){
        if (column == 0 ) {
            return "id";
        }
        if (column == 1 ) {
            return "nome";
        }
        if (column == 2 ) {
            return "cpf";
        }
        if (column == 3 ) {
            return "email";
        }
        if (column == 4 ) {
            return "telefone";
        }
        if (column == 5 ) {
            return "emailreserva";
        }
        if (column == 6 ) {
            return "datanascimento";
        }
        if (column == 7 ) {
            return "celular";
        }
        if (column == 8 ) {
            return "bairro";
        }
        if (column == 9 ) {
            return "cidade";
        }
        if (column == 10 ) {
            return "pais";
        }
        if (column == 11 ) {
            return "cep";
        }
        if (column == 12 ) {
            return "endereco";
        }
        if (column == 13 ) {
            return "sexo";
        }
        if (column == 14 ) {
            return "ativo";
        }
         if (column == 15 ) {
            return "carteiratrabalho";
        }
        return "";
    }
}
