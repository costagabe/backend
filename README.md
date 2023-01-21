
# Avaliação full stack

### Descrição do projeto
Projeto feito para um processo seletivo cujo intuito é avaliar a aptidão técina.
O front-end foi feito em Vue3 e o backend em Java + Spring Boot com a parte do Vue desenvolvida no VSCode e do Java no IntelliJ IDEA. Além disso, no front foi-se usado o Pinia como gestor de estado do sistema.
Para resolver o *desafio proposto* foi usado o padrão Strategy com o Factory para lidar com o problema.
No Java, para gerar os dados dos gráficos, foi-se usado JPA Criteria Query para aproveitar reuso de código.

### Como usar o sistema
* Para agendar uma nova transferência, há um botão **Agendar** no canto superior direito da tela;
* No topo da tela têm gráficos pizza que demonstram os valores agendados e a taxa baseada na data (HOJE, ESTA SEMANA, ESTE MÊS);
* Todos os agendamentos são listados logo abaixo dos gráficos pizza;
* Você pode apagar os agendamentos direto na tabela;
* O formulário de cadastro de transação possui diversas validações:
  * Os campos das contas são obrigatórios e devem seguir uma máscara (XXXXXX)
  * O campo do valor não pode ser <= 0
  * A data não pode ser anterior a hoje
  * Validações baseadas nos casos de uso das taxas aplicadas
* As validações também são aplicadas no backend


## Para rodar o projeto (Front)

### Intale as dependências

```

# yarn

yarn

  

# npm

npm install

  

# pnpm

pnpm install

```



### Compilação e rodar em dev mode



```

# yarn

yarn dev

  

# npm

npm run dev

  

# pnpm

pnpm dev

```



### Caso queira compilar para produção



```

# yarn

yarn build

  

# npm

npm run build

  

# pnpm

pnpm build

```

## Para rodar o projeto (Back)
Basta clonar o repositório e abrir na IDE de preferência, feito isso, esperar as dependências serem carregadas e iniciar a aplicação.