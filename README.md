## Projeto Nati

Consiste em um sistema responsável por lidar com a vizualização de Matrizes Curriculares, assim como gerenciar usuários(Aluno, Professor, Coordenador e Admin), cursos, semestres e disciplinas. 

## Decisões de Projeto

- Definição de qual banco utilizar. O PostgreSQL foi escolhido pela praticidade e familiaridade mas também possui outras vantagens como alto desempenho, evita vazamentos de memória e uma alta segurança dos dados.
- Com a instância do PostgreSQL rodando, em um container na porta 5432. Não é necessário criar schemas no banco, pois o controle de versão do flyway irá criar as tabelas e constraints de acordo com as migrations.
- O projeto é criado utilizando o Spring Initializr. Nele podemos definir se utilizaremos Maven ou Gradle, além de definir fatores como nome do projeto, versão do JDK e outros. Foi escolhido o Maven para gerenciar o projeto e suas dependências.
- Ainda com o Spring Initializr, algumas bibliotecas foram escolhidas e adicionadas ao arquivo pom.xml. 
- Nesse ponto, é criado os models das diversas entidades que farão parte do sistema.
- Foi criado models das entidades e para cada model existe um Repository, Service e Resource.
- Cada Repository extende a classe JpaRepository que torna o acesso a banco muito mais simples pois torna a interface disponivel via injeção de dependência e com métodos pré prontos.
- Foi optado por uma camada extra que é a Service. A Service tem o intuito de aumentar a manutenabilidade do código e separar as responsabilidades. Sem a camada de Service, os resources possuiriam lógicas que não seriam deles.
- Essa aplicação é RESTFUL e utiliza dos verbos HTTP para o correto manuseio das informações. A camada de Resource utiliza de mapeamentos do Spring para cada situação. Por exemplo, para obter a lista de professores é utilizado o verbo GET e a anotação é a @GetMapping.
- Foi criada a classe ApiErrorConfig para lidar com erros e deixar as respostas que chegam ao front mais claras e sucintas.

- Atual estado da aplicação:
    - A aplicação não está completa ainda. Os endpoints estão funcionais mas as visões de cada usuário e dos cursos ainda está por ser feita. Ainda não está ideal e ela poderá ser melhorada com a utilização do Spring Security.
    - Pode ser feito no momento requests que envolvam o CRUD de basicamente todas as entidades(Admin, Aluno, Coordenador, Curso, Cadeira, Professor e Semestre).
 

## Tecnologias/frameworks utilizados
Foram utilizadas tecnologias atuais de maneira que seja tirado proveito dos avanços alcançados pelo stack do Spring, principalmente do Spring Boot.

<b>Desenvolvido com</b>
- [JDK 1.8](https://docs.oracle.com/javase/8/docs/api/)
- [Spring Boot 2.1.3](http://spring.io/projects/spring-boot)
- [Spring MVC 2.1.3](http://spring.io/projects/spring-boot)
- [Spring JPA 2.1.9](http://spring.io/projects/spring-data-jpa)
- [Lombok 1.18.10](https://projectlombok.org)
- [Flyway 5.2.4](https://flywaydb.org)
- [PostgresSQL 12.0](https://www.postgresql.org/docs/12/release-12.html)
- [Docker 18.09.3](https://www.docker.com)
- [Docker Compose 1.17.1](https://www.docker.com)
- [Apache Maven 3.5.2](https://dev.mysql.com/doc/relnotes/mysql/8.0/en/news-8-0-12.html)

## Instalação
1. Instalar Docker e Docker Compose.
2. Fazer o fork do projeto e em seguida baixá-lo <code>git clone https://github.com/tarciso-torres/projeto-nati.git</code>
3. Navegar até a raiz do projeto e execute via linha de comando, o seguinte: <code>docker-compose up</code>. Isso fará com que o docker-compose faça o build da aplicação em uma image, depois vai criar um container para o postgreSQL e só depois que o banco estiver operacionavel ele subirá o container da aplicação.

## Postman
No momento todos os endpoints estão acessíveis via request, não há separação por nivel de acesso. Estou disponibilizando um arquivo para ser importado no postman , o mesmo se encontra diretório <code>/projeto-nati/src/main/resources/assets/postmanNati.postman_collection.json</code>, com todas as requisições do projeto, bastando apenas importar o mesmo para o Postman.

## Exemplo do código

### Resource:
      
@RestController
@RequestMapping(value = "/professores")
public class ProfessorResource {

	@Autowired
	private ProfessorService professorService;
	
	@GetMapping
	public ResponseEntity<List<Professor>> findAll(){
		List<Professor> professors = professorService.findAll();
		return ResponseEntity.ok().body(professors);
	}
   }

No exemplo acima, é criado um resource com um método de listar todos os professores que graças a anotação <code>@GetMapping</code>, o método estará disponível via GET a /professores.

### Repository:

    @Repository
	public interface ProfessorRepository extends JpaRepository<Professor, UUID>{
	
		Professor findByDadosPessoaisMatricula(String name);
		
		Professor findByDadosPessoaisCpf(String cpf);
		
		Professor findByUsuarioEmail(String email);
	}
É criada uma interface e fazemos ela estender a classe JpaRepository. Esse classe já traz diversos métodos prontos para serem utilizados e dessa maneira, basta nos instanciarmos um ProfessorRepository e anota-lo com <code>@Autowired</code>. Com isso o Spring tratará de injetar a instância de ProfessorRepository, podendo assim, utilizar diversos métodos ou criar personalizados como no exemplo acima.


MIT © [Tarciso Torres](https://github.com/tarciso-torres)
