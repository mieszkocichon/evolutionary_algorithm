import Levenstein.LevensteinDistance;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LevensteinDistanceTest {
    @BeforeClass
    public void setUp() {
        System.out.print("LevensteinDistance test");
    }

    @Test(groups = { "fast" })
    public void equals() {
        LevensteinDistance levensteinDistance = LevensteinDistance.build(new StringBuffer("sitting"), new StringBuffer("kitten"));
        Assert.assertEquals(levensteinDistance.initialize(), 3);

        levensteinDistance = LevensteinDistance.build(new StringBuffer("sitting"), new StringBuffer("kitte"));
        Assert.assertEquals(levensteinDistance.initialize(), 4);

        levensteinDistance = LevensteinDistance.build(new StringBuffer("sitting"), new StringBuffer("kitt"));
        Assert.assertEquals(levensteinDistance.initialize(), 4);

        levensteinDistance = LevensteinDistance.build(new StringBuffer("sitting"), new StringBuffer("kit"));
        Assert.assertEquals(levensteinDistance.initialize(), 5);

        levensteinDistance = LevensteinDistance.build(new StringBuffer("sitting"), new StringBuffer("ki"));
        Assert.assertEquals(levensteinDistance.initialize(), 6);

        levensteinDistance = LevensteinDistance.build(new StringBuffer("sitting"), new StringBuffer("k"));
        Assert.assertEquals(levensteinDistance.initialize(), 7);
    }
}
