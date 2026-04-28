public class overriding {

    interface Shape {
        void area();
    }

    static class Circle implements Shape {
        int r;

        Circle(int r) {
            this.r = r;
        }

        public void area() {
            System.out.println("Circle area = " + (3.14 * r * r));
        }
    }

    static class Rectangle implements Shape {
        int l, b;

        Rectangle(int l, int b) {
            this.l = l;
            this.b = b;
        }

        public void area() {
            System.out.println("Rectangle area = " + (l * b));
        }
    }

    public static void main(String[] args) {

        Circle c = new Circle(7);
        Rectangle r = new Rectangle(10, 5);

        c.area();
        r.area();
    }
}