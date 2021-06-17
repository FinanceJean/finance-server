package br.com.gz.finance.apifinance;

import br.com.gz.finance.apifinance.service.YahooFinanceApiService;
import br.com.gz.finance.apifinance.util.CotacaoUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;

@Profile("dev")
@SpringBootTest
class ApiFinanceApplicationTests {

    @Autowired
    private YahooFinanceApiService yahooFinanceApiService;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldReturnPriceBySymbol() {
        Object price = yahooFinanceApiService.findCotacaoBySymbol("OIBR4");
        assertThat(price).isNotNull();
    }

    @Test
    void shouldReturnValueCorrectWhenAcaoIsUp() {
        BigDecimal percentual = CotacaoUtil.getPercentualAumentoAcao(new BigDecimal(18.30), new BigDecimal(18.89));
        assertThat(percentual).isEqualTo(new BigDecimal(3.22).setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    void shouldReturnValueCorrectWhenAcaoIsDown() {
        BigDecimal percentual = CotacaoUtil.getPercentualAumentoAcao(new BigDecimal(1.75), new BigDecimal(1.67));
        assertThat(percentual).isEqualTo(new BigDecimal(4.57).setScale(2, RoundingMode.HALF_UP));
    }
}
