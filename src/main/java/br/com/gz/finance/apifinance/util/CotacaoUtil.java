package br.com.gz.finance.apifinance.util;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CotacaoUtil {

    public static final String[] cotacoes = {
            "CRPG6.SA",
            "CRPG5.SA",
            "BGIP4.SA",
            "HAGA4.SA",
            "CESP6.SA",
            "ABCB4.SA",
            "RSUL4.SA",
            "MTSA4.SA",
            "TRPL4.SA",
            "SAPR11.SA",
            "SAPR4.SA",
            "CESP3.SA",
            "SAPR3.SA",
            "BMEB3.SA",
            "BMEB4.SA",
            "BEES3.SA",
            "GPCP3.SA",
            "CRPG3.SA",
            "ELET5.SA",
            "CESP5.SA",
            "TAEE3.SA",
            "TAEE4.SA",
            "WHRL4.SA",
            "ENAT3.SA",
            "WHRL3.SA",
            "BEES4.SA",
            "SANB3.SA",
            "BRSR5.SA",
            "WIZS3.SA",
            "ETER3.SA",
            "ROMI3.SA",
            "EALT4.SA",
            "BTTL3.SA",
            "TRPL3.SA",
            "CSMG3.SA",
            "JHSF3.SA",
            "SANB4.SA",
            "CRIV3.SA",
            "EKTR4.SA",
            "EUCA4.SA",
            "BALM4.SA",
            "EKTR3.SA",
            "BRGE12.SA",
            "BSLI4.SA",
            "CRIV4.SA",
            "TGMA3.SA",
            "BGIP3.SA",
            "BALM3.SA",
            "NEOE3.SA",
            "FESA4.SA",
            "CSRN6.SA",
            "CSRN5.SA",
            "CBEE3.SA",
            "BRPR3.SA",
            "ALUP4.SA",
            "ATOM3.SA",
            "PSSA3.SA",
            "TKNO4.SA",
            "HAGA3.SA",
            "CSRN3.SA",
            "BRIV4.SA",
            "RPAD6.SA",
            "ITUB3.SA",
            "PTBL3.SA",
            "BRIV3.SA",
            "ALUP11.SA",
            "WLMM3.SA",
            "JOPA4.SA",
            "CEEB5.SA",
            "SULA4.SA",
            "BRGE8.SA",
            "AGRO3.SA",
            "SMTO3.SA",
            "CEEB3.SA",
            "AHEB3.SA",
            "AHEB5.SA",
            "RPAD3.SA",
            "JOPA3.SA",
            "COCE5.SA",
            "EEEL3.SA",
            "ITSA3.SA",
            "EQPA3.SA",
            "AHEB6.SA",
            "ALUP3.SA",
            "TRIS3.SA",
            "BRGE3.SA",
            "COCE3.SA",
            "FRTA3.SA",
            "TCNO4.SA",
            "WLMM4.SA",
            "CMIG3.SA",
            "SHUL4.SA",
            "GEPA3.SA",
            "ENMT3.SA",
            "ENMT4.SA",
            "BSLI3.SA",
            "EEEL4.SA",
            "FESA3.SA",
            "SLCE3.SA",
            "SULA3.SA",
            "TIET11.SA",
            "TIET3.SA",
            "GEPA4.SA",
            "BRGE11.SA",
            "TIET4.SA",
            "TEND3.SA",
            "CARD3.SA",
            "CAML3.SA",
            "EMAE4.SA",
            "ENGI4.SA",
            "BPAN4.SA",
            "RPAD5.SA",
            "VIVT3.SA",
            "CGAS3.SA",
            "MDIA3.SA",
            "CGAS5.SA",
            "KEPL3.SA",
            "RAPT3.SA",
            "LUXM4.SA",
            "EALT3.SA",
            "JPSA3.SA",
            "LEVE3.SA",
            "BPAC5.SA",
            "BRGE5.SA",
            "GRND3.SA",
            "MERC4.SA",
            "TCNO3.SA",
            "SEER3.SA",
            "ODPV3.SA",
            "DOHL4.SA",
            "ENEV3.SA",
            "DIRR3.SA",
            "GPAR3.SA",
            "EVEN3.SA",
            "POMO3.SA",
            "RAPT4.SA",
            "EQPA7.SA",
            "POMO4.SA",
            "EQPA5.SA",
            "UCAS3.SA",
            "AFLT3.SA",
            "LIPR3.SA",
            "BMKS3.SA",
            "ENGI3.SA",
            "PARD3.SA",
            "GOAU3.SA",
            "TXRX3.SA",
            "CNTO3.SA",
            "EUCA3.SA",
            "OFSA3.SA",
            "LOGG3.SA",
            "BAUH4.SA",
            "GGBR3.SA",
            "CCPR3.SA",
            "JSLG3.SA",
            "BOBR4.SA",
            "DTEX3.SA",
            "PFRM3.SA",
            "VIVA3.SA",
            "BRGE6.SA",
            "CEGR3.SA",
            "GUAR3.SA",
            "RLOG3.SA",
            "BRAP3.SA",
            "BPAC3.SA",
            "REDE3.SA",
            "FRAS3.SA",
            "BMIN4.SA",
            "BMIN3.SA",
            "WSON33.SA",
            "LCAM3.SA",
            "PNVL4.SA",
            "SCAR3.SA",
            "CEBR3.SA",
            "PNVL3.SA",
            "CEBR6.SA",
            "PGMN3.SA",
            "CEBR5.SA",
            "ALSO3.SA",
            "CAMB3.SA",
            "PDTC3.SA",
            "ALPA3.SA",
            "VULC3.SA",
            "LAME3.SA",
            "UNIP6.SA",
            "ALPA4.SA",
            "UNIP5.SA",
            "CASN3.SA",
            "CTSA4.SA",
            "UNIP3.SA",
            "MTRE3.SA",
            "POSI3.SA",
            "CTSA3.SA",
            "DOHL3.SA",
            "ARZZ3.SA",
            "MOVI3.SA",
            "OMGE3.SA",
            "NORD3.SA",
            "LWSA3.SA",
            "BIDI3.SA",
            "BIDI11.SA",
            "BIDI4.SA",
            "SQIA3.SA",
            "LINX3.SA",
            "IBOV11.SA",
            "%5EBVSP",
            "IFIX.SA",
            "FLRY3.SA",
            "RENT3.SA",
            "SBSP3.SA",
            "ENGI11.SA",
            "EGIE3.SA",
            "SULA11.SA",
            "AZUL4.SA",
            "LREN3.SA",
            "PETR3.SA",
            "IRBR3.SA",
            "PCAR3.SA",
            "CMIG4.SA",
            "QUAL3.SA",
            "CSAN3.SA",
            "GOAU4.SA",
            "BEEF3.SA",
            "TIMP3.SA",
            "GNDI3.SA",
            "CRFB3.SA",
            "BBDC4.SA",
            "ABEV3.SA",
            "CYRE3.SA",
            "CCRO3.SA",
            "RADL3.SA",
            "HYPE3.SA",
            "PRIO3.SA",
            "MRFG3.SA",
            "BRDT3.SA",
            "CIEL3.SA",
            "BRFS3.SA",
            "GOLL4.SA",
            "EQTL3.SA",
            "ITSA4.SA",
            "BBDC3.SA",
            "VVAR3.SA",
            "BRAP4.SA",
            "SUZB3.SA",
            "GGBR4.SA",
            "CPFE3.SA",
            "BBAS3.SA",
            "CSNA3.SA",
            "HGTX3.SA",
            "ELET3.SA",
            "IGTA3.SA",
            "TOTS3.SA",
            "PETR4.SA",
            "MULT3.SA",
            "MAPT4.SA",
            "BBSE3.SA",
            "LAME4.SA",
            "YDUQ3.SA",
            "USIM5.SA",
            "SANB11.SA",
            "BRML3.SA",
            "ECOR3.SA",
            "COGN3.SA",
            "MGLU3.SA",
            "ITUB4.SA",
            "BPAC11.SA",
            "KLBN11.SA",
            "UGPA3.SA",
            "BRKM5.SA",
            "EZTC3.SA",
            "VIVT4.SA",
            "TAEE11.SA",
            "VALE3.SA",
            "EMBR3.SA",
            "ELET6.SA",
            "B3SA3.SA",
            "RAIL3.SA",
            "JBSS3.SA",
            "HAPV3.SA",
            "MRVE3.SA",
            "WEGE3.SA",
            "ENBR3.SA",
            "STBP3.SA",
            "CVCB3.SA",
            "GFSA3.SA",
            "MAPT3.SA",
            "BTOW3.SA",
            "DASA3.SA",
            "PTNT4.SA",
            "PTNT3.SA",
            "TELB3.SA",
            "RDNI3.SA",
            "APER3.SA",
            "RANI4.SA",
            "ANIM3.SA",
            "CEAB3.SA",
            "NTCO3.SA",
            "LPSB3.SA",
            "RANI3.SA",
            "PEAB4.SA",
            "CEPE5.SA",
            "RCSL4.SA",
            "CEPE6.SA",
            "MOAR3.SA",
            "PEAB3.SA",
            "TELB4.SA",
            "HBSA3.SA",
            "MILS3.SA",
            "HBOR3.SA",
            "DTCY3.SA",
            "PRNR3.SA",
            "BIOM3.SA",
            "TUPY3.SA",
            "CRDE3.SA",
            "AALR3.SA",
            "USIM3.SA",
            "USIM6.SA",
            "BKBR3.SA",
            "MYPK3.SA",
            "LOGN3.SA",
            "BAHI3.SA",
            "KLBN3.SA",
            "KLBN4.SA",
            "PINE4.SA",
            "MSPA3.SA",
            "TASA4.SA",
            "TASA3.SA",
            "VLID3.SA",
            "ADHM3.SA",
            "AMAR3.SA",
            "MSPA4.SA",
            "MDNE3.SA",
            "MWET3.SA",
            "TPIS3.SA",
            "HBTS5.SA",
            "TCSA3.SA",
            "TESA3.SA",
            "SHOW3.SA",
            "IGBR3.SA",
            "FRIO3.SA",
            "GPIV33.SA",
            "BSEV3.SA",
            "MNDL3.SA",
            "ECPR4.SA",
            "MEAL3.SA",
            "IDVL3.SA",
            "IDVL4.SA",
            "MNPR3.SA",
            "SPRI3.SA",
            "BRKM3.SA",
            "CEDO3.SA",
            "BRKM6.SA",
            "CTNM3.SA",
            "SPRI5.SA",
            "SGPS3.SA",
            "RPMG3.SA",
            "LLIS3.SA",
            "CEDO4.SA",
            "ESTR4.SA",
            "OIBR4.SA",
            "TECN3.SA",
            "CTNM4.SA",
            "VIVR3.SA",
            "OIBR3.SA",
            "LUPA3.SA",
            "JBDU3.SA",
            "PMAM3.SA",
            "MWET4.SA",
            "DMMO3.SA",
            "BBRK3.SA",
            "RSID3.SA",
            "SNSY5.SA",
            "CEED3.SA",
            "JBDU4.SA",
            "HOOT4.SA",
            "MGEL4.SA",
            "RNEW4.SA",
            "RNEW11.SA",
            "RNEW3.SA",
            "ATMP3.SA",
            "BDLL3.SA",
            "GSHP3.SA",
            "SLED3.SA",
            "SLED4.SA",
            "TEKA3.SA",
            "INEP4.SA",
            "INEP3.SA",
            "MMXM3.SA",
            "BDLL4.SA",
            "TEKA4.SA",
            "PDGR3.SA",
            "OSXB3.SA",
            "ALPK3.SA",
            "AMBP3.SA",
            "AURA32.SA",
            "BMGB4.SA",
            "CSAB3.SA",
            "CSAB4.SA",
            "CURY3.SA",
            "DMVF3.SA",
            "LAVV3.SA",
            "LJQQ3.SA",
            "MELK3.SA",
            "PETZ3.SA",
            "PLPL3.SA",
            "SIMH3.SA",
            "SOMA3.SA",
            "AZEV4.SA",
            "FHER3.SA",
            "AZEV3.SA",
            "MTIG4.SA",
            "NUTR3.SA",
            "HETA4.SA",
            "PLAS3.SA",
            "CTKA4.SA",
            "CTKA3.SA",
            "LIGT3.SA",
            "BAZA3.SA",
            "CGRA4.SA",
            "PATI3.SA",
            "TXRX4.SA",
            "CGRA3.SA",
            "BNBR3.SA",
            "SMLS3.SA",
            "BRSR6.SA",
            "CPLE3.SA",
            "SOND6.SA",
            "PATI4.SA",
            "CPLE6.SA",
            "BRSR3.SA",
            "CLSC4.SA",
            "SOND5.SA",
            "CLSC3.SA"
    };


    /**
     * Caso o 'newValue' for maior que o 'oldValue', significa que houve um AUMENTO no valor da ação, logo o cálculo é:
     * (valorMaior - valorMenor) / valorMenor * 100
     * Caso o 'newValue' for menor que o 'oldValue', significa que houve uma QUEDA no valor da ação, logo o cálculo é:
     * (valorMaior - valorMenor) / valorMaior * 100
     * */
    public static BigDecimal getPercentualAumentoAcao(BigDecimal oldValue, BigDecimal newValue) {
        BigDecimal toReturn = new BigDecimal(0);
        if (oldValue.compareTo(newValue) >= 0) { // houve uma queda
            toReturn = ((oldValue.subtract(newValue)).divide(oldValue, MathContext.DECIMAL32).multiply(new BigDecimal(100))).negate();
        } else { // houve um aumento
            toReturn = (newValue.subtract(oldValue)).divide(oldValue, MathContext.DECIMAL32).multiply(new BigDecimal(100));
        }
        return toReturn.setScale(2, RoundingMode.HALF_UP);
    }

    public static String removeSAInSymbol(String symbol) {
        return symbol.replace(".SA", "");
    }

    public static String parseArrayToString(String[] symbols) {
        return Arrays.stream(symbols).collect(Collectors.joining(","));
    }
}
