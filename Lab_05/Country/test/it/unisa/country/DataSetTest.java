package it.unisa.country;

import org.junit.Assert;
import org.junit.Test;

public class DataSetTest {
    @Test
    public void testMinimum() {
        Country c1=new Country("Italia",500123.56);
        Country c2=new Country("Stati Uniti",500000123.56);
        Country c3=new Country("Repubblica di San Marino",40000.56);
        DataSet d1=new DataSet();
        d1.add(c1);
        d1.add(c2);
        d1.add(c3);
        Assert.assertEquals(40000.56,d1.getMinimum().getSurfaceArea(),0);
    }

    @Test
    public void testMaximum() {
        Country c1=new Country("Italia",500123.56);
        Country c2=new Country("Stati Uniti",500000123.56);
        Country c3=new Country("Repubblica di San Marino",40000.56);
        DataSet d1=new DataSet();
        d1.add(c1);
        d1.add(c2);
        d1.add(c3);
        Assert.assertEquals(500000123.56,d1.getMaximum().getSurfaceArea(),0);
    }
}