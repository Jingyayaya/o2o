package com.science.o2o.enums;

public enum ShopStateEnum {
	CHECK(0, "Under review"),
	OFFLINE(-1, "Illegal shop"),
	SUCCESS(1, "Operation is successful"),
	PASS(2, "Certified"),
	INNER_ERROR(-1001,
			"System error"),
	NULL_SHOPID(-1002, "ShopId is null"),
	NULL_SHOP(-1003, "shop info is empty");
	private int state;
	private String stateInfo;

	private ShopStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	/**
	 * return enum value
	 */
	public static ShopStateEnum stateOf(int state) {
		for (ShopStateEnum stateEnum : values()) {
			if (stateEnum.getState() == state) {
				return stateEnum;
			}
		}
		return null;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

}
