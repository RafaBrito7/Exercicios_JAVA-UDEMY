<h1> Conectando ao Banco de Dados: </h1>

<h2> Passo a Passo: </h2>

- Verificar se dentro de "Serviços"(No Windows) o MySQL tá em execução

- Logar no Workbench, para conectar o user

- Criar uma base de dados no WorkBench ou verificar se a base de dados já existe

- Verificar se você já possui o arquivo .JAR do JavaConnector

- Caso ainda não exista, criar uma User Library contendo o arquivo .jar do driver do MySQL (JavaConnector no Eclipse)
	- Window -> Preferences -> Java -> Build path -> User Libraries
	- Dê o nome da User Library de MySQLConnector
	- Add external JARs -> (localize o arquivo jar)

- Criar um novo Projeto no Java
	- Na tela de criação do projeto, ao invés de clicar em FINISH, clicar em Next
	- Ir na aba libraries
	- Add Library
	- User Library
	- Selecionar a library que criamos e FINISH

- Na pasta principal do Projeto (A que leva o nome do Projeto) criar um arquivo db.properties
	- Botão direito e NewFile
	- dá o nome e FINISH

- Escrever no db.properties o seguinte:
	- user=root(Depende do seu userName)
	- password=1234567(Depende da senha de acesso do UserName)
	- dburl=jdbc:mysql://localhost:3306/coursejdbc (Url do seu Server, último elemento é o nome da Base de Dados)
	- useSSL=false

- Criar uma Class de Exceção Personalizada (DbException - Extends RunTimeException)
	- https://github.com/RafaBrito7/Exercicios_Java-Udemy/tree/master/3_Avan%C3%A7ado/JDBC_Conectando%20ao%20Banco%20PASSO%20A%20PASSO/JDBC_Conectando%20ao%20Servidor%20MySQL/src/db

- Criar uma Class DB com métodos estáticos auxiliares (Connectar e Disconectar do Banco) {

	<h3>Método Auxiliar para carregar os dados do file db.properties</h3>
		- private static Properties loadProperties()
			- try (FileInputStream fs = new FileInputStream("db.properties")) 
				- Properties props = new Properties();
				- props.load(fs); // Faz a leitura do arquivo props apontado pelo arquivo fs
				- return props;
			- catch (IOException e)
				- throw new DbException(e.getMessage());

	<h3>Criar um objeto do tipo connection para receber os valores da Conexão</h3>
		- private static Connection con = null; // Importar do pacote java.sql.Connection;

	<h3>Método para Conectar com o Banco de Dados</h3>
		- public static Connection getConnection()
			- if (conn == null) 
				- try {
					- Properties props = loadProperties(); // Vai servir para carregar as propriedades do banco de dados do arquivo db.properties
					- String url = props.getProperty("dburl"); // pegando a url do banco do arquivo db.properties
					- conn = DriverManager.getConnection(url,props); // Vai connectar com o banco de dados
					} catch(SQLException)
			- return conn;

	<h3>Método para Desconectar com o Banco de Dados</h3>
			- if (conn != null)
				try {
					- conn.close();
					} catch (SQLException)
		
	<h3>Implementação no método main</h3>
		- Connection conn = DB.getConnection();
		- DB.closeConnection();