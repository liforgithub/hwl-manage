package com.huowulian365.condition;

import com.huowulian365.center.base.condition.BaseCondition;
import lombok.Data;

import java.util.List;

@Data
public class CamInfoCondition extends BaseCondition {

	/**
	 * id
	*/
	private Integer id;
	/**
	 * id列表
	*/
	private List<Integer> idList;
	/**
	 * 名称
	*/
	private String name;
	/**
	 * ysid
	*/
	private String ysid;
}