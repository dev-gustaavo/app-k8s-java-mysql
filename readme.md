# Aplicação em Java com MySQL8

A aplicação tem o simples objetivo de receber um payload e cadastrar uma pessoa no banco de dados. Foi construída apenas 
para aplicar conceitos de Kubernetes que estou estudando na pós-gradução em Arquitetura de Software na FIAP.

# Tecnologias necessárias para execução local
1. Docker
2. Docker Desktop

# Como executar localmente
1. Após baixar e instalar o Docker e o Docker Desktop, inicie o cluster Kubernetes que vem embarcado ao Docker Desktop. 
2. Através de algum CLI, acesse o diretório do projeto e execute os seguintes comandos:
```bash
cd kubernetes
kubectl apply -f configmap.yaml
kubectl apply -f mysql-secret.yaml
kubectl apply -f pod-mysql.yaml
kubectl apply -f svc-mysql.yaml
kubectl apply -f pod-k8s-pessoa-app.yaml
kubectl apply -f svc-k8s-pessoa-app.yaml
```
3. Após, utilizando o Postman ou Insomnia, faça uma chamada `POST` para `http://localhost:32000/pessoa`, com o seguinte body:
```json
{
  "nome": "nome_teste",
  "email": "email@teste.com.br",
  "cpf": "12345678910"
}
```

Com isso, a aplicação deve devolver status code 200 com o body vazio.
<br><br>
Como o Service do banco de dados é do tipo ClusterIP, você não conseguirá acessar por algum SGBD, você precisará acessar 
o pod via CLI. Para isso, execute os comandos abaixo:
```bash
kubectl exec -it mysql-db /bin/bash
```
Com isso, você estará dentro do pod e poderá executar o seguinte:
```bash
mysql -u user -p
```
A senha do usuário user será solicitada, neste caso ela foi definida dentro do arquivo mysql-secret.yaml, na variável `MYSQL_PASSWORD` 
e está em base64, no entanto, a senha é `pass`. Digite `pass` e pressione `ENTER`. Após, você poderá executar comandos do próprio 
MySQL para verificar os registros cadastrados.
<br><br>
1. Execute `show databases;` para listar todos os bancos de dados
2. Execute `use k8s-database` para acessar o banco de dados criado. O banco foi criado no momento em que o pod foi inicializado, definido na variável de ambiente `MYSQL_DATABASE`, no arquivo pod-mysql.yaml.
3. Execute `show tables;` para visualizar as tabelas do banco de dados;
4. Execute `select * from pessoas;` para visualizar o registro que você cadastrou :)