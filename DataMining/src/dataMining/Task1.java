package dataMining;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task1 {
	public static void main(String[] args) throws Exception {
		System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
		List<Data> list = new FileReader().readFromFile("res/Analysis.txt");
		printSeason(list);
		printSize(list);
		printSpeed(list);
		printVal("mxPH", list);
		printVal("mnO2", list);
		printVal("Cl", list);
		printVal("NO3", list);
		printVal("NH4", list);
		printVal("oPO4", list);
		printVal("PO4", list);
		printVal("Chla", list);
		printVal("a1", list);
		printVal("a2", list);
		printVal("a3", list);
		printVal("a4", list);
		printVal("a5", list);
		printVal("a6", list);
		printVal("a7", list);
	}
	private static void printSeason(List<Data> list){
		int winter=0;
		int spring=0;
		int autumn=0;
		int summer=0;
		for(int i=0;i<list.size();i++){
			if(list.get(i).season.equals("winter"))
				winter++;
			if(list.get(i).season.equals("spring"))
				spring++;
			if(list.get(i).season.equals("autumn"))
				autumn++;
			if(list.get(i).season.equals("summer"))
				summer++;
		}
		System.out.println("winter 频数 ：" + winter);
		System.out.println("spring 频数 ：" + spring);
		System.out.println("autumn 频数 ：" + autumn);
		System.out.println("summer 频数 ：" + summer);
	}
	private static void printSize(List<Data> list){
		int small=0;
		int medium=0;
		int large=0;
		for(int i=0;i<list.size();i++){
			if(list.get(i).size.equals("small"))
				small++;
			if(list.get(i).size.equals("medium"))
				medium++;
			if(list.get(i).size.equals("large"))
				large++;
		}
		System.out.println("small 频数 ：" + small);
		System.out.println("spring 频数 ：" + medium);
		System.out.println("autumn 频数 ：" + large);
	}
	private static void printSpeed(List<Data> list){
		int low=0;
		int medium=0;
		int high=0;
		for(int i=0;i<list.size();i++){
			if(list.get(i).speed.equals("low"))
				low++;
			if(list.get(i).speed.equals("medium"))
				medium++;
			if(list.get(i).speed.equals("high"))
				high++;
		}
		System.out.println("low 频数 ：" + low);
		System.out.println("medium 频数 ：" + medium);
		System.out.println("high 频数 ：" + high);
	}
	private static void printVal(String name,List<Data> list){
		double sum = 0;
		double max = 0;
		double min = 9999;
		List<Double> temp = new ArrayList<>();
		for(int i=0;i<list.size();i++){
			if(list.get(i).getIndex(name) != Data.NO_EXIST){
				temp.add(list.get(i).getIndex(name));
				if(max<list.get(i).getIndex(name)){
					max = list.get(i).getIndex(name);
				}
				if(min>list.get(i).getIndex(name)){
					min = list.get(i).getIndex(name);
				}
				sum+=list.get(i).getIndex(name);
			}
		}
		temp.sort(new Comparator<Double>() {

			@Override
			public int compare(Double o1, Double o2) {
				if(o1-o2>0)
					return 1;
				else
					return -1;
			}
		});
		double me = 0;
		if(temp.size()%2==1){
			me = temp.get(temp.size()/2);
		}else{
			me = temp.get(temp.size()/2)+temp.get((temp.size()-1)/2);
			me/=2;
		}
		double m1 = temp.get((temp.size()+1)/4-1);
		double m3 = temp.get((temp.size()+1)/4*3-1);
		System.out.println(name+"的最大值为"+max +",最小值为"+min+",均值为"+(sum/temp.size())+",缺少值有"+(list.size()-temp.size())+",中值为"+me+",四分数"+m1+","+m3);
	}
}
