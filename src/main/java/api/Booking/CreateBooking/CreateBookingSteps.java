package api.Booking.CreateBooking;

import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;

public class CreateBookingSteps {

    public CreateBookingLogic createBookingLogic;

    public CreateBookingSteps() {
        createBookingLogic = new CreateBookingLogic();
    }

    @Dado("que possuo tenho um request body para o endpoint {string}")
    public void quePossuoTenhoUmRequestBodyParaOEndpoint(String endpoint) {
        createBookingLogic.createRequestBodyCreateBooking(endpoint);
    }

    @Quando("realizar uma requisição POST")
    public void realizar_uma_requisição_post() {
        createBookingLogic.sendPost();
    }

    @Entao("receber o status code {int} e validar o jsonschema com os dados e tipos esperado da criação da reserva")
    public void receberOStatusCodeEValidarOJsonschemaComOsDadosETiposEsperadoDaCriaçãoDaReserva(int statusCode) {
        createBookingLogic.validateResponse(statusCode);
    }
}
