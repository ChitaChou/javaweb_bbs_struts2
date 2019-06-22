package com.discovery.utils;

public class GetExtention {
	public static String getExt(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
	}
}
