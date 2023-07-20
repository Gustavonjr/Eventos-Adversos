# Incidentes e Eventos Adversos

## Descrição do Projeto

Este projeto é uma aplicação web desenvolvida com o objetivo de relatar e gerenciar eventos adversos e incidentes. Ele permite que os usuários reportem eventos, visualizem detalhes dos eventos e atualizem seu status. A aplicação também inclui recursos de autenticação e autorização usando o Spring Security, permitindo que os usuários façam login e gerenciem seus eventos.

## Tecnologias Utilizadas

O projeto é construído utilizando o framework Spring Boot, que simplifica o desenvolvimento de aplicações web em Java. Aqui estão as principais tecnologias e componentes utilizados no projeto:

1. **Spring Boot**: Um framework poderoso para construir aplicações Java prontas para produção com configuração mínima.

2. **Spring Data JPA**: Fornece integração fácil com o JPA (Java Persistence API) para acesso e manipulação de banco de dados.

3. **Thymeleaf**: Um popular mecanismo de templates baseado em Java para renderizar páginas HTML com conteúdo dinâmico.

4. **Banco de Dados MySQL**: A aplicação utiliza o MySQL como banco de dados relacional para armazenar dados de eventos e usuários.

5. **Spring Security**: Um módulo do Spring que oferece recursos de segurança, incluindo autenticação e autorização de usuários.

## Funcionamento da Aplicação

Os usuários podem acessar a aplicação e criar eventos informando detalhes como nome do colaborador, data e hora do evento, setor de ocorrência, classificação, descrição do evento e ação imediata tomada. Após criar o evento, ele será armazenado no banco de dados.

Os eventos criados podem ser visualizados na página de eventos, onde são listados em ordem decrescente de criação. Cada evento exibido na lista contém um link para detalhes, onde o usuário pode visualizar todas as informações do evento, incluindo seu status de resolvido.

Os usuários também podem atualizar o status de resolvido de um evento. Para isso, basta selecionar o status adequado (por exemplo, "Resolvido" ou "Não Resolvido") e salvar a atualização.

A aplicação também inclui recursos de segurança. Os usuários precisam fazer login para acessar certas páginas, e apenas usuários autenticados têm permissão para visualizar listagem de eventos ou atualizar seus status. O Spring Security gerencia a autenticação e autorização dos usuários com base nas informações armazenadas no banco de dados.

## Observação

Este é um resumo geral do projeto e suas principais características. Para obter mais detalhes sobre a implementação do código e funcionalidades específicas, é recomendado revisar o código-fonte completo.
