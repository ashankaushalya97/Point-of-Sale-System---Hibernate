package lk.ijse.dep.pos.dao.custom.impl;

import lk.ijse.dep.pos.dao.CrudUtil;
import lk.ijse.dep.pos.dao.custom.OrderDAO;
import lk.ijse.dep.pos.entity.Order;
import org.hibernate.Session;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    private Session session;

    @Override
    public int getLastOrderId() throws Exception {
        return (int) session.createNativeQuery("Select id FROM Orders Order BY DESC LIMIT 1").uniqueResult();
    }

    @Override
    public boolean existsByCustomerId(String customerId) throws Exception {
        return session.createNativeQuery("SELECT * FROM Orders WHERE customer_id=?1").setParameter(1,customerId).uniqueResult()!=null;
    }

    @Override
    public List<Order> findAll() throws Exception {
        return session.createQuery("FROM Orders",Order.class).list();
    }

    @Override
    public Order find(Integer orderId) throws Exception {
        return session.find(Order.class,orderId);
    }

    @Override
    public void  save(Order order) throws Exception {
         session.save(order);
    }

    @Override
    public void update(Order order) throws Exception {
        session.merge(order);
    }

    @Override
    public void delete(Integer orderId) throws Exception {
        session.delete(session.load(Order.class,orderId));
    }

    @Override
    public void setSession(Session session) {
        this.session=session;
    }
}
