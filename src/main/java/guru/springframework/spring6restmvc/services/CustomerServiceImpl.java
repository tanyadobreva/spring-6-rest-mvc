package guru.springframework.spring6restmvc.services;
import guru.springframework.spring6restmvc.model.Customer;
//import guru.springframework.spring6restmvc.model.CustomerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.*;
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    private Map<UUID, Customer> customerMap;
    public CustomerServiceImpl() {
        this.customerMap = new HashMap<>();
        Customer customer1 = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .customerName("Customer1Tanya")
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();
        Customer customer2 = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .customerName("Customer2")
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();
        customerMap.put(customer1.getId(), customer1);
        customerMap.put(customer2.getId(), customer2);
    }
    @Override
    public List<Customer> listCustomers(){
        log.debug("in ListCustomers of CustomerServiceImpl");
        return new ArrayList<>(customerMap.values());
    }
    @Override
    public Customer getCustomerById(UUID id) {
        log.debug("Get customer by Id - in service. Id: " + id.toString());
        return customerMap.get(id);
    }
}
