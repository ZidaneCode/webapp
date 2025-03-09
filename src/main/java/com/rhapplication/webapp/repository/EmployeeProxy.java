package com.rhapplication.webapp.repository;
import com.rhapplication.webapp.CustomProperties;
import com.rhapplication.webapp.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class EmployeeProxy {
    @Autowired
    private CustomProperties customProperties;

    /**
     * Get all employees
     * @return An iterable of all employees
     */
   public Iterable<Employee>getEmployees(){
       String basApiUrl=customProperties.getApiUrl();
       String getEmployeesUrl=basApiUrl+"/employees";
       RestTemplate restTemplate=new RestTemplate();
       ResponseEntity<Iterable<Employee>> response=restTemplate.exchange(
               getEmployeesUrl,
               HttpMethod.GET,
               null,
               new ParameterizedTypeReference<Iterable<Employee>>() {}
       );
       //log.debug("lkkkkkkk");

       return response.getBody();
   }
    /**
     * Get One employees
     * @return An Employee of id
     */
    public Employee getEmployee(Integer id){
        String basApiUrl=customProperties.getApiUrl();
        String getEmployeeUrl=basApiUrl+"/employee/"+id;

        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<Employee> response=restTemplate.exchange(
                getEmployeeUrl,
                HttpMethod.GET,
                null,
                Employee.class
        );
        //log.debug("Get Employee id={} call{}", id, response.getStatusCode().toString());
        return response.getBody();
    }

    /**
     * Add a new employee
     * @param e A new employee (without an id)
     * @return The employee full filled (with an id)
     */
    public Employee ceateEmployee(Employee e){
        String baseApiUrl= customProperties.getApiUrl();
        String createEmployeeUrl=baseApiUrl+"/employee";

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Employee> request=new HttpEntity<Employee>(e);
        ResponseEntity<Employee> response=restTemplate.exchange(
                createEmployeeUrl,
                HttpMethod.POST,
                request,
                Employee.class
        );
        //log.debug("Create Employee call {}",response.getStatusCode().toString());
        return response.getBody();
    }

    /**
     * Update an employee - using the PUT HTTP Method.
     * @param e Existing employee to update
     */
    public Employee updateEmployee(Employee e){
        String baseApiUrl= customProperties.getApiUrl();
        String updateEmployeeUrl=baseApiUrl+"/employee/"+e.getId();
        RestTemplate restTemplate=new RestTemplate();
        HttpEntity<Employee> request=new HttpEntity<>(e);
        ResponseEntity<Employee> response=restTemplate.exchange(
                updateEmployeeUrl,
                HttpMethod.PUT,
                request,
                Employee.class
        );

        return response.getBody();
    }
    public void deleteEmployee(int id){
        String baseApiUrl= customProperties.getApiUrl();
        String deleteEmployeeUrl=baseApiUrl+"/employee/"+id;

        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<Void> response=restTemplate.exchange(
                deleteEmployeeUrl,
                HttpMethod.DELETE,
                null,
                Void.class
        );
    }

}
