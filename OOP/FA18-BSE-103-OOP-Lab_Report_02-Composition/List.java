public class List{
    private int[] items;
    public List(int[] items){
        this.items=items;
    }
    public List(){
        items=new int[0]; 
    }
    
    public void append(int value){
        copyElements();
        items[items.length - 1] = value;
    }
    
    private void copyElements(){
        int[] newList =new  int[items.length + 1];
        for(int i=0;i<items.length;i++){
            newList[i]=items[i];
        }
        
        items=newList;
        //won't delete previous data gc garbage collector
    }
    
    public void print(){
        System.out.print("[");
        for(int i=0; i <items.length-1;i++){
            System.out.print(items[i]+", ");
        }
        System.out.println(items[items.length-1]+"]");
    }
    
}