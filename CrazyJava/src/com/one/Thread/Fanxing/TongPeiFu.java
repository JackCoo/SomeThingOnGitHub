package com.one.Thread.Fanxing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <? extends T> 
 * 通配符上限，返回值丢失了子类信息，也会出现 父类 ——> 子类 的编译错误
 * 可以使用通配符下限
 * <? super T>
 * @author C4y
 *
 */
public class TongPeiFu {
	
	//T = Number,返回值为T即Number，src为T的子类
	public static <T> T copy (Collection<? extends T> src,Collection<T> dest){
		
		T last = null;
		for (T element:src){
			
			dest.add(element);
			last = element;
		}
		
		return last;
	}
	public static void main(String[] args) {
		
		List<Number> ln = new ArrayList<>();
		List<Integer> li = new ArrayList<>();
		//尝试将Number转换成Integer，编译出错
		//Integer last1 = copy(li,ln);
		//丢失了子类信息
		Number last2 = copy(li,ln);

	}

}
