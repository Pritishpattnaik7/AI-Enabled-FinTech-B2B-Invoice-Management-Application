//This file is the interface where I have created methods without the body
// The main implementation of these methods are in InvoiceDaoImpl.java file

package com.highradius.implementation;
import com.highradius.model.Invoice;
import java.util.List;

public interface InvoiceDao {
	//Method to get the list of invoices
	List<Invoice> getInvoice();
	
	//Method to update an invoice
    boolean updateInvoice(Invoice invoice);
    
    //Method to delete an invoice
    boolean deleteInvoice(int id);
    
    //Method to add an new invoice to the DB
	boolean insertInvoice(Invoice invoice);
	
	boolean insertInvoiceList(List<Invoice> invoices);

}
