#language: pt

@AutomationPractice
Funcionalidade: Checkout no marketplace AutomationPractice

  @Checkout
  Cenario: Checkout com sucesso

    Dado que estou logado no marketplace do AutomationPractice
    E na barra de pesquisa preencho com "Printed Summer Dress" e clico no ícone de lupa para pesquisar
    E seleciono um produto clicando no botão More
    E na tela do produto, seleciono um opção de tamanho e cor que tenha estoque disponível e clico em Add to Cart
    E clicar no botão Proceed to Checkout
    E na tela de Summary clicar em Proceed to Checkout
    E selecionar ou cadastrar um endereço de entrega e avançar
    E confirmar a opção de envio e concordar com os termos e avançar
    E na tela de pagamento, selecionar selecionar a opção Pay by bank wire
    Quando clicar no botão I confirm my order
    Entao devo ver a tela de confirmação de pedido informando a mensagem "Your order on My Shop is complete."
