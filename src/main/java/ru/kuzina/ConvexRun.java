package ru.kuzina;

//Тест для выпуклой оболочки.
class ConvexRun {

    public static void main(String[] args) throws Exception {
        Convex convex = new Convex();

        Window w = new Window(convex);

        while (true) {
            convex.add(new R2Point());
            w.add();
            System.out.println("S = " + convex.area() + ", P = " + convex.perimeter());
        }
    }
}
