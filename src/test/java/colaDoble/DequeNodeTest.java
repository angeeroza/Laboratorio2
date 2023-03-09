package colaDoble;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/* TEST CASES DEQUE NODE
*  1. Constructor parametro item asigna el valor correctamente.
*  2. Constructor parametro next funciona correctamente asignadole null.
*  3. Constructor parametro previous funciona correctamente asignadole null.
*  4. Next node es distinto de null y previous null, por tanto isNotATerminalNode devuelve false.
*  5. Previous node es distinto de null y next null, por tanto isNotATerminalNode devuelve false.
*  6. Previous y next node son distintos de null, por tanto isNotATerminalNode devuelve true.
*  7. GetItem() devuelve su valor.
*  8. Next node es distinto de null, getNext() devuelve su valor.
*  9. Previous node es distinto de null, getPrevious() devuelve su valor.
*  10. Next node es null, getNext() devuelve null.
*  11. Previous node es null, getPrevious() devuelve null.
*  12. getNext() del ultimo nodo devuelve null.
*  13. getPrevious() del primer nodo devuelve null.
*  14. Cambiamos el valor de item mediante setItem().
*  15. Cambiamos el valor de next node mediante setNext().
*  16. Cambiamos el valor de previous node mediante setPrevious().
 */

class DequeNodeTest {

    private DequeNode<Integer> dequeInt, dequeFirst, dequeLast;

    @BeforeEach
    public void setup(){
        dequeFirst = new DequeNode<>(1, null, dequeLast);
        dequeLast = new DequeNode<>(2, dequeFirst, null);
        dequeInt = new DequeNode<>(5,null,null);
    }

    @Nested
    @DisplayName("Test cases for the constructor")
    class TestCasesForConstructor {

        @Test
        @DisplayName("Test case for the parameter item")
        public void constructorShouldReturnSameValueItem(){
            int expectedValue = 5;
            int obtainedValue = dequeInt.getItem();

            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("Test case for the parameter next")
        public void constructorShouldReturnSameValueNext(){
            DequeNode<Integer> obtainedValue = dequeInt.getNext();

            assertNull(obtainedValue);
        }

        @Test
        @DisplayName("Test case for the parameter previous")
        public void constructorShouldReturnSameValuePrevious(){
            DequeNode<Integer> obtainedValue = dequeInt.getPrevious();

            assertNull(obtainedValue);
        }

    }

    @Nested
    @DisplayName("Test cases for the isNotATerminalNode() method")
    class TestCasesForIsNotATerminalNode {

        @Test
        @DisplayName("Test case previous node is null, is not a terminal node false")
        public void ifPreviousNodeIsNullIsNotATerminalNode(){
            DequeNode<Integer> next = new DequeNode<>(5,null,null);
            dequeInt = new DequeNode<>(5,null,next);
            boolean obtainedValue =dequeInt.isNotATerminalNode();

            assertFalse(obtainedValue);
        }

        @Test
        @DisplayName("Test case next node is null, is not a terminal node false")
        public void ifNextNodeIsNullIsNotATerminalNode(){
            DequeNode<Integer> previous = new DequeNode<>(5,null,null);
            dequeInt = new DequeNode<>(5,previous,null);
            boolean obtainedValue =dequeInt.isNotATerminalNode();

            assertFalse(obtainedValue);
        }
        @Test
        @DisplayName("Test case previous and next node is not null, is not a terminal node true")
        public void ifPreviousNodeAndNextNodeAreNotNullIsATerminalNode(){
            DequeNode<Integer> next = new DequeNode<>(5,null,null);
            DequeNode<Integer> previous = new DequeNode<>(5,null,null);
            dequeInt = new DequeNode<>(5,previous,next);
            boolean obtainedValue = dequeInt.isNotATerminalNode();

            assertTrue(obtainedValue);
        }

    }

    @Nested
    @DisplayName("Test cases for the getters methods")
    class TestCasesForGetters {
        @Test
        @DisplayName("Test case for the getter item method when is not null")
        public void getItemShouldReturnItemValue(){
            int expectedValue = 5;
            dequeInt = new DequeNode<>(expectedValue, null, null);
            int obtainedValue = dequeInt.getItem();

            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("Test case for the getter next method when is not null")
        public void getNextShouldReturnNextNode(){
            DequeNode<Integer> expectedValue = new DequeNode<>(5, null, null);
            dequeInt = new DequeNode<>(4, null,expectedValue);
            DequeNode<Integer> obtainedValue= dequeInt.getNext();

            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("Test case for the getter previous method when is not null")
        public void getPreviousShouldReturnPreviousNode(){
            DequeNode<Integer> expectedValue = new DequeNode<>(5, null, null);
            dequeInt = new DequeNode<>(4, expectedValue, null);
            DequeNode<Integer> obtainedValue= dequeInt.getPrevious();

            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("Test case for the getter next method when is null")
        public void getNextReturnsNullIfNextNodeIsNull(){
            dequeInt = new DequeNode<>(5,null,null);
            DequeNode<Integer> obtainedValue = dequeInt.getNext();

            assertNull(obtainedValue);
        }

        @Test
        @DisplayName("Test case for the getter previous method when is null")
        public void getPreviousReturnsNullIfPreviousNodeIsNull(){
            dequeInt = new DequeNode<>(5,null,null);
            DequeNode<Integer> obtainedValue = dequeInt.getPrevious();

            assertNull(obtainedValue);
        }

        @Test
        @DisplayName("Test case for the get previous method in the first node")
        public void getPreviousNodeOfFirstShouldReturnNull() {
            DequeNode<Integer> obtainedValue = dequeFirst.getPrevious();

            assertNull(obtainedValue);
        }

        @Test
        @DisplayName("Test case for the get next method in the last node")
        public void getNextNodeOfLastShouldReturnNull() {
            DequeNode<Integer> obtainedValue = dequeLast.getNext();

            assertNull(obtainedValue);
        }

    }

    @Nested
    @DisplayName("Test cases for the setters methods")
    class TestCasesForSetter {
        @Test
        @DisplayName("Test case for the set item method")
        public void setItemShouldChangeItemValue(){
            int expectedValue = 3;
            dequeInt = new DequeNode<>(5,null,null);
            dequeInt.setItem(expectedValue);
            int obtainedValue = dequeInt.getItem();

            assertEquals(expectedValue, obtainedValue);
        }

        @Test
        @DisplayName("Test case for the set next method")
        public void setNextShouldChangeNextNode(){
            DequeNode<Integer> expectedValue=  new DequeNode<>(5,null,null);
            dequeInt = new DequeNode<>(1,null,null);
            dequeInt.setNext(expectedValue);

            DequeNode<Integer> obtainedValue = dequeInt.getNext();

            assertEquals(expectedValue,obtainedValue);
        }

        @Test
        @DisplayName("Test case for the set previous method")
        public void setPreviousShouldChangePreviousNode(){
            DequeNode<Integer> expectedValue=  new DequeNode<>(5,null,null);
            dequeInt = new DequeNode<>(1,null,null);
            dequeInt.setPrevious(expectedValue);

            DequeNode<Integer> obtainedValue = dequeInt.getPrevious();

            assertEquals(expectedValue,obtainedValue);
        }

    }


    @AfterEach
    public void finish (){
        dequeFirst = null;
        dequeLast = null;
        dequeInt = null;
    }
}