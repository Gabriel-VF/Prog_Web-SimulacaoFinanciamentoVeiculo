package financiamento_veiculo.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.math.*;
@SuppressWarnings("unused")

@WebServlet("/dados")
public class SimulationServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double valorVeiculo = Double.parseDouble(req.getParameter("valorVeiculo"));
		double entrada = Double.parseDouble(req.getParameter("entrada"));
		double juros = Double.parseDouble(req.getParameter("juros")) / 100; // Porcentagem mensal
		int prazo =  Integer.parseInt(req.getParameter("prazo"));

		double valorFinanciado = valorVeiculo - entrada;
		// P = (PV × i) ÷ [1 – (1 + i)^-n]
		double p = (valorFinanciado * juros)/(1 - Math.pow(( 1 + juros ), prazo*-1));

		
		double valorTotalParcelas = p * prazo;
		double valorTotalJuros = valorTotalParcelas - valorFinanciado;
		double valorTotalPago = entrada + prazo * p;

		req.setAttribute("valorTotalPago", valorTotalPago);
		req.setAttribute("valorTotalParcelas", valorTotalParcelas);
		req.setAttribute("valorTotalJuros", valorTotalJuros);

		req.getRequestDispatcher("results.jsp").forward(req, resp);
	}
}


/*
 * 	<p>Valor total pago: ${valorTotalPago}</p>
	<p>Valor total de parcelas: ${valorTotalParcelas}</p>
	<p>Valor total de juros: ${valorTotalJuros}</p>
 */

/* 
 * (valorcarro *)
 */

 /*
  * P = (PV × i) ÷ [1 – (1 + i)^-n]
  */




/*
 * 
    P = Valor da parcela
    PV = Valor financiado
    I = Taxa de juros ao período
    N = Número total de parcelas

A fórmula é:

    P = PV x [ i / (1 - (1 + i)-n ) ]
 */




 /*
  * P = (PV * i) / [1 – (1 + i)^-n]

Onde:

    PV: Valor Presente (valor do empréstimo)
    i: Taxa de juros por período
    n: Número total de parcelas

  */