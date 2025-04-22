/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author User
 */
public class Categoria {
    private int idcategoria;
    private String descricao;

    public Categoria(int idcategoria,String descricao) {
        this.idcategoria = idcategoria;
        this.descricao = descricao;
    }
    
     public Categoria(String descricao) {
        this.descricao = descricao;
    }
   
    public int getIdcategoria() {
        return idcategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }   

    @Override
    public String toString() {
        return descricao;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }
    
}
