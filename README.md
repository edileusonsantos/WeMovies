# Desafio de Estruturação de Projeto Apps Nativo Android

O desafio consistiu na criação de um aplicativo mobile de e-commerce simplificado do zero, onde o candidato tinha que criar um fluxo com três módulos/telas.

São elas:

- **Home**: Onde terá que fazer uma requisição na API, trazendo assim, a lista de filmes quem podem ser adicionados ao carrinho.
- **Carrinho**: Onde poderá ver os itens que foram adicionados, somando o valor total com base em cada item adicionado, podendo remover um item do carrinho. Por padrão, se o carrinho tiver nenhum item adicionado, deverá aparecer a tela de **empty state** com a opção de voltar para tela inicial.
- **Compra realizada**: Após confirmar o pedido na tela anterior, o usuário deverá ser encaminhado para a tela de pedido confirmado. Aqui o usuário também terá a opção de voltar para tela inicial.

[Protótipo do Figma](https://www.figma.com/design/JO1VjFm5bqboChB2zf9maL/Teste-Front---Nativo-Android-iOS---WeFit-2024)

\*Obs: os assets podem ser exportados do próprio Figma.

**Sobre a API**

Para o desafio, simularemos uma API, onde o candidato terá que realizar um **GET** para [**https://wefit-movies.vercel.app/api/movies**](https://wefit-movies.vercel.app/api/movies) onde terá a lista de filmes.
