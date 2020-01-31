** REQUISITOS **
Banco de dados PostgreSQL 9.6 ou superior.
Java 8 ou superior.
IDE capaz de importar projetos Maven (usei o IntelliJ IDEA, Eclipse)

** RECOMENDAVEL **
Software que execute requisicoes (utilizado o Postman).

** PREPARANDO A API **
►Na busca do windows, digite "SQL Shell" e pressione enter
►Insira as informacoes solicitadas
►Uma vez logado como usuario "postgres", entre com o comando: "CREATE DATABASE backEndChallenge;" - E pressione ENTER
►Logo em seguida devera retornar a mensagem "CREATE DATABASE"
►Abra entao a IDE escolhida para importar o projeto e faca a devida importacao (Aguarde o download das dependencias)
►No Diretorio src.main.java.resources - tera um arquivo chamado "application.properties", abra-o
►Se por acaso o Postgres estiver utilizando outra porta que nao seja a padrao (5432), logo na primeira linha, se faz necessario a alteracao para a porta de uso
►Na 3 linha "spring.datasource.password=" logo apos, inserir a senha do usuario postgres
►Salve o projeto
►E o inicie
►Se tudo ocorreu corretamente, o banco de dados deve ter sido criado, e a ultima linha do console devera ser algo como "Started ChallengeApplication"

** USANDO A API **
Pode-se abrir o navegador e acessar "http://localhost:8080/swagger-ui.html", para ter acessos aos end points
Ou utilizar o software de requisicoes se nao quiser preencher todas as propriedes do JSON
No Postman:
→URL's
►Products:
GET = http://localhost:8080/api/products
GET = http://localhost:8080/api/product/id
~ ATENCAO ~
Para o POST e PUT e necessario na aba "Headers" a seguinte configuracao:
campo KEY = "Content-Type"
campo VALUE = "application/json"

Obs : Para "manufacturer" existem o ID 1 e 2;

POST = http://localhost:8080/api/product
~ Aba Body ~
{
  "name": "Grape juice",
  "description": "Natural grape juice",
  "barcode": "7002085002679",
  "manufacturer": {
    "id": 1
  },
  "unitPrice": 25.89
}

PUT = http://localhost:8080/api/product/id
~ Aba Body ~
{
  "name": "Grape juice",
  "description": "Natural grape juice",
  "barcode": "7002085002679",
  "manufacturer": {
    "id": 1
  },
  "unitPrice": 25.89
}

DELETE = http://localhost:8080/api/product/id

►Request
GET = http://localhost:8080/api/requests
GET = http://localhost:8080/api/request/id

POST = http://localhost:8080/api/product
~ Aba Body ~
{
	"items": [
		{
			"units": 3.0,
			"product": {
				"id": 1
			}
		},
		{
			"units": 4.0,
			"product": {
				"id": 2
			}
		}
	],
	"consumer": {
		"name": "Carlos",
		"phone": "5594656546",
		"email": "teste@gmail.com"
	},
	"payment": {
		"mode": "bank slip",
		"installments": 4
	},
	"delivery": {
		"mode": "in-store withdrawal"
	}
}

PUT = http://localhost:8080/api/request/id = CONFIRMACAO DO PEDIDO
DELETE = http://localhost:8080/api/request/id = CANCELAMENTO DO PEDIDO

** CONSIDERACOES **
De fato, a API nao ficou 100% implementada, por conta de ser um framework novo para mim, e por conta de tempo que já está se esgotando.