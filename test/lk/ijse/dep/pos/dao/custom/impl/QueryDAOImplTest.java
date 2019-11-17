package lk.ijse.dep.pos.dao.custom.impl;

import lk.ijse.dep.pos.dao.custom.QueryDAO;
import lk.ijse.dep.pos.entity.CustomEntity;
import lk.ijse.dep.pos.hibernate.HibernateUtil;
import org.hibernate.Session;

import java.sql.Date;
import java.util.List;

class QueryDAOImplTest {

    public static void main(String[] args) throws Exception {
        new QueryDAOImplTest().getOrdersInfo();
    }

    void getOrderInfo2() throws Exception {
        CustomEntity e = new QueryDAOImpl().getOrderInfo2(2);
        assert e.getCustomerName().equals("Wimal1") &&
                e.getOrderDate().equals(Date.valueOf("2019-05-28")): "Invalid getOrderInfo2";
    }

    void getOrderInfo() throws Exception {
        List<CustomEntity> ordersInfo = new QueryDAOImpl().getOrdersInfo("T%");
        for (CustomEntity customEntity : ordersInfo) {
            System.out.println(customEntity.getOrderId());
            System.out.println(customEntity.getCustomerName());
            System.out.println(customEntity.getOrderTotal());
        }

    }

    void testGetOrderInfo() {
    }

    void getOrdersInfo() throws Exception {
        QueryDAO queryDAO = new QueryDAOImpl();
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            queryDAO.setSession(session);
            session.beginTransaction();

            List<CustomEntity> ordersInfo = queryDAO.getOrdersInfo("");
            System.out.println(ordersInfo.toString());

            session.getTransaction().commit();
        }
    }
}
