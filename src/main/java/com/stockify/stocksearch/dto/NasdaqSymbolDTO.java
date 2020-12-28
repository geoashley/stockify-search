package com.stockify.stocksearch.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NasdaqSymbolDTO {
    private String symbol;
    private String securityName;

    private String marketCategory;
    private String testIssue;
    private String financialStatus;
    private String roundLotSize;
    private String ETF;
    private String nextShares;



    public static class Builder{
        private String symbol;
        private String securityName;
        private String marketCategory;
        private String testIssue;
        private String financialStatus;
        private String roundLotSize;
        private String ETF;
        private String nextShares;

        public Builder withSymbol(String symbol) {
            this.symbol = symbol;
            return this;
        }

        public Builder withSecurityName(String securityName) {
            this.securityName = securityName;
            return this;
        }

        public Builder withMarketCategory(String marketCategory) {
            this.marketCategory = marketCategory;
            return this;
        }

        public Builder withTestIssue(String testIssue) {
            this.testIssue = testIssue;
            return this;
        }

        public Builder withFinancialStatus(String financialStatus) {
            this.financialStatus = financialStatus;
            return this;
        }

        public Builder withRoundLotSize(String roundLotSize) {
            this.roundLotSize = roundLotSize;
            return this;
        }

        public Builder withETF(String ETF) {
            this.ETF = ETF;
            return this;
        }

        public Builder withNextShares(String nextShares) {
            this.nextShares = nextShares;
            return this;
        }

        public NasdaqSymbolDTO build(){
            return new NasdaqSymbolDTO(symbol,securityName,marketCategory, testIssue, financialStatus, roundLotSize, ETF, nextShares);
        }
    }
}
