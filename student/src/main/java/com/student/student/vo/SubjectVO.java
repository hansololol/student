package com.student.student.vo;

import org.springframework.stereotype.Component;

@Component("subjectVO")
public class SubjectVO {
	private String korean;
	private String math;
	private String english;
	private String history;
	private String id;
	private int Avg;
	private int Sum;
	private int Rank;
	
	
	public String getKorean() {
		return korean;
	}
	public void setKorean(String korean) {
		this.korean = korean;
	}
	public String getMath() {
		return math;
	}
	public void setMath(String math) {
		this.math = math;
	}
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		this.english = english;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAvg() {
		return Avg;
	}
	public void setAvg(int avg) {
		Avg = avg;
	}
	public int getSum() {
		return Sum;
	}
	public void setSum(int sum) {
		Sum = sum;
	}
	public int getRank() {
		return Rank;
	}
	public void setRank(int rank) {
		Rank = rank;
	}

}
