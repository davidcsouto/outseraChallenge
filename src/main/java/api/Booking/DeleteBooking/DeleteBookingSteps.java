package api.Booking.DeleteBooking;

import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;

public class DeleteBookingSteps {

    public DeleteBookingLogic deleteBookingLogic;

    public DeleteBookingSteps() {
        deleteBookingLogic = new DeleteBookingLogic();
    }

    @Dado("que possuo tenho uma reserva e um request body para o endpoint {string} informando o id de uma reserva para deleção")
    public void que_possuo_tenho_uma_reserva_e_um_request_body_para_o_endpoint_informando_o_id_de_uma_reserva_para_deleção(String endpoint) {
        deleteBookingLogic.createRequestDeleteBooking(endpoint);
    }
    @Quando("realizar uma requisição DELETE")
    public void realizar_uma_requisição_delete() {
        deleteBookingLogic.sendDelete();
    }

    @Entao("receber o status code {int} e validar a mensagem {string}")
    public void receberOStatusCodeEValidarAMensagem(int statusCode, String message) {
        deleteBookingLogic.validateResponse(statusCode, message);
    }
}
