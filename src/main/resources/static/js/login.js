function cadastrar() {
    // Obter os valores dos campos do formulário
    var nome = document.getElementById("cadastroNome").value;
    var login = document.getElementById("cadastroLogin").value;
    var senha = document.getElementById("cadastroSenha").value;

    // Verificar se todos os campos foram preenchidos
    if (nome && login && senha) {
        // Criar um objeto de usuário
        var novoUsuario = {
            nome: nome,
            login: login,
            senha: senha
        };

        // Obter a lista de usuários do localStorage ou inicializar uma lista vazia
        var listaUsuarios = JSON.parse(localStorage.getItem('listaUsuarios')) || [];

        // Adicionar o novo usuário à lista
        listaUsuarios.push(novoUsuario);

        // Salvar a lista atualizada de usuários no localStorage
        localStorage.setItem('listaUsuarios', JSON.stringify(listaUsuarios));

        // Limpar os campos do formulário
        document.getElementById("cadastroNome").value = "";
        document.getElementById("cadastroLogin").value = "";
        document.getElementById("cadastroSenha").value = "";

        // Fechar o modal
        $('#cadastroModal').modal('hide');

        // Exibir uma mensagem (pode ser substituída por um redirecionamento ou outra ação)
        alert("Usuário cadastrado com sucesso!");
    } else {
        // Exibir uma mensagem de erro se algum campo estiver em branco
        alert("Por favor, preencha todos os campos.");
    }
}
function fazerLogin() {
    // Obter os valores dos campos do formulário
    var loginInput = document.getElementById("login").value;
    var senhaInput = document.getElementById("senha").value;

    // Obter a lista de usuários do localStorage
    var listaUsuarios = JSON.parse(localStorage.getItem('listaUsuarios')) || [];

    // Verificar se há um usuário correspondente
    var usuarioCorrespondente = listaUsuarios.find(function(usuario) {
        return usuario.login === loginInput && usuario.senha === senhaInput;
    });

    if (usuarioCorrespondente) {
        // Redirecionar para a rota "/"
        window.location.href = "/";
    } else {
        // Exibir uma mensagem de erro
        alert("Dados de login não correspondem. Por favor, verifique seus dados.");
    }

    // Evitar o envio do formulário
    return false;
}

