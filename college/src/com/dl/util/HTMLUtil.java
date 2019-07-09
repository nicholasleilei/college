package com.dl.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLUtil {

	
	public static String getText(String content,int end) {
		Pattern p_html = Pattern.compile("<[^>]+>", Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(content);
        String a = m_html.replaceAll(""); // ����html��ǩ
        
        //��һ����ŵ�λ��
        int index= a.indexOf("��");
        if(index!=-1) {
        	  //index=end;
        	a=a.substring(0,index);
        }
        if(a.length()>end) {
        	a=a.substring(0,end).concat("...");
        }
        
        return  a;
	}
}
