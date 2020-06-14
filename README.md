# ES2-2019-IC2-32

Rúben Almeida - 54767;
João Ferro - 82108;
Guilherme Almeida - 78600;
António Godinho - 77676;
Márcio Jesus - 82412.


--Complemento 1 (Márcio Jesus)--
Funcionalidades não implementadas:
Funcionalidades parcialmente implementadas:
Funcionalidades que se encontram com erros:

--Complemento 2 (Guilherme Almeida)--
Funcionalidades não implementadas:
Funcionalidades parcialmente implementadas:
Funcionalidades que se encontram com erros:

--Complemneto 3 (Rúben Almeida)--
Funcionalidades não implementadas: Nada a acrescentar 
Funcionalidades parcialmente implementadas: Nada a acrescentar
Funcionalidades que se encontram com erros: Execução da aplicação no site WP-CMS com erro: 403 Forbidden
Instruções:
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
	 O title vai conter uma hiperligação para o diretório onde estão os PDfs e ao clicar vai abrir numa nova janela o pdf correspondente
	 
	 Há a opção de gerar o ficheiro .html ou fazer um print do código HTML com a tabela pretendida

--Complemento 4 (João Ferro)--
Funcionalidades não implementadas: Nada a acrescentar
Funcionalidades parcialmente implementadas: Nada a acrescentar
Funcionalidades que se encontram com erros: Execução da aplicação no site WP-CMS com erro: 403 Forbidden

--Complemento 5 (António Godinho)--
Funcionalidades não implementadas:
Funcionalidades parcialmente implementadas:
Funcionalidades que se encontram com erros:
