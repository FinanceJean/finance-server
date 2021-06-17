package br.com.gz.finance.apifinance.ennumeration;

public enum Plano {

    F("Free"),
    S("Standard"),
    P("Premium");

    private String tipo;

    Plano(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
