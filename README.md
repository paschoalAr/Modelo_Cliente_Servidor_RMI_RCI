
# Projeto de Cliente-Servidor em Java

Este projeto consiste em um sistema cliente-servidor escrito em Java, com três principais componentes: `admServidor`, `agenciaCliente`, e `caixaAutoCliente`. Cada um deles pode ser executado usando o `Makefile` para simplificar a compilação, execução e limpeza de arquivos temporários.

## Pré-requisitos

- **Java Development Kit (JDK)**: Certifique-se de que o JDK está instalado e configurado no seu sistema.
- **Make**: O comando `make` deve estar disponível para compilar e executar o projeto usando o Makefile.

## Estrutura do Makefile

Este projeto possui um `Makefile` com os seguintes alvos:

- **all**: Compila todos os arquivos `.java`.
- **run-server**: Compila e executa o servidor (`admServidor`).
- **run-agencia**: Compila e executa o cliente da agência (`agenciaCliente`) e limpa os arquivos compilados após a execução.
- **run-caixa**: Compila e executa o cliente do caixa automático (`caixaAutoCliente`), com um ID especificado pelo usuário, e limpa os arquivos compilados após a execução.
- **run-concorrencia**: Executa o teste de concorrência (`TesteConcorrencia`).
- **run-falhas**: Executa o teste de injeção de falhas (`injecaoFalhas`).
- **clean**: Remove todos os arquivos `.class` e limpa o terminal.

## Como Usar

### Compilação

Para compilar todos os arquivos Java, execute o comando:

```bash
make all
```

### Executar o Servidor

Para compilar e iniciar o servidor (`admServidor`), execute:

```bash
make run-server
```

### Executar o Cliente da Agência

Para compilar e iniciar o cliente da agência (`agenciaCliente`), execute:

```bash
make run-agencia
```

Esse comando compilará e executará o cliente da agência e, em seguida, removerá os arquivos `.class` gerados.

### Executar o Cliente do Caixa Automático com ID

Para compilar e iniciar o cliente do caixa automático (`caixaAutoCliente`) com um ID especificado, execute:

```bash
make run-caixa id=SEU_ID
```

Substitua `SEU_ID` pelo valor desejado. Por exemplo:

```bash
make run-caixa id=123
```

Esse comando compilará e executará o cliente do caixa automático com o ID especificado e, em seguida, removerá os arquivos `.class` gerados.

### Executar Teste de Concorrência

Para executar o teste de concorrência (`TesteConcorrencia`), utilize:

```bash
make run-concorrencia
```

### Executar Teste de Injeção de Falhas

Para executar o teste de injeção de falhas (`injecaoFalhas`), utilize:

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
- Antes de iniciar qualquer cliente, certifique-se de que o servidor (`admServidor`) está em execução.
