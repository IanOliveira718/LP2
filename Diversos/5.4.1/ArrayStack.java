import java.util.ArrayList;

public class ArrayStack implements IStackable{
    ArrayList l= new ArrayList();
	public int size(){
		return (l.size());
	}
	public void push(int v){
		l.add(v);
	}
	public int pop(){
		if(l.size()>0){
			int x= (int)l.get(l.size()-1);
            l.remove(l.size()-1);
			return (x);
		}
		else{
			return -1;}
		
		
	}
}
