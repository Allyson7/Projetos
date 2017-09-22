/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pesquisador.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import pesquisador.bean.PesquisadorBean;
import util.BaseDao;
import util.ConexaoPostGreSql;
import util.DaoException;

/**
 *
 * @author Allyson Lopes
 */
public class PesquisadorDao {

    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public Object inserir(Object obj) throws DaoException {
        PesquisadorBean pesquisador = (PesquisadorBean) obj;
        String sql = "insert into pesquisador(nome, pesquisa, data_nascimento, email, telefone, cidade, estado, salario, estado_civil) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            con = ConexaoPostGreSql.getConexao();
            pst = con.prepareStatement(sql);
            pst.setInt(1, pesquisador.getCodigo());
            pst.setString(2, pesquisador.getNome());
            pst.setString(3, pesquisador.getPesquisa());
            pst.setDate(4, (Date) pesquisador.getData_nascimento());
            pst.setString(5, pesquisador.getEmail());
            pst.setString(6, pesquisador.getTelefone());
            pst.setObject(7, pesquisador.getEndereco());
            pst.setString(8, pesquisador.getCidade());
            pst.setString(9, pesquisador.getEstado());
            pst.setFloat(10, pesquisador.getSalario());
            pst.setString(11, pesquisador.getEstado_civil());
            pst.execute();
            return pesquisador;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisadorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoPostGreSql.fechar(pst);
            ConexaoPostGreSql.fechar(con);
        }
        return null;
    }

    public Object alterar(Object obj) throws DaoException {
        PesquisadorBean pesquisador = (PesquisadorBean) obj;
        String sql = "update pesquisador set nome = ?, pesquisa = ?, data_nascimento = ?, email = ?, telefone = ?, cidade = ?, estado = ?, salario = ?, estado_civil = ? where = codigo = ?";
        try {
            con = ConexaoPostGreSql.getConexao();
            pst = con.prepareStatement(sql);
            pst.setInt(1, pesquisador.getCodigo());
            pst.setString(2, pesquisador.getNome());
            pst.setString(3, pesquisador.getPesquisa());
            pst.setDate(4, (Date) pesquisador.getData_nascimento());
            pst.setString(5, pesquisador.getEmail());
            pst.setString(6, pesquisador.getTelefone());
            pst.setObject(7, pesquisador.getEndereco());
            pst.setString(8, pesquisador.getCidade());
            pst.setString(9, pesquisador.getEstado());
            pst.setFloat(10, pesquisador.getSalario());
            pst.setString(11, pesquisador.getEstado_civil());
            pst.execute();
            return pesquisador;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisadorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoPostGreSql.fechar(pst);
            ConexaoPostGreSql.fechar(con);
        }
        return null;
    }

    public Boolean excluir(Integer codigo) throws DaoException {
        String sql = "delete from pesquisador where codigo = ?";
        try {
            con = ConexaoPostGreSql.getConexao();
            pst = con.prepareStatement(sql);
            pst.setInt(1, codigo);
            pst.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisadorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoPostGreSql.fechar(pst);
            ConexaoPostGreSql.fechar(con);
        }
        return null;
    }

    public Collection listar() throws DaoException {
        ArrayList pesquisadores = new ArrayList();
        PesquisadorBean pesquisador;
        String sql = "select * from pesquisador";
        try {
            con = ConexaoPostGreSql.getConexao();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                pesquisador = new PesquisadorBean();
                pst.setInt(1, pesquisador.getCodigo());
                pst.setString(2, pesquisador.getNome());
                pst.setString(3, pesquisador.getPesquisa());
                pst.setDate(4, (Date) pesquisador.getData_nascimento());
                pst.setString(5, pesquisador.getEmail());
                pst.setString(6, pesquisador.getTelefone());
                pst.setObject(7, pesquisador.getEndereco());
                pst.setString(8, pesquisador.getCidade());
                pst.setString(9, pesquisador.getEstado());
                pst.setFloat(10, pesquisador.getSalario());
                pst.setString(11, pesquisador.getEstado_civil());
                pesquisadores.add(pesquisador);
            }
            return pesquisadores;
        } catch (SQLException ex) {
            Logger.getLogger(PesquisadorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoPostGreSql.fechar(rs);
            ConexaoPostGreSql.fechar(pst);
            ConexaoPostGreSql.fechar(con);
        }
        return null;
    }

    public Object selecionar(Integer codigo) throws DaoException {
        PesquisadorBean pesquisador;
        String sql = "select * from pesquisador qhere codigo = ?";
        try {
            con = ConexaoPostGreSql.getConexao();
            pst = con.prepareStatement(sql);
            pst.setInt(1, codigo);
            rs = pst.executeQuery();
            while (rs.next()) {
                pesquisador = new PesquisadorBean();
                pst.setInt(1, pesquisador.getCodigo());
                pst.setString(2, pesquisador.getNome());
                pst.setString(3, pesquisador.getPesquisa());
                pst.setDate(4, (Date) pesquisador.getData_nascimento());
                pst.setString(5, pesquisador.getEmail());
                pst.setString(6, pesquisador.getTelefone());
                pst.setObject(7, pesquisador.getEndereco());
                pst.setString(8, pesquisador.getCidade());
                pst.setString(9, pesquisador.getEstado());
                pst.setFloat(10, pesquisador.getSalario());
                pst.setString(11, pesquisador.getEstado_civil());
                return pesquisador;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PesquisadorDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConexaoPostGreSql.fechar(rs);
            ConexaoPostGreSql.fechar(pst);
            ConexaoPostGreSql.fechar(con);
        }
        return null;
    }
}
