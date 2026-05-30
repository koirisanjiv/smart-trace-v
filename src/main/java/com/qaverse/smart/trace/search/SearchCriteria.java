package com.qaverse.smart.trace.search;

public class SearchCriteria {

	private SearchFields field;

	private SearchOperator operator;

	private String value;

	public SearchFields getField() {
		return field;
	}

	public void setField(SearchFields field) {

		this.field = field;
	}

	public SearchOperator getOperator() {
		return operator;
	}

	public void setOperator(SearchOperator operator) {

		this.operator = operator;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {

		this.value = value;
	}
}