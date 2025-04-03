package io.pragra.learning.springdatajpademo.api;

import io.pragra.learning.springdatajpademo.dto.ResponseDTO;
import io.pragra.learning.springdatajpademo.model.Employee;
import io.pragra.learning.springdatajpademo.utils.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.pragra.learning.springdatajpademo.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeAPI {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @PostMapping("/addAll")
    public List<Employee> addAllEmployees(@RequestBody List<Employee> employees) {
        return employeeService.addAllEmployees(employees);
    }

    @GetMapping("/getById")
    public ResponseEntity<ResponseDTO> getEmployeeById(@RequestParam Long id) {

        ///  5 < id < 7 <-- Id should be in this range
        ///  let's say we pass 8 digits
        if (!EmployeeValidator.validateId(id)){
            // return error with proper details
            // validation fails - code 1010
            //GitUser user = tempUser.get();
            ResponseDTO userDTO = ResponseDTO.builder()
                    .statusCode("1010")  // failure code
                    .statusDesc("Id is not valid")
                    .build();

            ResponseEntity<ResponseDTO> responseEntity = ResponseEntity
                    .ok()
                    .header("test", "test1234")
                    .body(userDTO);

            return responseEntity;
        }

        Optional<Employee> tempEmp = null;
        try{
            tempEmp = employeeService.getEmployeeById(id);
            ///  AAA (1011) App: (id) -> receiving custId  // may further call to XYZ app (if this is down - 2020)
            System.out.println("asasadsda");

            ///  BBB (1012) App: (custId) -> account numbers
            System.out.println("sdgertegeg");

            ///  CCC (1013) App: (acc#) -> AccountAccessId
            System.out.println("htyertert");

            ///  DDD (1014) App: (AccountAccessId)  ->  (Process the payment and gives the object back)
            System.out.println("ertryytrtg");
        } catch (Exception ex){
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .statusCode(ex.getMessage().substring(0, 4))  // exception message includes - 1111What ever issue is there
                    .statusDesc(ex.getMessage().substring(4))
                    .build();

            ResponseEntity<ResponseDTO> responseEntity = ResponseEntity
                    .ok()
                    .header("test", "test1234")
                    .body(responseDTO);

            return responseEntity;
        }

        if (tempEmp.isPresent()){
            Employee employee = tempEmp.get();
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .data(employee)
                    .statusCode("SS0") // success code
                    .build();

            ResponseEntity<ResponseDTO> responseEntity = ResponseEntity
                    .ok()
                    .header("test", "test1234")
                    .body(responseDTO);

            return responseEntity;
        } else {
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .statusCode("1011")  // failure code
                    .statusDesc("Employee not available for id: "+id)
                    .build();

            ResponseEntity<ResponseDTO> responseEntity = ResponseEntity
//                    .notFound()
//                    .header("test", "test1223")
//                    .build();
                    .ok()
                    .header("test", "test1234")
                    .body(responseDTO);

            return responseEntity;
        }

        //return employeeService.getEmployeeById(id);
    }


    @GetMapping("/hello")
    public String test(){
        return "Hello World!";
    }

    @GetMapping("/getFnameById")
    public String getFnameById(@RequestParam Long id) {
        return employeeService.getEmployeeById(id).get().getFirstName();
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @DeleteMapping("/deleteEmployee")
    public ResponseEntity<ResponseDTO> deleteEmployee(@RequestParam Long id) {

        ///  5 < id < 7 <-- Id should be in this range
        ///  let's say we pass 8 digits
        if (!EmployeeValidator.validateId(id)){
            // return error with proper details
            // validation fails - code 1010
            //GitUser user = tempUser.get();
            ResponseDTO userDTO = ResponseDTO.builder()
                    .statusCode("1010")  // failure code
                    .statusDesc("Id is not valid")
                    .build();

            ResponseEntity<ResponseDTO> responseEntity = ResponseEntity
                    .ok()
                    .header("test", "test1234")
                    .body(userDTO);

            return responseEntity;
        }

        Optional<Employee> tempEmp;
        try{
            tempEmp = employeeService.deleteEmployee(id);
            ///  AAA (1011) App: (id) -> receiving custId  // may further call to XYZ app (if this is down - 2020)
            System.out.println("asasadsda");

            ///  BBB (1012) App: (custId) -> account numbers
            System.out.println("sdgertegeg");

            ///  CCC (1013) App: (acc#) -> AccountAccessId
            System.out.println("htyertert");

            ///  DDD (1014) App: (AccountAccessId)  ->  (Process the payment and gives the object back)
            System.out.println("ertryytrtg");
        } catch (Exception ex){
            System.out.println("In catch block");
            ResponseDTO responseDTO = ResponseDTO.builder()
                    //.statusCode(ex.getMessage().substring(0, 4))  // exception message includes - 1111What ever issue is there
                    .statusCode("2121")  // delete failure code - 2121
                    .statusDesc(ex.getMessage())
                    .build();

            ResponseEntity<ResponseDTO> responseEntity = ResponseEntity
                    .ok()
                    .body(responseDTO);

            return responseEntity;
        }

        if (tempEmp.isPresent()){
            System.out.println("Emp found : " + id);
            Employee employee = tempEmp.get();
            ResponseDTO responseDTO = new ResponseDTO(employee, "SS0", "success");
            /*ResponseDTO responseDTO = ResponseDTO.builder()
                    .data(employee)
                    .statusCode("SS0") // success code
                    .build();*/

            ResponseEntity<ResponseDTO> responseEntity = ResponseEntity
                    .ok()
                    .body(responseDTO);

            return responseEntity;
        } else {
            System.out.println("Emp not found: " + id);
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .statusCode("1011")  // failure code
                    .statusDesc("Employee not available for id: "+id)
                    .build();

            ResponseEntity<ResponseDTO> responseEntity = ResponseEntity
//                    .notFound()
//                    .header("test", "test1223")
//                    .build();
                    .ok()
                    .header("test", "test1234")
                    .body(responseDTO);

            return responseEntity;
        }

        //return employeeService.deleteEmployee(id);
    }

    @PutMapping("/updateEmployee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @PatchMapping("/patchEmployee")
    public Employee patchEmployee(@RequestBody Employee employee) {
        return employeeService.patchEmployee(employee);
    }

    @GetMapping("/getAllByFirstName")
    public List<Employee> getEmployeeByFirstName(@RequestParam String firstName) {
        return employeeService.getEmployeesByFirstName(firstName);
    }

    @GetMapping("/getAllByLastName")
    public ResponseEntity<ResponseDTO> getEmployeeByLastName(@RequestParam String lastName) {

        if (!EmployeeValidator.validateLastName(lastName)){
            // return error with proper details
            // validation fails - code 1010
            ResponseDTO userDTO = ResponseDTO.builder()
                    .statusCode("1010")  // failure code
                    .statusDesc("Employee with Last name '"+lastName +"' does not exist")
                    .build();

            ResponseEntity<ResponseDTO> responseEntity = ResponseEntity
                    .ok()
                    .header("test", "test1234")
                    .body(userDTO);

            return responseEntity;
        }

        Optional<Employee> tempEmp = null;
        try{
            tempEmp = Optional.ofNullable(employeeService.getEmployeeByLastName(lastName));

            System.out.println("Try block execution");

        } catch (Exception ex){
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .statusCode(ex.getMessage().substring(0, 4))  // exception message includes - 1111What ever issue is there
                    .statusDesc(ex.getMessage().substring(4))
                    .build();

            ResponseEntity<ResponseDTO> responseEntity = ResponseEntity
                    .ok()
                    .header("test", "test1234")
                    .body(responseDTO);

            return responseEntity;
        }

        if (tempEmp.isPresent()){
            Employee employee = tempEmp.get();
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .data(employee)
                    .statusCode("SS0") // success code
                    .build();

            ResponseEntity<ResponseDTO> responseEntity = ResponseEntity
                    .ok()
                    .header("test", "test1234")
                    .body(responseDTO);

            return responseEntity;
        } else {
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .statusCode("1011")  // failure code
                    .statusDesc("Employee not available with last name: "+lastName)
                    .build();

            ResponseEntity<ResponseDTO> responseEntity = ResponseEntity
//                    .notFound()
//                    .header("test", "test1223")
//                    .build();
                    .ok()
                    .header("test", "test1234")
                    .body(responseDTO);

            return responseEntity;
        }

        //return employeeService.getEmployeesByLastName(lastName);
    }

    @GetMapping("/getAllByDesignation")
    public List<Employee> getEmployeesByDesignation(@RequestParam String designation) {
        return employeeService.getEmployeesByDesignation(designation);
    }
}
