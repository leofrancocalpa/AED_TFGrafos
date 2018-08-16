package generadorCasos;

import java.util.ArrayList;

public class Generador {
	
	public Generador() {
		
	}
	
	public int[][] cordenadas25(){
		int[][] salida = {
				{500,418},
				{289,375},
				{667,370},
				{409,258},
				{985,280},
				{867,520},
				{839,419},
				{713,318},
				{100,474},
				{244,145},
				{711,210},
				{480,239},
				{641,186},
				{545,272},
				{803,305},
				{665,463},
				{108,107},
				{957,289},
				{508,133},
				{619,69},
				{658,276},
				{334,52},
				{429,197},
				{394,239},
				{703,240}};
		return salida;
	}
	
	public int[][] cordenadas30(){
		int[][] salida = {
				{401,377},
				{1015,225},
				{846,220},
				{571,339},
				{713,318},
				{100,474},
				{244,145},
				{711,210},
				{480,239},
				{641,186},
				{545,272},
				{803,305},
				{293,259},
				{1041,120},
				{918,304},
				{712,114},
				{369,159},
				{667,370},
				{409,258},
				{985,280},
				{867,520},
				{665,463},
				{108,107},
				{121,139},
				{405,485},
				{768,339},
				{536,435},
				{839,419},
				{508,133},
				{619,69}};
		return salida;
	}
	
	public int[][] cordenadas28(){
		int[][] salida ={
				{401,377},
				{1015,225},
				{665,463},
				{108,107},
				{121,139},
				{711,210},
				{480,239},
				{641,186},
				{545,272},
				{803,305},
				{293,259},
				{1041,120},
				{918,304},
				{712,114},
				{369,159},
				{667,370},
				{409,258},
				{985,280},
				{867,520},
				{405,485},
				{768,339},
				{846,220},
				{571,339},
				{713,318},
				{100,474},
				{244,145},
				{536,435},
				{839,419}};
		return salida;
	}
	
	public int[][] darCordenadas(int n){
		if(n==25) {
			return cordenadas25();
		}
		if(n==30) {
			return cordenadas30();
		}
		if(n==28) {
			return cordenadas28();
		}
		else{
			return null;
		}
	}
	
	public void generarDatos(String[] nombres,String[] ids, int[][] matriz) {
//		nombres = new String[n];
//		ids = new String[n];
//		matriz = new int[n][n];
		
		for(int i=0; i<matriz.length; i++) {
			nombres[i]=(i+1)+"";
			ids[i]=(i+1)+"";
			for(int j=i; j<matriz.length; j++) {
				if(i==j) {
					matriz[i][j]=0;
				}else{
					int a = (int)Math.rint(Math.random());
					matriz[i][j]=a;
					matriz[j][i]=a;
				}
				
			}
		}
		
	}

}
