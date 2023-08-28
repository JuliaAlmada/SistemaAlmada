/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Fornecedores;
import dao.DAO_Abstract;
import java.sql.Connection;
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
public class Fornecedores_DAO extends DAO_Abstract {

    @Override
    public void insert(Object object) {
        Fornecedores fornecedores = (Fornecedores) object;
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

            String sql = "insert into fornecedores values(?,?,?,?,?,?)  ";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, fornecedores.getIdfornecedor());
            pstm.setString(2, fornecedores.getNome());
            pstm.setString(3, fornecedores.getEmail());
            pstm.setString(4, fornecedores.getTelefone());
            pstm.setString(5, fornecedores.getCnpj());
            pstm.setString(6, fornecedores.getEnderecocompleto());

            pstm.executeUpdate();
            // stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Fornecedores_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Fornecedores_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        Fornecedores fornecedores = (Fornecedores) object;
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
            String sql = "update fornecedores set nome=?, email=?, telefone=?, cnpj=?, enderecocompleto=? where idfornecedor=? ";
            PreparedStatement pstm = cnt.prepareStatement(sql);

            pstm.setString(1, fornecedores.getNome());
            pstm.setString(2, fornecedores.getEmail());
            pstm.setString(3, fornecedores.getTelefone());
            pstm.setString(4, fornecedores.getCnpj());
            pstm.setString(5, fornecedores.getEnderecocompleto());
            pstm.setInt(6, fornecedores.getIdfornecedor());
            pstm.executeUpdate();
            // pstm.executeUpdate(); executa a operação, nesse caso o update
            // contanto que as linhas estejam seguindo a numeração do String sql,
            //tanto faz a sua posisão depois do PreparedStatement pstm = cnt.prepareStatement(sql);

            //  stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Fornecedores_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Fornecedores_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(Object object) {
        Fornecedores fornecedores = (Fornecedores) object;
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
            String sql = "delete from fornecedores where idfornecedor=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, fornecedores.getIdfornecedor());
            pstm.executeUpdate();
            // pstm.executeUpdate(); executa a operação, nesse caso a delete

            //  stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Fornecedores_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Fornecedores_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public Object list(int id) {
        Fornecedores fornecedores = new Fornecedores();
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
            String sql = "select * from fornecedores where idfornecedor=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next() == true) {
                fornecedores.setIdfornecedor(rs.getInt("idfornecedor"));
                fornecedores.setNome(rs.getString("nome"));
                fornecedores.setEmail(rs.getString("email"));
                fornecedores.setTelefone(rs.getString("telefone"));
                fornecedores.setCnpj(rs.getString("cnpj"));
                fornecedores.setEnderecocompleto(rs.getString("enderecocompleto"));

            }

            // pstm.executeUpdate(); executa a operação, nesse caso o list
            //  stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Fornecedores_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Fornecedores_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fornecedores;
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

            String sql = "select * from fornecedores ";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next() == true) {
                Fornecedores fornecedores = new Fornecedores();
                fornecedores.setIdfornecedor(rs.getInt("idfornecedor"));
                fornecedores.setNome(rs.getString("nome"));
                fornecedores.setEmail(rs.getString("email"));
                fornecedores.setTelefone(rs.getString("telefone"));
                fornecedores.setCnpj(rs.getString("cnpj"));
                fornecedores.setEnderecocompleto(rs.getString("enderecocompleto"));

                lista.add(fornecedores);
            }
            // pstm.executeUpdate(); executa a operação, nesse caso o list
            //  stm.executeUpdate(sql);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Fornecedores_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Fornecedores_DAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return lista;

    }

    /*public static void main(String[] args) {

        Fornecedores fornecedores = new Fornecedores();
        fornecedores.setIdfornecedor(6);
        fornecedores.setNome("forfor");
        fornecedores.setEmail("fornecedorfoda@gmail.com");
        fornecedores.setTelefone("45646747");
        fornecedores.setCnpj("1252626623");
        fornecedores.setEnderecocompleto("Ali na esquina do lado");
        Fornecedores_DAO fornecedores_DAO = new Fornecedores_DAO();
        fornecedores_DAO.insert(fornecedores);
        System.out.println("deu certo");
    }*/
}
