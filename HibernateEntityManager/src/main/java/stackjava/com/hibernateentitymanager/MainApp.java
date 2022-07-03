package stackjava.com.hibernateentitymanager;

import java.util.List;

import stackjava.com.hibernateentitymanager.dao.CustomerDAO;
import stackjava.com.hibernateentitymanager.entities.Customer;

public class MainApp {
	public static void main(String[] args) {
		CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.save(new Customer("Kai", "Viet Nam"));
		customerDAO.save(new Customer("Thanos", "Viet Nam"));
		customerDAO.save(new Customer("Thor", "Asgard"));
		customerDAO.save(new Customer("Hulk", "USA"));
		customerDAO.save(new Customer("Iron Man", "USA"));
		
		System.out.println("all customer after insert:");
		List<Customer> listCustomer = customerDAO.findAll();
		listCustomer.forEach(c -> {
			System.out.println(c.getName());
		});

		customerDAO.close();
	}
}
