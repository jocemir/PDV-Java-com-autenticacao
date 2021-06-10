/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Telas.FrmLogin;
import Telas.FrmMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Clientes;
import modelo.Funcionarios;
import projeto.jdbc.ConnectionFactory;

/**
 *
 * @author JJV
 */
public class FuncionariosDAO {
    
    //conexão
    
    private Connection con;

    public FuncionariosDAO() {
        this.con = new ConnectionFactory().getConnection();

    }
    
    //metodos cadastrar funcionarios
    
     public void cadastrarFuncionarios(Funcionarios obj) {
        try {
            //1 passo - crir o comando sql
            String sql = "insert into tb_funcionarios(nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            //2 passo - conectar o banco de dados e organizar o comendo sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro!" + erro);
        }

    }
     
     //metodo alterar funcionarios
     
      public void alterarFuncionarios(Funcionarios obj) {
        try {
            //1 passo - crir o comando sql
            String sql = "update tb_funcionarios set nome=?,rg=?,cpf=?,email=?,senha=?,cargo=?,nivel_acesso=?,telefone=?,celular=?,cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id=?" ;

            //2 passo - conectar o banco de dados e organizar o comendo sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());
            
            stmt.setInt(17, obj.getId());

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro!" + erro);
        }

    }
     
     // Método excluir funcionarios
     
      public void excluirFuncionaro(Funcionarios obj) {
        try {
            //1 passo - crir o comando sql
            String sql = "delete from tb_funcionarios where id = ?";

            //2 passo - conectar o banco de dados e organizar o comendo sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro!" + erro);
        }

    }
     
     // Medodo listar funcionarios
     
      public List<Clientes> listarClientes() {

        try {
            //1 passo criar a lista
            List<Clientes> lista = new ArrayList<>();

             // 2 passo - criar o sql, organizar e executar.
            String sql = "select * from tb_clientes";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);

            }
            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }

    }

     public List<Funcionarios> listarFuncionarios() {

        try {
            //1 passo criar a lista
            List<Funcionarios> lista = new ArrayList<>();

             // 2 passo - criar o sql, organizar e executar.
            
            String sql = "select * from tb_funcionarios";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionarios obj = new Funcionarios();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);

            }
            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }

    }
     
     //Metodo Consulta funcionario por nome dentro no cadastro
    
    public Funcionarios consultaPorNome(String nome){
        try {
            //1 passo criar o sql, organizar e executar.
            String sql = "select * from tb_funcionarios where nome = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
             Funcionarios obj = new Funcionarios();
            
             if (rs.next()) {
               
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                 }
             return obj;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Funcionário Não Encontrado");
            return null;
        }
        }
     
     //metodo listar funcionario por nome
    
     public List<Funcionarios> listaFucnioariosPorNome(String nome) {

        try {
            //1 passo criar a lista
            List<Funcionarios> lista = new ArrayList<>();

             // 2 passo - criar o sql, organizar e executar.
            
            String sql = "select * from tb_funcionarios where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionarios obj = new Funcionarios();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
            }
            
            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);
            return null;
        }
     }
     
     //Metodo Efetura Login
     
     public void efetuarLogin(String email, String senha){
         try {
             //1 passo -SQL
             
             String sql = "Select*from tb_funcionarios where email = ? and senha = ?";
             
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                //Usuario Logou
                
                JOptionPane.showMessageDialog(null, "Seja bem vindo");
                FrmMenu tela = new FrmMenu();
                tela.usuariologado = rs.getString("nome");
                tela.setVisible(true);
            }else {
                //Dados Incorretos
                JOptionPane.showMessageDialog(null, "Ops, Dados Incorretos");
                 new FrmLogin().setVisible(true);
            }
             
         } catch (SQLException erro) {
             JOptionPane.showMessageDialog(null, "Erro: " + erro);
         }
         
             
     }
}
