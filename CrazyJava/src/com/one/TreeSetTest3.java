package com.one;


import java.util.*;
class R implements Comparable
{
	int count;
	public R(int count)
	{
		this.count = count;
	}
	public String toString()
	{
		return "count:" + count;
	}
	// ��дequals����������count���ж��Ƿ����
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if(obj != null && obj.getClass() == R.class)
		{
			R r = (R)obj;
			return r.count == this.count;
		}
		return false;
	}
	// ��дcompareTo����������count���Ƚϴ�С
	public int compareTo(Object obj)
	{
		R r = (R)obj;
		return count > r.count ? 1 :
			count < r.count ? -1 : 0;
	}
}
public class TreeSetTest3
{
	public static void main(String[] args)
	{
		TreeSet ts = new TreeSet();
		ts.add(new R(-10));
		ts.add(new R(-5));
		ts.add(new R(1));
		ts.add(new R(20));
		// ��ӡTreeSet���ϣ�����Ԫ�����������е�
		System.out.println(ts);    // ��
		// ȡ����һ��Ԫ��
		R first = (R)ts.first();
		// �Ե�һ��Ԫ�ص�count��ֵ
		first.count = 10;
		// ȡ�����һ��Ԫ��
		R last = (R)ts.last();
		// �����һ��Ԫ�ص�count��ֵ����ڶ���Ԫ�ص�count��ͬ
		last.count = -5;
		// �ٴ����������TreeSet���Ԫ�ش�������״̬�������ظ�Ԫ��
		System.out.println(ts);   // ��
		// ɾ��ʵ���������ı��Ԫ�أ�ɾ��ʧ��
		System.out.println(ts.remove(new R(-5)));   // ��
		System.out.println(ts);
		// ɾ��ʵ������û�б��ı��Ԫ�أ�ɾ���ɹ�
		System.out.println(ts.remove(new R(1)));    // ��
		System.out.println(ts);
	}
}
