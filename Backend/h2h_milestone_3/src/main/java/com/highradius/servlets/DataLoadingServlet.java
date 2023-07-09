//****DISPLAY DATA****
//this used to display the query

package com.highradius.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.highradius.model.Invoice;
import com.google.gson.Gson;
import com.highradius.implementation.*;


@WebServlet("/DataLoadingServlet")
public class DataLoadingServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InvoiceDao dao = new InvoiceDaoImpl();
		List<Invoice> invoices = new ArrayList<Invoice>();
		invoices = dao.getInvoice();
		String errorString = "Sorry! No invoices found!";
		Gson gson = new Gson();
		String jsonResponse = gson.toJson(errorString);
		if (invoices.size() > 0) {
			jsonResponse = gson.toJson(invoices);
		}
		
		response.setHeader("Content-Type", "application/json");
		response.getWriter().append(jsonResponse);
	}

}
