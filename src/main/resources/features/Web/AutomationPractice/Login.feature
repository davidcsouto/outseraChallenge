#language: pt

  @AutomationPractice
  Funcionalidade: Login no marketplace AutomationPractice

    @Login
    Cenario: Login com sucesso

      Dado que acesso a página principal do AutomationPractice
      E clicar em Sign in
      Quando na formulário de login preencher os campos de email address e password e clicar no botão Sign in
      Entao devo ser direcionado para a página My Account

