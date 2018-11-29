package com.seongwon.junit;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class SpreadsheetData{
    private transient Collection data = null;
    
    public SpreadsheetData(final InputStream excelInputStream) throws IOException{
        this.data = loadFromSpreadsheet(excelInputStream);
    }
    public Collection getData(){
        return data;
    }
    private Collection loadFromSpreadsheet(final InputStream excelFile)
        throws IOException{
            HSSFWorkbook workbook = new HSSFWorkbook(excelFile);
            
            data = new ArrayList();
            Sheet sheet = workbook.getSheetAt(0);

            int numberOfColumns = countNonEmptyColumns(sheet);
            List rows = new ArrayList();
            List rowData = new ArrayList();

            for(Row row : sheet){
                if (isEmpty(row)){
                    break;
                } else {
                    rowData.clear();
                    for (int column = 0; column < numberOfColumns; column++){
                        Cell cell = row.getCell(column);
                        rowData.add(objectFrom(workbook, cell));
                    }
                    rows.add(rowData.toArray());
                }
            }
            return rows;
    }
    private boolean isEmpty(final Row row){
        Cell firstCell = row.getCell(0);
        boolean rowIsEmpty = (firstCell == null)
            || (firstCell.getCellType() == CellType.BLANK );
        return rowIsEmpty;
    }
    private int countNonEmptyColumns(final Sheet sheet){
        Row firstRow = sheet.getRow(0);
        return firstEmptyCellPosition(firstRow);
    }
    private int firstEmptyCellPosition(final Row cells){
        int columnCount = 0;
        for(Cell cell : cells){
            if (cell.getCellType() == CellType.BLANK){
                break;
            }
            columnCount++;
        }
        return columnCount;
    }
    private Object objectFrom(final HSSFWorkbook workbook, final Cell cell){
        Object cellValue = null;

        if(cell.getCellType() == CellType.STRING){
            cellValue = cell.getRichStringCellValue().getString();
        } else if (cell.getCellType() == CellType.NUMERIC){
            cellValue = cell.getBooleanCellValue();
        } else if (cell.getCellType() == CellType.FORMULA){
            cellValue = evaluateCellFormula(workbook, cell);
        }
        return cellValue;
    }
    private Object getNumericCellValue(final Cell cell){
        Object cellValue;
        if(DateUtil.isCellDateFormatted(cell)){
            cellValue = new Date(cell.getDateCellValue().getTime());
        } else {
            cellValue = cell.getNumericCellValue();
        }
        return cellValue;
    }
    private Object evaluateCellFormula(final HSSFWorkbook workbook, final Cell cell){
        FormulaEvaluator evaluator = workbook.getCreationHelper()
            .createFormulaEvaluator();
        CellValue cellValue = evaluator.evaluate(cell);
        Object result = null;

        if(cellValue.getCellType() == CellType.BOOLEAN){
            result = cellValue.getBooleanValue();
        } else if(cellValue.getCellType() == CellType.NUMERIC){
            result = cellValue.getNumberValue();
        } else if (cellValue.getCellType() == CellType.STRING){
            result = cellValue.getStringValue();
        }
        return result;
    }
}