package dataprovider;

import org.testng.annotations.DataProvider;

public class FBSupplyDataToAnotherClass {
	@DataProvider
    public Object[][] supplyTheData() {
		Object[][] obj = new Object[3][4];
		//firstpersondata
		obj[0][0]="aish";
		obj[0][1]="g";
		obj[0][2]="1234567890";
		obj[0][3]="abc";
		//secondpersondata
		obj[1][0]="vish";
		obj[1][1]="n";
		obj[1][2]="2345678901";
		obj[1][3]="def";
		//thirdpersondata
		obj[2][0]="nish";
		obj[2][1]="d";
		obj[2][2]="3456789012";
		obj[2][3]="ghi";
		return obj;
				}
	
}
