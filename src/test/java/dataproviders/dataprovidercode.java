package dataproviders;



import java.util.HashMap;

import org.testng.annotations.DataProvider;

import Utils.ExcelHandler;



public class dataprovidercode {
	
	
	@DataProvider(name="Data_provider")
    public static Object[][] dpRemodeDICOMNode() throws Exception 
    {
	String sheetname="data";
	System.getProperty("java.classpath");
	ExcelHandler xl = new ExcelHandler(System.getenv("APPDATA")+"//omkar//input.xlsx");
        
    int cols= xl.getXLColumnCount(sheetname); 
    int rows=xl.getXLRowCount(sheetname);
   
    Object[][] obj=new Object[rows][1];
    
    HashMap<String,String> table=null;

        for(int i=1; i<=rows;i++)
        {            
            table = new HashMap<String,String>();
    
                for(int j=0 ; j<cols; j++)
                {
                try {
                	System.out.println(xl.readXLData(sheetname, 0, j)+","+ xl.readXLData(sheetname, i, j));
                    table.put(xl.readXLData(sheetname, 0, j), xl.readXLData(sheetname, i, j));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                }
    
                obj[i-1][0] = table;
        }
               
        return obj;
    }

	
	
	

}
