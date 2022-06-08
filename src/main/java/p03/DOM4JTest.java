package p03;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

/**
 * @author: ymm
 * @date: 2022/6/1
 * @version: 1.0.0
 * @description:
 */
public class DOM4JTest {

    @Test
    public void test1() throws DocumentException {

        // 1.获取XML解析对象
        SAXReader saxReader = new SAXReader();

        // 2.解析XML，获取文档对象document
        Document document = saxReader.read("E:\\lagou\\lg_stage02_module02\\src\\main\\java\\p03\\user.xml");

        // 3.获取根元素
        Element rootElement = document.getRootElement();

        // 根元素名称
        String name = rootElement.getName();
        System.out.println("name = " + name);


        List<Element> elements = rootElement.elements();

        // 子元素名称
        for (Element element : elements) {
//            System.out.println("子节点：" + element.getName());
            List<Element> elements1 = element.elements();

            for (Element element1 : elements1) {
                System.out.println("子节点2：" + element1.getName());
            }

        }

    }


    /**
     * 获取XML中文本信息和属性信息
     *
     * @throws DocumentException
     */
    @Test
    public void test2() throws DocumentException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("E:\\lagou\\lg_stage02_module02\\src\\main\\java\\p03\\user.xml");
        Element rootElement = document.getRootElement();

        List<Element> elements = rootElement.elements();

        // 获取第1个子节点
        Element user = elements.get(0);

        // 获取节点信息
        String id = user.attributeValue("id"); // 获取id的值
        String name = user.elementText("name");
        String age = user.elementText("age");
        String sex = user.elementText("sex");
        String hobby = user.elementText("hobby");
        String hobby1 = user.element("hobby").getText();

        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("sex = " + sex);
        System.out.println("hobby = " + hobby);
        System.out.println("hobby1 = " + hobby1);




    }

}
