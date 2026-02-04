class Area_Calculator {

    double area(double side) {
        return side * side;
    }

    double area(double length, double breadth) {
        return length * breadth;
    }

    double area(int radius) {
        return 3.14 * radius * radius;
    }

    public static void main(String[] args) {
        Area_Calculator obj = new Area_Calculator();

        System.out.println("Area of Square: " + obj.area(10.1));
        System.out.println("Area of Rectangle: " + obj.area(7, 8));
        System.out.println("Area of Circle: " + obj.area(7));
    }
}