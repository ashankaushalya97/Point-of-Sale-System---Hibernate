package lk.ijse.dep.pos.dao.custom.impl;

import lk.ijse.dep.pos.dao.custom.OrderDAO;
import lk.ijse.dep.pos.entity.Orders;
import org.hibernate.Session;

import java.util.List;

public class OrderDAOImpl implements OrderDAO {

    private Session session;

    @Override
    public int getLastOrderId() throws Exception {
        return (int) session.createNativeQuery("Select id FROM Orders Order BY id DESC LIMIT 1").uniqueResult();
    }

    @Override
    public boolean existsByCustomerId(String customerId) throws Exception {
        return session.createNativeQuery("SELECT * FROM Orders WHERE customer_id=?1").setParameter(1,customerId).uniqueResult()!=null;
    }

    @Override
    public List<Orders> findAll() throws Exception {
        return session.createQuery("FROM Orders", Orders.class).list();
    }

    @Override
    public Orders find(Integer orderId) throws Exception {
        return session.find(Orders.class,orderId);
    }

    @Override
    public void  save(Orders orders) throws Exception {
         session.save(orders);
    }

    @Override
    public void update(Orders orders) throws Exception {
        session.merge(orders);
    }

    @Override
    public void delete(Integer orderId) throws Exception {
        session.delete(session.load(Orders.class,orderId));
    }

    @Override
    public void setSession(Session session) {
        this.session=session;
    }
}
