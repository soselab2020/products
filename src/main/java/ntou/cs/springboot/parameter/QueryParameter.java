package ntou.cs.springboot.parameter;

public class QueryParameter {
	private String keyword;
	private String orderedBy;
	private String sortRule;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getOrderedBy() {
		return orderedBy;
	}

	public void setOrderedBy(String orderedBy) {
		this.orderedBy = orderedBy;
	}

	public String getSortRule() {
		return sortRule;
	}

	public void setSortRule(String sortRule) {
		this.sortRule = sortRule;
	}

	@Override
	public String toString() {
		return "QueryParameter{" + "keyword='" + keyword + '\'' + ", orderedBy='" + orderedBy + '\'' + ", sortRule='"
				+ sortRule + '\'' + '}';
	}
}
