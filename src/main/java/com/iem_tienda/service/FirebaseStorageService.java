
package com.iem_tienda.service;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {
    String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    // El BucketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "sonicwavecr.appspot.com";

    // Esta es la ruta básica de este proyecto SonicWave
    final String rutaSuperiorStorage = "sonicwavecr";

    // Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";

    // El nombre del archivo Json
    final String archivoJsonFile = "sonicwavecr-firebase-adminsdk.json";
}