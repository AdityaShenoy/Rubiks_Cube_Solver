package rubiks_cube;

import java.util.Scanner;

public class Face {
	private byte size;
	private byte[] colors;
	
	public Face(int size, char c){
		this.size = (byte)size;
		colors = new byte[size*size];
		for(int i=0; i<(size*size); i++){
			colors[i] = (byte)c;
		}
	}
	
	public char getColor(int i){
		return (char)(colors[i]);
	}
	
	public void inputColorFromConsole(){
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		byte[] allowedColor = {'B','G','O','R','W','Y'};
		for(int i=0;i<(size*size);i++)
		{
			System.out.print("Enter colour " + (i+1) + " ");
			colors[i] = (byte)(Character.toUpperCase(input.next().charAt(0)));
			if((new String(allowedColor).
					indexOf(colors[i])) == -1){
				System.out.println("Entered input is not a valid Rubik colour."
						+ "\nEnter the colour again");
				i--;
			}
		}
	}
	
	public boolean isSolved(){
		for(byte x:colors){
			if(x!=colors[0]){
				return false;
			}
		}
		return true;
	}
	
	public void setColor(int pos,char c){
		colors[pos] = (byte)c;
	}
	
	public void showColorOnConsole(){
		for(int i=0;i<(size*size);i++){
			System.out.print(Character.toUpperCase((char)colors[i]));
			if((i+1)%size != 0){
				System.out.print(" ");
			}
			else{
				System.out.println();
			}
		}
	}
	
	public void turnAnticlockwise(){
		byte[] temp = new byte[size*size];
		int i=0;
		for(int j=(size*(size-1)); j<(size*size); j++){
			for(int k=0; k<size; k++){		
				temp[j - (k*size)] = colors[i++];
			}
		}
		colors = temp;
	}
	
	public void turnClockwise(){
		byte[] temp = new byte[size*size];
		int i=0;
		for(int j=(size*(size-1)); j<(size*size); j++){
			for(int k=0; k<size; k++){		
				temp[i++] = colors[j - (k*size)];
			}
		}
		colors = temp;
	}
}