package ru.kuzina;

import java.awt.*;
import java.awt.geom.Path2D;

//Класс "Многоугольник", реализующий интерфейс фигуры.
class Polygon extends Deq implements Figure {
    private double s, p;

    public Polygon(R2Point a, R2Point b, R2Point c){
        pushFront(b);

        if (b.light(a, c)){
            pushFront(a);
            pushBack(c);
        }
        else{
            pushFront(c);
            pushBack(a);
        }

        p = R2Point.dist(a, b) + R2Point.dist(b, c)+ R2Point.dist(c, a);
        s = Math.abs(R2Point.area(a, b, c));
    }

    public double perimeter(){
        return p;
    }

    public double area(){
        return s;
    }

    private void grow(R2Point a, R2Point b, R2Point t){
        p -= R2Point.dist(a, b);
        s += Math.abs(R2Point.area(a, b, t));
    }

    public Figure add(R2Point t){
        int i;
        //Ищем освещенные ребра, просматривая их одно за другим.
        for(i = length(); i>0 && !t.light(back(), front()); i--)
            pushBack(popFront());

        //УТВЕРЖДЕНИЕ:
        //либо ребро [back(), front()] освещено из t,
        //либо освещенных ребер нет совсем.
        if (i>0){
            R2Point x;
            grow(back(), front(), t);

            //Удаляем все освещенные ребра из начала дека.
            for(x = popFront(); t.light(x, front()); x = popFront())
                grow(x, front(), t);
            pushFront(x);

            //Удаляем все освещенные ребра из конца дека.
            for (x = popBack(); t.light(back(), x); x = popBack())
                grow(back(), x, t);
            pushBack(x);

            //Завершаем обработку добавляемой точки.
            p += R2Point.dist(back(), t) + R2Point.dist(t, front());
            pushFront(t);
        }

        return this;
    }

    public void draw(Graphics g){

        Path2D p = new Path2D.Double();
        double mv_to_x = front().getX();
        double mv_to_y = -front().getY();
        p.moveTo(mv_to_x, mv_to_y);

        for (int i = 0; i < length(); i++) {

            double ln_to_x = front().getX();
            double ln_to_y = -front().getY();
            p.lineTo(ln_to_x, ln_to_y);
            pushBack(popFront());
        }

        p.closePath();
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(new Color(255, 50, 234));
        graphics2D.fill(p);

    }
}