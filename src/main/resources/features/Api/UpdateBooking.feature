#language: pt

@Booking
Funcionalidade: Consultar uma reserva

  @AtualizarReserva
  Cenario: Atualização de Reserva

    Dado que possuo tenho uma reserva e um request body para o endpoint "/booking" informando o id de uma reserva para realizar uma atualização
    Quando realizar uma requisição PUT
    Entao receber o status code 200 e validar que houve alteração