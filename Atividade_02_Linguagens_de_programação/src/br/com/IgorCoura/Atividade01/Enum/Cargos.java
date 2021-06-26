package br.com.IgorCoura.Atividade01.Enum;

public enum Cargos  {
    MobileMembers("Happy Coding!", "Happy_C0d1ng. Maskers",1),
    HeavyLifters("Podem contar conosco!","N00b_qu3_n_Se_r3pita.bat",2),
    ScriptGuys("Prazer em ajudar novos amigos de código!","QU3Ro_S3us_r3curs0s.py",3),
    BigBrothers("Sempre ajudando as pessoas membros ou não S2!", "...",4);

    private String normal;
    private String extra;
    private int id;

    Cargos(String normal, String extra, int id) {
        this.normal = normal;
        this.extra = extra;
        this.id = id;
    }

    public String getNormalMessage(){
        return normal;
    }

    public String getExtraMessage(){
        return extra;
    }

    public int getId() {
        return id;
    }
}
