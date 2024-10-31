package com.razah.dev.bookstore.transaction.service.impl;

import com.razah.dev.bookstore.transaction.dto.request.CreateEmployeeRequest;
import com.razah.dev.bookstore.transaction.dto.request.UpdateEmployeeRequest;
import com.razah.dev.bookstore.transaction.dto.response.EmployeeResponse;
import com.razah.dev.bookstore.transaction.entities.Employee;
import com.razah.dev.bookstore.transaction.entities.Users;
import com.razah.dev.bookstore.transaction.mapper.impl.EmployeeMapperImpl;
import com.razah.dev.bookstore.transaction.repository.EmployeeRepository;
import com.razah.dev.bookstore.transaction.service.EmployeeService;
import com.razah.dev.bookstore.transaction.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final ValidationUtil validationUtil;
    private final EmployeeMapperImpl employeeMapperImpl;


    @Override
    public Employee create(CreateEmployeeRequest request, Users users) {
        validationUtil.validate(request);
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setTelephone(request.getTelephone());
        employee.setPosition(request.getPosition());
        employee.setUsersEmployee(users);
        return employeeRepository.saveAndFlush(employee);
    }

    @Override
    public Employee update(UpdateEmployeeRequest request) {
        validationUtil.validate(request);
        Employee byId = getById(request.getId());
        byId.setName(request.getName());
        byId.setEmail(request.getEmail());
        byId.setTelephone(request.getTelephone());
        byId.setPosition(request.getPosition());
        return employeeRepository.saveAndFlush(byId);
    }

    @Override
    public Employee getById(String id) {
        if(Objects.isNull(id))
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase());
        }
        return employeeRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        HttpStatus.NOT_FOUND.getReasonPhrase())
        );
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void delete(String id) {
        Employee byId = getById(id);
        employeeRepository.delete(byId);
    }

    @Override
    public EmployeeResponse createResponse(CreateEmployeeRequest request, Users users) {
        Employee employee = create(request, users);
        return employeeMapperImpl.map(employee);
    }

    @Override
    public EmployeeResponse updateResponse(UpdateEmployeeRequest request) {
        Employee update = update(request);
        return employeeMapperImpl.map(update);
    }

    @Override
    public EmployeeResponse getByIdResponse(String id) {
        Employee byId = getById(id);
        return employeeMapperImpl.map(byId);
    }

    @Override
    public List<EmployeeResponse> getAllResponses() {
        return getAll().stream().map(
                employeeMapperImpl::map
        ).toList();
    }
}
