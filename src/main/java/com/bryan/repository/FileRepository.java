package com.bryan.repository;

import com.bryan.domain.model.FileTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface FileRepository extends JpaRepository<FileTable, UUID> {

    @Query("select fileid from FileTable")
    List<String> getFileIds();
}
