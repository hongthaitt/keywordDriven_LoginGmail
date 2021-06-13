package Excute;

import Operation.UIOperation;
import ReadFileExcel.ReadExcel;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Before;
import org.junit.Test;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class executeTest {
    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
    }
    @Test
    public void search() throws Exception {
        ReadExcel file = new ReadExcel();
        UIOperation operation = new UIOperation();
        Sheet sheet = file.readExcel("D:\\autotest\\Code\\Testcase"+"\\","TestcaseLoginGmail.xlsx" , "LoginGmail");
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        for (int i = 1; i < rowCount+1; i++) {
            Row row = sheet.getRow(i);
            if( row.getCell(4).toString().length()!=0){
                operation.perform(row.getCell(4).toString(), row.getCell(5).toString(), row.getCell(6).toString(),
                        row.getCell(7).toString());
                System.out.println("Step: "+ row.getCell(3).toString());
            }
            else{
                System.out.println("end step...........");
            }

        }
    }

}
