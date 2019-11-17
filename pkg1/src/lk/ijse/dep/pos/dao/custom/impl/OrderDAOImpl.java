package lk.ijse.dep.pos.dao.custom.impl;

import lk.ijse.dep.pos.dao.CrudDAOImpl;
import lk.ijse.dep.pos.dao.custom.OrderDAO;
import lk.ijse.dep.pos.entity.Orders;
import org.hibernate.Session;

import java.util.List;

public class OrderDAOImpl extends CrudDAOImpl<Orders,Integer> implements OrderDAO {

    private Session session;

    @Override
    public int getLastOrderId() throws Exception {
        return (int) session.createNativeQuery("Select id FROM Orders Order BY id DESC LIMIT 1").uniqueResult();
    }

    @Override
    public boolean existsByCustomerId(String customerId) throws Exception {
        return session.createNativeQuery("SELECT * FROM Orders WHERE customer_id=?1").setParameter(1,customerId).uniqueResult()!=null;
    }

}
