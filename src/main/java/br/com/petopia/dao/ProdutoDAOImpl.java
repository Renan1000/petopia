package br.com.petopia.dao;


import br.com.petopia.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdutoDAOImpl implements ProdutoDAO {
    private static List<Produto> produtos = new ArrayList<>();
    private static Long idCounter = 1L;

    @Override
    public List<Produto> listarTodos() {
        return produtos;
    }

    @Override
    public Produto obterPorId(Long id) {
        return produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void salvar(Produto produto) {
        if (produto.getId() == null) {
            produto.setId(idCounter++);
            produtos.add(produto);
        } else {
            atualizar(produto);
        }
    }

    @Override
    public void atualizar(Produto produto) {
        int index = produtos.indexOf(obterPorId(produto.getId()));
        if (index != -1) {
            produtos.set(index, produto);
        }
    }

    @Override
    public void excluir(Long id) {
        produtos.removeIf(p -> p.getId().equals(id));
    }
}