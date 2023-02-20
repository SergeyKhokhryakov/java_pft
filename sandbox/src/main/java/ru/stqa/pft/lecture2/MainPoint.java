package ru.stqa.pft.lecture2;

import java.util.Locale;

public class MainPoint {
  public static void main(String[] args) {
    Point p0 = new Point("p0");
    Point p1 = new Point("p1",3,0);
    Point p2 = new Point("p2", 3,4);
   // System.out.println(distFormat(p0,p1));
   // System.out.println(distFormat(p1,p2));
   // System.out.println(distFormat(p0,p2));
    System.out.println("Расстояние между точками " + p0.getName() + "," + p1.getName() + " = " + String.format("%.2f",p0.distance(p1)));
    System.out.println("Расстояние между точками " + p1.getName() + "," + p2.getName() + " = " + String.format("%.2f",p1.distance(p2)));
    System.out.println("Расстояние между точками " + p0.getName() + "," + p2.getName() + " = " + String.format("%.2f",p0.distance(p2)));

  }
  public static String distFormat(Point p1, Point p2){
    return String.format(Locale.US,"Расстояние между точками p0,p1 = %.2f", p1.distance(p2));
  }
/*
  public static double distance(Point p1, Point p2) {
    double sum = Math.pow((p2.getPointX() - p1.getPointX()), 2) + Math.pow((p2.getPointY() - p1.getPointY()), 2);
    return Math.sqrt(sum);
  }
*/
}

