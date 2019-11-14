package lk.ijse.dep.pos.dao.custom.impl;

import lk.ijse.dep.pos.dao.CrudUtil;
import lk.ijse.dep.pos.dao.custom.QueryDAO;
import lk.ijse.dep.pos.entity.CustomEntity;
import org.hibernate.Session;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QueryDAOImpl implements QueryDAO {

    @Override
    public CustomEntity getOrderInfo(int orderId) throws Exception {
        return null;
    }

    @Override
    public CustomEntity getOrderInfo2(int orderId) throws Exception {
        return null;
    }

    @Override
    public List<CustomEntity> getOrdersInfo(String query) throws Exception {
        return null;
    }

    @Override
    public void setSession(Session session) {

    }
}
