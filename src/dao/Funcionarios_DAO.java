/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Fornecedores;
import bean.Funcionarios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

/**
 *
 * @author User
 */
public class Funcionarios_DAO extends DAO_Abstract {

    public void Funcionarios_DAO() {
    }

    @Override
    public void insert(Object object) {
        Funcionarios funcionarios = (Funcionarios) object;
        String url, user, password;

        url = "jdbc:mysql://127.0.0.1:3306/localhost"; //"jdbc:mysql://10.7.51:33062/db_julia_almada";
        user = "root"; //"julia_almada";
        password = ""; //"julia_almada";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            // Statement stm;
            //  stm = cnt.createStatement;

            String sql = "insert into funcionarios values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, funcionarios.getIdfuncionario());
            pstm.setString(2, funcionarios.getNome());
            pstm.setString(3, funcionarios.getCpf());
            pstm.setString(4, funcionarios.getEmail());
            pstm.setString(5, funcionarios.getTelefone());
            pstm.setString(6, funcionarios.getEmailreserva());
            pstm.setDate(7, new java.sql.Date(funcionarios.getDatanascimento().getTime()));
            pstm.setString(8, funcionarios.getCelular());
            pstm.setString(9, funcionarios.getBairro());
            pstm.setString(10, funcionarios.getCidade());
            pstm.setString(11, funcionarios.getPais());
            pstm.setString(12, funcionarios.getCep());
            pstm.setString(13, funcionarios.getEndereco());
            pstm.setInt(14, funcionarios.getSexo());
            pstm.setString(15, funcionarios.getAtivo());
            pstm.setString(16, funcionarios.getCarteiratrabalho());

            pstm.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Funcionarios_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Funcionarios_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Object object) {
        Funcionarios funcionarios = (Funcionarios) object;
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
            String sql = "update funcionarios set nome=?,cpf=?, email=?, telefone=?, emailreserva=?,  datanascimento=?, celular=?,"
                    + "  bairro=?, cidade=?, pais=?,cep=?, endereco=?,sexo=?,ativo=?, carteiratrabalho=? where idfuncionario=? ";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setString(1, funcionarios.getNome());
            pstm.setString(2, funcionarios.getCpf());
            pstm.setString(3, funcionarios.getEmail());
            pstm.setString(4, funcionarios.getTelefone());
            pstm.setString(5, funcionarios.getEmailreserva());
            pstm.setDate(6, new java.sql.Date(funcionarios.getDatanascimento().getTime()));
            pstm.setString(7, funcionarios.getCelular());
            pstm.setString(8, funcionarios.getBairro());
            pstm.setString(9, funcionarios.getCidade());
            pstm.setString(10, funcionarios.getPais());
            pstm.setString(11, funcionarios.getCep());
            pstm.setString(12, funcionarios.getEndereco());
            pstm.setInt(13, funcionarios.getSexo());
            pstm.setString(14, funcionarios.getAtivo());
            pstm.setString(15, funcionarios.getCarteiratrabalho());
            pstm.setInt(16, funcionarios.getIdfuncionario());
            pstm.executeUpdate();
            // pstm.executeUpdate(); executa a operação, nesse caso o update
            // contanto que as linhas estejam seguindo a numeração do String sql,
            //tanto faz a sua posisão depois do PreparedStatement pstm = cnt.prepareStatement(sql);

            //  stm.executeUpdate(sql);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Vendedores_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Vendedores_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Object object) {
        Funcionarios funcionarios = (Funcionarios) object;
        String url, user, password;

        url = "jdbc:mysql://127.0.0.1:3306/localhost"; //"jdbc:mysql://10.7.51:33062/db_tatiana_oseko";
        user = "root"; //"tatiana_oseko";
        password = ""; //"tatiana_oseko";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            // Statement stm;
            //  stm = cnt.createStatement;

            String sql = "delete from funcionarios where idfuncionario=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, funcionarios.getIdfuncionario());
            pstm.executeUpdate();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Funcionarios_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Funcionarios_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Object list(int id) {
        Funcionarios funcionarios = new Funcionarios();
        String url, user, password;

        url = "jdbc:mysql://127.0.0.1:3306/localhost"; //"jdbc:mysql://10.7.51:33062/db_tatiana_oseko";
        user = "root"; //"tatiana_oseko";
        password = ""; //"tatiana_oseko";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            cnt = DriverManager.getConnection(url, user, password);
            // Statement stm;
            //  stm = cnt.createStatement;

            String sql = "select * from funcionarios where idfuncionario=?";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next() == true) {
                funcionarios.setIdfuncionario(rs.getInt("idfuncionario"));
                funcionarios.setNome(rs.getString("nome"));
                funcionarios.setCpf(rs.getString("cpf"));
                funcionarios.setEmail(rs.getString("email"));
                funcionarios.setTelefone(rs.getString("telefone"));
                funcionarios.setEmailreserva(rs.getString("emailreserva"));
                funcionarios.setDatanascimento(rs.getDate("datanascimento"));
                funcionarios.setCelular(rs.getString("celular"));
                funcionarios.setBairro(rs.getString("bairro"));
                funcionarios.setCidade(rs.getString("cidade"));
                funcionarios.setPais(rs.getString("pais"));
                funcionarios.setCep(rs.getString("cep"));
                funcionarios.setEndereco(rs.getString("endereco"));
                funcionarios.setSexo(rs.getInt("sexo"));
                funcionarios.setAtivo(rs.getString("ativo"));
                funcionarios.setCarteiratrabalho(rs.getString("carteiratrabalho"));
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Funcionarios_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Funcionarios_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionarios;

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

            String sql = "select * from funcionarios ";
            PreparedStatement pstm = cnt.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next() == true) {
                Funcionarios funcionarios = new Funcionarios();
                funcionarios.setIdfuncionario(rs.getInt("idfuncionario"));
                funcionarios.setNome(rs.getString("nome"));
                funcionarios.setCpf(rs.getString("cpf"));
                funcionarios.setEmail(rs.getString("email"));
                funcionarios.setTelefone(rs.getString("telefone"));
                funcionarios.setEmailreserva(rs.getString("emailreserva"));
                funcionarios.setDatanascimento(rs.getDate("datanascimento"));
                funcionarios.setCelular(rs.getString("celular"));
                funcionarios.setBairro(rs.getString("bairro"));
                funcionarios.setCidade(rs.getString("cidade"));
                funcionarios.setPais(rs.getString("pais"));
                funcionarios.setCep(rs.getString("cep"));
                funcionarios.setEndereco(rs.getString("endereco"));
                funcionarios.setSexo(rs.getInt("sexo"));
                funcionarios.setAtivo(rs.getString("ativo"));
                funcionarios.setCarteiratrabalho(rs.getString("carteiratrabalho"));

                lista.add(funcionarios);
            }
            // pstm.executeUpdate(); executa a operação, nesse caso o list
            //  stm.executeUpdate(sql);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Funcionarios_DAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Funcionarios_DAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return lista;
    }

    /* public static void main(String[] args) {
        Funcionarios funcionarios = new Funcionarios();
        funcionarios.setIdfuncionario(4);
        funcionarios.setNome("Funcionario");
        funcionarios.setCpf("456457567");
        funcionarios.setEmail("cfuncionario@gmail.com");
        funcionarios.setTelefone("7867868678");
        funcionarios.setEmailreserva("funcionario@gmail.com");
        //duncionarios.setDatanascimento("12/12/2012");
        funcionarios.setCelular("65876787");
        funcionarios.setBairro("Fruta");
        funcionarios.setCidade("Ponta Pora");
        funcionarios.setPais("Brazil");
        funcionarios.setCep("79904067");
        funcionarios.setEndereco("Beco");
        funcionarios.setSexo(1);
        funcionarios.setAtivo("S");
        funcionarios.setCarteiratrabalho("89789799");
        Funcionarios_DAO funcionarios_DAO = new Funcionarios_DAO();
        funcionarios_DAO.insert(funcionarios);
        System.out.println("deu certo");

    }*/
}
