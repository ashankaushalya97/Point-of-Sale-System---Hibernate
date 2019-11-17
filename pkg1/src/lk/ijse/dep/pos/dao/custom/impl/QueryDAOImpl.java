package lk.ijse.dep.pos.dao.custom.impl;

import lk.ijse.dep.pos.dao.CrudUtil;
import lk.ijse.dep.pos.dao.custom.QueryDAO;
import lk.ijse.dep.pos.entity.CustomEntity;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {

    private Session session;


    @Override
    public List<CustomEntity> getSearchInfo(String searchText) throws Exception {

        NativeQuery nativeQuery = session.createNativeQuery("select orders.orderDate,sum((orderDetail.qty)*(orderDetail.unitPrice)) as total,orders.customerId,customer.name from orders INNER JOIN orderDetail ON orders.orderId = orderDetail.orderId INNER JOIN customer ON orders.customerId = customer.id group by orders.orderId having orders.orderId like ?1 OR orders.orderDate like ?2 OR orders.customerId like ?3 OR customer.name like ?4 OR sum((orderDetail.qty)*(orderDetail.unitPrice)) like ?5;")
                .setParameter(1,searchText).setParameter(2,searchText).setParameter(3,searchText).setParameter(4,searchText).setParameter(5,searchText);
        Query<CustomEntity> query = nativeQuery.
                setResultTransformer(Transformers.aliasToBean(CustomEntity.class));
        List<CustomEntity> list = query.list();
        System.out.println(list.toString());
        return null;
    }

    @Override
    public List<CustomEntity> getOrdersInfo() throws Exception {
        NativeQuery nativeQuery = session.createNativeQuery("SELECT O.id as orderId, C.customer_id as customerId, C.name as customerName, O.date as orderDate, SUM(OD.qty * OD.unit_price) AS orderTotal  FROM Customer C INNER JOIN `Orders` O ON C.customer_id=O.customer_id INNER JOIN OrderDetail OD on O.id = OD.order_id GROUP BY O.id");
        Query<CustomEntity> query = nativeQuery.
                setResultTransformer(Transformers.aliasToBean(CustomEntity.class));
        List<CustomEntity> list = query.list();
        System.out.println(list.toString());

//        private int orderId;
//        private String customerId;
//        private String customerName;
//        private Date orderDate;
//        private double orderTotal;

        return list;
    }

    @Override
    public void setSession(Session session) {
        this.session=session;
    }
}
