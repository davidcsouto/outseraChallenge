package api.Booking.ReadBooking;

import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;

public class ReadBookingSteps {

    ReadBookingLogic readBookingLogic;

    public ReadBookingSteps() {
        readBookingLogic = new ReadBookingLogic();
    }

    @Dado("que possuo tenho um request body para o endpoint {string} informando o id de uma reserva")
    public void que_possuo_tenho_um_request_body_para_o_endpoint_informando_o_id_de_uma_reserva(String endpoint) {
        readBookingLogic.createRequestReadBooking(endpoint);
    }
    @Quando("realizar uma requisição GET")
    public void realizar_uma_requisição_get() {
        readBookingLogic.sendGet();
    }
    @Entao("receber o status code {int} e validar o jsonschema com os dados e tipos esperado")
    public void receber_o_status_code_e_validar_o_jsonschema_com_os_dados_e_tipos_esperado(Integer statusCode) {
        readBookingLogic.validateResponse(statusCode);
    }

}
