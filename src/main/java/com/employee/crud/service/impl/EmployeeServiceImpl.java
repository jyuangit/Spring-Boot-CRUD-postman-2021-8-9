package com.employee.crud.service.impl;

import com.employee.crud.entity.Employee;
import com.employee.crud.mapper.EmployeeMapper;
import com.employee.crud.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jyuan
 * @since 2021-08-09
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}
