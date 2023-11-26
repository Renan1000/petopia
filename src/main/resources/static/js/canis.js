document.addEventListener('DOMContentLoaded', function () {
    const formCadastroCanil = document.getElementById('formCadastroCanil');
    const listaCanis = document.getElementById('listaCanis');

    formCadastroCanil.addEventListener('submit', function (event) {
        event.preventDefault();

        // Obter os valores do formulário
        const nomeCanil = document.getElementById('nomeCanil').value;
        const textoCanil = document.getElementById('textoCanil').value;

        // Criar um item da lista para o novo Canil
        const li = document.createElement('li');
        li.className = 'list-group-item';
        li.textContent = `${nomeCanil}: ${textoCanil}`;

        // Adicionar o novo Canil à lista
        listaCanis.appendChild(li);

        // Salvar o novo Canil no localStorage
        const canis = JSON.parse(localStorage.getItem('canis')) || [];
        canis.push({ nome: nomeCanil, texto: textoCanil });
        localStorage.setItem('canis', JSON.stringify(canis));

        // Limpar o formulário
        document.getElementById('nomeCanil').value = '';
        document.getElementById('textoCanil').value = '';
    });

    // Carregar a lista de Canis do localStorage ao carregar a página
    function carregarListaCanis() {
        const canis = JSON.parse(localStorage.getItem('canis')) || [];

        canis.forEach(function (canil) {
            const li = document.createElement('li');
            li.className = 'list-group-item';
            li.textContent = `${canil.nome}: ${canil.texto}`;
            listaCanis.appendChild(li);
        });
    }

    // Chamar a função para carregar a lista de Canis ao carregar a página
    carregarListaCanis();
});
