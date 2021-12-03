/*Code written by:

	Dipl. Eng. Ioan Simiciuc
	Software Developer

	ioan.simiciuc@continental-corporation.com

	Advanced driver-assistance systems (ADAS)
	Autonomous Mobility and Safety (AMS)

	S.C. Continental Automotive Romania S.R.L. Iasi
 */

package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    private final SessionFactory sessionFactory;

    @Autowired
    public CustomerDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Customer> getCustomers() {
        Session session = sessionFactory.getCurrentSession();
        Query<Customer> query = session.createQuery(
                        "from Customer " +
                        "order by lastName",
                Customer.class);
        List<Customer> customers = query.getResultList();

        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, Long.valueOf(id));

        return customer;
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(
                "delete from Customer " +
                "where id = :id");
        query.setParameter("id", Long.valueOf(id));
        query.executeUpdate();
    }

}
