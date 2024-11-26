package com.java.CarRentalSystem.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.java.CarRentalSystem.model.Payment;

public interface PaymentDao {

	boolean InsertPayment(String payid, String leid, Date paymentDate, double amount) throws ClassNotFoundException, SQLException;

	Payment ShowByLeaseID(String leid) throws ClassNotFoundException, SQLException;

	List<Payment> PendingPayments() throws ClassNotFoundException, SQLException;

}
