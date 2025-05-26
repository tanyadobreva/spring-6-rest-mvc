package guru.springframework.spring6restmvc.controller;

import guru.springframework.spring6restmvc.model.Customer;
import guru.springframework.spring6restmvc.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by jt, Spring Framework Guru.
 */
@RequestMapping("/api/customer")
@RequiredArgsConstructor
@RestController
public class CustomerController {

    private final CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listAllCustomers(){
        return customerService.getAllCustomers();
    }

    @RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("customerId") UUID id){
        return customerService.getCustomerById(id);
    }

    @DeleteMapping("{customerId}")
    public ResponseEntity deleteCustomerById(@PathVariable("customerId") UUID id){
        customerService.deleteCustomerById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @PostMapping
    //creating
    public ResponseEntity handleRequest(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveNewCustomerPOST(customer);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/customer/" + savedCustomer.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
    @PutMapping("{customerId}")
    //updating
    public ResponseEntity updateCustomerByIDPut(@PathVariable("customerId") UUID customerId, @RequestBody Customer customer) {
        customerService.updateCustomerByIDPUT(customerId, customer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("{customerId}")
    //updating
    public ResponseEntity patchCustomerById(@PathVariable("customerId") UUID customerId, @RequestBody Customer customer) {
        customerService.patchCustomerById(customerId, customer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
