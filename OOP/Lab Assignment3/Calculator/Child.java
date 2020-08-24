    public class Child extends Parent{
        int b;
        public Child(){
            super(2);
            System.out.println();
            
        }
        
        public void sum(int a,int b){
           
        }
        
        private Child add(int b){
         return new Child();
        }
        public String toString(){
            return "Child";
        }
    
}