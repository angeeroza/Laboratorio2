package colaDoble;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/* TEST CASES DOUBLY LINKED LIST DEQUE
*  1. Metodo prepend funciona correctamente, insertamos 3 elementos, comprobamos el primero y el ultimo.
*  2. Metodo append funciona correctamente, insertamos 3 elementos, comprobamos el primero y el ultimo.
*  3. Metodo deleteFirst() funciona correctamente con varios elementos, borramos y comprobamos que el primero ha cambiado.
*  4. Metodo deleteFirst() funciona correctamente con un elemento, lo borramos y comprobamos que la lista esta vacia.
*  5. Metodo deleteLast() funciona correctamente con varios elementos, borramos y comprobamos que el ultimo ha cambiado.
*  6. Metodo deleteLast() funciona correctamente con un elemento, lo borramos y comprobamos que la lista esta vacia.
*  7. Metodo size() funciona correctamente, añadimos y borramos elementos.
 */

class DoublyLinkedListDequeTest {

    private DoublyLinkedListDeque<Integer> list;

    @BeforeEach
    public void setUp() throws Exception {
        list = new DoublyLinkedListDeque<Integer>();
    }

    @Nested
    @DisplayName("Test cases for the preprend() method")
    class TestCasesForPrependMethod {

        @Test
        @DisplayName("Prepend 3 elements")
        public void prepend() {
            list.prepend(1);
            list.prepend(2);
            list.prepend(3);
            assertEquals(3, list.first().intValue());
            assertEquals(1, list.last().intValue());
            assertEquals(3, list.size());
        }

    }

    @Nested
    @DisplayName("Test cases for the append() method")
    class TestCasesForAppendMethod {

        @Test
        @DisplayName("Appends 3 elements")
        public void append() {
            list.append(1);
            list.append(2);
            list.append(3);
            assertEquals(3, list.last().intValue());
            assertEquals(1, list.first().intValue());
            assertEquals(3, list.size());
        }
    }

    @Nested
    @DisplayName("Test cases for both delete methods")
    class TestCasesForDeleteMethod {

        @Test
        @DisplayName("Test case for the deleteFirst() method when size > 1")
        public void deleteFirstMoreOneElement() {
            list.prepend(1);
            list.prepend(2);
            list.prepend(3);
            list.deleteFirst();
            assertEquals(2, list.first().intValue());
        }

        @Test
        @DisplayName("Test case for the deleteFirst() method when size = 1")
        public void deleteFirstOneElement() {
            list.prepend(1);
            assertEquals(1, list.size());
            list.deleteFirst();
            assertEquals(0, list.size());
            assertNull(list.getFirst());
            assertNull(list.getLast());
        }

        @Test
        @DisplayName("Test case for the deleteFirst() method when size = 0")
        public void deleteFirstZeroElements() {
            assertEquals(0, list.size());
            assertThrows(DoubleEndedQueueException.class, () ->  list.deleteFirst());
            assertNull(list.getFirst());
            assertNull(list.getLast());
        }

        @Test
        @DisplayName("Test case for the deleteLast() method when size > 1")
        public void deleteLastMoreOneElement() {
            list.append(1);
            list.append(2);
            list.append(3);
            list.deleteLast();
            assertEquals(2, list.last().intValue());
        }

        @Test
        @DisplayName("Test case for the deleteLast() method when size = 1")
        public void deleteLastOneElement() {
            list.prepend(1);
            assertEquals(1,      list.size());
            list.deleteLast();
            assertEquals(0, list.size());
            assertNull(list.getFirst());
            assertNull(list.getLast());
        }

        @Test
        @DisplayName("Test case for the deleteLast() method when size = 0")
        public void deleteLastZeroElements() {
            assertEquals(0, list.size());
            assertThrows(DoubleEndedQueueException.class, () ->  list.deleteLast());
            assertNull(list.getFirst());
            assertNull(list.getLast());
        }
    }

    @Nested
    @DisplayName("Test cases for the size() method")
    class TestCasesForSizeMethod {

        @Test
        @DisplayName("Test case for the size()")
        public void size() {
            list.prepend(1);
            list.prepend(2);
            list.append(3);
            assertEquals(3, list.size());
            list.deleteFirst();
            assertEquals(2, list.size());
        }
    }

    @Nested
    @DisplayName("Test cases for the remove() method")
    class TestCasesForRemoveMethod {

        @Test
        @DisplayName("When the value is the first")
        public void removeFirst() {
            list.append(1);
            list.append(2);
            list.remove(1);
            assertFalse(list.contains(1));
            assertEquals(1, list.size());
            assertEquals(list.getFirst().getItem(), 2);
        }

        @Test
        @DisplayName("When the value is the last")
        public void removeLast() {
            list.append(1);
            list.append(2);
            list.append(3);
            list.remove(3);
            assertFalse(list.contains(3));
            assertEquals(2, list.size());
            assertEquals(list.getLast().getItem(), 2);
        }

        @Test
        @DisplayName("When the value is the middle")
        public void removeMiddleNode() {
            list.append(1);
            list.append(2);
            list.append(3);
            list.remove(2);
            assertFalse(list.contains(2));
            assertEquals(2, list.size());
            assertEquals(list.getFirst().getNext().getItem(), 3);
            assertEquals(list.getLast().getPrevious().getItem(), 1);
        }

        @Test
        @DisplayName("When the value is null")
        public void removeThrowException() {
            list.prepend(1);
            list.prepend(2);
            assertThrows(DoubleEndedQueueException.class, () ->  list.remove(null));
        }
    }

    @Nested
    @DisplayName("Test cases for the contains() method")
    class TestCasesForContainsMethod {

        @Test
        @DisplayName("When the value is in list")
        public void containsTrue() {
            list.append(1);
            list.prepend(2);
            assertTrue(list.contains(1));
        }

        @Test
        @DisplayName("When the value is not in list")
        public void containsFalse() {
            list.prepend(1);
            list.append(2);
            assertFalse(list.contains(3));
        }

        @Test
        @DisplayName("When the value is not in list")
        public void containsThrowException() {
            list.prepend(1);
            list.prepend(2);
            assertThrows(DoubleEndedQueueException.class, () ->  list.contains(null));
        }

    }

    @Nested
    @DisplayName("Test cases for the get() method")
    class TestCasesForGetMethod {

        @Test
        @DisplayName("When the index is valid")
        public void getIndexValid() {
            list.append(1);
            list.append(2);
            list.append(3);
            assertEquals(1, list.get(0));
            assertEquals(2, list.get(1));
            assertEquals(3, list.get(2));
        }

        @Test
        @DisplayName("When the index is not valid")
        public void getThrowException() {
            list.prepend(1);
            list.prepend(2);
            assertThrows(DoubleEndedQueueException.class, () ->  list.get(5));
        }

    }

    @Nested
    @DisplayName("Test cases for the sort() method")
    class TestCasesForSortMethod {

        @Test
        @DisplayName("When the list is messy")
        public void sortListMessy() {
            list.append(3);
            list.append(2);
            list.append(1);
            list.sort(Integer::compareTo);
            assertEquals(1,list.getFirst().getItem());
            assertEquals(2,list.getFirst().getNext().getItem());
            assertEquals(3,list.getLast().getItem());
        }

        @Test
        @DisplayName("When the list is ordered")
        public void sortListOrdered() {
            list.append(1);
            list.append(2);
            list.append(3);
            list.sort(Integer::compareTo);
            assertEquals(1,list.getFirst().getItem());
            assertEquals(2,list.getFirst().getNext().getItem());
            assertEquals(3,list.getLast().getItem());
        }

        @Test
        @DisplayName("When the size is not valid")
        public void sortThrowException() {
            list.append(1);
            assertThrows(DoubleEndedQueueException.class, () ->  list.sort(Integer::compareTo));
        }

    }


    @AfterEach
    public void finish() {
        list = null;
    }
}