package utils;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
		 
 		private static XSSFSheet ExcelWSheet;

 		private static XSSFWorkbook ExcelWBook;

 		private static XSSFCell Cell;

 		private static XSSFRow Row;

		//设定要操作Excel的文件路径和Excel文件中的Sheet名称
 		//在读/写Excel的时候，均需要先调用此方法，设定要操作的Excel文件路径和要操作的Sheet名称

		public static void setExcelFile(String Path,String SheetName) throws Exception {

			try {

    			//实例化Excel 文件的FileInputStream对象

				FileInputStream ExcelFile = new FileInputStream(Path);

				
              //实例化Excel文件的XSSFWorkbook对象
				ExcelWBook = new XSSFWorkbook(ExcelFile);
				// 实例化XSSFSheet对象，指定Excel文件中的Sheet名称，后续用于Sheet 中行、列和单元格的操作
				ExcelWSheet = ExcelWBook.getSheet(SheetName);

				} catch (Exception e){

					throw (e);

				}

		}

		//读取Excel 文件指定单元格的函数

	    public static String getCellData(int RowNum, int ColNum) throws Exception{

			try{
        //通过函数参数指定单元格的行号和列号，获取指定的单元格对象
   			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

   			String CellData = Cell.getCellType()==XSSFCell.CELL_TYPE_STRING? Cell.getStringCellValue()+"":
   				String.valueOf(Math.round(Cell.getNumericCellValue()));

   			return CellData;

   			}catch (Exception e){

					return"";

   			}

	    }

		//在Excel文件的执行单元格中写入数据

		public static void setCellData(String Result,  int RowNum, int ColNum) throws Exception	{

			try{
           //获取Excel 文件中的行对象
   			Row  = ExcelWSheet.getRow(RowNum);
   		  //如果单元格为空，则返回Null
				Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
          
				if (Cell == null) {
          //当单元格对象是NULL的时候，则创建单元格
	      //如果单元格为空，无法直接调用单元格对象的setCellValue方法设定单元格的值		
					Cell = Row.createCell(ColNum);
          //创建单元格后可以调用单元格对象的setCellValue方法设定单元格的值
					Cell.setCellValue(Result);

					} else {
         //单元格中有内容，则 可以直接调用单元格对象的setCellValue方法设定单元格的值
						Cell.setCellValue(Result);

					}

   // 实例化写入Excel文件的文件输出流对象

   				FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData + Constant.File_TestData);
  //讲内容写入Excel文件中
   				ExcelWBook.write(fileOut);
  //调用Flush方法强制刷新写入文件
   				fileOut.flush();
  //关闭文件输出流对象
					fileOut.close();

					}catch(Exception e){

						throw (e);

				}

			}

}


