import  java.util.*;
class LinkedStack implements IStackable{
	private LinkedList l = new LinkedList();
	public int size(){
		return (l.size());
	}
	public void push(int v){
		l.addFirst(v);
	}
	public int pop(){
		if(l.size()>0){
			int x= (int) l.removeFirst();
			return (x);
		}
		else{
			return -1;}
		
		
	}
}
