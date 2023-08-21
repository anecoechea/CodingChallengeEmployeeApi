package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ReportingStructureService reportingStructureService;

    @Override
    public ReportingStructure read(String id){
        LOG.debug("Reading ReportingStructure for employee with id [{}]",id);
        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null){
            throw new RuntimeException("Invalid employeeId:" + id);
        }
        int numOfReports = 0;
        numOfReports = getTotalReports(employee);

        return new ReportingStructure(employee,numOfReports);
    }

    private int getTotalReports(Employee employee){
        int numOfReports = 0;
        LOG.debug("Got here for employee {} name {} ",employee.getEmployeeId(),employee.getLastName());
        List<Employee> reportList;
        reportList = employee.getDirectReports();

        // Recursive traversal through lists until it comes back as null
        // Add one to each value you iterate through plus all the values from the recursive traversal
        if (reportList != null){
            for (Employee value : reportList) {
                String tempEmpID = value.getEmployeeId();
                Employee tempEmp = employeeRepository.findByEmployeeId(tempEmpID);
                numOfReports += 1 + getTotalReports(tempEmp);
            }
        }
        return numOfReports;
    }


}
