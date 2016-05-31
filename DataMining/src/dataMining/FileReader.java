package dataMining;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
	List<Data> readFromFile(String fileName) throws Exception{
		File file = new File(fileName);
		InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
		BufferedReader br = new BufferedReader(reader);
		String lineTxt = null;
		List<Data> list = new ArrayList<>();
        while((lineTxt = br.readLine()) != null){
            Data data = new Data();
            String[] tempData = lineTxt.trim().split("\\s+");
            data.season = tempData[0];
            data.size = tempData[1];
            data.speed = tempData[2];
            data.mxPH = toDouble(tempData[3]);
            data.mnO2 = toDouble(tempData[3+1]);
            data.Cl = toDouble(tempData[4+1]);
            data.NO3 = toDouble(tempData[5+1]);
            data.NH4 = toDouble(tempData[6+1]);
            data.oPO4 = toDouble(tempData[7+1]);
            data.PO4 = toDouble(tempData[8+1]);
            data.Chla = toDouble(tempData[9+1]);
            data.a1 = toDouble(tempData[10+1]);
            data.a2 = toDouble(tempData[11+1]);
            data.a3 = toDouble(tempData[12+1]);
            data.a4 = toDouble(tempData[13+1]);
            data.a5 = toDouble(tempData[14+1]);
            data.a6 = toDouble(tempData[15+1]);
            data.a7 = toDouble(tempData[16+1]);
            list.add(data);
        }		
		return list;
	}
	private double toDouble(String a){
		if(a.contains("X")){
			return -1;
		}else{
			return Double.parseDouble(a);
		}
	}
	public static void main(String[] args) throws Exception {
		new FileReader().readFromFile("res/Analysis.txt");
	}
}
