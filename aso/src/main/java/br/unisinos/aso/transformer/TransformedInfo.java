package br.unisinos.aso.transformer;

public class TransformedInfo {
	private String chartUrl;
	private String bloodPressureComparisonChartUrl;

	public String getChartUrl() {
		return chartUrl;
	}

	public void setChartUrl(String chartUrl) {
		this.chartUrl = chartUrl;
	}

	public void setComparisonChartUrl(String bloodPressureComparisonChartUrl) {
		this.bloodPressureComparisonChartUrl = bloodPressureComparisonChartUrl;
	}
	
	public String getBloodPressureComparisonChartUrl() {
		return bloodPressureComparisonChartUrl;
	}

}