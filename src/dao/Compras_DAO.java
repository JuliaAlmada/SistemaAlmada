/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Compras;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Compras_DAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {
        Compras compras = (Compras) object;
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

            String sql = "insert into compras values(?,?,?,?,?)  ";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, compras.getIdcompra());
            pstm.setDate(2, new java.sql.Date(compras.getData().getTime()));
            pstm.setInt(3, compras.getFornecedor());
            pstm.setInt(4, compras.getFuncionario());
            pstm.setDouble(5, compras.getTotal());
            pstm.executeUpdate();
            // stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Compras_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Compras_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        Compras compras = (Compras) object;
        String url, user, password;
        url = "jdbc:mysql://127.0.0.1:3306/localhost"; //"jdbc:mysql://10.7.51:33062/db_julia_almada";
        user = "root"; //"julia_almada";
        password = ""; //"julia_almada";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            //  Statement stm;
            // stm = cnt.createStatement();
            String sql = "update compras set data=?, fornecedor=?, funcionario=?, total=? where idcompra=? ";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setDate(1, new java.sql.Date(compras.getData().getTime()));
            pstm.setInt(2, compras.getFornecedor());
            pstm.setInt(3, compras.getFuncionario());
            pstm.setDouble(4, compras.getTotal());
            pstm.setInt(5, compras.getIdcompra());
            pstm.executeUpdate();
            // pstm.executeUpdate(); executa a operação, nesse caso o update
            // contanto que as linhas estejam seguindo a numeração do String sql,
            //tanto faz a sua posisão depois do PreparedStatement pstm = cnt.prepareStatement(sql);

            //  stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Compras_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Compras_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Compras compras = (Compras) object;
        String url, user, password;
        url = "jdbc:mysql://127.0.0.1:3306/localhost"; //"jdbc:mysql://10.7.51:33062/db_julia_almada";
        user = "root"; //"julia_almada";
        password = ""; //"julia_almada";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            //  Statement stm;
            // stm = cnt.createStatement();
            String sql = "delete from compras where idcompra=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, compras.getIdcompra());
            pstm.executeUpdate();
            // pstm.executeUpdate(); executa a operação, nesse caso a delete

            //  stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Compras_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Compras_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        Compras compras = new Compras();
        String url, user, password;
        url = "jdbc:mysql://127.0.0.1:3306/localhost"; //"jdbc:mysql://10.7.51:33062/db_julia_almada";
        user = "root"; //"julia_almada";
        password = ""; //"julia_almada";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            //  Statement stm;
            // stm = cnt.createStatement();
            String sql = "select * from compras where idcompra=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next() == true) {
                compras.setIdcompra(rs.getInt("idcompra"));
                compras.setData(rs.getDate("data"));
                compras.setFornecedor(rs.getInt("fornecedor"));
                compras.setFuncionario(rs.getInt("funcionario"));
                compras.setTotal(rs.getDouble("total"));

            }

            // pstm.executeUpdate(); executa a operação, nesse caso o list
            //  stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Compras_produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Compras_produtos_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return compras;
    }

    @Override
    public List listAll() {
        String url, user, password;
        url = "jdbc:mysql://127.0.0.1:3306/localhost"; //"jdbc:mysql://10.7.51:33062/db_julia_almada";
        user = "root"; //"julia_almada";
        password = ""; //"julia_almada";
        List lista = new ArrayList();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            // Statement stm;
            //  stm = cnt.createStatement;

            String sql = "select * from compras ";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next() == true) {
                Compras compras = new Compras();
                compras.setIdcompra(rs.getInt("idcompra"));
                compras.setData(rs.getDate("data"));
                compras.setFornecedor(rs.getInt("fornecedor"));
                compras.setFuncionario(rs.getInt("funcionario"));
                compras.setTotal(rs.getDouble("total"));
                lista.add(compras);
            }
            // pstm.executeUpdate(); executa a operação, nesse caso o list
            //  stm.executeUpdate(sql);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Compras_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Compras_DAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return lista;
    }

    /*   public static void main(String[] args) {

        Compras compras = new Compras();
        compras.setIdcompra(3);
        // compras.setDate("25/04/15");
        compras.setFuncionario(1);
        compras.setFornecedor(1);
        compras.setTotal(2000.00);
        Compras_DAO compras_DAO = new Compras_DAO();
        compras_DAO.insert(compras);
        System.out.println("deu certo");
    }*/
}
