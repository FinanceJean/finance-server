package br.com.gz.finance.apifinance.controller;

import br.com.gz.finance.apifinance.service.UpdateValuesAcaoService;
import br.com.gz.finance.apifinance.util.CotacaoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("teste-api")
public class TesteController {

    @Autowired
    private UpdateValuesAcaoService updateValuesAcaoService;

    @GetMapping
    public void getCotacoes() {
        updateValuesAcaoService.updateValuesInBd(CotacaoUtil.cotacoes);
    }
}
