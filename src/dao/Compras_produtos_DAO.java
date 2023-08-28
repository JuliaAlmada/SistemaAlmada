/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Compras_produtos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Compras_produtos_DAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {
        Compras_produtos compras_produtos = (Compras_produtos) object;
        String url, user, password;

        url = "jdbc:mysql://127.0.0.1:3306/localhost"; //"jdbc:mysql://10.7.51:33062/db_julia_almada";
        user = "root"; //"julia_almada";
        password = ""; //"julia_almada";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            //   Statement stm;
            //stm = cnt.createStatement();

            String sql = "insert into compras_produtos values(?,?,?,?,?)  ";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, compras_produtos.getIdcompra_produto());
            pstm.setInt(2, compras_produtos.getCompra());
            pstm.setInt(3, compras_produtos.getProduto());
            pstm.setString(4, compras_produtos.getQuantidade());
            pstm.setDouble(5, compras_produtos.getValorUnitario());
            pstm.executeUpdate();
            // stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Compras_produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Compras_produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  /*  public static void main(String[] args) {

        Compras_produtos compras_produtos = new Compras_produtos();
        compras_produtos.setIdcompra_produto(3);
        compras_produtos.setCompra(1);
        compras_produtos.setProduto(1);
        compras_produtos.setQuantidade("10");
        compras_produtos.setValorUnitario(20.00);
        Compras_produtos_DAO compras_produtos_DAO = new Compras_produtos_DAO();
        compras_produtos_DAO.insert(compras_produtos);
        System.out.println("deu certo");
    }*/

}
