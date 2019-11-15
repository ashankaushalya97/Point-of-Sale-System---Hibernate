package lk.ijse.dep.pos.dao.custom.impl;

import lk.ijse.dep.pos.dao.CrudUtil;
import lk.ijse.dep.pos.dao.custom.OrderDetailDAO;
import lk.ijse.dep.pos.entity.OrderDetail;
import lk.ijse.dep.pos.entity.OrderDetailPK;
import org.hibernate.Session;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAOImpl implements OrderDetailDAO {

    private Session session;

    @Override
    public List<OrderDetail> findAll() throws Exception {
        return session.createQuery("FROM OrderDetail",OrderDetail.class).list();
    }

    @Override
    public OrderDetail find(OrderDetailPK orderDetailPK) throws Exception {
        return session.get(OrderDetail.class,orderDetailPK);
    }

    @Override
    public void save(OrderDetail orderDetail) throws Exception {
        session.save(orderDetail);
    }

    @Override
    public void update(OrderDetail orderDetail) throws Exception {
        session.merge(orderDetail);
    }

    @Override
    public void delete(OrderDetailPK orderDetailPK) throws Exception {
        session.delete(session.load(OrderDetail.class,orderDetailPK));
    }

    @Override
    public boolean existsByItemCode(String itemCode) throws Exception {
        System.out.println(itemCode);
        return session.createNativeQuery("SELECT  * FROM OrderDetail Where item_code=?1").setParameter(1,itemCode).uniqueResult()!=null;
    }

    @Override
    public void setSession(Session session) {
        this.session=session;
    }
}
