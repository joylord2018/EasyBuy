package util;

import java.util.Arrays;
import java.util.LinkedList;

public class CookieUtil {
	public static String getStr(String cookieStr,String newId){
		if(cookieStr==null||cookieStr.equals("")){
			return newId;
		}
		String[] arr=cookieStr.split(",");
		
		LinkedList<String> li=new LinkedList<String>(Arrays.asList(arr));
		if(li.contains(newId)){
			li.remove(newId);
			li.addFirst(newId);
		}else{
			if(li.size()>=3){
				li.removeLast();
				li.addFirst(newId);
			}else{
				li.addFirst(newId);
			}
		}
		StringBuilder sb=new StringBuilder();
		for(String s:li){
			sb.append(s+",");
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
}
