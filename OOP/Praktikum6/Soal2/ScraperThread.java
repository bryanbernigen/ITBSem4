package Soal2;

import java.util.ArrayList;

public class ScraperThread implements Runnable {
    private Website website;
    private ThreadListener listener;
    private String prefix;
    private String year;
    private int suffixFirst;
    private int suffixLast;

	// TODO: constructor
	public ScraperThread(Website website, ThreadListener listener, String prefix, String year, int suffixFirst, int suffixLast) {
		this.website = website;
		this.listener = listener;
		this.prefix = prefix;
		this.year = year;
		this.suffixFirst = suffixFirst;
		this.suffixLast = suffixLast;
	}
	
	// TODO: thread method
	// PROCEDURE:
	// 1. Construct NIM from given prefix, year, and suffixes.
	// 2. For each NIM constructed, get data from website.
	// 3. For each student data got from website, store in ArrayList
	public void run() {
		ArrayList<Student> result = new ArrayList<Student>();
		for (int i = suffixFirst; i <= suffixLast; i++) {
			String nim = prefix + year + String.format("%03d", i);
			Student student = website.getStudentDataByNIM(nim);
			result.add(student);
		}
		this.listener.onSuccess(result);
	}
}