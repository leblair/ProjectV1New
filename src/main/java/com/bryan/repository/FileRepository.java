package com.bryan.repository;

import com.bryan.domain.dto.FilesResult;
import com.bryan.domain.model.FileTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;
/*
public interface FileRepository extends JpaRepository<FileTable, UUID> {

    @Query("select fileid from FileTable")
    List<String> getFileIds();
}*/

public interface FileRepository extends JpaRepository<FileTable, UUID> {//quien le da la informacion de la tabla. Es quien hace las consultas
    // la tabla y el tipo de dato de la clave primaria
    //con interface genera la clase por cada consulta
//    List<String >

    //@Query("select new com.project.domain.dto.FileResult(fileid, contenttype) from FileTable")
    List<FilesResult> findBy();

}