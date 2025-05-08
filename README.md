# Desafio Outsera

# Tecnologias Usadas:

- Java 11
- Maven
- RestAssured
- Cucumber
- Selenium WebDriver
- TestNg
- Allure

## Arquitetura de pastas

    📦 Api - contém arquivos relacionados aos testes de API e pacote de métodos de suporte a esses testes.
    📦 Runner - pacote com runners para os testes de API e Web.
    📦 Support - contém o gerenciamento das variáveis de contexto, webdriver e classe Utils.
    📦 Web - está separada em pacote por sistema/site automatizado e dentro deste, separado por feature automatizada.
        📦 Dentro de cada pacote de feature, há a implementação do Page Object usando classes Page com elementos de página e Logic com a lógica de interação com esses elementos
    📦 Resources
        📦 Features - contém os arquivos .features dos cenários de teste
        📦 JsonSchemas - pasta com os jsonSchema para validação dos cenários de Api
    📦 Allure-results
        Pasta que é criada na execução dos testes, contém os arquivos para geração do Allure Report, a cada execução a pasta é excluída e uma nova é criada.


## Pré requisitos:

1. Instalado e configurado JDK 11: [Guia](https://medium.com/@joze-rocha/como-instalar-o-jdk-java-development-kit-no-windows-cf2b49d77634)
2. Instalado e configurado o Maven: [Guia](https://medium.com/@januario86/o-que-%C3%A9-o-maven-e-como-instalar-1d5e9f29ac4c)
3. Realizar instalação e configuração do Allure conforme link: [Guia](https://medium.com/@sonaldwivedi/allure-reporting-in-selenium-using-testng-and-maven-8a3a5ff07856)

## Como executar:

1. Realizar um clone do projeto
2. Abrir o terminal na pasta raiz do projeto e realizar a instalação das dependências rodando o comando ``mvn install  -DskipTests``
3. Caso o build ocorra com sucesso, executar em seguida o comando ``mvn test``

## Visualizando o report:

1. Ao final da execução, rodar o comando ``allure serve allure-results\`` no terminal na pasta do projeto
2. Caso a execução ocorra via Github Actions o report pode ser visualizado em [Report](https://davidcsouto.github.io/outseraChallenge)