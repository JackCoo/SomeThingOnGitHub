package org.fkit.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;
/**
 * 
 * @XmlRootElement(name ="xxx")
 * 		将java对象的属性映射为xml的根节点，同时可以重命名该节点。
 * @XmlElement(name = "xxx")
 * 
 * @author C4y
 *
 */
@Component
@XmlRootElement(name = "NewestGoodsList")
public class ListGoodsOverview {
    
	private List<GoodsOverview> goodOvList;
	
	@XmlElement(name = "Goods",required = true)
	public List<GoodsOverview> getGoodOvList() {
		return goodOvList;
	}

	public void setGoodOvList(List<GoodsOverview> goodOvList) {
		this.goodOvList = goodOvList;
	}

	@Override
	public String toString() {
		return "TestGoodsOvList [goodOvList=" + goodOvList + "]";
	}
	
}
