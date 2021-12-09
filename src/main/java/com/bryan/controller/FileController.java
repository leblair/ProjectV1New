package com.bryan.controller;


import com.bryan.domain.dto.Error;
import com.bryan.domain.dto.FilesResult;
import com.bryan.domain.dto.ResponseList;
import com.bryan.domain.model.FileTable;
import com.bryan.repository.FileRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/files") //con que intencion lo vamos a mapear
//cuando pidan /hello accederan a este controlador
public class FileController {
    //este es el endpoint, el que recibe las peticiones http://algo/movies hace la peticion y devuelve el json
    //el endpoint es lo que va despues del servidor

    private final FileRepository fileRepository;

    FileController(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @GetMapping("/")
    public ResponseList filesTable(){


        return new ResponseList(fileRepository.findBy()) ;
    }
    //para hacer proyecciones select fileid,content

    //peticion por get y "/algo"
    @GetMapping("/{id}") //array de byte[]?
    public ResponseEntity<?> getId(@PathVariable UUID id) {
        FileTable file = fileRepository.findById(id).orElse(null);

        if (file == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Error.message("No s'ha trobat l'arxiu amd id '"+id+"'"));

        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(file.contenttype))
                .contentLength(file.data.length)
                .body(file.data);
    }



    @PostMapping("/")
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile uploadedFile) {
        try {
            System.out.println(uploadedFile.getOriginalFilename() + ", " + uploadedFile.getContentType());
            FileTable file = new FileTable();
            file.contenttype = uploadedFile.getContentType();
            file.data = uploadedFile.getBytes();

            fileRepository.save(file);
            FilesResult fileResult = new FilesResult(file.fileid, file.contenttype);

            return ResponseEntity.ok().body(fileResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /*
    @GetMapping
    public String hack() {
        List<String> files = fileRepository.getFileIds();

        String filesStr = "";
        for (String file : files) {
            filesStr += "<img src='/files/"+file+"' style='width:15em'>";
        }

        return "<form method=\"POST\" enctype=\"multipart/form-data\" style=\"display:flex;\">\n" +
                "    <input id=\"file\" type=\"file\" name=\"file\" style=\"display:none\" onchange=\"document.getElementById('preview').src=window.URL.createObjectURL(event.target.files[0])\">\n" +
                "    <label for=\"file\" style=\"border: 1px dashed #999\">\n" +
                "        <img id=\"preview\" src=\"\" style=\"width:64px;\">\n" +
                "    </label>\n" +
                "    <input type=\"submit\" style=\"background:#0096f7;color: white;border: 0;border-radius: 3px;padding: 8px;\" value=\"Upload\">\n" +
                "</form>\n <div style='display:flex;flex-wrap:wrap;gap:1em;'>" + filesStr + "</div>";
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFile(@PathVariable UUID id){
       /* for(FileTable fileTable : fileRepository.findAll()){
            if(fileTable.fileid.equals(id)){
                fileRepository.delete(fileTable);
                return ResponseEntity.ok().body("S'ha eliminat l'usuari amd id '"+ fileTable.fileid + "'");
            }
        }
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Error.message("No s'ha trobat el File amb id '" + id + "'"));*/
        FileTable file = fileRepository.findById(id).orElse(null);

        if (file == null) {return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Error.message("No s'ha trobat l'arxiu amd id '"+id+"'"));}
        //si no ha encontrado

        fileRepository.delete(file);//elimina el anime con ese id
        return ResponseEntity.ok().body(Error.message("S'ha eliminat l'anime amb id '"+id+"'"));
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteUsers(){
        fileRepository.deleteAll();
        return ResponseEntity.ok().body("Files borrats.");
    }

}