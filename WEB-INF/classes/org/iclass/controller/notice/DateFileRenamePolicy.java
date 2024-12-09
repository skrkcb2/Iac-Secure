/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.oreilly.servlet.multipart.FileRenamePolicy
 */
package org.iclass.controller.notice;

import com.oreilly.servlet.multipart.FileRenamePolicy;
import java.io.File;
import java.util.Date;

public class DateFileRenamePolicy
implements FileRenamePolicy {
    public File rename(File file) {
        String parentDir = file.getParent();
        String fileName = file.getName();
        Object newFileName = String.valueOf(new Date().getTime());
        int dotIndex = fileName.lastIndexOf(".");
        String extension = dotIndex == -1 ? "" : fileName.substring(dotIndex);
        File newFile = new File(parentDir, (String)(newFileName = (String)newFileName + extension));
        if (newFile.exists()) {
            return this.rename(file);
        }
        return newFile;
    }
}
