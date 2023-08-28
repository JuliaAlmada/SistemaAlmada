/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author User
 */
public class Compras_produtos {

    private int idcompra_produto;
    private int compra;
    private int produto;
    private String quantidade;
    private double valorUnitario;
    
    public Compras_produtos(){
    }
    /**
     * @return the idcompra_produto
     */
    public int getIdcompra_produto() {
        return idcompra_produto;
    }

    /**
     * @param idcompra_produto the idcompra_produto to set
     */
    public void setIdcompra_produto(int idcompra_produto) {
        this.idcompra_produto = idcompra_produto;
    }

    /**
     * @return the compra
     */
    public int getCompra() {
        return compra;
    }

    /**
     * @param compra the compra to set
     */
    public void setCompra(int compra) {
        this.compra = compra;
    }

    /**
     * @return the produto
     */
    public int getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(int produto) {
        this.produto = produto;
    }

    /**
     * @return the quantidade
     */
    public String getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the valorUnitario
     */
    public double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

}
