/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package internnet2;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import domein.Student;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;

/**
 *
 * @author laurens
 */
public class Pdf {
    
    public void createPdf(String filename,Student student)
	throws DocumentException, IOException {
      
        PdfReader pdfReader = new PdfReader("stagecontract.pdf");
        String defaultFolder=new JFileChooser().getFileSystemView().getDefaultDirectory().toString()+"\\InternNet\\";
        File dir = new File(defaultFolder);
        dir.mkdir();
        PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(defaultFolder+filename));
        pdfStamper.close();
       
        
        
    }
}
