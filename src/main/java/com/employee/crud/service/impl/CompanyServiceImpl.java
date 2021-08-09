package com.employee.crud.service.impl;

import com.employee.crud.entity.Company;
import com.employee.crud.mapper.CompanyMapper;
import com.employee.crud.service.ICompanyService;
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
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {

}
