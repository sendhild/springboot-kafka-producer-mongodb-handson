package com.epam.learning.handson;

import com.epam.learning.handson.model.Employee;
import com.epam.learning.handson.repositories.EmployeeRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

/**
 * Created by savithasendhil on 3/8/19.
 */

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    private final EmployeeProducer producer;

    @Autowired
    EmployeeController(EmployeeProducer producer)   {
        this.producer = producer;
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public List<Employee> findAllEmployees() {
        return repository.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Employee findEmployeeByID(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        employee.set_id(ObjectId.get());
        employee.setCreateTimeStamp(new SimpleDateFormat("yyyy.MM.dd HH:mm:ss Z").format(new Date()));
        repository.save(employee);

        //Send a message with Object ID to Kafka Producer
        producer.sendMessage(employee.get_id());
        return  employee;
    }
}
