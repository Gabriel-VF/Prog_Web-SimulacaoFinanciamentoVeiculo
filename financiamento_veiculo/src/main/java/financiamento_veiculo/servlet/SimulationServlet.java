package financiamento_veiculo.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.math.*;

@WebServlet("/dados")
public class SimulationServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		double valorVeiculo = Double.parseDouble(req.getParameter("valorVeiculo"));
		double entrada = Double.parseDouble(req.getParameter("entrada"));
		double juros = Double.parseDouble(req.getParameter("juros")) / 100;
		int prazo =  Integer.parseInt(req.getParameter("prazo"));

		double valorFinanciado = valorVeiculo - entrada;
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
