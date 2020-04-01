package com.zrdh;

import com.zrdh.utils.JDBCUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;

/**
 * Description: cti-link-dataAnalysis
 * Created by hua on 2020/3/30 17:12
 *  poi导入数据库脚本
 */
public class JDBCTest {


    public void insert(List<Map<String,String>> paramList) throws SQLException {
        if(paramList == null){
            return;
        }
        Connection conn = null;
        conn = JDBCUtil.getConnection();
        for (Map<String, String> paramMap : paramList) {
            try {
                String name = paramMap.get("name");
                Integer id = null;
                try {
                     id = Integer.parseInt(paramMap.get("id"));
                } catch (Exception e) {

                }
                String sql = "INSERT INTO heatstation (name,hId) VALUES (?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1,name);
                if(id == null){
                    ps.setNull(2,-7);
                }else {
                    ps.setInt(2, id);
                }
                int i = ps.executeUpdate();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
//                JDBCUtil.close(rs, stmt, conn);
            }
        }
        conn.close();
    }

    @Test
    public void readPOI() throws Exception{
        // 判断文件是否存在
        File file = new File("C:\\Users\\17645\\Desktop\\guanxi\\换热站ID对照表.xlsx");
        if (!file.exists()) {
            throw new IOException("文件名为" + file.getName() + "Excel文件不存在！");
        }
//        HSSFWorkbook wb = null;
        XSSFWorkbook xb = null;
        FileInputStream fis=null;
        List<Map<String,String>> paramList = new ArrayList<>();
        try {
            fis = new FileInputStream(file);
            // 去读Excel
//            wb = new HSSFWorkbook(fis);
            xb = new XSSFWorkbook(fis);
            Sheet sheet = xb.getSheetAt(0);
            // 获取最后行号
            int lastRowNum = sheet.getLastRowNum();
            if (lastRowNum > 0) { // 如果>0，表示有数据
//                out("\n开始读取名为【" + sheet.getSheetName() + "】的内容：",showInfo);
                System.out.println("总行数:"+lastRowNum);
            }
            Row row = null;
            // 循环读取
            for (int i = 1; i <= lastRowNum ; i++) {
                row = sheet.getRow(i);
                if (row != null) {
//                    System.out.println("第" + (i + 1) + "行："+row.toString());
                    // 获取每一单元格的值
//                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        HashMap<String, String> hashMap = new HashMap<>();
                        String name = row.getCell(0).getStringCellValue();
                        Cell cell = row.getCell(1);
                        String id = null;
                        if(cell != null){
                            id = cell.getStringCellValue();
                        }
                        hashMap.put("name",name);
                        hashMap.put("id",id);
                        paramList.add(hashMap);
//                    }
                }
            }
            xb.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
//            wb.close();
        }
        insert(paramList);
    }

    @Test
    public void readPOI2() throws Exception{
        // 判断文件是否存在
        File file = new File("C:\\Users\\17645\\Desktop\\guanxi\\房卡号地址信息.xlsx");
        if (!file.exists()) {
            throw new IOException("文件名为" + file.getName() + "Excel文件不存在！");
        }
//        HSSFWorkbook wb = null;
        XSSFWorkbook xb = null;
        FileInputStream fis=null;
        try {
            fis = new FileInputStream(file);
            // 去读Excel
//            wb = new HSSFWorkbook(fis);
            xb = new XSSFWorkbook(fis);
            Sheet sheet = xb.getSheetAt(0);
            // 获取最后行号
            int lastRowNum = sheet.getLastRowNum();
            if (lastRowNum > 0) { // 如果>0，表示有数据
//                out("\n开始读取名为【" + sheet.getSheetName() + "】的内容：",showInfo);
                System.out.println("总行数:"+lastRowNum);
            }
            Row row = null;

            // 循环读取
            List<Map<String,Object>> paramList = new ArrayList<>();
            for (int i = 1; i <= lastRowNum ; i++) {
                row = sheet.getRow(i);
                if (row != null) {
//                    System.out.println("第" + (i + 1) + "行："+row.toString());
                    // 获取每一单元格的值
//                    for (int j = 0; j < row.getLastCellNum(); j++) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        String C_BoroughName = row.getCell(0).getStringCellValue();
                        String C_BuildingName = row.getCell(1).getStringCellValue();
                        Cell cell1 = row.getCell(4);
                        String C_CardNum = null;
                        if(cell1 != null) {
                            C_CardNum = cell1.getStringCellValue();
                        }
                        String C_EnrolAddress = null;
                        Cell cell2 = row.getCell(7);
                        if(cell2 != null) {
                            C_EnrolAddress = cell2.getStringCellValue();
                        }
                        Cell cell = row.getCell(5);
                        String C_RoomNum = null;
                        if(cell != null) {
                            C_RoomNum = cell.getStringCellValue();
                        }
                        double I_Cell = row.getCell(6).getNumericCellValue();
                        double I_BoroughID = row.getCell(2).getNumericCellValue();
                        double I_BuildingID = row.getCell(8).getNumericCellValue();
                        double I_RoomID = row.getCell(3).getNumericCellValue();
                        hashMap.put("C_BoroughName",C_BoroughName);
                        hashMap.put("C_BuildingName",C_BuildingName);
                        hashMap.put("C_CardNum",C_CardNum);
                        hashMap.put("C_EnrolAddress",C_EnrolAddress);
                        hashMap.put("C_RoomNum",C_RoomNum);
                        hashMap.put("I_Cell",I_Cell+"");
                        hashMap.put("I_BoroughID",I_BoroughID);
                        hashMap.put("I_BuildingID",I_BuildingID);
                        hashMap.put("I_RoomID",I_RoomID);
                        paramList.add(hashMap);
//                    }
                }
            }
            insert2(paramList);
            xb.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{

        }
    }

    public void insert2(List<Map<String,Object>> paramList) throws SQLException,NumberFormatException {
        if(paramList == null){
            return;
        }
        Connection conn = null;
        conn = JDBCUtil.getConnection();
        for (Map<String, Object> paramMap : paramList) {
            try {
                String C_BoroughName = (String) paramMap.get("C_BoroughName");
                String C_BuildingName = (String) paramMap.get("C_BuildingName");
                String C_CardNum = (String) paramMap.get("C_CardNum");
                String C_EnrolAddress = (String) paramMap.get("C_EnrolAddress");
                String C_RoomNum = (String) paramMap.get("C_RoomNum");
                String I_Cell = (String) paramMap.get("I_Cell");
                Double iBoroughID = (Double)paramMap.get("I_BoroughID");
                Integer I_BoroughID =Integer.valueOf(iBoroughID.intValue());
                Double iBuildingID = (Double) paramMap.get("I_BuildingID");
                Integer I_BuildingID = Integer.valueOf(iBuildingID.intValue());
                Double iRoomID = (Double) paramMap.get("I_RoomID");
                Integer I_RoomID = Integer.valueOf(iRoomID.intValue());
                String sql = "INSERT INTO cardnumberaddress (C_BoroughName,C_BuildingName,C_CardNum,C_EnrolAddress,C_RoomNum,I_Cell,I_BoroughID,I_BuildingID,I_RoomID) VALUES (?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1,C_BoroughName);
                ps.setString(2,C_BuildingName);
                if(C_CardNum == null){
                    ps.setNull(3, 12);
                }else {
                    ps.setString(3, C_CardNum);
                }
                if(C_EnrolAddress == null){
                    ps.setNull(4,12);
                }else {
                    ps.setString(4, C_EnrolAddress);
                }
                if(C_RoomNum == null){
                    ps.setNull(5,12);
                }else {
                    ps.setString(5, C_RoomNum);
                }
                ps.setString(6,I_Cell);
                ps.setInt(7,I_BoroughID);
                ps.setInt(8,I_BuildingID);
                ps.setInt(9,I_RoomID);
                int i = ps.executeUpdate();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
//                JDBCUtil.close(rs, stmt, conn);
            }
        }
        conn.close();
    }


}