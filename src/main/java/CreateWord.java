import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class CreateWord {

    public void writeInWord(List<Coefficient> coefficients) throws IOException {
        XWPFDocument document = new XWPFDocument();

        //Write the Document in file system
        FileOutputStream out = new FileOutputStream(new File("/home/solii/IdeaProjects/EcoLab1/da.docx"));

        //create table
        XWPFTable table = document.createTable();

        //create first row
        XWPFTableRow tableRowOne = table.getRow(0);
        tableRowOne.getCell(0).setText("Показник");
        tableRowOne.addNewTableCell().setText("Значення");

        for (Coefficient coefficient : coefficients) {
            XWPFTableRow nextRow = table.createRow();
            nextRow.getCell(0).setText(coefficient.getName());
            nextRow.getCell(1).setText(String.valueOf(coefficient.getValue()));
        }

        document.write(out);
        out.close();
        System.out.println("create_table.docx written successully");
    }
}
