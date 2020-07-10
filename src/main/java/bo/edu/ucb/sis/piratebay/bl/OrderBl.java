package bo.edu.ucb.sis.piratebay.bl;

import bo.edu.ucb.sis.piratebay.dao.OrderDao;
import bo.edu.ucb.sis.piratebay.model.OrderModel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderBl {

    private OrderDao orderDao;

    @Autowired
    public OrderBl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<PayedModel> findAllPayed() {
        return this.orderDao.findAllPayed();
    }
    public List<ReadyModel> findAllReady() {
        return this.orderDao.findAllReady();
    }
    public List<DispatchedModel> findAllDispatched() {
        return this.orderDao.findAllDispatched();
    }
    public List<DeliveredModel> findAllDelivered() {
        return this.orderDao.findAllDelivered();
    }
}
