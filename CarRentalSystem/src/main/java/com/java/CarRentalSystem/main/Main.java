package com.java.CarRentalSystem.main;

import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;
import com.java.CarRentalSystem.dao.CustomerDaoImpl;
import com.java.CarRentalSystem.model.Customer;
import com.java.CarRentalSystem.model.Lease;
import com.java.CarRentalSystem.model.Payment;
import com.java.CarRentalSystem.model.Vehicle;
import com.java.CarRentalSystem.dao.CustomerDao;
import com.java.CarRentalSystem.dao.VehicleDao;
import com.java.CarRentalSystem.dao.VehicleDaoImpl;
import com.java.CarRentalSystem.dao.LeaseDao;
import com.java.CarRentalSystem.dao.LeaseDaoImpl;
import com.java.CarRentalSystem.dao.PaymentDao;
import com.java.CarRentalSystem.dao.PaymentDaoImpl;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	static CustomerDao custDao = new CustomerDaoImpl();
	static VehicleDao vehDao=new VehicleDaoImpl();
	static LeaseDao leaseDao=new LeaseDaoImpl();
	static PaymentDao payDao=new PaymentDaoImpl();
	
	public static void Vehicleshow() throws ClassNotFoundException, SQLException {
		List<Vehicle> vehList = vehDao.showVehDao();
		for (Vehicle veh : vehList) {
			System.out.println(veh);
		}
		
	}
	private static void searchVehicle() throws ClassNotFoundException, SQLException {
		String VehicleID;
		System.out.println("Enter Vehicle Id  ");
		VehicleID = sc.next();
		Vehicle veh = vehDao.searchByVehId(VehicleID);
		if (veh!=null) {
			System.out.println(veh);
		} else {
			System.out.println("*** Customer Record Not Found ***");
		}
	}
	private static void addVehicle() throws ClassNotFoundException, SQLException {
		String vehid,make,model,engine,status;
		int rate,pass;
		System.out.println("Enter the Vehicle ID : ");
		vehid=sc.next();
		System.out.println("Enter the Make : ");
		make=sc.next();
		System.out.println("Enter the Model : ");
		model=sc.next();
		System.out.println("Enter Daily Rate : ");
		rate=sc.nextInt();
		System.out.println("Enter the Status : ");
		status=sc.next();
		System.out.println("Enter the Passenger Capacity : ");
		pass=sc.nextInt();
		System.out.println("Enter the Engine Capacity : ");
		engine=sc.next();
		boolean veh=vehDao.insertVehicle(vehid,make,model,rate,status,pass,engine);
		if(veh) {
			System.out.println("Values Inserted");
		}
		else {
			System.out.println("Can't insert the values");
		}
		
	}
	private static void deleteVehicle() throws ClassNotFoundException, SQLException {
		String vehid;
		System.out.println("Enter Vehicle ID : ");
		vehid=sc.next();
		boolean veh=vehDao.DelVehicle(vehid);
		if(veh) {
			System.out.println("The Value Deleted");
		}
		else {
			System.out.println("Can't delete");
		}
	}
	public static void Customershow() throws ClassNotFoundException, SQLException {
		List<Customer> custList = custDao.showcustDao();
		for (Customer cust : custList) {
			System.out.println(cust);
		}
	}
	public static void searchCustomer() throws ClassNotFoundException, SQLException {
		String CustomerID;
		System.out.println("Enter Customer Id  ");
		CustomerID = sc.next();
		Customer Cust = custDao.searchByCustId(CustomerID);
		if (Cust!=null) {
			System.out.println(Cust);
		} else {
			System.out.println("*** Customer Record Not Found ***");
		}
	}
	public static void ShowByCustName() throws ClassNotFoundException, SQLException {
		String CustomerName;
		System.out.println("Enter Customer Name  ");
		CustomerName = sc.next();
		Customer Cust = custDao.searchByCustName(CustomerName);
		if (Cust!=null) {
			System.out.println(Cust);
		} else {
			System.out.println("*** Customer Record Not Found ***");
		}
	}
	public static void addcust() throws ClassNotFoundException, SQLException {
		String customerID,first,last,email,userid,pass;
		long phone,aadhar;
		System.out.println("Enter the Customer ID : ");
		customerID=sc.next();
		System.out.println("Enter the Customer First Name : ");
		first=sc.next();
		System.out.println("Enter the Customer Last Name : ");
		last=sc.next();
		System.out.println("Enter the Customer Email ID : ");
		email=sc.next();
		System.out.println("Enter the Customer User ID : ");
		userid=sc.next();
		System.out.println("Enter the Customer Password : ");
		pass=sc.next();
		System.out.println("Enter the Customer Phone Number : ");
		phone=sc.nextLong();
		System.out.println("Enter the Customer Aadhar Number : ");
		aadhar=sc.nextLong();
		boolean cust=custDao.InsertCustomer(customerID,first,last,email,userid,pass,phone,aadhar);
		if(cust) {
			System.out.println("Record Updated");
		}
		else {
			System.out.println("Record Can't inserted");
		}
		
	}
	public static void SearchCapacity() throws ClassNotFoundException, SQLException {
		int capacity;
		System.out.println("Enter Passenger Capacity : ");
		capacity=sc.nextInt();
		Vehicle veh=vehDao.searchByCapacity(capacity);
		if(veh!=null) {
			System.out.println(veh);
		}
		else {
			System.out.println("*** Not Available ***");
		}
	}
	public static void addLease() throws ParseException, ClassNotFoundException, SQLException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String lid,cid,vid,type;
		System.out.println("Enter Lease Id : ");
		lid=sc.next();
		System.out.println("Enter Vehicle ID : ");
		vid=sc.next();
		System.out.println("Enter Customer ID : ");
		cid=sc.next();
		System.out.println("Enter Start Date : ");
		Date stdate=sdf.parse(sc.next());
		java.sql.Date sqlStartDate = new java.sql.Date(stdate.getTime());
		System.out.println("Enter End Date : ");
		Date stdate2=sdf.parse(sc.next());
		java.sql.Date sqlEndDate = new java.sql.Date(stdate2.getTime());
		System.out.println("Enter Type : ");
		type=sc.next();
		boolean le=leaseDao.InsertLease(lid,vid,cid,sqlStartDate,sqlEndDate,type);
		if(le) {
			System.out.println("Values Inserted");
		}
		else {
			System.out.println("Can't Insert");
		}
	}
		public static void searchByLEid() throws ClassNotFoundException, SQLException {
			System.out.println("Enter Lease ID : ");
			String lid=sc.next();
			Lease le=leaseDao.searchByLeId(lid);
			if(le!=null) {
				System.out.println(le);
			}
			else {
				System.out.println("*** Not Available *** ");
			}	
		}
		public static void showLeaseByVehicleId() throws ClassNotFoundException, SQLException {
			System.out.println("Enter the Vehicle ID : ");
			String Vid=sc.next();
			Lease le=leaseDao.showLeaseByVehicleID(Vid);
			if(le!=null) {
				System.out.println(le);
			}
			else {
				System.out.println("*** Not Availble *** ");
			}
		}
		public static void ShowLeaseByCusId() throws ClassNotFoundException, SQLException {
			System.out.println("Enter the Customer ID : ");
			String cid=sc.next();
			Lease le=leaseDao.showLEaseByCustomerId(cid);
			if(le!=null) {
				System.out.println(le);
			}
			else {
				System.out.println("*** Not Available ***");
			}
		}
		public static void Showlast6Month() throws ClassNotFoundException, SQLException {
			List<Lease> lelist=leaseDao.ShowLast6Month();
			for(Lease leh:lelist) {
				System.out.println(leh);
			}
		}
		public static void showLeaseFromStToEnd() throws ParseException, ClassNotFoundException, SQLException {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("Enter the Start Date : ");
			Date stdate=sdf.parse(sc.next());
			java.sql.Date sqlStartDate = new java.sql.Date(stdate.getTime());
			System.out.println("Enter the End Date : ");
			Date endDate=sdf.parse(sc.next());
			java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
			List<Lease> lelist=leaseDao.ShowFromStToEnd(sqlStartDate,sqlEndDate);
			for(Lease le:lelist) {
				System.out.println(le);
			}
		}
		public static void insertPayment() throws ParseException, ClassNotFoundException, SQLException {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
			String payid,leid;
			System.out.println("Enter the Payment Id : ");
			payid=sc.next();
			System.out.println("Enter Lease ID : ");
			leid=sc.next();
			System.out.println("Enter the Payment Date : ");
			Date paydate=sdf.parse(sc.next());
			java.sql.Date paymentDate=new java.sql.Date(paydate.getTime());
			System.out.println("Enter the Amount : ");
			double amount=sc.nextDouble();
			boolean pm=payDao.InsertPayment(payid,leid,paymentDate,amount);
			if(pm) {
				System.out.println("Value Inserted ");
			}
			else {
				System.out.println("Can't insert Value");
			}
		}
		public static void showByLeaseId() throws ClassNotFoundException, SQLException {
			System.out.println("Enter Lease ID :");
			String leid=sc.next();
			Payment pm=payDao.ShowByLeaseID(leid);
			if(pm!=null) {
				System.out.println(pm);
			}
			else {
				System.out.println("Result Not Found");
			}
		}
		public static void PendingPay() throws ClassNotFoundException, SQLException {
			List<Payment> pmlist=payDao.PendingPayments();
			if(pmlist!=null) {
				for(Payment pm:pmlist) {
					System.out.println(pm);
				}
			}
			else {
				System.out.println("No Matching Values");
			}
			
		}
		
	public static void main(String[] args) {
		int choice;
			System.out.println("1.Print All the values from Vehicle Table : ");
			System.out.println("2.Print Values by Vehicle ID : ");
			System.out.println("3.Search By Passenger Capacity : ");
			System.out.println("4.Add Vehicle ");
			System.out.println("5.Delete Vehicle : ");
			System.out.println("6.Show Customer ");
			System.out.println("7.Show By Customer ID");
			System.out.println("8.Show By Customer Name");
			System.out.println("9.Add Customer");
			System.out.println("10.Add lease : ");
			System.out.println("11.Search By Lease ID : ");
			System.out.println("12. Show LeaseDeails of Particular VehicleId : ");
			System.out.println("13.Show LeaseDetails of particular Customer : ");
			System.out.println("14. Show Lease Details of last 6 months : ");
			System.out.println("15. Show LeaseDetails of start date to end date : ");
			System.out.println("16. Add Payment : ");
			System.out.println("17.Show Payment by LeaseId : ");
			System.out.println("18. Show Pending Payments :");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				try {
					Vehicleshow();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					searchVehicle();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					SearchCapacity();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					addVehicle();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 5:
				try {
					deleteVehicle();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 6:
				try {
					Customershow();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 7:
				try {
					searchCustomer();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			case 8:
				try {
					ShowByCustName();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 9:
				try {
					addcust();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 10:
				try {
					addLease();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 11:
				try {
					searchByLEid();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 12:
				try {
					showLeaseByVehicleId();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();					
				}	
				break;
			case 13:
				try {
					ShowLeaseByCusId();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 14:
				try {
					Showlast6Month();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 15:
				
				try {
					showLeaseFromStToEnd();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 16:
				try {
					insertPayment();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 17:
				try {
					showByLeaseId();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 18:
				try {
					PendingPay();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	}
	
}