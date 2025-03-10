package com.javaweb.controller;

import com.javaweb.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    private static final String UPLOAD_DIR = "/Users/yangxue/images/";

    /**
     * Téléverser un fichier - param file
     */
    @PostMapping("/upload")
    public Result upload(String name, Integer age , MultipartFile file) throws Exception {
        log.info("Téléverser un fichier ：{}, {}, {}", name, age, file);

        if(!file.isEmpty()){
            // Générer un nom de fichier unique
            String originalFilename = file.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
            String uniqueFileName = UUID.randomUUID().toString().replace("-", "") + extName;
            // Construire le chemin complet du fichier
            File targetFile = new File(UPLOAD_DIR + uniqueFileName);

            // Si le répertoire cible n'existe pas, le créer
            if (!targetFile.getParentFile().exists()) {
                targetFile.getParentFile().mkdirs();
            }
            // Enregistrer le fichier
            file.transferTo(targetFile);

        }
        return Result.success();
    }

}
