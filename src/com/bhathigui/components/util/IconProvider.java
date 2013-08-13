package com.bhathigui.components.util;

import java.util.HashMap;
import javax.swing.ImageIcon;

/**
 * Provide an icon for the given file
 * @author Bhathiya Perera
 */
public class IconProvider {
    public static final ImageIcon archiveIcon    = new ImageIcon(IconProvider.class.getResource("/com/bhathigui/res/extensions/file_extension_zip.png"));
    public static final ImageIcon bmpIcon    = new ImageIcon(IconProvider.class.getResource("/com/bhathigui/res/extensions/file_extension_bmp.png"));
    public static final ImageIcon gifIcon    = new ImageIcon(IconProvider.class.getResource("/com/bhathigui/res/extensions/file_extension_gif.png"));
    public static final ImageIcon htmIcon    = new ImageIcon(IconProvider.class.getResource("/com/bhathigui/res/extensions/file_extension_htm.png"));
    public static final ImageIcon jpgIcon    = new ImageIcon(IconProvider.class.getResource("/com/bhathigui/res/extensions/file_extension_jpg.png"));
    public static final ImageIcon logIcon    = new ImageIcon(IconProvider.class.getResource("/com/bhathigui/res/extensions/file_extension_log.png"));
    public static final ImageIcon pngIcon    = new ImageIcon(IconProvider.class.getResource("/com/bhathigui/res/extensions/file_extension_png.png"));
    public static final ImageIcon txtIcon    = new ImageIcon(IconProvider.class.getResource("/com/bhathigui/res/extensions/file_extension_txt.png"));
    public static final ImageIcon progIcon    = new ImageIcon(IconProvider.class.getResource("/com/bhathigui/res/extensions/programming.png"));
    public static final ImageIcon unknownIcon    = new ImageIcon(IconProvider.class.getResource("/com/bhathigui/res/extensions/unknown.png"));
    public static final ImageIcon folderIcon    = new ImageIcon(IconProvider.class.getResource("/com/bhathigui/res/extensions/Folder.png"));
    public static final ImageIcon computerIcon    = new ImageIcon(IconProvider.class.getResource("/com/bhathigui/res/extensions/computer.png"));
    public static final ImageIcon diskIcon    = new ImageIcon(IconProvider.class.getResource("/com/bhathigui/res/extensions/drive_disk.png"));
    
    private static final HashMap<String,ImageIcon> IconStore;
    static{
        IconStore = new HashMap<String, ImageIcon>();
        IconStore.put(".zip", archiveIcon);
        IconStore.put(".bmp", bmpIcon);
        IconStore.put(".gif", gifIcon);
        IconStore.put(".jpg", jpgIcon);
        IconStore.put(".jpeg", jpgIcon);
        IconStore.put(".htm", htmIcon);
        IconStore.put(".html", htmIcon);
        IconStore.put(".xml", htmIcon);
        IconStore.put(".log", logIcon);
        IconStore.put(".png", pngIcon);
        IconStore.put(".txt", txtIcon);       
    }
    
    public static ImageIcon provide(String file){
        int pos = file.lastIndexOf(".");
        if(pos==-1){
            return unknownIcon;
        }
        String ext = file.toLowerCase().substring(pos);
        ImageIcon ico = IconStore.get(ext);
        if(ico==null) {
            return unknownIcon;
        }
        return ico;
    }
}
