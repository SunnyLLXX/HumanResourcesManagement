package com.manage.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.dao.EmployeeInfoDao;
import com.manage.pojo.EmployeeContract;
import com.manage.pojo.EmployeeDeployment;
import com.manage.pojo.EmployeeInfo;
import com.manage.pojo.EmployeeRecords;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleInfo;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 模块1.2.3 & 1.2.4所用
 * 员工基本信息维护页面链接 http://localhost:8080/empInfo/baseInfoManagement
 * 员工档案管理页面链接 http://localhost:8080/empInfo/recordsManagement
 * 员工合同管理页面链接 http://localhost:8080/empInfo/contractManagement
 * 人事调配管理页面链接 http://localhost:8080/empInfo/deploymentManagement
 *
 * @author 张杰
 */
@Service
public class EmpInfoServiceImplement implements EmpInfoService {
    @Autowired
    EmployeeInfoDao employeeInfoDao;

    @Override
    public HashMap<String, Object> selectInfo(EmployeeInfo employeeInfo) {
        HashMap<String, Object> map = new HashMap<>();
        //设置分页参数
        PageHelper.startPage(employeeInfo.getPage(), employeeInfo.getRow());

        //根据用户选择的查询条件查询结果
        List<EmployeeInfo> list = null;
        if (employeeInfo.getConValue() != null) {
            if (employeeInfo.getConValue().equals("")) {
                list = employeeInfoDao.selectInfo();
            } else {
                if (employeeInfo.getCondition().equals("编号")) {
                    //设置用户输入的查询条件
                    employeeInfo.setId(Integer.parseInt(employeeInfo.getConValue()));
                    list = employeeInfoDao.selectInfoById(employeeInfo);
                } else if (employeeInfo.getCondition().equals("姓名")) {
                    employeeInfo.setEmpName(employeeInfo.getConValue());
                    list = employeeInfoDao.selectInfoByEmpName(employeeInfo);
                } else {
                    //查询数据库表数据
                    list = employeeInfoDao.selectInfo();
                }
            }
        } else {
            list = employeeInfoDao.selectInfo();
        }

        //把查询到的数据转换成分页对象
        PageInfo<EmployeeInfo> page = new PageInfo<>(list);

        //获取分页的当前页的集合
        map.put("list", page.getList());
        //总条数
        map.put("total", page.getTotal());
        //总页数
        map.put("totalPage", page.getPages());
        //上一页
        if (page.getPrePage() == 0) {
            map.put("pre", 1);
        } else {
            map.put("pre", page.getPrePage());
        }
        //下一页
        if (page.getNextPage() == 0) {
            map.put("next", page.getPages());
        } else {
            map.put("next", page.getNextPage());
        }
        //当前页
        map.put("cur", page.getPageNum());

        return map;
    }

    @Override
    public EmployeeInfo selectInfoById(EmployeeInfo employeeInfo) {
        return employeeInfoDao.selectInfoById(employeeInfo).get(0);
    }

    @Override
    public String updateInfo(EmployeeInfo employeeInfo) {
        int num = employeeInfoDao.updateInfo(employeeInfo);
        if (num > 0) {
            return "修改成功";
        }
        return "修改失败";
    }

    @Override
    public String addInfo(EmployeeInfo employeeInfo) {
        int num = employeeInfoDao.addInfo(employeeInfo);
        if (num > 0) {
            return "添加成功";
        }
        return "添加失败";
    }

    @Override
    public String deleteInfo(EmployeeInfo employeeInfo) {
        int num = employeeInfoDao.delInfo(employeeInfo);
        if (num > 0) {
            return "删除成功";
        }
        return "删除失败";
    }

    // ===================================
    // 员工档案所用

    @Override
    public HashMap<String, Object> selectRecords(EmployeeRecords employeeRecords) {
        HashMap<String, Object> map = new HashMap<>();
        //设置分页参数
        PageHelper.startPage(employeeRecords.getPage(), employeeRecords.getRow());

        //根据用户选择的查询条件查询结果
        List<EmployeeRecords> list = null;
        if (employeeRecords.getConValue() != null) {
            if (employeeRecords.getConValue().equals("")) {
                list = employeeInfoDao.selectRecords();
            } else {
                if (employeeRecords.getCondition().equals("档案编号")) {
                    //设置用户输入的查询条件
                    employeeRecords.setRecordsId(Integer.parseInt(employeeRecords.getConValue()));
                    list = employeeInfoDao.selectRecordsByRecordsId(employeeRecords);
                } else if (employeeRecords.getCondition().equals("员工编号")) {
                    employeeRecords.setEmpId(Integer.parseInt(employeeRecords.getConValue()));
                    list = employeeInfoDao.selectRecordsByEmpId(employeeRecords);
                } else {
                    //查询数据库表数据
                    list = employeeInfoDao.selectRecords();
                }
            }
        } else {
            list = employeeInfoDao.selectRecords();
        }

        //把查询到的数据转换成分页对象
        PageInfo<EmployeeRecords> page = new PageInfo<>(list);

        //获取分页的当前页的集合
        map.put("list", page.getList());
        //总条数
        map.put("total", page.getTotal());
        //总页数
        map.put("totalPage", page.getPages());
        //上一页
        if (page.getPrePage() == 0) {
            map.put("pre", 1);
        } else {
            map.put("pre", page.getPrePage());
        }
        //下一页
        if (page.getNextPage() == 0) {
            map.put("next", page.getPages());
        } else {
            map.put("next", page.getNextPage());
        }
        //当前页
        map.put("cur", page.getPageNum());

        return map;
    }

    @Override
    public EmployeeRecords selectRecordsByRecordsId(EmployeeRecords employeeRecords) {
        return employeeInfoDao.selectRecordsByRecordsId(employeeRecords).get(0);
    }

    @Override
    public String updateRecords(EmployeeRecords employeeRecords) {
        int num = employeeInfoDao.updateRecords(employeeRecords);
        if (num > 0) {
            return "修改成功";
        }
        return "修改失败";
    }

    @Override
    public String addRecords(EmployeeRecords employeeRecords) {
        int num = employeeInfoDao.addRecords(employeeRecords);
        if (num > 0) {
            return "添加成功";
        }
        return "添加失败";
    }

    @Override
    public String deleteRecords(EmployeeRecords employeeRecords) {
        int num = employeeInfoDao.delRecords(employeeRecords);
        if (num > 0) {
            return "删除成功";
        }
        return "删除失败";
    }

    @Override
    public void excelExport(HttpServletResponse response, String type) {
        OutputStream output = null;
        try {
            // 创建HSSFWorkbook对象
            HSSFWorkbook wb = new HSSFWorkbook();

            String fileName = type;
            // 创建HSSFSheet对象,如果要创建多个sheet，就再创建sheet对象
            HSSFSheet sheet = wb.createSheet(fileName);

            // 创建HSSFRow对象，先写入列名
            HSSFRow colName = sheet.createRow(0);
            if (type.equals("records")) {
                // 写入入第一行列名
                colName.createCell(0).setCellValue("档案编号");
                colName.createCell(1).setCellValue("员工编号");
                colName.createCell(2).setCellValue("档案名称");
                colName.createCell(3).setCellValue("内容摘要");
                colName.createCell(4).setCellValue("备注");

                //查询员工所有信息
                List<EmployeeRecords> list = employeeInfoDao.selectRecords();

                for (int i = 1; i <= list.size(); i++) {
                    //从第二行开始写入数据
                    HSSFRow row = sheet.createRow(i);
                    row.createCell(0).setCellValue(list.get(i - 1).getRecordsId());
                    row.createCell(1).setCellValue(list.get(i - 1).getEmpId());
                    row.createCell(2).setCellValue(list.get(i - 1).getRecordsName());
                    row.createCell(3).setCellValue(list.get(i - 1).getSummary());
                    row.createCell(4).setCellValue(list.get(i - 1).getRemarks());
                }
            } else if (type.equals("contract")) {
                // 写入入第一行列名
                colName.createCell(0).setCellValue("合同编号");
                colName.createCell(1).setCellValue("员工编号");
                colName.createCell(2).setCellValue("合同开始日期");
                colName.createCell(3).setCellValue("合同结束日期");
                colName.createCell(4).setCellValue("职务");
                colName.createCell(5).setCellValue("合同内容");
                colName.createCell(6).setCellValue("备注");

                //查询员工所有信息
                List<EmployeeContract> list = employeeInfoDao.selectContract();

                for (int i = 1; i <= list.size(); i++) {
                    //从第二行开始写入数据
                    HSSFRow row = sheet.createRow(i);
                    row.createCell(0).setCellValue(list.get(i - 1).getContractId());
                    row.createCell(1).setCellValue(list.get(i - 1).getEmpId());
                    row.createCell(2).setCellValue(list.get(i - 1).getStartDate());
                    row.createCell(3).setCellValue(list.get(i - 1).getEndDate());
                    row.createCell(4).setCellValue(list.get(i - 1).getJob());
                    row.createCell(5).setCellValue(list.get(i - 1).getContent());
                    row.createCell(6).setCellValue(list.get(i - 1).getRemarks());
                }
            }
            //输出Excel文件到页面
            output = response.getOutputStream();

            //解决中文文件名下载 变成下划线的问题
            fileName = new String(fileName.getBytes("utf-8"), "ISO8859-1") + "";
            response.reset();
            response.setHeader("Content-disposition", "attachment; filename=" + fileName + ".xls");
            response.setContentType("application/msexcel");
            wb.write(output);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public HashMap<String, Object> selectContract(EmployeeContract employeeContract, String sortType) {
        HashMap<String, Object> map = new HashMap<>();
        //设置分页参数

        String orderBy = "";
        // 按照开始时间升序 sa -- start ascend
        if (sortType != null) {
            switch (sortType) {
                case "sa":
                    orderBy = "startDate ASC";
                    break;
                case "sd":   // start descend
                    orderBy = "startDate DESC";
                    break;
                case "ea":
                    orderBy = "endDate ASC";
                    break;
                case "ed":
                    orderBy = "endDate DESC";
                    break;
                default:
                    break;
            }
        }

        PageHelper.startPage(employeeContract.getPage(), employeeContract.getRow(), orderBy);

        //根据用户选择的查询条件查询结果
        List<EmployeeContract> list = null;
        if (employeeContract.getConValue() != null) {
            if (employeeContract.getConValue().equals("")) {
                list = employeeInfoDao.selectContract();
            } else {
                if (employeeContract.getCondition().equals("合同编号")) {
                    //设置用户输入的查询条件
                    employeeContract.setContractId(Integer.parseInt(employeeContract.getConValue()));
                    list = employeeInfoDao.selectContractByContractId(employeeContract);
                } else if (employeeContract.getCondition().equals("员工编号")) {
                    employeeContract.setEmpId(Integer.parseInt(employeeContract.getConValue()));
                    list = employeeInfoDao.selectContractByEmpId(employeeContract);
                } else {
                    //查询数据库表数据
                    list = employeeInfoDao.selectContract();
                }
            }
        } else {
            list = employeeInfoDao.selectContract();
        }

        //把查询到的数据转换成分页对象
        PageInfo<EmployeeContract> page = new PageInfo<>(list);

        //获取分页的当前页的集合
        map.put("list", page.getList());
        //总条数
        map.put("total", page.getTotal());
        //总页数
        map.put("totalPage", page.getPages());
        //上一页
        if (page.getPrePage() == 0) {
            map.put("pre", 1);
        } else {
            map.put("pre", page.getPrePage());
        }
        //下一页
        if (page.getNextPage() == 0) {
            map.put("next", page.getPages());
        } else {
            map.put("next", page.getNextPage());
        }
        //当前页
        map.put("cur", page.getPageNum());

        return map;
    }

    @Override
    public EmployeeContract selectContractByContractId(EmployeeContract employeeContract) {
        return employeeInfoDao.selectContractByContractId(employeeContract).get(0);
    }

    @Override
    public String updateContract(EmployeeContract employeeContract) {
        int num = employeeInfoDao.updateContract(employeeContract);
        if (num > 0) {
            return "修改成功";
        }
        return "修改失败";
    }

    @Override
    public String addContract(EmployeeContract employeeContract) {
        int num = employeeInfoDao.addContract(employeeContract);
        if (num > 0) {
            return "添加成功";
        }
        return "添加失败";
    }

    @Override
    public String deleteContract(EmployeeContract employeeContract) {
        int num = employeeInfoDao.delContract(employeeContract);
        if (num > 0) {
            return "删除成功";
        }
        return "删除失败";
    }

    @Override
    public HashMap<String, Object> selectDeployment(EmployeeDeployment employeeDeployment, String sortType) {
        HashMap<String, Object> map = new HashMap<>();

        // 设置排序参数
        String orderBy = "";
        if (sortType != null) {
            switch (sortType) {
                case "sa":   // 按照开始时间升序 sa -- start ascend
                    orderBy = "startDate ASC";
                    break;
                case "sd":   // start descend
                    orderBy = "startDate DESC";
                    break;
                case "da":
                    orderBy = "deployDate ASC";
                    break;
                case "dd":
                    orderBy = "deployDate DESC";
                    break;
                default:
                    break;
            }
        }

        //设置分页参数
        PageHelper.startPage(employeeDeployment.getPage(), employeeDeployment.getRow(), orderBy);

        //根据用户选择的查询条件查询结果
        List<EmployeeDeployment> list = null;
        if (employeeDeployment.getConValue() != null) {
            if (employeeDeployment.getConValue().equals("")) {
                list = employeeInfoDao.selectDeployment();
            } else {
                if (employeeDeployment.getCondition().equals("员工姓名")) {
                    //设置用户输入的查询条件
                    employeeDeployment.setEmpName(employeeDeployment.getConValue());
                    list = employeeInfoDao.selectDeploymentByEmpName(employeeDeployment);
                } else if (employeeDeployment.getCondition().equals("员工编号")) {
                    employeeDeployment.setEmpId(Integer.parseInt(employeeDeployment.getConValue()));
                    list = employeeInfoDao.selectDeploymentByEmpId(employeeDeployment);
                } else {
                    //查询数据库表数据
                    list = employeeInfoDao.selectDeployment();
                }
            }
        } else {
            list = employeeInfoDao.selectDeployment();
        }

        //把查询到的数据转换成分页对象
        PageInfo<EmployeeDeployment> page = new PageInfo<>(list);

        //获取分页的当前页的集合
        map.put("list", page.getList());
        //总条数
        map.put("total", page.getTotal());
        //总页数
        map.put("totalPage", page.getPages());
        //上一页
        if (page.getPrePage() == 0) {
            map.put("pre", 1);
        } else {
            map.put("pre", page.getPrePage());
        }
        //下一页
        if (page.getNextPage() == 0) {
            map.put("next", page.getPages());
        } else {
            map.put("next", page.getNextPage());
        }
        //当前页
        map.put("cur", page.getPageNum());

        return map;
    }

    @Override
    public List<EmployeeDeployment> selectDeploymentByEmpId(EmployeeDeployment employeeDeployment) {
        return employeeInfoDao.selectDeploymentByEmpId(employeeDeployment);
    }

    @Override
    public String updateDeployment(EmployeeDeployment employeeDeployment) {
        int num = employeeInfoDao.updateDeployment(employeeDeployment);
        if (num > 0) {
            return "修改成功";
        }
        return "修改失败";
    }

    @Override
    public String addDeployment(EmployeeDeployment employeeDeployment) {
        int num = employeeInfoDao.addDeployment(employeeDeployment);
        if (num > 0) {
            return "添加成功";
        }
        return "添加失败";
    }

    @Override
    public String deleteDeployment(EmployeeDeployment employeeDeployment) {
        int num = employeeInfoDao.delDeployment(employeeDeployment);
        if (num > 0) {
            return "删除成功";
        }
        return "删除失败";
    }

    @Override
    public List<String> selectDeploymentDep() {
        return employeeInfoDao.selectDeploymentDep();
    }

    @Override
    public List<Object> selectEmployees() {
        return employeeInfoDao.selectEmployees();
    }
}
