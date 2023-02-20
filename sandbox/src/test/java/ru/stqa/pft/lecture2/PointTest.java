package ru.stqa.pft.lecture2;
import java.util.Locale;
import org.testng.Assert;
import org.testng.annotations.Test;
public class PointTest {
  @Test
  public void pointTest(){
    Point p0 = new Point("p0");
    Point p1 = new Point("p1",3,0);
    Point p2 = new Point("p2",3,4);

    Assert.assertEquals(String.format(Locale.US,"%.2f",p0.distance(p1)), "3.00");
    Assert.assertEquals(String.format(Locale.US,"%.2f",p1.distance(p2)), "4.00");
    Assert.assertEquals(String.format(Locale.US,"%.2f",p0.distance(p2)), "5.00");
  }
}
