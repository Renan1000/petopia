 document.addEventListener('DOMContentLoaded', function () {
            const formCadastroOng = document.getElementById('formCadastroOng');
            const listaOngs = document.getElementById('listaOngs');

            formCadastroOng.addEventListener('submit', function (event) {
                event.preventDefault();

                // Obter os valores do formulário
                const nomeOng = document.getElementById('nomeOng').value;
                const textoOng = document.getElementById('textoOng').value;

                // Criar um item da lista para a nova ONG
                const li = document.createElement('li');
                li.className = 'list-group-item';
                li.textContent = `${nomeOng}: ${textoOng}`;

                // Adicionar a nova ONG à lista
                listaOngs.appendChild(li);

                // Salvar a nova ONG no localStorage
                const ongs = JSON.parse(localStorage.getItem('ongs')) || [];
                ongs.push({ nome: nomeOng, texto: textoOng });
                localStorage.setItem('ongs', JSON.stringify(ongs));

                // Fechar a modal
                const modal = new bootstrap.Modal(document.getElementById('cadastroOngModal'));
                modal.hide();
            });

            // Carregar a lista de ONGs do localStorage ao carregar a página
            function carregarListaOngs() {
                const ongs = JSON.parse(localStorage.getItem('ongs')) || [];

                ongs.forEach(function (ong) {
                    const li = document.createElement('li');
                    li.className = 'list-group-item';
                    li.textContent = `${ong.nome}: ${ong.texto}`;
                    listaOngs.appendChild(li);
                });
            }

            // Chamar a função para carregar a lista de ONGs ao carregar a página
            carregarListaOngs();
        });