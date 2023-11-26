document.addEventListener('DOMContentLoaded', function () {
    const btn = document.getElementById('btn');

    btn.addEventListener('click', function (event) {
        event.preventDefault();

        // Obter os valores do formulário
        const nome = document.getElementById('nomeCompleto').value;
        const cpf = document.getElementById('cpf').value;
        const idade = document.getElementById('idade').value;
        const endereco = document.getElementById('endereco').value;
        const telefone = document.getElementById('telefone').value;

        // Criar um objeto com os dados
        const adocaoData = {
            nome,
            cpf,
            idade,
            endereco,
            telefone
        };

        // Obter os dados existentes no localStorage ou inicializar um array vazio
        const adocoes = JSON.parse(localStorage.getItem('adocoes')) || [];

        // Adicionar o novo dado à lista
        adocoes.push(adocaoData);

        // Salvar a lista atualizada no localStorage
        localStorage.setItem('adocoes', JSON.stringify(adocoes));

        // Limpar o formulário
        document.getElementById('nomeCompleto').value = '';
        document.getElementById('cpf').value = '';
        document.getElementById('idade').value = '';
        document.getElementById('endereco').value = '';
        document.getElementById('telefone').value = '';

        // Atualizar a lista exibida
        atualizarListaAdocoes();
    });

    // Função para exibir a lista de adoções abaixo do formulário
    function atualizarListaAdocoes() {
        const adocoes = JSON.parse(localStorage.getItem('adocoes')) || [];
        const listaAdocoes = document.getElementById('listaAdocoes');

        // Limpar a lista atual
        listaAdocoes.innerHTML = '';

        // Adicionar cada adoção à lista
        adocoes.forEach(function (adocao) {
            const li = document.createElement('li');
            li.textContent = `Nome: ${adocao.nome}, CPF: ${adocao.cpf}, Idade: ${adocao.idade}, Endereço: ${adocao.endereco}, Telefone: ${adocao.telefone}`;
            listaAdocoes.appendChild(li);
        });
    }

    // Chamar a função para exibir a lista ao carregar a página
    atualizarListaAdocoes();
});
