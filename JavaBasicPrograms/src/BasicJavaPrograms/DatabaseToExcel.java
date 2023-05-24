package BasicJavaPrograms;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DatabaseToExcel {
	
	public static String createFilepath(String filename)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMMYYYYHHmm");
		Date dt = new Date();
		String dateStr = formatter.format(dt);
		String file = filename + dateStr + ".xlsx";
		String filepath = "C:\\\\testingrelated\\\\" + file;
		return filepath;
	}
	
	

	public static void main(String[] args) throws IOException {

		String filepath = createFilepath("testdata");
		FileOutputStream fos = new FileOutputStream(new File(filepath));
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("LoginData");
		XSSFRow ro = sheet.createRow(0);
		XSSFCell cell = ro.createCell(0);
		XSSFCreationHelper createHelper = wb.getCreationHelper();
		XSSFCellStyle currencyCellStyle = wb.createCellStyle();
		currencyCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("0.00"));
		cell.setCellValue("Value 1");
		cell.setCellStyle(currencyCellStyle);
		cell = ro.createCell(1);
		cell.setCellValue("Value 2");
		cell.setCellStyle(currencyCellStyle);
		cell = ro.createCell(2);
		cell.setCellValue("Date Field");
		
		XSSFCellStyle cellstyle = wb.createCellStyle();
		cellstyle.setDataFormat(createHelper.createDataFormat().getFormat("MMM : DD : YYYY"));
		
		
		
		for(int i =1;i<11;i++)
		{
			ro = sheet.createRow(i);
			int j = 0;
			cell = ro.createCell(j++);
			cell.setCellValue((int) (Math.random() * 10) + 1);
			cell = ro.createCell(j++);
			cell.setCellValue((int) (Math.random() * 10) + 1);
			cell = ro.createCell(j);
			cell.setCellValue(new Date());
			cell.setCellStyle(cellstyle);
			
		}
		try {
			wb.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		try {
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		FileInputStream fis = new FileInputStream(new File(filepath));
		XSSFWorkbook wb1 = new XSSFWorkbook(fis);
		XSSFSheet shet = wb1.getSheetAt(0);
		int rowcount = shet.getLastRowNum();
		System.out.println("Total number of rows in the Sheet is " + rowcount);
		XSSFRow row;
		XSSFCell cel;
		for(int i=0;i<rowcount;i++)
		{
			row = shet.getRow(i);
			int cellcount = row.getLastCellNum();
			for(int j=0;j<cellcount;j++)
			{
					cel = row.getCell(j);
					CellType ct = cel.getCellType();
					switch(ct)
					{
					case STRING: System.out.println("String " + cel.getStringCellValue());
								 break;
					case NUMERIC: System.out.println("Numeric " + cel.getNumericCellValue());
								  break;
					case BOOLEAN: System.out.println("Boolean " + cel.getBooleanCellValue());
								  break;
					}
				    System.out.print(row.getCell(j)+ " ");
			}
			System.out.println();
		}
		
//		REading from Database
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/personaldatabase","root","Mysql4rebu");
													
		String sqlStatement = "select * from employee where empAge > 8";
		PreparedStatement ps = con.prepareStatement(sqlStatement);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			int id = rs.getInt("empID");
			String name = rs.getString("empName");
			System.out.println("ID " + id + " Name " + name);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
