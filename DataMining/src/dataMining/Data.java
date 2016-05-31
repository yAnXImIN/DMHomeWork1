package dataMining;

public class Data {
	public static final double NO_EXIST = -1;
	public String season;
	public String size;
	public String speed;
	public double mxPH;
	public double mnO2;
	public double Cl;
	public double NO3;
	public double NH4;
	public double oPO4;
	public double PO4;
	public double Chla;
	public double a1;
	public double a2;
	public double a3;
	public double a4;
	public double a5;
	public double a6;
	public double a7;
	public double getIndex(String a){
		if(a.equals("mxPH")){
			return mxPH;
		}
		if(a.equals("mnO2")){
			return mnO2;
		}
		if(a.equals("Cl")){
			return Cl;
		}
		if(a.equals("NO3")){
			return NO3;
		}
		if(a.equals("NH4")){
			return NH4;
		}
		if(a.equals("oPO4")){
			return oPO4;
		}
		if(a.equals("PO4")){
			return PO4;
		}
		if(a.equals("Chla")){
			return Chla;
		}
		if(a.equals("a1")){
			return a1;
		}
		if(a.equals("a2")){
			return a2;
		}
		if(a.equals("a3")){
			return a3;
		}
		if(a.equals("a4")){
			return a4;
		}
		if(a.equals("a5")){
			return a5;
		}
		if(a.equals("a6")){
			return a6;
		}
		if(a.equals("a7")){
			return a7;
		}
		return 0;
	}
}
