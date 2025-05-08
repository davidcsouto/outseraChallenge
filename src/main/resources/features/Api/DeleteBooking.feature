#language: pt

@Booking
Funcionalidade: Deletar uma reserva

  @DeletarReserva
  Cenario: Deleção de Reserva

    Dado que possuo tenho uma reserva e um request body para o endpoint "/booking" informando o id de uma reserva para deleção
    Quando realizar uma requisição DELETE
    Entao receber o status code 201 e validar a mensagem "Created"