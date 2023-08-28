/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.Fornecedores;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u49558987859
 */
public class FornecedoresControle extends AbstractTableModel{
    private List lista;
    public void setList(List lista){
    this.lista = lista;
    }

    public Fornecedores getBean (int row){
    return (Fornecedores) lista.get(row);
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Fornecedores fornecedores =(Fornecedores) lista.get(rowIndex);
         if (columnIndex == 0 ) {
            return fornecedores.getIdfornecedor();
        }
        if (columnIndex == 1 ) {
            return fornecedores.getNome();
        }
        if (columnIndex == 2 ) {
            return fornecedores.getEmail();
        }
        if (columnIndex == 3 ) {
            return fornecedores.getTelefone();
        }
        if (columnIndex == 4 ) {
            return fornecedores.getCnpj();
        }
         if (columnIndex == 5 ) {
            return fornecedores.getEnderecocompleto();
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
            return "email";
        }
        if (column == 3 ) {
            return "telefone";
        }
        if (column == 4 ) {
            return "cnpj";
        }
        if (column == 4 ) {
            return "enderecocompleto";
        }
        return "";
    }
}
