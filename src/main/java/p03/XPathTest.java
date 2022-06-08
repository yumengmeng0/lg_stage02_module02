package p03;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @author: ymm
 * @date: 2022/6/5
 * @version: 1.0.0
 * @description:
 */
public class XPathTest {

    public static void main(String[] args) {

    }

    /**
     * 使用selectSingleNode()方法，查询节点信息
     */
    @Test
    public void test1() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("E:\\lagou\\lg_stage02_module02\\src\\main\\java\\p03\\book.xml");

        Node node = document.selectSingleNode("/bookstore/book/name");
        System.out.println("书名的节点：" + node.getName());
        System.out.println("书名：" + node.getText());

        // 获取第二本书的书名
        Node node1 = document.selectSingleNode("/bookstore/book[2]/name");

        System.out.println("书名：" + node1.getText());

    }


    /**
     * 获取属性值
     *
     * @throws DocumentException
     */
    @Test
    public void test2() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("E:\\lagou\\lg_stage02_module02\\src\\main\\java\\p03\\book.xml");

        // 获取第一个book节点id属性的值
        Node node = document.selectSingleNode("/bookstore/book/attribute::id");

        System.out.println("第1个book节点id属性的值：" + node.getText());

        Node node1 = document.selectSingleNode("/bookstore/book[last()]/attribute::id");
        System.out.println("最后一个book节点的id属性的值：" + node1.getText());


        // 通过id的值获取book2节点中的书名
        Node node2 = document.selectSingleNode("/bookstore/book[@id='book2']");

        System.out.println("id为book2的书名：" + node2.selectSingleNode("name").getText());

    }

    /**
     * @throws DocumentException
     */
    @Test
    public void test3() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("E:\\lagou\\lg_stage02_module02\\src\\main\\java\\p03\\book.xml");

        // 查询所有节点
        List<Node> list = document.selectNodes("//*");

        for (Node node : list) {
            System.out.println("节点名：" + node.getName());
        }

        // 获取所有的书名
        List<Node> list1 = document.selectNodes("//name");

        for (Node node : list1) {
            System.out.println("书名：" + node.getText());
        }

        // 获取id值为book1的节点的所有内容
        List<Node> list2 = document.selectNodes("/bookstore/book[@id='book1']//*");
        for (Node node : list2) {
            System.out.println(node.getName() + " = " + node.getText());
        }

    }


}
