package br.com.petopia.controller;

import br.com.petopia.dao.ProdutoDAO;
import br.com.petopia.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class ProdutoController {
    private final ProdutoDAO produtoDAO;

    @Autowired
    public ProdutoController(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    @GetMapping
    public String listarProdutos(Model model) {
        List<Produto> produtos = produtoDAO.listarTodos();
        model.addAttribute("produtos", produtos);
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("produto", new Produto());
        return "login";
    }

    @GetMapping("/adocao")
    public String adocao(Model model){
        model.addAttribute("produto", new Produto());
        return "adocao";
    }

    @GetMapping("/ongs")
    public String ongs(Model model){
        model.addAttribute("produto", new Produto());
        return "ongs";
    }

    @GetMapping("/canis")
    public String canis(Model model){
        model.addAttribute("produto", new Produto());
        return "canisParceiros";
    }

    @GetMapping("/{id}")
    public String visualizarProduto(@PathVariable Long id, Model model) {
        Produto produto = produtoDAO.obterPorId(id);
        model.addAttribute("produto", produto);
        return "visualizarProduto";
    }

    @GetMapping("/novo")
    public String novoProduto(Model model) {
        model.addAttribute("produto", new Produto());
        return "formularioProduto";
    }

    @PostMapping("/salvar")
    public String salvarProduto(@ModelAttribute Produto produto) {
        produtoDAO.salvar(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/editar/{id}")
    public String editarProduto(@PathVariable Long id, Model model) {
        Produto produto = produtoDAO.obterPorId(id);
        model.addAttribute("produto", produto);
        return "formularioProduto";
    }

    @GetMapping("/excluir/{id}")
    public String excluirProduto(@PathVariable Long id) {
        produtoDAO.excluir(id);
        return "redirect:/produtos";
    }
}