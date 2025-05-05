package guru.springframework.spring6restmvc.controller;
import guru.springframework.spring6restmvc.model.Customer;
import guru.springframework.spring6restmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;
    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listCustomers(){
        log.debug("Get Customer by Id - in CMR controller listCustomers");
        return customerService.listCustomers();
    }
    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("customerId") UUID customerId){
        log.debug("Get Customer by Id - in CMR controller");
        return customerService.getCustomerById(customerId);
    }
}
