public class Bicycle {

    String color;
    int size;
    int numberOfWheels;
    int wheelsDiameter;

    public Bicycle(String color) {
        this.color = color;
    }

    public Bicycle() {

    }

    public void ride(){
        System.out.println("WE ARE RIDING");
    }

    public void turnLeft(){

    }

    public void turnRight(){

    }

    public String getColor() {
        return this.color;
    }
}