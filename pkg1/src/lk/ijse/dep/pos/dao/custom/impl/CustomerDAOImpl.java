package lk.ijse.dep.pos.dao.custom.impl;

import lk.ijse.dep.pos.dao.CrudUtil;
import lk.ijse.dep.pos.dao.custom.CustomerDAO;
import lk.ijse.dep.pos.entity.Customer;
import org.hibernate.Session;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {

    private Session session;

    @Override
    public String getLastCustomerId() throws Exception {
        return (String) session.createNativeQuery("SELECT customer_id FROM Customer order by customer_id desc LIMIT 1 ").uniqueResult();
    }

    @Override
    public List<Customer> findAll() throws Exception {

        return session.createQuery("from Customer",Customer.class).list();
    }

    @Override
    public Customer find(String s) throws Exception {

        return session.get(Customer.class,s);
    }

    @Override
    public void save(Customer entity) throws Exception {
        session.save(entity);
    }

    @Override
    public void update(Customer customer) throws Exception {
        session.merge(customer);
    }

    @Override
    public void delete(String s) throws Exception {
        session.delete(session.load(Customer.class,s));
    }

    @Override
    public void setSession(Session session) {
        this.session=session;
    }
}
