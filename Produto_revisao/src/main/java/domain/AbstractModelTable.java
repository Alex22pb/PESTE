/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class AbstractModelTable extends AbstractTableModel {

    private List lista = new ArrayList();

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Produto prod = (Produto) lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return prod.getIdProduto();
            case 1:
                return prod.getNome();
            case 2:
                return prod.getQuantidade();
            case 3:
                return prod.getPreco();
            case 4:
                return prod.getCategoria();
        }
        return null;
    }

    public String getColumnName(int column) {
        String nomes[] = {"ID", "Nome", "Qtd", "preco", "Categoria"};
        return nomes[column];
    }

    public List getLista() {
        return lista;
    }

    public void setLista(List novaLista) {
        if (novaLista == null || novaLista.isEmpty()) {
            if (!lista.isEmpty()) {
                lista.clear();
                fireTableRowsDeleted(0, 0);
            }
        } else {
            lista = novaLista;
            fireTableRowsInserted(0, lista.size() - 1);
        }
    }
}
