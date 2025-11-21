/*package com.atacorp.SISEAN.decoupageAdministratif.region;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class RegionExcelService {
	@Autowired
	RegionRepository repository;
	
	static String[] header = { "codeRegion", "nomRegion"};
	
	public static List<Region> excelToRegion(InputStream is) {
		List<Region> listeRegions = new ArrayList<Region>();
		try {
	    	
	      Workbook workbook = new XSSFWorkbook(is);
	      Sheet sheet = workbook.getSheetAt(0);
	      Iterator<Row> rows = sheet.iterator();
	      //
	      int rowNumber = 0;
	      while (rows.hasNext()) {
	        Row currentRow = rows.next();
	        // skip header
	        if (rowNumber == 0) {
	          rowNumber++;
	          continue;
	        }

	        Iterator<Cell> cellsInRow = currentRow.iterator();
	        Region region = new Region();
	        int cellIdx = 0;
	        while (cellsInRow.hasNext()) {
	          Cell currentCell = cellsInRow.next();
	          switch (cellIdx) {
	          case 0:
	        	  region.setCodeRegion(currentCell.getStringCellValue());
	            break;
	          case 1:
	        	  region.setNomRegion(currentCell.getStringCellValue());
	            break;
	          default:
	            break;
	          }
	          
	          cellIdx++;
	        }

	        listeRegions.add(region);
	      }

	      workbook.close();
	      
	    } catch (IOException e) {
	    	System.out.println(e);
	    }
		return listeRegions;
	  }
	
	public void importData(MultipartFile file) {
	    try {
	      List<Region> listRegions = this.excelToRegion(file.getInputStream());
	      repository.saveAll(listRegions);
	    } catch (IOException e) {
	    	System.out.println(e);
	     
	    }
	  }
	
	 public static ByteArrayInputStream regionToExcel(List<Region> regions) {

		    try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
		      Sheet sheet = workbook.createSheet("regions");
		      // Header
		      Row headerRow = sheet.createRow(0);

		      for (int col = 0; col < header.length; col++) {
		        Cell cell = headerRow.createCell(col);
		        cell.setCellValue(header[col]);
		      }

		      int rowIdx = 1;
		      for (Region region : regions) {
		        Row row = sheet.createRow(rowIdx++);

		        row.createCell(0).setCellValue(region.getCodeRegion());
		        row.createCell(1).setCellValue(region.getNomRegion());
		      }

		      workbook.write(out);
		      return new ByteArrayInputStream(out.toByteArray());
		      
		    } catch (IOException e) {
		      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		    }
		  }
	 
	 public ByteArrayInputStream  exportData() {  
	    	List<Region> regions = (List<Region>) repository.findAll();
	    	ByteArrayInputStream in = RegionExcelService.regionToExcel(regions);
	    	return in;
		    
		  }
		
	
}*/
