package br.com.gz.finance.apifinance.converter;

import br.com.gz.finance.apifinance.model.Acao;
import br.com.gz.finance.apifinance.model.AcaoDto;

import java.math.RoundingMode;

public class AcaoDTOConverter {

    public static AcaoDto toAcaoDto(Acao acao) {
        AcaoDto acaoDTO = new AcaoDto();
        acaoDTO.setSimbolo(acao.getSymbol());
        acaoDTO.setUltAltCotacao(acao.getRegularMarketTime());
        acaoDTO.setPreco(acao.getRegularMarketPrice());
        acaoDTO.setPercentual(acao.getRegularMarketChangePercent().setScale(2, RoundingMode.HALF_UP));
        return acaoDTO;
    }
}
