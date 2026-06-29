# CRUD Alunos — JDBC + MySQL

Primeiro CRUD desenvolvido em Java puro com JDBC, conectado a um banco MySQL. Projeto de estudo para aprender como o Java se comunica com bancos de dados relacionais sem o uso de frameworks.

---

## Sobre o projeto

O sistema permite cadastrar, listar, buscar, atualizar e deletar alunos via terminal. Toda a comunicação com o banco é feita manualmente usando JDBC, com `PreparedStatement` e `try-with-resources`.

---

## Funcionalidades

- Inserir novo aluno
- Listar todos os alunos
- Buscar aluno por ID
- Atualizar dados de um aluno
- Deletar aluno por ID

---

## Tecnologias

- Java 17
- JDBC (java.sql)
- MySQL 8
- Maven

---

## Estrutura do projeto

    CRUD_alunos/
    └── src/
        └── main/
            └── java/
                └── CRUD_alunos/
                    ├── db/
                    │   └── ConexaoDB.java    ← abre a conexão com o banco
                    ├── model/
                    │   └── Aluno.java        ← representa um aluno
                    ├── dao/
                    │   └── AlunoDAO.java     ← operações CRUD no banco
                    └── Main.java             ← menu e interação com o usuário

---

## Pré-requisitos

- JDK 17 ou superior
- Maven instalado
- Banco MySQL acessível (local ou em nuvem)

---

## Configuração

**1. Clone o repositório**

```bash
git clone https://github.com/KaueKreuzDeMiranda/CRUD_alunos_basico.git
```

**2. Crie a tabela no banco**

```sql
CREATE TABLE alunos (
    id    INT AUTO_INCREMENT PRIMARY KEY,
    nome  VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    curso VARCHAR(80),
    nota  DECIMAL(4, 2)
);
```

**3. Configure a conexão**

Edite o arquivo `ConexaoDB.java` com as credenciais do seu banco.

**4. Execute o projeto**

---

## Como usar

Ao rodar o projeto, um menu é exibido no terminal.

Digite o número da opção desejada e siga as instruções.

---

## Aprendizados

- Como usar `DriverManager` e `Connection` para abrir conexões JDBC
- Diferença entre `Statement` e `PreparedStatement` (e por que usar `PreparedStatement`)
- Como iterar sobre um `ResultSet` para mapear dados do banco em objetos Java
- Uso de `try-with-resources` para fechar recursos automaticamente
- Separação de responsabilidades em camadas: `model`, `dao` e `db`

---

## Autor

**Kauê Kreuz de Miranda**  
[github.com/KaueKreuzDeMiranda](https://github.com/KaueKreuzDeMiranda)
