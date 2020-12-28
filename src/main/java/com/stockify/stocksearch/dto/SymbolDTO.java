package com.stockify.stocksearch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SymbolDTO implements SymbolBaseDTO{
    private String symbol;
    private String securityName;

    private String lastSale;
    private String netChange;
    private String percentChange;
    private String marketCap;
    private String country;
    private String ipoYear;
    private String volume;
    private String sector;
    private String industry;

    @Override
    public SymbolBaseDTO mapNewSymbol(String[] tokens) {
        return SymbolDTO.SymbolDTOBuilder.aSymbolDTO()
                .withSymbol(tokens[0])
                .withSecurityName(tokens[1])
                .build();
    }

    public static final class SymbolDTOBuilder {
        private String symbol;
        private String securityName;
        private String lastSale;
        private String netChange;
        private String percentChange;
        private String marketCap;
        private String country;
        private String ipoYear;
        private String volume;
        private String sector;
        private String industry;

        private SymbolDTOBuilder() {
        }

        public static SymbolDTOBuilder aSymbolDTO() {
            return new SymbolDTOBuilder();
        }

        public SymbolDTOBuilder withSymbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public SymbolDTOBuilder withSecurityName(String securityName) {
            this.securityName = securityName;
            return this;
        }

        public SymbolDTOBuilder withLastSale(String lastSale) {
            this.lastSale = lastSale;
            return this;
        }

        public SymbolDTOBuilder withNetChange(String netChange) {
            this.netChange = netChange;
            return this;
        }

        public SymbolDTOBuilder withPercentChange(String percentChange) {
            this.percentChange = percentChange;
            return this;
        }

        public SymbolDTOBuilder withMarketCap(String marketCap) {
            this.marketCap = marketCap;
            return this;
        }

        public SymbolDTOBuilder withCountry(String country) {
            this.country = country;
            return this;
        }

        public SymbolDTOBuilder withIpoYear(String ipoYear) {
            this.ipoYear = ipoYear;
            return this;
        }

        public SymbolDTOBuilder withVolume(String volume) {
            this.volume = volume;
            return this;
        }

        public SymbolDTOBuilder withSector(String sector) {
            this.sector = sector;
            return this;
        }

        public SymbolDTOBuilder withIndustry(String industry) {
            this.industry = industry;
            return this;
        }

        public SymbolDTO build() {
            return new SymbolDTO(symbol, securityName, lastSale, netChange, percentChange, marketCap, country, ipoYear, volume, sector, industry);
        }
    }
}
