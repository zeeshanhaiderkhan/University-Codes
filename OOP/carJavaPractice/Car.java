public class Car extends Interior implements Body{
    private String color;
    private int doors;
    public String getColor(){
        return color;
    }
    public void changeColor(String newColor){
        color = newColor;
    }
    
    public void openDoor(int doorNo){
        System.out.println("Opening Door NO: "+doorNo);
    }
    public int getDoors(){
        return doors;
    }
    public void changeDoors(int newDoors){
        doors = newDoors;
    }
    
    
    
    
}