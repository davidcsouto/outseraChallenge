package api.Booking.UpdateBooking;

import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;

public class UpdateBookingSteps {

    UpdateBookingLogic updateBookingLogic;

    public UpdateBookingSteps() {
        updateBookingLogic = new UpdateBookingLogic();
    }

    @Dado("que possuo tenho uma reserva e um request body para o endpoint {string} informando o id de uma reserva para realizar uma atualização")
    public void quePossuoTenhoUmaReservaEUmRequestBodyParaOEndpointInformandoOIdDeUmaReservaParaRealizarUmaAtualização(String endpoint) {
        updateBookingLogic.createRequestUpdateBooking(endpoint);
    }

    @Quando("realizar uma requisição PUT")
    public void realizar_uma_requisição_put() {
        updateBookingLogic.sendPut();
    }
    @Entao("receber o status code {int} e validar que houve alteração")
    public void receber_o_status_code_e_validar_que_houve_alteração(Integer statusCode) {
        updateBookingLogic.validateResponse(statusCode);
    }


}
