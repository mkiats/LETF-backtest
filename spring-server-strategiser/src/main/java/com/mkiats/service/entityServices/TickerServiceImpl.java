package com.mkiats.service.entityServices;

import com.mkiats.dao.TickerRepository;
import com.mkiats.entity.Ticker;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class TickerServiceImpl implements TickerService{
    private final TickerRepository tickerRepo;

    public Ticker getTickerBySymbol(String theTickerSymbol){
        return tickerRepo.findByTickerSymbol(theTickerSymbol).orElseThrow(() ->  new RuntimeException("Ticker symbol cannot be found"));
    }
}