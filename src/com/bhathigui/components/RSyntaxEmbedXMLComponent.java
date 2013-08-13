package com.bhathigui.components;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.swing.*;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.Gutter;
import org.fife.ui.rtextarea.RTextScrollPane;


/**
 * now this extends JPanel which is embeddable 
 * 
 * modified by Bhathiya Perera
 * 
 * The root pane used by the demos.  This allows both the applet and the
 * stand-alone application to share the same UI. 
 *
 * @author Robert Futrell
 * @version 1.0
 */
public class RSyntaxEmbedXMLComponent extends JPanel implements SyntaxConstants {

	private RTextScrollPane scrollPane;
	private RSyntaxTextArea textArea;


	public RSyntaxEmbedXMLComponent() {
                setLayout(new BorderLayout());
		textArea = createTextArea();
		textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_XML);
		scrollPane = new RTextScrollPane(textArea, true);
		Gutter gutter = scrollPane.getGutter();
		gutter.setBookmarkingEnabled(true);
		URL url = getClass().getClassLoader().getResource("com/bhathigui/res/bookmark.png");
		gutter.setBookmarkIcon(new ImageIcon(url));
		add(scrollPane,BorderLayout.CENTER);
                
	}

	/**
	 * Creates the text area for this application.
	 *
	 * @return The text area.
	 */
	private RSyntaxTextArea createTextArea() {
		RSyntaxTextArea zRsyntax = new RSyntaxTextArea(25, 70);
		zRsyntax.setTabSize(3);
		zRsyntax.setCaretPosition(0);
		zRsyntax.requestFocusInWindow();
		zRsyntax.setMarkOccurrences(true);
		zRsyntax.setCodeFoldingEnabled(true);
		zRsyntax.setClearWhitespaceLinesEnabled(false);
		return zRsyntax;
	}


	/**
	 * Focuses the text area.
	 */
	void focusTextArea() {
		textArea.requestFocusInWindow();
	}
        
        
        /**
         * 
         * @param iread inputstream to read from
         */
	public void setText(InputStream iread) {
		BufferedReader r;
		try {
			r = new BufferedReader(new InputStreamReader(iread));
			textArea.read(r, null);
			r.close();
			textArea.setCaretPosition(0);
			textArea.discardAllEdits();
		} catch (RuntimeException re) {
			//throw re; // FindBugs
		} catch (Exception e) { // Never happens
			//textArea.setText("Type here to see syntax highlighting");
		}
	}

    public RSyntaxTextArea getTextArea() {
        return textArea;
    }
       
        
}