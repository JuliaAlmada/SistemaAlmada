/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;

/**
 *
 * @author User
 */
public class Compras {

    private int idcompra;
    private Date data;
    private int fornecedor;
    private int funcionario;
    private double total;
    
    public Compras(){
    }
    /**
     * @return the idcompra
     */
    public int getIdcompra() {
        return idcompra;
    }

    /**
     * @param idcompra the idcompra to set
     */
    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the fornecedor
     */
    public int getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }

    /**
     * @return the funcionario
     */
    public int getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(int funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * @return the total
     */
}
