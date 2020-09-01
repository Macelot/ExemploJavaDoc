# ExemploJavaDoc

Projeto de exemplo:
https://github.com/Macelot/ExemploJavaDoc

Basta abrir um comentário com barra e dois asteriscos, assim /** e clicar no enter.

ordem das tags

@author (classes and interfaces)
@version (classes and interfaces)
@param (methods and constructors)
@return (methods)
@throws (@exception is an older synonym)
@see
@since
@serial
@deprecated
@link
...

Tag	Significado
@author	Especifica o autor da classe ou do método em questão.
@deprecated	Identifica classes ou métodos obsoletos. É interessante informar nessa tag, quais métodos ou classes podem ser usadas como alternativa ao método obsoleto. Esta tag deve ser colocada no caso de um método ser realmente obsoleto.
@link	Possibilita a definição de um link para um outro documento local ou remoto através de um URL.
@param	Mostra um parâmetro que será passado a um método.
@return	Mostra qual o tipo de retorno de um método. Em caso de void, não colocar a tag
@see	Possibilita a definição referências de classes ou métodos, que podem ser consultadas para melhor compreender     ideia daquilo que está sendo comentada.
@since	Indica desde quando uma classe ou métodos foi adicionado na aplicação.
@throws	Indica os tipos de exceções que podem ser lançadas por um método. Se esta tag for utilizada deve ser informado na criação do método algo como:
public void setWords(String file) throws IOException{

@version	Informa a versão da classe.
Tabela 01 - Tags oferecidas pelo JavaDoc.


No IntelliJ
https://www.jetbrains.com/help/idea/working-with-code-documentation.html#generate-javadoc

Tools, Generate JavaDoc



Em “Output directory” 
Informar uma pasta onde deseja criar os arquivos da documentação
Em “Other command line arguments” 
preencher com: -encoding utf8 -docencoding utf8 -charset utf8


Referências
Lista completa de tags
https://www.tutorialspoint.com/java/java_documentation.htm

Exemplos diversos de tags
https://idratherbewriting.com/java-javadoc-tags/
