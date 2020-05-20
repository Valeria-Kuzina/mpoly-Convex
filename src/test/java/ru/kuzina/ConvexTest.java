package ru.kuzina;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvexTest {
    Convex convex = new Convex();
    ArrayList<double[]> data = new ArrayList<>();

    ///     ПРЯМОУГОЛЬНИКИ     ///

    @Test
    // Прямоугольник 50% ниже у = 0
    public void rectangle50percent() {
        data.add(new double[]{100, 100});
        data.add(new double[]{100, -100});
        data.add(new double[]{0, 100});
        data.add(new double[]{0, -100});

        for (double[] point : data) {
            R2Point p = new R2Point(point[0], point[1]);
            convex.add(p);
        }
        assertEquals(300, convex.perimeter());
    }

    @Test
    // Прямоугольник ниже у = 0
    public void rectangleUnderY() {
        data.add(new double[]{-200, -10});
        data.add(new double[]{-200, -40});
        data.add(new double[]{200, -40});
        data.add(new double[]{200, -10});

        for (double[] point : data) {
            R2Point p = new R2Point(point[0], point[1]);
            convex.add(p);
        }
        assertEquals(0, convex.perimeter());
    }

    @Test
    // Прямоугольник выше у = 0
    public void rectangleOverY() {
        data.add(new double[]{150, 10});
        data.add(new double[]{-100, 10});
        data.add(new double[]{150, 100});
        data.add(new double[]{-100, 100});

        for (double[] point : data) {
            R2Point p = new R2Point(point[0], point[1]);
            convex.add(p);
        }
        assertEquals(680, convex.perimeter());
    }

    @Test
    // Прямоугольник на оси OY 100
    public void rectangleOnY() {
        data.add(new double[]{100, 0});
        data.add(new double[]{200, 0});
        data.add(new double[]{100, 100});
        data.add(new double[]{200, 100});

        for (double[] point : data) {
            R2Point p = new R2Point(point[0], point[1]);
            convex.add(p);
        }
        assertEquals(400, convex.perimeter());
    }

    ///     ТРЕУГОЛЬНИКИ     ///

    @Test
    // Треугольник пересекающий осью OY
    public void triangleIntersectingOY() {
        data.add(new double[]{100, 100});
        data.add(new double[]{-20, -50});
        data.add(new double[]{20, 50});

        for (double[] point : data) {
            R2Point p = new R2Point(point[0], point[1]);
            convex.add(p);
        }
        assertEquals(314, (int) convex.perimeter());
    }

    @Test
    // Треугольник под осью OY
    public void triangleUnderOY() {
        data.add(new double[]{-50, -50});
        data.add(new double[]{-150, -50});
        data.add(new double[]{-150, -150});

        for (double[] point : data) {
            R2Point p = new R2Point(point[0], point[1]);
            convex.add(p);
        }
        assertEquals(0, (int) convex.perimeter());
    }

    @Test
    // Треугольник над осью OY
    public void triangleOverOY() {
        data.add(new double[]{50, 50});
        data.add(new double[]{150, 50});
        data.add(new double[]{150, 150});

        for (double[] point : data) {
            R2Point p = new R2Point(point[0], point[1]);
            convex.add(p);
        }
        assertEquals(341, (int) convex.perimeter());
    }

    @Test
    // Треугольник на оси OY
    public void triangleOnOY() {
        data.add(new double[]{-100, 0});
        data.add(new double[]{-20, 0});
        data.add(new double[]{-20, 150});

        for (double[] point : data) {
            R2Point p = new R2Point(point[0], point[1]);
            convex.add(p);
        }
        assertEquals(400, convex.perimeter());
    }

    ///     Остальное    ///

    @Test
    // Выпуклый пятиугольник
    public void pentahedron() {
        data.add(new double[]{50, 50});
        data.add(new double[]{10, 100});
        data.add(new double[]{-50, 50});
        data.add(new double[]{-20, -20});
        data.add(new double[]{40, -50});

        for (double[] point : data) {
            R2Point p = new R2Point(point[0], point[1]);
            convex.add(p);
        }
        assertEquals(251, (int) convex.perimeter());
    }

    @Test
    // Отрезок над осью OY
    public void segmentOverOY() {
        data.add(new double[]{50, 50});
        data.add(new double[]{150, 150});

        for (double[] point : data) {
            R2Point p = new R2Point(point[0], point[1]);
            convex.add(p);
        }
        assertEquals(282, (int) convex.perimeter());
    }

    @Test
    // Отрезок под осью OY
    public void segmentUnderOY() {
        data.add(new double[]{-50, -50});
        data.add(new double[]{-150, -50});

        for (double[] point : data) {
            R2Point p = new R2Point(point[0], point[1]);
            convex.add(p);
        }
        assertEquals(0, convex.perimeter());
    }

    @Test
    // Отрезок на оси OY
    public void segmentOnOY() {
        data.add(new double[]{50, 0});
        data.add(new double[]{-50, 0});

        for (double[] point : data) {
            R2Point p = new R2Point(point[0], point[1]);
            convex.add(p);
        }
        assertEquals(200, convex.perimeter());
    }


    @Test
    // Точка
    public void Point() {
        data.add(new double[]{-50, 50});

        for (double[] point : data) {
            R2Point p = new R2Point(point[0], point[1]);
            convex.add(p);
        }
        assertEquals(0, convex.perimeter());
    }

    @Test
    // Выпуклый семиугольник
    public void heptagon() {
        data.add(new double[]{-150, 20});
        data.add(new double[]{-100, 80});
        data.add(new double[]{20, 100});
        data.add(new double[]{150, 0});
        data.add(new double[]{100, -80});
        data.add(new double[]{20, -100});
        data.add(new double[]{-80, -80});

        for (double[] point : data) {
            R2Point p = new R2Point(point[0], point[1]);
            convex.add(p);
        }
        assertEquals(486, (int) convex.perimeter());
    }

    @Test
    // Невыпуклый четыреугольник
    public void quadrangleNonConvex() {
        data.add(new double[]{-50, -10});
        data.add(new double[]{60, 0});
        data.add(new double[]{50, 50});
        data.add(new double[]{0, 0});

        for (double[] point : data) {
            R2Point p = new R2Point(point[0], point[1]);
            convex.add(p);
        }
        assertEquals(272,(int)convex.perimeter());
    }
}

