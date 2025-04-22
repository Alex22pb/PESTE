
package dao;

import domain.Categoria;
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
public class CategoriaDAO {
          
    public void inserir(Categoria cat) throws ClassNotFoundException, SQLException{
        // Insere todos os dados da categoria no banco de dados       
	// Observe que o parâmetro é um objeto do tipo Categoria, 
        // portanto você deverá ler de um Frame os dados, criar um objeto 
        // do tipo Categoria e passar como parâmetro para essa função
        //
        // O ID da categoria é auto numeração
	//
	// INSERT INTO nome_tabela (CAMPOS separados por virgula)  VALUES 
        //    ( VALORES separados por vírgula )
        
        String sql = "INSERT INTO Categoria (descricao) values (?)";
        
        PreparedStatement pstmt = ConexaoBanco.fazerConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS );
        
        int col = 1;
        pstmt.setString(col++, cat.getDescricao());
        
        pstmt.execute();
        
        ResultSet res = pstmt.getGeneratedKeys();
        if(res.next()){
            int id = res.getInt(1);
            cat.setIdcategoria(id);
        }
        
    }

    
    public List<Categoria> listar() throws ClassNotFoundException, SQLException{

	// Pesquisa no banco e retorna, através de um List,
        // todas as categorias
        // 	
        // No seu Frame, chame essa função e preencha o combobox com o
        //	resultado do List
        // SELECT * FROM nome_tabela 
        
        Statement stmt;
        
        stmt = ConexaoBanco.fazerConexao().createStatement();
        List<Categoria> lista = new ArrayList();
        Categoria cat;
                
        String sql = "SELECT * FROM categoria";
        
        ResultSet res = stmt.executeQuery(sql);
        
        while (res.next()){
            cat = new Categoria (res.getInt("idcategoria"), res.getString("descricao"));
            lista.add(cat);
        }
        
        return lista;
    }
}
