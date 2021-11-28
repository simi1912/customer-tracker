/*Code written by:

	Dipl. Eng. Ioan Simiciuc
	Software Developer

	ioan.simiciuc@continental-corporation.com

	Advanced driver-assistance systems (ADAS)
	Autonomous Mobility and Safety (AMS)

	S.C. Continental Automotive Romania S.R.L. Iasi
 */

package com.luv2code.springdemo.service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        System.out.println("In Service!!!");
        this.customerDAO = customerDAO;
    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDAO.getCustomers();
    }
}
