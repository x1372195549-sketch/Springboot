package top.jzxue.week04.utils;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import top.jzxue.week04.exception.BusinessException;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.UUID;

@Slf4j
public class FileUploadUtil {
    public static final String UPLOAD_DIR
            = System.getProperty("user.dir") + "/target/classes/static/upload/";

    static {
        File dir = new File(UPLOAD_DIR);
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                throw new RuntimeException("创建上传目录失败: " + UPLOAD_DIR);
            }
        }
    }

    /**
     * 允许上传的文件类型白名单
     */
    private static final Set<String> ALLOWED_EXTENSIONS = Set.of(
            // 图片
            ".jpg", ".jpeg", ".png", ".gif", ".bmp", ".webp",
            // 文档
            ".pdf", ".doc", ".docx", ".xls", ".xlsx", ".ppt", ".pptx",
            // 文本
            ".txt", ".md", ".csv",
            // 压缩包
            ".zip", ".rar", ".7z",
            // 其他
            ".json", ".xml"
    );

    // 2. 彻底删除整个 getUploadDir() 方法（从方法头到右大括号全删）

    public static String upload(MultipartFile file) throws IOException {
        // 文件名校验
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || originalFilename.isEmpty()) {
            throw new BusinessException(400, "文件名不能为空");
        }
        // 获取文件后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        // 文件类型校验
        if (!ALLOWED_EXTENSIONS.contains(suffix)) {
            throw new BusinessException(400, "不支持的文件类型: " + suffix);
        }
        // 拼接新文件名，并创建新文件
        String fileName = UUID.randomUUID() + suffix;
        File dest = new File(UPLOAD_DIR + fileName);
        // 保存新文件到上传目录（上传）
        file.transferTo(dest);
        return fileName;
    }
}
