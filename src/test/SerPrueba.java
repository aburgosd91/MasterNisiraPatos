package test;

import java.io.Serializable;

import org.apache.commons.lang.SerializationUtils;

public class SerPrueba {
	public static void main(String[] args) {
		ObjPrueba a = new ObjPrueba();
		a.a = 1;
		a.b = 2F;
		a.c = "LLL";
		
		
		ObjPrueba B = new ObjPrueba();
		B.a = 1;
		B.b = 2F;
		B.c = "LLL";
		
		
		byte[] data = SerializationUtils.serialize(a);
		System.out.println(data.length);
		byte[] data2 = SerializationUtils.serialize(B);
		System.out.println(data2.length);
		System.out.println(data);
		System.out.println(data2);
		for (int i = 0; i< data.length;i++) {
			System.out.println(data[i] == data2[i]?true:data[i]+"=="+ data2[i]);
		}
		
		String aaaaa = new String("aaaaa");
		String aaa = new String("aaaaa");
		System.out.println(aaaaa.hashCode());
		System.out.println(aaa.hashCode());
		
	}
}
