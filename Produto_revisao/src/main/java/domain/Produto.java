/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.Objects;

/**
 *
 * @author User
 */
public class Produto {
    private int idProduto;
    private String nome;
    private int quantidade;
    private double preco;
    private Categoria categoria;

    public Produto(int idProduto, String nome, int quantidade, double preco, Categoria categoria) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Produto(String nome, int quantidade, double preco, Categoria categoria) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
        this.categoria = categoria;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        return Objects.equals(this.categoria, other.categoria);
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    } 

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    
    
}
