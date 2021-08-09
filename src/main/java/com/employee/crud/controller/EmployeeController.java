package com.employee.crud.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.employee.crud.entity.Employee;
import com.employee.crud.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jyuan
 * @since 2021-08-09
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;
    @Autowired
    JdbcTemplate jdbcTemplate;



    @GetMapping("")
    public ResponseEntity getAllUser() {
        return new ResponseEntity<>(employeeService.list(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity getone(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/page/{page}/pagesize/{pagesize}")
    public ResponseEntity pageList(@PathVariable Long page,@PathVariable Long pagesize ) {
        QueryWrapper<Employee> wrapper=new QueryWrapper<>();
        Page page1=new Page();
        page1.setSize(pagesize);
        page1.setCurrent(page);
        employeeService.page(page1,wrapper);
        return new ResponseEntity<>(employeeService.page(page1,wrapper), HttpStatus.OK);
    }
    @PostMapping("")
    ResponseEntity add(@RequestBody Employee employee){
        String sql="INSERT INTO Employee (name,age,gender) VALUES ( ?,?,?) ";
        return new ResponseEntity(jdbcTemplate.update(sql,employee.getName(),employee.getAge(),employee.getGender()),HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    ResponseEntity update(@PathVariable Integer id,@RequestBody Employee  employee){
        String sql="UPDATE  employee  set  name=?, age=? , gender = ? where id =? ";
        return new ResponseEntity(jdbcTemplate.update(sql,employee.getName(),employee.getAge(),employee.getGender(),id),HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    ResponseEntity del(@PathVariable Long id){
        return new ResponseEntity(employeeService.removeById(id),HttpStatus.NO_CONTENT);
    }

}
