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

    @Test
    public void testlengthistwo() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(2);
        assertTrue(arb.isEmpty());
        for(int i = 0; i < 2; i++) {
            arb.enqueue(i);
        }
        assertTrue(arb.isFull());
        assertFalse(arb.isEmpty());
        for(int i = 0; i < 2; i++) {
            arb.dequeue();
        }
        assertTrue(arb.isEmpty());
        arb.enqueue(1);
        arb.enqueue(2);
    }

    @Test
    public void testlengthisone() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(1);
        assertTrue(arb.isEmpty());
        for(int i = 0; i < 1; i++) {
            arb.enqueue(i);
        }
        assertTrue(arb.isFull());
        assertFalse(arb.isEmpty());
        for(int i = 0; i < 1; i++) {
            arb.dequeue();
        }
        assertTrue(arb.isEmpty());
        arb.enqueue(1);
    }
    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
}
