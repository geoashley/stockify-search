package com.stockify.stocksearch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileDTO {
    public FileDTO() {
    }
    private String fileName;
    private FileTypes fileType;

    public static enum FileTypes{
        all,nasdaq_only
    }

}
