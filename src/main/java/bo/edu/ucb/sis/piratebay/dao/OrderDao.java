package bo.edu.ucb.sis.piratebay.dao;

import bo.edu.ucb.sis.piratebay.model.OrderModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class OrderDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<PayedModel> findAllPayed() {
        // Implmentamos SQL varible binding para evitar SQL INJECTION
        String query =
                "SELECT o.order_id, DATE(o.date), CONCAT(p.first_name,' ',p.first_surname) as customer, p.address " +
                "FROM \"order\" as o, \"user\" as u, customer as c, person as p " +
                "WHERE o.user_id = u.user_id " +
                "AND u.user_id = c.user_id " +
                "AND c.person_id = p.person_id " +
                "AND o.status = 1";
        List<PayedModel> result = null;
        try {
            result = jdbcTemplate.query(query, new RowMapper<PayedModel>() {
                @Override
                public PayedModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new PayedModel(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4));
                }
            });
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
    }

    public List<ReadyModel> findAllReady() {
        // Implmentamos SQL varible binding para evitar SQL INJECTION
        String query =
                "SELECT o.order_id, DATE(o.date), CONCAT(p.first_name,' ',p.first_surname) as customer, o.date_courier_req " +
                        "FROM \"order\" as o, \"user\" as u, customer as c, person as p " +
                        "WHERE o.user_id = u.user_id " +
                        "AND u.user_id = c.user_id " +
                        "AND c.person_id = p.person_id " +
                        "AND o.status = 2";
        List<ReadyModel> result = null;
        try {
            result = jdbcTemplate.query(query, new RowMapper<ReadyModel>() {
                @Override
                public ReadyModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new ReadyModel(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4));
                }
            });
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
    }

    public List<DispatchedModel> findAllDispatched() {
        // Implmentamos SQL varible binding para evitar SQL INJECTION
        String query =
                "SELECT o.order_id, DATE(o.date), CONCAT(p.first_name,' ',p.first_surname) as customer, o.date_courier_rec " +
                        "FROM \"order\" as o, \"user\" as u, customer as c, person as p " +
                        "WHERE o.user_id = u.user_id " +
                        "AND u.user_id = c.user_id " +
                        "AND c.person_id = p.person_id " +
                        "AND o.status = 3";
        List<DispatchedModel> result = null;
        try {
            result = jdbcTemplate.query(query, new RowMapper<DispatchedModel>() {
                @Override
                public DispatchedModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new DispatchedModel(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4));
                }
            });
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
    }

    public List<DeliveredModel> findAllDelivered() {
        // Implmentamos SQL varible binding para evitar SQL INJECTION
        String query =
                "SELECT o.order_id, DATE(o.date), CONCAT(p.first_name,' ',p.first_surname) as customer, o.date_courier_rec, o.date_cust_rec " +
                        "FROM \"order\" as o, \"user\" as u, customer as c, person as p " +
                        "WHERE o.user_id = u.user_id " +
                        "AND u.user_id = c.user_id " +
                        "AND c.person_id = p.person_id " +
                        "AND o.status = 4";
        List<DeliveredModel> result = null;
        try {
            result = jdbcTemplate.query(query, new RowMapper<DeliveredModel>() {
                @Override
                public DeliveredModel mapRow(ResultSet resultSet, int i) throws SQLException {
                    return new DeliveredModel(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5));
                }
            });
        } catch (Exception ex) {
            throw new RuntimeException();
        }
        return result;
    }
}
