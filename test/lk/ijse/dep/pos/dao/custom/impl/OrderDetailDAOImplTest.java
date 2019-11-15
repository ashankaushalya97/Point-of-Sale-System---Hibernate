package lk.ijse.dep.pos.dao.custom.impl;

import lk.ijse.dep.pos.entity.OrderDetail;
import lk.ijse.dep.pos.hibernate.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

class OrderDetailDAOImplTest {

    public static void main(String[] args) throws Exception {
        new OrderDetailDAOImplTest().existsByItemCode();
    }

    void existsByItemCode() throws Exception {
        OrderDetailDAOImpl itemDAO = new OrderDetailDAOImpl();
        boolean i001=false;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            itemDAO.setSession(session);
            session.beginTransaction();

            i001 = itemDAO.existsByItemCode("I001");
            session.getTransaction().commit();
        }

        System.out.println(i001);
    }

    void testFindAll() {

    }
}