package org.bcaring.intellj.vue;

import com.intellij.openapi.fileTypes.FileTypeConsumer;
import com.intellij.openapi.fileTypes.FileTypeFactory;
import org.jetbrains.annotations.NotNull;

/**
 * auth : bqxu
 * create_at:  16/6/5.
 * desc:
 * note:
 * 1.
 */
public class VueFileTypeFactory extends FileTypeFactory {

    @Override
    public void createFileTypes(@NotNull FileTypeConsumer fileTypeConsumer) {
        fileTypeConsumer.consume(VueFileType.INSTANCE, "vue");
    }
}
