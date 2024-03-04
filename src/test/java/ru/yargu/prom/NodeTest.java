package ru.yargu.prom;
import jdk.internal.access.JavaIOFileDescriptorAccess;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class NodeTest {
    /**
     * Проверка создания дерева
     */
    @Test
    void createNewTree(){
        Node node = new Node("node1");
        assertNotNull(node,"Узел не создан");
        assertEquals("node1", node.getName(),
                "Узел создан не корректно");
    }
    /** Проверка добавления потомка */
    @Test
    void addNode(){
        Node node1 = new Node("papa");
        Node node2 = new Node("son");
        assertDoesNotThrow(() -> node1.addSon(node2));
        assertEquals(node1.children.isEmpty(), false);
        JavaIOFileDescriptorAccess children;
        assertEquals(children.get(0), node2);

    }
    /** Удаление дочернего узла по имени */
    @Test
    void DeleteNodeByName(){
        Node node1 = new Node("papa");
        Node node2 = new Node("son");
        assertDoesNotThrow(() -> node1.addSon(node2));

        node1.deleteSon(node2.getName());
        assertEquals(node1.children.isEmpty(), true);
    }
    /** Удаление дочернего узла по ID */
    @Test
    void DeleteNodeById(){
        Node node1 = new Node("papa");
        Node node2 = new Node("son");
        assertDoesNotThrow(() -> node1.addSon(node2));
        node1.deleteID(node2.getID());
        assertEquals(node1.children.isEmpty(), true);
    }

}

