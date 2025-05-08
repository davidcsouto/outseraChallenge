#language: pt

@Booking
Funcionalidade: Consultar uma reserva

  @ConsultarReserva
  Cenario: Consulta de Reserva

    Dado que possuo tenho um request body para o endpoint "/booking" informando o id de uma reserva
    Quando realizar uma requisição GET
    Entao receber o status code 200 e validar o jsonschema com os dados e tipos esperado