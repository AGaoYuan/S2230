package cn.bdqn.Chapter01;

import java.awt.print.Book;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXML {

	public static void main(String[] args) throws Exception {
		//readerDemo(); ��ȡ
		//saveDemo(); д��
		//UpdateDemo(); �޸�
		delDemo();//ɾ��
		
		
	}


	private static void delDemo() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// ����Builder
		DocumentBuilder builder = factory.newDocumentBuilder();

		// �γ�Document����
		Document parse = builder.parse("D:/eclipse/Workspace/Swish/src/cn/bdqn/Chapter01/Books.xml");
		
		
		Element item =(Element) parse.getElementsByTagName("book").item(2);
		parse.getElementsByTagName("books").item(0).removeChild(item);
		
		
		TransformerFactory tff = TransformerFactory.newInstance();
		Transformer tf = tff.newTransformer();
		
		Source source =new  DOMSource(parse);
		Result result =new  StreamResult("D:/eclipse/Workspace/Swish/src/cn/bdqn/Chapter01/Books.xml");
		tf.transform(source, result);
		System.out.println("Delete ok!");
		
		
		
	}



	private static void UpdateDemo() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// ����Builder
		DocumentBuilder builder = factory.newDocumentBuilder();

		// �γ�Document����
		Document parse = builder.parse("D:/eclipse/Workspace/Swish/src/cn/bdqn/Chapter01/Books.xml");
		
		
		Element item =(Element) parse.getElementsByTagName("book").item(2);
		item.getElementsByTagName("bookPrice").item(0).setTextContent("99");
		
		
		
		TransformerFactory tff = TransformerFactory.newInstance();
		Transformer tf = tff.newTransformer();
		
		Source source =new  DOMSource(parse);
		Result result =new  StreamResult("D:/eclipse/Workspace/Swish/src/cn/bdqn/Chapter01/Books.xml");
		tf.transform(source, result);
		System.out.println("Update ok!");
	}



	private static void saveDemo() throws Exception {
		// ����������ͨ����̬����
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				// ����Builder
				DocumentBuilder builder = factory.newDocumentBuilder();

				// �γ�Document����
				Document parse = builder.parse("D:/eclipse/Workspace/Swish/src/cn/bdqn/Chapter01/Books.xml");
				
				Element book = parse.createElement("book");
				book.setAttribute("typeId", "3");
				
				Element bookId = parse.createElement("bookId");
				bookId.setTextContent("003");
				
				Element bookName = parse.createElement("bookName");
				bookName.setTextContent("ԤԼ����");
				
				Element bookPrice = parse.createElement("bookPrice");
				bookPrice.setTextContent("56");
				
				Element bookAuthor = parse.createElement("bookAuthor");
				bookAuthor.setTextContent("������");
				
				book.appendChild(bookId);
				book.appendChild(bookName);
				book.appendChild(bookPrice);
				book.appendChild(bookAuthor);
				
				parse.getElementsByTagName("books").item(0).appendChild(book);
				
				TransformerFactory tff = TransformerFactory.newInstance();
				Transformer tf = tff.newTransformer();
				
				Source source =new  DOMSource(parse);
				Result result =new  StreamResult("D:/eclipse/Workspace/Swish/src/cn/bdqn/Chapter01/Books.xml");
				tf.transform(source, result);
				System.out.println("Save ok!");

		
	}



	private static void readerDemo() throws Exception {
		//����������ͨ����̬����
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				//����Builder
				DocumentBuilder builder = factory.newDocumentBuilder();
				
				//�γ�Document����
				Document parse = builder.parse("D:/eclipse/Workspace/Swish/src/cn/bdqn/Chapter01/Books.xml");
				
				NodeList list = parse.getElementsByTagName("book");
				for (int i = 0; i < list.getLength(); i++) {
					Element item = (Element) list.item(i);
					
					String attribute = item.getAttribute("typeId");//��ȡIDֵ
					
					String bookId = item.getElementsByTagName("bookId").item(0).getTextContent();
					String bookName = item.getElementsByTagName("bookName").item(0).getTextContent();
					String bookPrice = item.getElementsByTagName("bookPrice").item(0).getTextContent();
					String bookAuthor = item.getElementsByTagName("bookAuthor").item(0).getTextContent();
					System.out.println(bookId);
					System.out.println(bookName);
					System.out.println(bookPrice);
					System.out.println(bookAuthor);
					
					System.out.println(attribute);//��ӡID�е�ֵ
					System.out.println("---------------");
		
				}

	}
}
