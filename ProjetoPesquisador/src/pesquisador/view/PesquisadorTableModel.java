/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pesquisador.view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import pesquisador.bean.PesquisadorBean;

/**
 *
 * @author Allyson Lopes
 */
public class PesquisadorTableModel extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = {"codigo", "nome", "pesquisa", "data_nascimento", "email", "telefone", "endereco", "cidade", "estado", "salario", "estado_civil"};

    public PesquisadorTableModel(ArrayList<PesquisadorBean> dados) {
        setLinhas(dados);
    }

    /**
     * @return the linhas
     */
    public ArrayList<PesquisadorBean> getLinhas() {
        return linhas;
    }

    /**
     * @param linhas the linhas to set
     */
    public void setLinhas(ArrayList<PesquisadorBean> linhas) {
        this.linhas = linhas;
    }

    /**
     * @return the colunas
     */
    public String[] getColunas() {
        return colunas;
    }

    /**
     * @param colunas the colunas to set
     */
    public void setColunas(String[] colunas) {
        this.setColunas(colunas);
    }

    //Retorna o numero de colunas no modelo
    //@see javax.swing.table.TableModel#getColumnCount()
    @Override
    public int getColumnCount() {
        return getColunas().length;
    }

    //Retorna o numero de linhas existentes no modelo
    //@see javax.swing.table.TableModel#getRowCount()
    @Override
    public int getRowCount() {
        return getLinhas().size();
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PesquisadorBean bean = (PesquisadorBean) linhas.get(rowIndex);
        if (columnIndex != -1) {
            switch (columnIndex) {
                case 0:
                    return bean.getCodigo();
                case 1:
                    return bean.getNome();
                case 2:
                    return bean.getPesquisa();
                case 3:
                    return bean.getData_nascimento();
                case 4:
                    return bean.getEmail();
                case 5:
                    return bean.getTelefone();
                case 6:
                    return bean.getCidade();
                case 7:
                    return bean.getEstado();
                case 8:
                    return bean.getSalario();
                case 9:
                    return bean.getEstado_civil();
            }
        } else if (columnIndex == -1) {
            return bean;
        }
        return null;
    }
}
