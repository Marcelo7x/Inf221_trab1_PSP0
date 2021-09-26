import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.Assert.*;

public class ImpedimentoTest {
    Impedimento imp;
    @Before
    public void init() {
        imp = new Impedimento();
    }

    @Test
    public void setAD_1() {  //14,16,17,22,23,25,25a,26,31,33
        String input = "3 3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //Impedimento imp = new Impedimento();
        assertTrue(imp.setAtacantesDefesores());
    }

    @Test
    public void setAD_2() { //14,16,19,22,14,16,17,22,23,25,25a,26,31,33
        String input = "1 3 2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //Impedimento imp = new Impedimento();
        assertTrue(imp.setAtacantesDefesores());
    }

    @Test
    public void setAD_3() {  //14,16,17,22,23,25,25a,28,31,23,25,26,31,33
        String input = "3 0 2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //Impedimento imp = new Impedimento();
        assertTrue(imp.setAtacantesDefesores());
    }

    @Test
    public void setDis_1() {
        String input = "2 2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        imp.setAtacantesDefesores();

        input = "100 200 300 400";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        imp.setDistancias();

        int[] dis = new int[2];

        dis[0] = 100; dis[1] = 200;
        assertArrayEquals(dis,imp.getDistancia_Atacantes());

        dis[0] = 300; dis[1] = 400;
        assertArrayEquals(dis, imp.getDistancia_Defensores());

    }

    @Test
    public void setDis_2() {
        String input = "2 2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        imp.setAtacantesDefesores();

        input = "-100 100 200 -300 300 400";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        imp.setDistancias();

        int[] dis = new int[2];

        dis[0] = 100; dis[1] = 200;
        assertArrayEquals(dis,imp.getDistancia_Atacantes());

        dis[0] = 300; dis[1] = 400;
        assertArrayEquals(dis, imp.getDistancia_Defensores());

    }

    @Test
    public void calcD_1() {
        String input = "2 2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        imp.setAtacantesDefesores();

        input = "100 200 400 300";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        imp.setDistancias();

        imp.resultado();
        assertEquals(300,imp.getUltimo_def());
        assertEquals(400, imp.getPenultimo_def());
    }

    @Test
    public void calcD_2() {
        String input = "2 2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        imp.setAtacantesDefesores();

        input = "100 200 300 400";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        imp.setDistancias();

        imp.resultado();
        assertEquals(300,imp.getUltimo_def());
        assertEquals(400, imp.getPenultimo_def());
    }

    @Test
    public void calcA_1() {
        String input = "2 2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        imp.setAtacantesDefesores();

        input = "200 100 300 400";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        imp.setDistancias();

        imp.resultado();
        assertEquals(300,imp.getUltimo_def());
        assertEquals(400, imp.getPenultimo_def());
    }

    @Test
    public void resultado_1() {
        String input = "2 1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        imp.setAtacantesDefesores();

        input = "100 200 300";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        imp.setDistancias();

        assertTrue(imp.resultado());
    }

    @Test
    public void resultado_2() {
        String input = "2 2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        imp.setAtacantesDefesores();

        input = "500 500 300 400";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        imp.setDistancias();

        assertFalse(imp.resultado());
    }

    @Test
    public void resultado_3() {
        String input = "2 2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        imp.setAtacantesDefesores();

        input = "100 200 300 500";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        imp.setDistancias();

        assertTrue(imp.resultado());
    }
}