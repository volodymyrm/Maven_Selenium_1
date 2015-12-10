package package_with_tests;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

public class Parser {

    public static String parse(String name) {
        String result = "";
        InputStream in = null;
        HSSFWorkbook wb = null;
        try {
            in = new FileInputStream(name);
            wb = new HSSFWorkbook(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sheet sheet = wb.getSheetAt(0);
        Iterator<Row> it = sheet.iterator();
        while (it.hasNext()) {
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            while (cells.hasNext()) {
                Cell cell = cells.next();
                int cellType = cell.getCellType();
                switch (cellType) {
                    case Cell.CELL_TYPE_STRING:
                        result += cell.getStringCellValue() + "=";
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        result += "[" + cell.getNumericCellValue() + "]";
                        break;

                    case Cell.CELL_TYPE_FORMULA:
                        result += "[" + cell.getNumericCellValue() + "]";
                        break;
                    default:
                        result += "|";
                        break;
                }
            }
            result += "\n";
        }

        return result;
    }

    public static String parseErrorMsg(String element, String errortype) {
        String filename = Page.translationPage;
        String lang = Tests.language;
        HSSFWorkbook wb = null;
        try {
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(filename));
            wb = new HSSFWorkbook(fs);
        } catch (Exception e) {
            return null;
        }

        HSSFSheet sheet = wb.getSheetAt(0);
        String result="";

        int maxRow = 0;
        int maxCell = 0;
        Iterator<Row> it = sheet.iterator();

        while (it.hasNext()) {
            maxCell = 0;
            Row row = it.next();
            Iterator<Cell> cells = row.iterator();
            maxRow ++;
            while (cells.hasNext()) {
                Cell cell = cells.next();
                maxCell++;
            }
        }

        //System.out.print("maxRow = "+ maxRow + "\n");
        //System.out.print("maxCell = "+ maxCell + "\n");

        for (int i=0; i<maxRow; i++){
            HSSFRow row = sheet.getRow(i);
            for (int j=0; j<maxCell; j++){
                HSSFCell cell = row.getCell(j);
                if (row.getCell(j) != null &&
                        row.getCell(0).getRichStringCellValue().getString().equals(element) &&
                            row.getCell(1).getRichStringCellValue().getString().equals(errortype) &&
                                sheet.getRow(0).getCell(j).getRichStringCellValue().getString().equals(lang)){
                    result += cell.getRichStringCellValue().getString();
                }
            }
        }
        return result;
    }
}
