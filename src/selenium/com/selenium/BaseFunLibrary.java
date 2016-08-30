package com.selenium;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.*;

public class BaseFunLibrary {
	
	public String GetInputMXL(String InputeDateName){
		
		long lasting = System.currentTimeMillis();
		
		String InputeDateADD = "CreateOrder_Adult.xml" ;
		
			
		return null;
	}

	@Test
	// ��ȡdocument����
	public void testUntitled() throws Exception {
	    DocumentBuilderFactory factory = null;
	    DocumentBuilder builder = null;
	    Document document = null;
	    
	    try {
	      factory = DocumentBuilderFactory.newInstance();
	      builder = factory.newDocumentBuilder();
	      //document = builder.parse("C:\\Users\\dujuan\\Desktop\\Selenium\\InputDate\\CreateOrder_Adult.xml");
	      document = builder.parse("CreateOrder_Adult.xml");
	    } catch (Exception e) {
	      throw new RuntimeException(" Can not get document !");
	    }
	    
		  NodeList nlist = document.getElementsByTagName("root");
		  System.out.println("Node count is ***********************************" + nlist.getLength());
		  for(int i=0;i<=nlist.getLength();i++){
			  Node n = nlist.item(i);
			  System.out.println("Node Text is ***********************************" + n.getTextContent());
		  }
		  
	  }
 

	//�ݹ�ڵ����
	public static void getAllNodeText(Document document) {
		  // 1. �����Ҫ�����Ľڵ�
		  Node node = document.getElementsByTagName("State").item(0);
		  // 2. �ݹ���õĿ�ʼ
		  recursion(node);
		}
		 
	private static void recursion(Node node) {
		  // 1. ֻ��Ԫ�ؽڵ�Ŵ�ӡ
		  if (node.getNodeType() == Node.ELEMENT_NODE) {
		    System.out.println("Node Name is " + node.getTextContent());
		  }
		  // 2. �õ���ǰ�ڵ�������ӽڵ�
		  NodeList nlist = node.getChildNodes();
		  for (int i = 0; i < nlist.getLength(); i++) {
		    Node n = nlist.item(i);
		    recursion(n);
		  }
		}		
	

}
