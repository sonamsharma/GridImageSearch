package com.codepath.example.gridimagesearch;

import java.io.Serializable;

public class AdvanceSettings implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4739876770519426008L;
	private String iSize;
	private String iColor;
	private String iType;
	private String iSiteFilter;

	AdvanceSettings(String size, String color, String type, String siteFilter) {
		this.iSize = size;
		this.iColor = color;
		this.iType = type;
		this.iSiteFilter = siteFilter;
	}
	public String getSize() {
		return iSize;
	}

	public String getColor() {
		return iColor;
	}

	public String getType() {
		return iType;
	}

	public String getSiteFilter() {
		return iSiteFilter;
	}
	public String toString() {
		return "Size=" + iSize + ",Color=" + iColor + ",Type=" + iType + ",Site="
				+ iSiteFilter;
	}

		/*private String iSize;
		private String iColor;
		private String iType;
		private String iSiteFilter;

		AdvanceSettings() {
			iSize = "";
			iColor = "";
			iSiteFilter = "";
			iType = "";
		}

		public String getSize() {
			return iSize;
		}

		public void setSize(String size) {
			iSize = size;
		}

		public String getColor() {
			return iColor;
		}

		public void setColor(String color) {
			iColor = color;
		}

		public String getType() {
			return iType;
		}

		public void setType(String type) {
			iType = type;
		}

		public String getSiteFilter() {
			return iSiteFilter;
		}

		public void setSiteFilter(String siteFilter) {
			iSiteFilter = siteFilter;
		}
		*/

}
