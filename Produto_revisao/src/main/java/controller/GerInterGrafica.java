/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Categoria;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import viewer.ProdutoMain;

/**
 *
 * @author User
 */
public class GerInterGrafica {

    private ProdutoMain telaInicio;
    GerDominio gerDom;

    public GerInterGrafica() {

        telaInicio = null;
        
        try {
            gerDom = new GerDominio();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GerInterGrafica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GerInterGrafica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    
     public void abrirTelaLogin(){
        if(telaInicio == null){ 
            telaInicio = new ProdutoMain (this);
        }
        telaInicio.setVisible(true);
    }

    public GerDominio getGerDom() {
        return gerDom;
    }    
    
    public void carregarComboBoxCategoria(JComboBox comboBoxCat){
        List<Categoria> listaCat;
        try {
            listaCat = gerDom.listarcategorias();
            comboBoxCat.setModel(new DefaultComboBoxModel(listaCat.toArray()));
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(telaInicio, "Erro ao carregar categorias");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(telaInicio, "Erro ao carregar categorias");
        }     
    } 
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ProdutoMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutoMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutoMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutoMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        GerInterGrafica gerenciarInter = new GerInterGrafica();
        gerenciarInter.abrirTelaLogin();
    }
     
     
}
