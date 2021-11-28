/*Code written by:

	Dipl. Eng. Ioan Simiciuc
	Software Developer

	ioan.simiciuc@continental-corporation.com

	Advanced driver-assistance systems (ADAS)
	Autonomous Mobility and Safety (AMS)

	S.C. Continental Automotive Romania S.R.L. Iasi
 */

package com.luv2code.springdemo.service;

import com.luv2code.springdemo.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService{

    List<Customer> getCustomers();

}
