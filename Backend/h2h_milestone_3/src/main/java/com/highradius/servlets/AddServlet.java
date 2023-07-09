//****ADD / INSERT DATA****

package com.highradius.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.highradius.model.*;
import com.google.gson.Gson;
import com.highradius.implementation.*;


@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Invoice invoice = null;
		InvoiceDao dao = new InvoiceDaoImpl();
		
        Gson gson = new Gson();
		
		
		
		//Read Request data from the Request object
				StringBuffer requestBody = new StringBuffer();
				BufferedReader reader = request.getReader();
				String line = null;
				
				while ((line = reader.readLine()) != null) {
					requestBody.append(line);
				}
				
				Invoice i = gson.fromJson(requestBody.toString(), Invoice.class);
				
				
				boolean insert = dao.insertInvoice(i);
				
				Map<String, String> responseJson = new HashMap<String, String>();
				responseJson.put("message", "Data not inserted");
				if (insert) {
					responseJson.put("message", "Data inserted successfully");
				}
				response.getWriter().append(gson.toJson(responseJson));
	}
}

