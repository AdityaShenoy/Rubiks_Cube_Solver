package rubiks_cube;

import java.io.IOException;

public class Cube {
	private Face right;
	private Face left;
	private Face front;
	private Face back;
	private Face top;
	private Face down;
	public int size;
	
	public Cube(int size){
		this.size = size;
		front = new Face(size, 'G');
		back = new Face(size, 'B');
		top = new Face(size, 'W');
		down = new Face(size, 'Y');
		right = new Face(size, 'R');
		left = new Face(size, 'O');
	}
	
	public void takeInputFromConsole() throws IOException{
			System.out.println("Enter front colors");
			front.inputColorFromConsole();
			System.out.println("Enter left colors");
			left.inputColorFromConsole();
			System.out.println("Enter right colors");
			right.inputColorFromConsole();
			System.out.println("Enter top colors");
			top.inputColorFromConsole();
			System.out.println("Enter back colors");
			back.inputColorFromConsole();
			System.out.println("Enter down colors");
			down.inputColorFromConsole();
	}
	
	public void showCubeOnConsole(){
		for(int i=0;i<size;i++){
			space(2*size + 3);
			for(int j=0;j<size;j++){
				System.out.print(top.getColor(((size*i)+j)) + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				System.out.print(left.getColor(((size*i)+j)) + " ");
			}
			space(3);
			for(int j=0;j<size;j++){
				System.out.print(front.getColor(((size*i)+j)) + " ");
			}
			space(3);
			for(int j=0;j<size;j++){
				System.out.print(right.getColor(((size*i)+j)) + " ");
			}
			space(3);
			for(int j=0;j<size;j++){
				System.out.print(back.getColor(((size*i)+j)) + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i=0;i<size;i++){
			space(2*size + 3);
			for(int j=0;j<size;j++){
				System.out.print(down.getColor(((size*i)+j)) + " ");
			}
			System.out.println();
		}
	}
	
	private void space(int i) {
		for(int j=0; j<i; j++){
			System.out.print(" ");
		}
	}
	
	public boolean isSolved(){
		return (front.isSolved() && back.isSolved() && left.isSolved() && right.isSolved()
				&& top.isSolved() && down.isSolved());
	}
	
	public void R(int n){
		if(n == 1){
			right.turnClockwise();
		}else if(n == size){
			left.turnAnticlockwise();
		}else if(n>size || n<1){
			return;
		}
		for(int i=0; i<size; i++){
			int j = size*(i+1) - n;
			int k = size*(size-1-i) + n - 1;
			char temp = top.getColor(j);
			top.setColor(j, front.getColor(j));
			front.setColor(j, down.getColor(j));
			down.setColor(j, back.getColor(k));
			back.setColor(k, temp);
		}
	}
	public void Ri(int n){
		R2(n);R(n);
	}
	public void R2(int n){
		R(n);R(n);
	}
	public void Rw(int n){
		for(int i=1; i<=n; i++){
			R(i);
		}
	}
	public void Rwi(int n){
		Rw2(n);Rw(n);
	}
	public void Rw2(int n){
		Rw(n);Rw(n);
	}
	public void L(int n){
		Ri(size - n + 1);
	}
	public void Li(int n){
		L2(n);L(n);
	}
	public void L2(int n){
		L(n);L(n);
	}
	public void Lw(int n){
		for(int i=1; i<=n; i++){
			L(i);
		}
	}
	public void Lwi(int n){
		Lw2(n);Lw(n);
	}
	public void Lw2(int n){
		Lw(n);Lw(n);
	}
	public void M(){
		for(int i=2; i<size; i++){
			Ri(i);
		}
	}
	public void Mi(){
		M2();M();
	}
	public void M2(){
		M();M();
	}
	public void x(){
		Rw(size);
	}
	public void xi(){
		x2();x();
	}
	public void x2(){
		x();x();
	}
	
	public void U(int n){
		if(n == 1){
			top.turnClockwise();
		}else if(n == size){
			down.turnAnticlockwise();
		}else if(n<1 || n>size){
			return;
		}
		for(int i=0; i<size; i++){
			int j = size*(n-1) + i;
			char temp = front.getColor(j);
			front.setColor(j, right.getColor(j));
			right.setColor(j, back.getColor(j));
			back.setColor(j, left.getColor(j));
			left.setColor(j, temp);
		}
	}
	public void Ui(int n){
		U2(n);U(n);
	}
	public void U2(int n){
		U(n);U(n);
	}
	public void Uw(int n){
		for(int i=1; i<=n; i++){
			U(i);
		}
	}
	public void Uwi(int n){
		Uw2(n);Uw(n);
	}
	public void Uw2(int n){
		Uw(n);Uw(n);
	}
	public void D(int n){
		Ui(size - n + 1);
	}
	public void Di(int n){
		D2(n);D(n);
	}
	public void D2(int n){
		D(n);D(n);
	}
	public void Dw(int n){
		for(int i=1; i<=n; i++){
			D(i);
		}
	}
	public void Dwi(int n){
		Dw2(n);Dw(n);
	}
	public void Dw2(int n){
		Dw(n);Dw(n);
	}
	public void E(){
		for(int i=2; i<size; i++){
			Ui(i);
		}
	}
	public void Ei(){
		E2();E();
	}
	public void E2(){
		E();E();
	}
	public void y(){
		Uw(size);
	}
	public void yi(){
		y2();y();
	}
	public void y2(){
		y();y();
	}
	
	public void F(int n){
		if(n == 1){
			front.turnClockwise();
		}else if(n == size){
			back.turnAnticlockwise();
		}else if(n<1 || n>size){
			return;
		}
		for(int i=0; i<size; i++){
			int t = (size * (size - n)) + i;
			int l = (size * (size - i)) - n;
			int d = (size * n) - i - 1;
			int r = (size * i) + n - 1;
			char temp = top.getColor(t);
			top.setColor(t, left.getColor(l));
			left.setColor(l, down.getColor(d));
			down.setColor(d, right.getColor(r));
			right.setColor(r, temp);
		}
	}
	public void Fi(int n){
		F2(n);F(n);
	}
	public void F2(int n){
		F(n);F(n);
	}
	public void Fw(int n){
		for(int i=1; i<=n; i++){
			F(i);
		}
	}
	public void Fwi(int n){
		Fw2(n);Fw(n);
	}
	public void Fw2(int n){
		Fw(n);Fw(n);
	}
	public void B(int n){
		Fi(size - n + 1);
	}
	public void Bi(int n){
		B2(n);B(n);
	}
	public void B2(int n){
		B(n);B(n);
	}
	public void Bw(int n){
		for(int i=1; i<=n; i++){
			B(i);
		}
	}
	public void Bwi(int n){
		Bw2(n);Bw(n);
	}
	public void Bw2(int n){
		Bw(n);Bw(n);
	}
	public void S(){
		for(int i=2; i<size; i++){
			F(i);
		}
	}
	public void Si(){
		S2();S();
	}
	public void S2(){
		S();S();
	}
	public void z(){
		Fw(size);
	}
	public void zi(){
		z2();z();
	}
	public void z2(){
		z();z();
	}
}