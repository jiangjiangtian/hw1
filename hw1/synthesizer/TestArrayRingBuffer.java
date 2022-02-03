package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        assertTrue(arb.isEmpty());
        for(int i = 0; i < 10; i++) {
            arb.enqueue(i);
        }
        for(int i : arb) {
            System.out.print(i + " ");
        }
        assertTrue(arb.isFull());
        for(int i = 0; i < 10; i++) {
            arb.dequeue();
        }
        arb.enqueue(10);
        assertEquals((Integer)10, arb.peek());
        arb.dequeue();
        assertEquals(null, arb.peek());
        assertTrue(arb.isEmpty());

    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
}
