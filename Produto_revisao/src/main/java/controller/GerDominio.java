/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CategoriaDAO;
import dao.ConexaoBanco;
import dao.ProdutoDAO;
import domain.Categoria;
import domain.Produto;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public class GerDominio {

    private CategoriaDAO categoria_DAO;
    private ProdutoDAO produto_DAO;
    
    public GerDominio() throws ClassNotFoundException, SQLException {
        ConexaoBanco.fazerConexao();
        categoria_DAO = new CategoriaDAO();
        produto_DAO = new ProdutoDAO();
    }  
    
    public List<Categoria> listarcategorias() throws ClassNotFoundException, SQLException{
        return categoria_DAO.listar();
    }
    
    public int inserirCategoria(String descricao) throws ClassNotFoundException, SQLException{
        Categoria cate = new Categoria(descricao);
        
        categoria_DAO.inserir(cate);
        return cate.getIdcategoria();
    }
    
   public int inserirProduto(Produto prod) throws ClassNotFoundException, SQLException{      
       produto_DAO.inserir(prod);
       return prod.getIdProduto();
   }
   
   public Produto pesquisarProduto(int id) throws SQLException, ClassNotFoundException{
       Produto prod = produto_DAO.pesquisar(id);
       return prod;
   }
   
   public Produto alterarProduto(Produto prod) throws SQLException, ClassNotFoundException{
       produto_DAO.alterar(prod);
       return prod;
   }
   
   public List mostrarTodoProdutos() throws ClassNotFoundException, SQLException{
       return produto_DAO.listarTudo();
   }
   
   public List mostrarProdutoLimite(int limite) throws ClassNotFoundException, SQLException{
       return produto_DAO.listarLimite(limite);
   }
   
   public List mostrarProdutoCategoria(Categoria cat) throws SQLException, ClassNotFoundException{
       return produto_DAO.listarCategoria(cat);
   }
}
