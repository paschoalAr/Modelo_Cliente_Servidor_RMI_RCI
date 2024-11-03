# Projeto Cliente em Java

Este projeto consiste em uma aplicação cliente em Java que oferece diversas funcionalidades, incluindo execução de uma agência cliente, um caixa automático, um teste de concorrência e um teste de injeção de falhas. Cada funcionalidade pode ser executada usando o `Makefile`, que simplifica a compilação, execução e limpeza de arquivos temporários.

## Pré-requisitos

- **Java Development Kit (JDK)**: Certifique-se de que o JDK está instalado e configurado no seu sistema.
- **Make**: O comando `make` deve estar disponível para compilar e executar o projeto usando o Makefile.

## Estrutura do Makefile

Este projeto possui um `Makefile` com os seguintes alvos:

- **all**: Compila todos os arquivos `.java`.
- **run-agencia**: Executa o programa `agenciaCliente` e limpa os arquivos compilados após a execução.
- **run-caixa**: Executa o programa `caixaAutoCliente` com um ID especificado pelo usuário e limpa os arquivos compilados após a execução.
- **run-concorrencia**: Executa o programa `TesteConcorrencia`.
- **run-falhas**: Executa o programa `injecaoFalhas`.
- **clean**: Remove todos os arquivos `.class` e limpa o terminal.

## Como Usar

### Compilação

Para compilar todos os arquivos Java, execute o comando:

```bash
make all
```

### Executar o Cliente da Agência

Para iniciar o cliente da agência (`agenciaCliente`), execute:

```bash
make run-agencia
```

Esse comando compilará e executará o cliente da agência e, em seguida, removerá os arquivos `.class` gerados.

### Executar o Cliente do Caixa Automático com ID

Para iniciar o cliente do caixa automático (`caixaAutoCliente`) com um ID especificado, execute:

```bash
make run-caixa id=SEU_ID
```

Substitua `SEU_ID` pelo valor desejado. Por exemplo:

```bash
make run-caixa id=123
```

Esse comando executará o cliente do caixa automático com o ID especificado e, em seguida, removerá os arquivos `.class` gerados.

### Executar o Teste de Concorrência

Para iniciar o programa de teste de concorrência (`TesteConcorrencia`), execute:

```bash
make run-concorrencia
```

### Executar o Teste de Injeção de Falhas

Para iniciar o programa de injeção de falhas (`injecaoFalhas`), execute:

```bash
make run-falhas
```

### Limpar Arquivos Compilados

Para remover todos os arquivos `.class` e limpar o terminal, execute:

```bash
make clean
```

## Observações

- O comando `make clean` é executado automaticamente após a execução dos alvos `run-agencia` e `run-caixa`, então não é necessário executá-lo manualmente após esses comandos.
- Certifique-se de definir um valor para `id` ao executar `run-caixa`, caso contrário, o comando poderá falhar.
