package com.ssafy.tong.expert.model;

public class ExpertImage {
	private int fileId;
	private int expertId;
	private String filePath;
	private String oriName;
	private String systemName;
	private String extension;
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public int getExpertId() {
		return expertId;
	}
	public void setExpertId(int expertId) {
		this.expertId = expertId;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getOriName() {
		return oriName;
	}
	public void setOriName(String oriName) {
		this.oriName = oriName;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	@Override
	public String toString() {
		return "ExpertImage [fileId=" + fileId + ", expertId=" + expertId + ", filePath=" + filePath + ", oriName="
				+ oriName + ", systemName=" + systemName + ", extension=" + extension + "]";
	} 
}
