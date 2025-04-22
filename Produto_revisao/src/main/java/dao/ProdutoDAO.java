
package dao;

import domain.AbstractModelTable;
import domain.Categoria;
import domain.Produto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jean_
 */
public class ProdutoDAO {
          
    public void inserir(Produto prod) throws ClassNotFoundException, SQLException{
        // Insere todos os dados do produto no banco de dados       
	// Observe que o parâmetro é um objeto do tipo Produto (prod), 
        // portanto você deverá ler de um Frame os dados, criar um objeto 
        // do tipo Produto e passar como parâmetro para essa função
        //
        // O ID do produto é auto numeração
	//
	// INSERT INTO nome_tabela (CAMPOS separados por virgula)  VALUES 
        //    ( VALORES separados por vírgula )
        
        String sql = "INSERT INTO Produto (nome, quantidade, preco, idCategoria) "
                + "VALUES(?,?,?,?)";
        
        PreparedStatement pstmt = ConexaoBanco.fazerConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS );
        
        int col = 1;
        pstmt.setString(col++, prod.getNome());
        pstmt.setInt(col++, prod.getQuantidade());
        pstmt.setDouble(col++, prod.getPreco());
        pstmt.setInt(col++, prod.getCategoria().getIdcategoria());
        
        pstmt.execute();
        
        ResultSet res = pstmt.getGeneratedKeys();
        if(res.next()){
            int id = res.getInt(1);
            prod.setIdProduto(id);
        }
        
    }
//
//    
    public void alterar (Produto prod) throws SQLException, ClassNotFoundException{

	// Altera no banco os dados do produto
        // O código do produto deve ser um produto já inserido
        // Os demais campos são os novos dados
        // UPDATE nome_tabela SET campos = novos_valores
        //	WHERE campo_codigo = cod
        
        String sql = "UPDATE Produto SET "
                + "nome=?, quantidade=?, preco=?, idCategoria=? "
                + "WHERE idProduto = " + prod.getIdProduto();
        
        PreparedStatement stmt = ConexaoBanco.fazerConexao().prepareStatement(sql);
        
        int col = 1;
        stmt.setString(col++, prod.getNome());
        stmt.setInt(col++, prod.getQuantidade());
        stmt.setDouble(col++, prod.getPreco());
        stmt.setInt(col++, prod.getCategoria().getIdcategoria());
        
        stmt.execute();

    }
//
    public Produto pesquisar (int id ) throws SQLException, ClassNotFoundException{

	// Pesquisa no banco pelo ID passado como parâmetro 
        //  e retorna um objeto do tipo Produto.
        //  Antes de retornar deve criar um objeto do tipo Produto.
        // SELECT * FROM nome_tabela WHERE campo_codigo = cod_pesquisa
        Produto produto = null;
        
        String sql = "SELECT * FROM Produto as prod, Categoria as cat "
           + "WHERE prod.idCategoria = cat.idCategoria "
           + "AND idProduto = '" + id + "'";
        
        Statement pstmt = ConexaoBanco.fazerConexao().createStatement();
        
        ResultSet res = pstmt.executeQuery(sql);
        
         if(res.next()){
            Categoria cat = new Categoria(res.getInt("idcategoria"), res.getString("descricao"));
            produto = new Produto(res.getInt("idproduto"),res.getString("nome"), res.getInt("quantidade"), res.getDouble("preco"), cat);
        }

        return produto;
    }    
//
    public List<Produto> listarLimite(int limite) throws ClassNotFoundException, SQLException{

	// Pesquisa no banco e retorna, através de um List, 
        // todos os produtos que estão com a quantidade abaixo
        // 	do limite
        // No seu Frame, chame essa função e preencha a tabela com o
        //	resultado do List
        // SELECT * FROM nome_tabela  WHERE qtde < limite
        List<Produto> lista = new ArrayList();
        String sql = "SELECT * FROM Produto as prod, Categoria as cat "
                + "WHERE prod.idCategoria = cat.idCategoria and quantidade < " + limite ;
        Statement pstmt = ConexaoBanco.fazerConexao().createStatement();
        
        ResultSet res = pstmt.executeQuery(sql);
        
        while(res.next()){
            Categoria cat = new Categoria(res.getInt("idcategoria"), res.getString("descricao"));
            Produto produto = new Produto(res.getInt("idproduto"),res.getString("nome"), res.getInt("quantidade"), res.getDouble("preco"), cat);
            lista.add(produto);    
        }
        return lista;
    }
//
    public List<Produto> listarTudo() throws ClassNotFoundException, SQLException{

	// Pesquisa no banco e retorna, através de um List,
        // todos os produtos
        // 	
        // No seu Frame, chame essa função e preencha a tabela com o
        //	resultado do List
        List<Produto> lista = new ArrayList();
        
        String sql = "SELECT * FROM Produto as prod, Categoria as cat "
                + "WHERE prod.idCategoria = cat.idCategoria";
        Statement pstmt = ConexaoBanco.fazerConexao().createStatement();
        
        ResultSet res = pstmt.executeQuery(sql);
        
        while(res.next()){
            Categoria cat = new Categoria(res.getInt("idcategoria"), res.getString("descricao"));
            Produto produto = new Produto(res.getInt("idproduto"),res.getString("nome"), res.getInt("quantidade"), res.getDouble("preco"), cat);
            lista.add(produto);    
        }
        
        return lista;
    }
//    
    public List<Produto> listarCategoria(Categoria cat) throws SQLException, ClassNotFoundException{

	// Pesquisa no banco e retorna, através de um List,
        // todos os produtos de uma determinada categoria
        // 	
        // No seu Frame, chame essa função e preencha a tabela com o
        //	resultado do List
        // SELECT * FROM nome_tabela WHERE idCategoria = id_parametro_pesq
        List<Produto> lista = new ArrayList();
        
        Statement pstmt = ConexaoBanco.fazerConexao().createStatement();
        
        String sql = "SELECT * FROM Produto WHERE idCategoria =  " + cat.getIdcategoria();
        
        ResultSet res = pstmt.executeQuery(sql);
        
        while(res.next()){
            Produto produto = new Produto(res.getInt("idproduto"),res.getString("nome"), res.getInt("quantidade"), res.getDouble("preco"), cat);
            lista.add(produto);    
        }
        
        return lista;
    }

    
}
