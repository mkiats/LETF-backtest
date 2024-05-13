package com.mkiats.backtest.service.strategy.financialRatio.impl;

import com.mkiats.backtest.service.strategy.financialRatio.output.FinancialRatioOutput;
import com.mkiats.backtest.service.strategy.financialRatio.interfaces.FinancialRatioStrategy;
import com.mkiats.backtest.service.strategy.investment.InvestmentOutput;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Sortino implements FinancialRatioStrategy {
    private final List<String> ratioDependencies = List.of("CompoundAnnualGrowthRate", "StandardDeviation");


    @Override
    public FinancialRatioOutput computeRatio(InvestmentOutput investmentOutput, FinancialRatioOutput financialRatioOutput) {
        System.out.println("Computing Sortino...");
        return financialRatioOutput;
    }

    @Override
    public List<String> getRatioDependencies() {
        return this.ratioDependencies;
    }
}
