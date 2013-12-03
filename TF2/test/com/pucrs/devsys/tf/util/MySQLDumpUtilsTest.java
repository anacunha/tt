package com.pucrs.devsys.tf.util;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class MySQLDumpUtilsTest {


	
	@Test
	public void getDumpBackupOk() {
		MySQLDumpUtils md = new MySQLDumpUtils();
				try {
					md.backup();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
	}
	
	@Test
	public void getDumpBackupNotOk() {
		MySQLDumpUtils md = new MySQLDumpUtils();
				try {
					md.dump( "C:/Users/israelberbigier/Documents/m", "", "88hbtb", "basedetest" );  
				} catch (Exception e) {
					
					assertEquals(new IOException(), e);
				}
				
	}
	
	
	@Test
	public void getDumpRestoreOk() {
		MySQLDumpUtils md = new MySQLDumpUtils();
				try {
					md.restore();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
	}
	
	@Test
	public void getDumpRestoreNotOk() {
		MySQLDumpUtils md = new MySQLDumpUtils();
		try {
			md.restore("C:\\Users\\israelberbigier\\Documents\\minhaBase.sql", "localho", "3006", "root", "88hbtb", "basedetest");
		} catch (Exception e) {
			assertEquals(new IOException(), e);
		}  
	}
	
	

}
