package br.com.gz.finance.apifinance.controller;

import br.com.gz.finance.apifinance.model.Acao;
import br.com.gz.finance.apifinance.model.AcaoDto;
import br.com.gz.finance.apifinance.service.AcaoService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teste")
public class AcaoController {

    @Autowired
    private AcaoService acaoService;

    @GetMapping("find-dados-by-symbol/{symbol}")
    public Acao findDadosAcao(@PathVariable("symbol") String symbol) {
        return acaoService.findAcaoBySymbol(symbol);
    }

    @GetMapping("find-acoes-by-usuario/{username}")
    public List<AcaoDto> findAll(@PathVariable("username") @NonNull String username) {
        return acaoService.findAllAcaoByUsuario(username);
    }

    @GetMapping("complete")
    public List<Acao> complete(@RequestParam("query") String query) {
        return acaoService.complete(query);
    }
}
