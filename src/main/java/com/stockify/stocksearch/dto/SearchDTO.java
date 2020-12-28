package com.stockify.stocksearch.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchDTO {
    public SearchDTO() {
    }

    @JsonProperty("symbol")
    private String symbol;
}
