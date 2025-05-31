package guru.springframework.spring6restmvc.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by jt, Spring Framework Guru.
 */
@Data
@Builder
public class Customer {

    private String name;
    private UUID id;
    private Integer version;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;

public String toString(){

    String printObject = "name: " + this.name + " ID: " + this.id + " version: " + this.version + " createdDate: " + this.createdDate + " updateDate: " + this.updateDate;

    System.out.println(printObject);
    System.out.println("ENDING TO STRING: ");

    return printObject;
}

}