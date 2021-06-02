package com.login.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.bean.Question;

@Service
@Transactional
public class QuestionServiceImpl {
	@Autowired

	private static Workbook wb;
	private static Sheet sh;
	private static FileInputStream fis;
	private static FileOutputStream fos;
	private static Row row;
	private static Cell cell;

	public Question excel(int Id) throws Exception {

		fis = new FileInputStream("./assignment.xlsx");
		wb = WorkbookFactory.create(fis);
		sh = wb.getSheet("sheet1");
		int noOfRows = sh.getLastRowNum();
		System.out.println(noOfRows);
		
		int i = Id;

		Question question = new Question();

		question.setId(Id);

		Cell cell = sh.getRow(i).getCell(1);
		String ques= cell.toString();
		question.setQuestion(ques);

		Cell cell1 = sh.getRow(i).getCell(2);
		String answer = cell1.toString();
		question.setAnswer(answer);

		System.out.println(sh.getRow(i).getCell(0));
		System.out.println(sh.getRow(i).getCell(1));
		System.out.println(sh.getRow(i).getCell(2));
		return question;

	}
	

	@SuppressWarnings("deprecation")
	public static Question create(Question q) throws Exception {
		fis = new FileInputStream("./write.xlsx");
		wb = WorkbookFactory.create(fis);
		sh = wb.getSheet("sheet1");
		int noOfRows = sh.getLastRowNum();
		System.out.println(noOfRows);
		
		
		row=sh.createRow(1);
		
		cell=row.createCell(0);
		cell.setCellValue(q.getId());
		System.out.println(cell.getCellType());
		cell=row.createCell(1);
		cell.setCellValue(q.getQuestion());
		System.out.println(cell.getStringCellValue());
		cell=row.createCell(2);
		cell.setCellValue(q.getAnswer());
		System.out.println(cell.getStringCellValue());
		
		
		
	fos=new FileOutputStream("./write.xlsx");
		wb.write(fos);
		fos.flush();
		fos.close();
		return null;
	}


	}
