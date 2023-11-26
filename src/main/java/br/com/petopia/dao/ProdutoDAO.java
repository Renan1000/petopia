package br.com.petopia.dao;

import br.com.petopia.model.Produto;

import java.util.List;

public interface ProdutoDAO {
    List<Produto> listarTodos();
    Produto obterPorId(Long id);
    void salvar(Produto produto);
    void atualizar(Produto produto);
    void excluir(Long id);
}
