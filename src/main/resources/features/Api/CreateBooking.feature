#language: pt

@Booking
Funcionalidade: Criar uma reserva

  @CriarReserva
  Cenario: Criação de Reserva

    Dado que possuo tenho um request body para o endpoint "/booking"
    Quando realizar uma requisição POST
    Entao receber o status code 200 e validar o jsonschema com os dados e tipos esperado da criação da reserva