# ES2-2019-IC2-32

Rúben Almeida - 54767;
João Ferro - 82108;
Guilherme Almeida - 78600;
António Godinho - 77676;
Márcio Jesus - 82412.


--Complemento 1 (Márcio Jesus)--
Funcionalidades não implementadas: Nada a acrescentar 
Funcionalidades parcialmente implementadas: File Management e Web Site Analytics
Funcionalidades que se encontram com erros: Nada a acrescentar

--Complemento 2 (Guilherme Almeida)--
Funcionalidades não implementadas:
Funcionalidades parcialmente implementadas:
Funcionalidades que se encontram com erros: Monitorização da ferramenta do wordpress nao funcional para o website responsavel pelo Record metrics of availability/uptime and downtime, como nao faz o login envia o email necessário ao admin como requerido, no entanto esta parte foi descomentada pois nao estava totalmente funcional
Instruções:
- A parte do codigo que permite recorrentemente correr o programa de 2 em 2horas está descomentada pois foram efetuados os testes em tempo real para poder efetivamente testar o programa, no entanto ao descomentar já irá funcionar
- A parte do login do wordpress poderá ter o user "guilhermee" tendo um "e" a mais no final foi usado para efetuar o teste,
e ao estar incorreto envia email correspondente a erro no login ao admin
- A aplicaçao corre e efetua logo a monitorizaçao entrando no site wordpress em localhost, em seguida preenche as credencias, de seguida entra o website wordpress, depois irá verificar o repository, forms no entanto como as paginas nao estao implementadas nesta parte verifica que nao estao disponiveis e envia email ao admin 
- Logins disponiveis em codigo
Gmail para receber os email de alerta da ferramenta de monitorizaçao - user "reportr22@gmail.com", pass "reportmonitoring2020"
Uptime Robot (plugin externo disponivel via URL no wordpress) - https://uptimerobot.com/login user:gacaa@iscte-iul.pt pass:robot2020
Wordpress - user:guilherme pass:ZLniRzUTYesiElkhH2

--Complemneto 3 (Rúben Almeida)--
Funcionalidades não implementadas: Nada a acrescentar 
Funcionalidades parcialmente implementadas: Nada a acrescentar
Funcionalidades que se encontram com erros: Execução da aplicação no site WP-CMS com erro: 403 Forbidden
Instruções:
	 Correr a aplicação CovidSciDiscoveries.java aguardar uns segundos até o programa acabar de correr os ficheiros do diretório
	 Utilizado o Cermine para extração dos metadados dos PDFs:
	 https://github.com/CeON/CERMINE
	 Usado como depêndencia no POM.xml
	  
	 Código exemplo de metodo de extração
	 ContentExtractor extractor = new ContentExtractor();
	 InputStream inputStream = new FileInputStream("path/to/pdf/file");
         extractor.setPDF(inputStream);
	 Element result = extractor.getContentAsNLM();
	
   	 É necessário mudar o diretorio que contem os pdfs que queremos ler (linha 196 do CovidSciDiscoveries.java)
	 É criado um tabela com linhas iguais ao numero de documentos e com 4 colunas:
	 Title , Journal, Year, Authors
	 O title vai conter uma hiperligação para o diretório onde estão os PDFs e ao clicar vai abrir numa nova janela o pdf correspondente
	 
	 Há a opção de gerar o ficheiro .html ou fazer um print do código HTML com a tabela pretendida basta escolher a opção quer queremos comentando e descomentando: Ficheiro (linhas 219 a 220), print (linha 221)

--Complemento 4 (João Ferro)--
Funcionalidades não implementadas: Nada a acrescentar
Funcionalidades parcialmente implementadas: Nada a acrescentar
Funcionalidades que se encontram com erros: Execução da aplicação no site WP-CMS com erro: 403 Forbidden

--Complemento 5 (António Godinho)--
Funcionalidades não implementadas: 
Funcionalidades parcialmente implementadas: Algumas querys não foram devidamente implementadas, devido a um erro no servidor do WP-CMS
Funcionalidades que se encontram com erros: Devido a um erro no servidor não foi possível a execução da aplicação no site WP-CMS
