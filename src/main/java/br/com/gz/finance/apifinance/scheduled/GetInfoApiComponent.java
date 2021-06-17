package br.com.gz.finance.apifinance.scheduled;

import br.com.gz.finance.apifinance.service.UpdateValuesAcaoService;
import br.com.gz.finance.apifinance.util.CotacaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GetInfoApiComponent {

    @Autowired
    private UpdateValuesAcaoService updateValuesAcaoService;

    @Async
    @Scheduled(cron = "0 0/1 10-18 2-6 * *") // 10-18
    public void geraInfo() {
        this.updateValuesAcaoService.updateValuesInBd(CotacaoUtil.cotacoes);
    }
}
