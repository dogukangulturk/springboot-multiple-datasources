package service;
import java.util.List;


import model.Order;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.OrderRepository;
import repository.UserRepository;

@Service
public class UserOrdersService
{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional(transactionManager="securityTransactionManager")
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    @Transactional(transactionManager="ordersTransactionManager")
    public List<Order> getOrders()
    {
        return orderRepository.findAll();
    }
}
