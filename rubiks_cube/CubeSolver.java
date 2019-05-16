package rubiks_cube;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class CubeSolver {
	private static LinkedList<Character> lc;
	private static LinkedList<Integer> ln;
	private static Cube cube;
	private static int algorithmSize;
	
	public static void findSolution(){
		lc = new LinkedList<>();
		ln = new LinkedList<>();
		cube.R(1);
		lc.add('R');
		ln.add(1);
		while(lc.size() <= algorithmSize){
			if(cube.isSolved()){
				System.out.println(printAlgorithmOnConsole());
			}
			incrementList(0);
		}
	}
	
	private static String printAlgorithmOnConsole(){
		StringBuilder sb = new StringBuilder();
		for(int i=lc.size()-1; i>=0; i--){
			sb.append(ln.get(i));
			sb.append(lc.get(i));
			sb.append(" ");
		}
		for(int i=0; i<3; i++){
			String c, c1, c2, c3, c4, c5;
			if(i==0){c = "R"; c1 = "x"; c2 = "r"; c3 = "l"; c4 = "L"; c5 = "M";}
			else if(i==1){c = "U"; c1 = "y"; c2 = "u"; c3 = "d"; c4 = "D"; c5 = "E";}
			else{c = "F"; c1 = "z"; c2 = "f"; c3 = "b"; c4 = "B"; c5 = "S";}
			StringBuilder rotPrime=new StringBuilder(), rotTwice=new StringBuilder(), rot=new StringBuilder();;
			for(int j=1; j<=cube.size; j++){
				StringBuilder fourTimes = new StringBuilder();
				for(int k=0; k<4; k++){
					fourTimes.append(j);
					fourTimes.append(c);
					fourTimes.append(" ");
				}
				for(int k=0; k<3; k++){
					rotPrime.append(j);
					rotPrime.append(c);
					rotPrime.append(" ");
				}
				for(int k=0; k<2; k++){
					rotTwice.append(j);
					rotTwice.append(c);
					rotTwice.append(" ");
				}
				rot.append(j);
				rot.append(c);
				rot.append(" ");
				if(sb.indexOf(fourTimes.toString()) != -1){
					return "";
				}
			}
			int loc;
			while((loc = sb.indexOf(rotPrime.toString())) != -1){
				sb.replace(loc, loc + rotPrime.length(), c1 + "' ");
			}
			while((loc = sb.indexOf(rotTwice.toString())) != -1){
				sb.replace(loc, loc + rotTwice.length(), c1 + "2 ");
			}
			while((loc = sb.indexOf(rot.toString())) != -1){
				sb.replace(loc, loc + rot.length(), c1 + " ");
			}
			for(int j=cube.size-1; j>1; j--){
				StringBuilder widePrime=new StringBuilder(), wideTwice=new StringBuilder(), wide=new StringBuilder();
				for(int k=1; k<=j; k++){
					for(int l=0; l<3; l++){
						widePrime.append(k);
						widePrime.append(c);
						widePrime.append(" ");
					}
					for(int l=0; l<2; l++){
						wideTwice.append(k);
						wideTwice.append(c);
						wideTwice.append(" ");
					}
					wide.append(k);
					wide.append(c);
					wide.append(" ");
				}
				while((loc=sb.indexOf(widePrime.toString())) != -1){
					sb.replace(loc, loc + widePrime.length(), j + c2 + "' ");
				}
				while((loc=sb.indexOf(wideTwice.toString())) != -1){
					sb.replace(loc, loc + wideTwice.length(), j + c2 + "2 ");
				}
				while((loc=sb.indexOf(wide.toString())) != -1){
					sb.replace(loc, loc + wide.length(), j + c2 + " ");
				}
			}
			for(int j=2; j<cube.size; j++){
				StringBuilder widePrime=new StringBuilder(), wideTwice=new StringBuilder(), wide=new StringBuilder();
				for(int k=j; k<=cube.size; k++){
					for(int l=0; l<3; l++){
						widePrime.append(k);
						widePrime.append(c);
						widePrime.append(" ");
					}
					for(int l=0; l<2; l++){
						wideTwice.append(k);
						wideTwice.append(c);
						wideTwice.append(" ");
					}
					wide.append(k);
					wide.append(c);
					wide.append(" ");
				}
				while((loc=sb.indexOf(widePrime.toString())) != -1){
					sb.replace(loc, loc + widePrime.length(), (cube.size - j + 1) + c3 + " ");
				}
				while((loc=sb.indexOf(wideTwice.toString())) != -1){
					sb.replace(loc, loc + wideTwice.length(), (cube.size - j + 1) + c3 + "2 ");
				}
				while((loc=sb.indexOf(wide.toString())) != -1){
					sb.replace(loc, loc + wide.length(), (cube.size - j + 1) + c3 + "' ");
				}
			}
			StringBuilder slicePrime=new StringBuilder(),sliceTwice=new StringBuilder(),slice=new StringBuilder();
			for(int j=2; j<cube.size; j++){
				for(int k=0; k<3; k++){
					slice.append(j);
					slice.append(c);
					slice.append(" ");
				}
				for(int k=0; k<2; k++){
					sliceTwice.append(j);
					sliceTwice.append(c);
					sliceTwice.append(" ");
				}
				slicePrime.append(j);
				slicePrime.append(c);
				slicePrime.append(" ");
			}
			if(cube.size > 2){
				while((loc = sb.indexOf(slice.toString())) != -1){
					sb.replace(loc, loc + slice.length(), c5 + " ");
				}
				while((loc = sb.indexOf(sliceTwice.toString())) != -1){
					sb.replace(loc, loc + sliceTwice.length(), c5 + "2 ");
				}
				while((loc = sb.indexOf(slicePrime.toString())) != -1){
					sb.replace(loc, loc + slicePrime.length(), c5 + "' ");
				}
			}
			for(int j=1; j<=cube.size; j++){
				StringBuilder prime=new StringBuilder(), twice=new StringBuilder(); 
				for(int k=0; k<3; k++){
					prime.append(j);
					prime.append(c);
					prime.append(" ");
				}
				for(int k=0; k<2; k++){
					twice.append(j);
					twice.append(c);
					twice.append(" ");
				}
				while((loc = sb.indexOf(prime.toString())) != -1){
					sb.replace(loc+1, loc+prime.length(), c+"' ");
				}
				while((loc = sb.indexOf(twice.toString())) != -1){
					sb.replace(loc+1, loc+twice.length(), c+"2 ");
				}
			}
			for(int j=(int)(Math.ceil(cube.size/2.0) + 1); j<=cube.size; j++){
				while((loc = sb.indexOf(String.valueOf(j) + c)) != -1){
					sb.replace(loc, loc+2, String.valueOf(cube.size - j +1) + c4 + "'");
				}
			}
			while((loc = sb.indexOf("2" + c2)) != -1){
				sb.deleteCharAt(loc);
			}
			while((loc = sb.indexOf("2" + c3)) != -1){
				sb.deleteCharAt(loc);
			}
		}
		int loc;
		while((loc = sb.indexOf("1")) != -1){
			sb.deleteCharAt(loc);
		}
		while((loc = sb.indexOf("S'")) != -1){
			sb.replace(loc, loc+2, "s");
		}
		while((loc = sb.indexOf("S")) != -1){
			sb.replace(loc, loc+1, "S'");
		}
		while((loc = sb.indexOf("s")) != -1){
			sb.replace(loc, loc+1, "S");
		}
		while((loc = sb.indexOf("''")) != -1){
			sb.delete(loc, loc+2);
		}
		while((loc = sb.indexOf("'2")) != -1){
			sb.deleteCharAt(loc);
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	
	private static void incrementList(int i){
		try{
			reverseMove(lc.get(i), ln.get(i));
		}catch(IndexOutOfBoundsException e){}
		if(i == lc.size()){
			lc.add('R');ln.add(1);
		}else if(lc.get(i)=='F' && ln.get(i)==cube.size){
			lc.set(i, 'R');ln.set(i, 1);
			incrementList(1+i);
		}else if(ln.get(i) != cube.size){
			ln.set(i, ln.get(i)+1);
		}else{
			if(lc.get(i)=='R'){
				lc.set(i, 'U');
			}else{
				lc.set(i, 'F');
			}
			ln.set(i,1);
		}
		skipParallelMoves(i);
		doMove(lc.get(i),ln.get(i));
	}
	
	private static void reverseMove(char c, int i){
		switch(c){
		case 'R': cube.Ri(i);return;
		case 'U': cube.Ui(i);return;
		case 'F': cube.Fi(i);
		}
	}
	
	private static void doMove(char c, int i){
		switch(c){
		case 'R': cube.R(i);return;
		case 'U': cube.U(i);return;
		case 'F': cube.F(i);
		}
	}
	
	private static void skipParallelMoves(int i){
		for(int j=0; j<cube.size*3; j++){
			try{
				if(lc.get(i+j) == lc.get(i+j+1)){
					if(ln.get(i+j) < ln.get(i+j+1)){
						doMove(lc.get(i), ln.get(i));
						incrementList(i);
						reverseMove(lc.get(i),ln.get(i));
						return;
					}
				}else{
					return;
				}
			}catch(IndexOutOfBoundsException e){
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the size of the cube: ");
		int size = sc.nextInt();
		algorithmSize = (size-1)*15;
		cube = new Cube(size);
		try {
			cube.takeInputFromConsole();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sc.close();
		findSolution();
	}
}