package dataMining;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.ui.ApplicationFrame;

public class Task2 {
	
	public static void main(String[] args) throws Exception {
		System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
		List<Data> list = new FileReader().readFromFile("res/Analysis.txt");
		List<Double> list_apart = printVal("mxPH", list);
		DefaultCategoryDataset ds = new DefaultCategoryDataset();
		double min = list_apart.get(0);
		double max = list_apart.get(list_apart.size()-1);
		double step = 0.1;
		int num = (int) ((max-min)/step);
		int i = 0;
        for(int n=0;n<num;n++){
        	int k = 0;
        	for(;list_apart.get(i)<min+n*step&&i<list_apart.size();i++){
        		k++;
        	}
        	ds.addValue(k, "value", Integer.toString(n));
        }
        JFreeChart chart = ChartFactory.createBarChart3D(  
        		"mxPH", //ͼ�����  
                "number", //Ŀ¼�����ʾ��ǩ  
                "value", //��ֵ�����ʾ��ǩ  
                ds, //���ݼ�  
                PlotOrientation.VERTICAL, //ͼ����  
                true, //�Ƿ���ʾͼ�������ڼ򵥵���״ͼ����Ϊfalse  
                false, //�Ƿ�������ʾ����  
                false);         //�Ƿ�����url����  
        ApplicationFrame a = new ApplicationFrame("mxPH");
        a.setContentPane(new ChartPanel(chart));
        a.pack();
        a.setVisible(true);
	}
	private static List<Double> printVal(String name,List<Data> list){
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
		//System.out.println(name+"�����ֵΪ"+max +",����СֵΪ"+min+",��ֵΪ"+(sum/temp.size())+",ȱ��ֵ��"+(list.size()-temp.size())+",��ֵΪ"+me+",�ķ���"+m1+","+m3);
		return temp;
	}
}
