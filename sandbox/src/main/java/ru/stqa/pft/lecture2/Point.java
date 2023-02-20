package ru.stqa.pft.lecture2;

public class Point {
  protected double x, y;
  protected String name;
  Point(String name){
    this.name=name;
    x=0;
    y=0;
  }
  Point(String name, double x, double y){
    this.name=name;
    this.x=x;
    this.y=y;
  }
  double getPointX(){
    return x;
  }
  double getPointY(){
    return y;
  }
  String getName(){
    return name;
  }
  public double distance(Point p) {
    double sum = Math.pow((p.getPointX() - x), 2) + Math.pow((p.getPointY() - y), 2);
    return Math.sqrt(sum);
  }
}
