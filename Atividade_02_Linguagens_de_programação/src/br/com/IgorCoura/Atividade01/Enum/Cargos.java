package br.com.IgorCoura.Atividade01.Enum;

public enum Cargos  {
    /**
     * Cargos possiveis no sociedade.
     */
    MobileMembers("Happy Coding!", "Happy_C0d1ng. Maskers"),
    HeavyLifters("Podem contar conosco!","N00b_qu3_n_Se_r3pita.bat"),
    ScriptGuys("Prazer em ajudar novos amigos de código!","QU3Ro_S3us_r3curs0s.py"),
    BigBrothers("Sempre ajudando as pessoas membros ou não S2!", "...");

    private String normal;
    private String extra;

    Cargos(String normal, String extra) {
        this.normal = normal;
        this.extra = extra;
    }

    /**
     * este metodo returna a messagem do cargo em horario norma de trabalho.
     * @return String - mensagens horarios normal de trabalho.
     */
    public String getNormalMessage(){
        return normal;
    }

    /**
     * este metodo returna a messagem do cargo em horario extra de trabalho.
     * @return String - mensagens horarios extra de trabalho.
     */
    public String getExtraMessage(){
        return extra;
    }

}
